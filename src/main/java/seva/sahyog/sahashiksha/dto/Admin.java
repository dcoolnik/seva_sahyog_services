package seva.sahyog.sahashiksha.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @Column(name = "admin_id")
    private int adminId;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "email", nullable = true, length = 100)
    private String email;

    @Column(name = "mobile_number", nullable = true, length = 15)
    private String mobileNumber;

    @Column(name = "active")
    private boolean isActive;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_datetime")
    private LocalDateTime createdDatetime;

    public Admin(){}

    public Admin(int adminId, String name, String email, String mobileNumber, boolean isActive, String createdBy, LocalDateTime createdDatetime) {
        this.adminId = adminId;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.isActive = isActive;
        this.createdBy = createdBy;
        this.createdDatetime = createdDatetime;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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
        return "Admin{" +
                "adminId=" + adminId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", isActive=" + isActive +
                ", createdBy='" + createdBy + '\'' +
                ", createdDatetime=" + createdDatetime +
                '}';
    }
}
