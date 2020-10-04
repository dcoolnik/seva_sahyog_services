package seva.sahyog.sahashiksha.model;

import seva.sahyog.sahashiksha.util.ValidEmail;
import seva.sahyog.sahashiksha.util.ValidPassword;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RegistrationRequest {

    @NotNull
    @NotEmpty
    private UserType userType;
    @NotNull
    @NotEmpty
    private String userId;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    @ValidEmail
    private String emailAddress;
    @NotNull
    @NotEmpty
    private String phoneNumber;
    @NotNull
    @NotEmpty
    @ValidPassword
    private String password;
    private String schoolCode;

    public UserType getUserType() {
        return userType;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

}
