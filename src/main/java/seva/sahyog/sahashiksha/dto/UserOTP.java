package seva.sahyog.sahashiksha.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_otp")
public class UserOTP {

    @Column(name = "user_id")
    private int userId;

    @Column(name = "otp")
    private String OTP;

    @Column(name = "generated_datetime")
    private LocalDateTime otpGeneratedDatetime;

    @Column(name = "validity_datetime")
    private LocalDateTime otpValidityDatetime;

    public UserOTP(){}

    public UserOTP(int userId, String OTP, LocalDateTime otpGeneratedDatetime, LocalDateTime otpValidityDatetime) {
        this.userId = userId;
        this.OTP = OTP;
        this.otpGeneratedDatetime = otpGeneratedDatetime;
        this.otpValidityDatetime = otpValidityDatetime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOTP() {
        return OTP;
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }

    public LocalDateTime getOtpGeneratedDatetime() {
        return otpGeneratedDatetime;
    }

    public void setOtpGeneratedDatetime(LocalDateTime otpGeneratedDatetime) {
        this.otpGeneratedDatetime = otpGeneratedDatetime;
    }

    public LocalDateTime getOtpValidityDatetime() {
        return otpValidityDatetime;
    }

    public void setOtpValidityDatetime(LocalDateTime otpValidityDatetime) {
        this.otpValidityDatetime = otpValidityDatetime;
    }

    @Override
    public String toString() {
        return "UserOTP{" +
                "userId=" + userId +
                ", OTP='" + OTP + '\'' +
                ", otpGeneratedDatetime=" + otpGeneratedDatetime +
                ", otpValidityDatetime=" + otpValidityDatetime +
                '}';
    }
}
