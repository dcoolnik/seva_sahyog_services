package seva.sahyog.sahashiksha.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_login")
public class UserLogin {

    @Column(name="user_id", unique = true)
    private int userId;

    @Column(name = "old_password")
    private String oldPassword;

    @Column(name = "current_password")
    private String currentPassword;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_datetime")
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
