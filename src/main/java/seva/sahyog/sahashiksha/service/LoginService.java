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
import java.util.Optional;

@Service
public class LoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);
    private static final String REGISTRATION_SUCCESSFUL = "User has been successfully registered";
    private static final String REGISTRATION_FAILED = "User registration failed";
    private static final String INVALID_USER_TYPE = "Invalid User Type";

    @Autowired
    private LoginDao loginDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private SchoolDao schoolDao;
    @Autowired
    private OtpDao otpDao;

    public boolean checkUserLogin(String username, String password) throws UserAuthenticationException {
        UserLogin userLogin = loginDao.findUserByUsername(username);
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
        UserLogin userLogin = loginDao.findUserByUsername(userName);
        UserOtp userOtp = new UserOtp();
        LocalDateTime currentTime = LocalDateTime.now();
        UserOtp persistedUserOtp = otpDao.save(new UserOtp(userLogin.getUserId(),
                OtpGenerator.generateOtp(),
                currentTime,
                currentTime.plusMinutes(2)));

        //Get stored Email for userName
        String userEmail = getEmailForUser(userLogin.getUserType(), userLogin.getUserId());
        OtpGenerator.sendOtp(userEmail, persistedUserOtp.getOtp());
    }

    private String getEmailForUser(UserType userType, int userId) {
        String userEmail = null;
        switch (userType) {
            case STUDENT: {
                Optional<Student> student = studentDao.findById(userId);
                userEmail = student.get().getEmail();
            }
            case TEACHER: {
                Optional<Teacher> teacher = teacherDao.findById(userId);
                userEmail = teacher.get().getEmail();
            }
            case ADMIN: {
                Optional<Admin> admin = adminDao.findById(userId);
                userEmail = admin.get().getEmail();
            }
        }
        return userEmail;
    }

    private boolean validateOtp(long userId, String otp) {
        UserOtp userOtp = otpDao.findOtpForUserId(userId);
        if (userOtp != null && userOtp.getOtpValidityDatetime().isAfter(LocalDateTime.now())) {
            return true;
        }
        return false;
    }

    public boolean changePassword(PasswordChangeRequest request) {
        UserLogin userLogin = loginDao.findUserByUsername(request.getUserName());
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
            int userId = saveUserLogin(request.getName(), request.getPassword(), request.getUserType());
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

    private int saveUserLogin(String userName, String password, UserType userType) throws Exception {
        String encryptedPwd = EncryptDecryptHelper.encrypt(password);
        UserLogin userLogin = loginDao.save(new UserLogin(userName, encryptedPwd, true, userType, userName, LocalDateTime.now()));
        return userLogin.getUserId();
    }

    private void registerStudent(RegistrationRequest request, int userId) {
        Student student = new Student();
        student.setStudentId(userId);
        student.setName(request.getName());
        student.setEmail(request.getEmailAddress());
        student.setMobileNumber(request.getPhoneNumber());
        student.setSchool(getSchool(request.getSchoolCode()));
        studentDao.save(student);
    }

    private void registerTeacher(RegistrationRequest request, int userId) {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(userId);
        teacher.setName(request.getName());
        teacher.setEmail(request.getEmailAddress());
        teacher.setSchool(getSchool(request.getSchoolCode()));
        teacherDao.save(teacher);
    }

    private void registerAdmin(RegistrationRequest request, int userId) {
        Admin admin = new Admin();
        admin.setAdminId(userId);
        admin.setName(request.getName());
        admin.setEmail(request.getEmailAddress());
        admin.setMobileNumber(request.getPhoneNumber());
        adminDao.save(admin);
    }

    private void registerSchool(RegistrationRequest request, int userId) {
        School school = new School();
        school.setSchoolId(userId);
        school.setSchoolName(request.getName());
        schoolDao.save(school);
    }

    private School getSchool(String schoolCode) {
        return schoolCode != null ? schoolDao.findSchoolByCode(schoolCode) : null;
    }

}
