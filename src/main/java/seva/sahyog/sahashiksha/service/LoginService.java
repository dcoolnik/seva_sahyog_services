package seva.sahyog.sahashiksha.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seva.sahyog.sahashiksha.util.OtpGenerator;
import seva.sahyog.sahashiksha.dao.*;
import seva.sahyog.sahashiksha.dto.*;
import seva.sahyog.sahashiksha.exception.UserAuthenticationException;
import seva.sahyog.sahashiksha.model.PasswordChangeRequest;
import seva.sahyog.sahashiksha.model.RegistrationRequest;
import seva.sahyog.sahashiksha.model.RegistrationResponse;
import seva.sahyog.sahashiksha.model.UserType;
import seva.sahyog.sahashiksha.util.EncryptDecryptHelper;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class LoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);
    private static final String REGISTRATION_SUCCESSFUL = "User has been successfully registered";
    private static final String REGISTRATION_FAILED = "User registration failed";
    private static final String INVALID_USER_TYPE = "Invalid User Type";

    @Autowired
    private LoginDao loginDao;
    @Resource
    private StudentDao studentDao;
    @Resource
    private TeacherDao teacherDao;
    @Resource
    private AdminDao adminDao;
    @Resource
    private SchoolDao schoolDao;
    @Resource
    private OtpDao otpDao;

    public boolean checkUserLogin(String username, String password) throws UserAuthenticationException {
        UserLogin userLogin = loginDao.getUserLoginByUsername(username);
        if (null != userLogin) {
            String encryptedPwd = userLogin.getCurrentPassword();
            try {
                return validatePassword(userLogin.getCurrentPassword(), password);
            } catch (Exception e) {
                throw new UserAuthenticationException("Incorrect Password");
            }
        } else {
            throw new UserAuthenticationException("User does not exist");
        }
    }

    private boolean validatePassword(String persistedPassword, String inputPassword) {
        try {
            String decryptedText = EncryptDecryptHelper.decrypt(persistedPassword, inputPassword);
            return true;
        } catch (Exception e) {
            LOGGER.error("Persisted user password did not match with user input password!");
            return false;
        }
    }

    public boolean validateRegistrationRequest(RegistrationRequest request) {
        //custom validation logic if required
        return true;
    }

    public void generateOtp(String userName) {
        //Generate OTP
        UserLogin userLogin = loginDao.getUserLoginByUsername(userName);
        UserOtp userOtp = new UserOtp();
        userOtp.setOtp(OtpGenerator.generateOtp());
        userOtp.setUserId(userLogin.getUserId());
        LocalDateTime currentTime = LocalDateTime.now();
        userOtp.setOtpGeneratedDatetime(currentTime);
        userOtp.setOtpValidityDatetime(currentTime.plusMinutes(2));
        String otp = otpDao.saveOtp(userOtp);

        //Get stored Email for userName
        String userEmail = getEmailForUser(userLogin.getUserType(), userLogin.getUserId());
        OtpGenerator.sendOtp(userEmail, otp);
    }

    private String getEmailForUser(UserType userType, long userId) {
        String userEmail = null;
        switch (userType) {
            case STUDENT: {
                Student student = studentDao.getStudentForId(userId);
                userEmail = student.getEmail();
            }
            case TEACHER: {
                Teacher teacher = teacherDao.getTeacherForId(userId);
                userEmail = teacher.getEmail();
            }
            case ADMIN: {
                Admin admin = adminDao.getAdminForId(userId);
                userEmail = admin.getEmail();
            }
        }
        return userEmail;
    }

    private boolean validateOtp(long userId, String otp) {
        UserOtp userOtp = otpDao.getOtpForUserId(userId, otp);
        if (userOtp != null && userOtp.getOtpValidityDatetime().isAfter(LocalDateTime.now())) {
            return true;
        }
        return false;
    }

    public boolean changePassword(PasswordChangeRequest request) {
        UserLogin userLogin = loginDao.getUserLoginByUsername(request.getUserName());
        if (userLogin != null) {
            if (validateOtp(userLogin.getUserId(), request.getOtp())) {
                if (validatePassword(userLogin.getOldPassword(), request.getOldPassword())) {
                    try {
                        userLogin.setOldPassword(userLogin.getCurrentPassword());
                        userLogin.setCurrentPassword(EncryptDecryptHelper.encrypt(request.getNewPassword()));
                        return true;
                    } catch (Exception e) {
                        LOGGER.error("Error occured while persisting old password and/or new password - ", e);
                    }
                } else {
                    LOGGER.info("Old password does not match with existing password!");
                }
            } else {
                LOGGER.info("Provided OTP has expired. Please regenerate OTP");
            }
        } else {
            LOGGER.info("User {} does not exist", request.getUserName());
        }
        return false;
    }

    @Transactional
    public RegistrationResponse registerUser(RegistrationRequest request) {
        RegistrationResponse response = new RegistrationResponse();
        //boolean allowRegistration = validateRegistrationRequest(request);
        try {
            long userId = saveUserLogin(request.getName(), request.getPassword(), request.getUserType());
            switch (request.getUserType()) {
                case STUDENT: {
                    registerStudent(request, userId);
                }
                case TEACHER: {
                    registerTeacher(request, userId);
                }
                case ADMIN: {
                    registerAdmin(request, userId);
                }
                case SCHOOL: {
                     registerSchool(request, userId);
                }
                default:
                    throw new Exception(INVALID_USER_TYPE);
            }

        } catch(Exception e) {
            LOGGER.error("Error occurred while registering user ", e);
            response.setMessage(REGISTRATION_FAILED);
        }
        if (response.getMessage() == null) {
            response.setSuccess(true);
            response.setMessage(REGISTRATION_SUCCESSFUL);
        }
        return response;
    }

    private long saveUserLogin(String userName, String password, UserType userType) throws Exception {
        String encryptedPwd = EncryptDecryptHelper.encrypt(password);
        UserLogin userLogin = new UserLogin(userName, encryptedPwd, true, userType, userName, LocalDateTime.now());
        long userId = loginDao.saveUserLogin(userLogin);
        return userId;
    }

    private void registerStudent(RegistrationRequest request, long userId) {
        Student student = new Student();
        student.setStudentId(userId);
        student.setName(request.getName());
        student.setEmail(request.getEmailAddress());
        student.setMobileNumber(request.getPhoneNumber());
        student.setSchool(getSchool(request.getSchoolCode()));
        studentDao.saveStudent(student);
    }

    private void registerTeacher(RegistrationRequest request, long userId) {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(userId);
        teacher.setName(request.getName());
        teacher.setEmail(request.getEmailAddress());
        teacher.setSchool(getSchool(request.getSchoolCode()));
        teacherDao.saveTeacher(teacher);
    }

    private void registerAdmin(RegistrationRequest request, long userId) {
        Admin admin = new Admin();
        admin.setAdminId(userId);
        admin.setName(request.getName());
        admin.setEmail(request.getEmailAddress());
        admin.setMobileNumber(request.getPhoneNumber());
        adminDao.saveAdmin(admin);
    }

    private void registerSchool(RegistrationRequest request, long userId) {
        School school = new School();
        school.setSchoolId(userId);
        school.setSchoolName(request.getName());
        schoolDao.saveSchool(school);
    }

    private School getSchool(String schoolCode) {
        return schoolCode != null ? schoolDao.getSchoolForCode(schoolCode) : null;
    }

}
