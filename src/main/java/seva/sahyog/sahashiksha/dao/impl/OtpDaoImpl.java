package seva.sahyog.sahashiksha.dao.impl;

import org.hibernate.query.Query;
import seva.sahyog.sahashiksha.dao.DaoTemplate;
import seva.sahyog.sahashiksha.dao.OtpDao;
import seva.sahyog.sahashiksha.dto.UserOtp;

public class OtpDaoImpl extends DaoTemplate implements OtpDao {

    @Override
    public UserOtp getOtpForUserId(long userId, String otp) {

        Query<UserOtp> query = getCurrentSession().createQuery("from UserOtp u where" +
                " u.userId=:userId and u.otp=:otp", UserOtp.class);
        query.setParameter("userId", userId);
        query.setParameter("otp", otp);

        return query.uniqueResult();
    }

    @Override
    public String saveOtp(UserOtp userOtp) {
        getCurrentSession().saveOrUpdate(userOtp);
        return userOtp.getOtp();
    }

}
