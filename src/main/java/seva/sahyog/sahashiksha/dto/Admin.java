package seva.sahyog.sahashiksha.dto;

import java.time.LocalDateTime;

public class Admin {

    private int adminId;

    private String name;

    private String email;

    private String mobileNumber;

    private boolean isActive;

    private String createdBy;

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
