package seva.sahyog.sahashiksha.model;

public class PasswordChangeRequest {

    private String userName;
    private String oldPassword;
    private String newPassword;
    private String otp;

    public String getUserName() {
        return userName;
    }

    public void setUserIName(String userName) {
        this.userName = userName;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
