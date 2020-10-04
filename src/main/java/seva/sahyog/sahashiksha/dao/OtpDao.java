package seva.sahyog.sahashiksha.dao;

import org.springframework.stereotype.Service;
import seva.sahyog.sahashiksha.dto.UserOtp;

@Service
public interface OtpDao {

    public UserOtp getOtpForUserId(long userId, String otp);
    public String saveOtp(UserOtp userOtp);

}

