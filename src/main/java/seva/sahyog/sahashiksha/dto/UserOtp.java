package seva.sahyog.sahashiksha.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_otp")
public class UserOtp {

    @Column(name = "user_id")
    private int userId;

    @Column(name = "otp")
    private String otp;

    @Column(name = "generated_datetime")
    private LocalDateTime otpGeneratedDatetime;

    @Column(name = "validity_datetime")
    private LocalDateTime otpValidityDatetime;

    public UserOtp() {}

    public UserOtp(int userId, String otp, LocalDateTime otpGeneratedDatetime, LocalDateTime otpValidityDatetime) {
        this.userId = userId;
        this.otp = otp;
        this.otpGeneratedDatetime = otpGeneratedDatetime;
        this.otpValidityDatetime = otpValidityDatetime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
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
        return "UserOtp{" +
                "userId=" + userId +
                ", OTP='" + otp + '\'' +
                ", otpGeneratedDatetime=" + otpGeneratedDatetime +
                ", otpValidityDatetime=" + otpValidityDatetime +
                '}';
    }
}
