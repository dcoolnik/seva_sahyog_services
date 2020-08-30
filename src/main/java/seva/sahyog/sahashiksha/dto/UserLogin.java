package seva.sahyog.sahashiksha.dto;

import java.time.LocalDateTime;

public class UserLogin {

    private int userId;

    private String oldPassword;

    private String currentPassword;

    private String createdBy;

    private LocalDateTime createdDatetime;

    public UserLogin(){}

    public UserLogin(int userId, String oldPassword, String currentPassword, String createdBy, LocalDateTime createdDatetime) {
        this.userId = userId;
        this.oldPassword = oldPassword;
        this.currentPassword = currentPassword;
        this.createdBy = createdBy;
        this.createdDatetime = createdDatetime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(LocalDateTime createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "userId=" + userId +
                ", oldPassword='" + oldPassword + '\'' +
                ", currentPassword='" + currentPassword + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdDatetime=" + createdDatetime +
                '}';
    }
}
