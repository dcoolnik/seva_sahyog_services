package seva.sahyog.sahashiksha.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import seva.sahyog.sahashiksha.dto.UserOtp;

@Repository
public interface OtpDao extends CrudRepository<UserOtp, Integer> {

    @Query(value = "SELECT * from user_otp uo where uo.userId = :userId", nativeQuery = true)
    public UserOtp findOtpForUserId(@Param("userId") long userId);

}

