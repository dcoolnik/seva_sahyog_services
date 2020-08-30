package seva.sahyog.sahashiksha.dto;

import java.time.LocalDateTime;

public class UserOTP {

    private int userId;

    private String OTP;

    private LocalDateTime otpGeneratedDatetime;

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
