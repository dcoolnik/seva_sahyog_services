package seva.sahyog.sahashiksha.dto;

import seva.sahyog.sahashiksha.model.UserType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_login")
public class UserLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private int userId;

    @Column(name="username", unique = true)
    private String userName;

    @Column(name = "old_password")
    private String oldPassword;

    @Column(name = "current_password")
    private String currentPassword;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "userType")
    private UserType userType;

    /*@Column(name = "is_student", nullable = false)
    private boolean isStudent;

    @Column(name = "is_teacher", nullable = false)
    private boolean isTeacher;

    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin;*/

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_datetime")
    private LocalDateTime createdDatetime;

    public UserLogin(){}

    public UserLogin(String userName,
                     //String oldPassword,
                     String currentPassword,
                     boolean isActive,
                     UserType userType,
                     /*boolean isStudent,
                     boolean isTeacher,
                     boolean isAdmin,*/
                     String createdBy,
                     LocalDateTime createdDatetime) {
        this.userName = userName;
        this.oldPassword = currentPassword; //when creating, old & new password should be the same
        this.currentPassword = currentPassword;
        this.isActive = isActive;
        //this.isStudent = isStudent;
        //this.isTeacher = isTeacher;
        //this.isAdmin = isAdmin;
        this.userType = userType;
        this.createdBy = createdBy;
        this.createdDatetime = createdDatetime;
    }

    public int getUserId() {
        return userId;
    }

    /*public void setUserId(int userId) {
        this.userId = userId;
    }*/

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    /*public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }*/

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
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
                ", userName='" + userName + '\'' +
                ", oldPassword='" + oldPassword + '\'' +
                ", currentPassword='" + currentPassword + '\'' +
                ", isActive=" + isActive +
                ", userType=" + userType.name() +
                /*", isStudent=" + isStudent +
                ", isTeacher=" + isTeacher +
                ", isAdmin=" + isAdmin +*/
                ", createdBy='" + createdBy + '\'' +
                ", createdDatetime=" + createdDatetime +
                '}';
    }
}
