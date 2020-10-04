package seva.sahyog.sahashiksha.dao.impl;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import seva.sahyog.sahashiksha.dao.DaoTemplate;
import seva.sahyog.sahashiksha.dao.LoginDao;
import seva.sahyog.sahashiksha.dto.UserLogin;

@Repository
public class LoginDaoImpl extends DaoTemplate implements LoginDao {

    @Override
    public UserLogin getUserLoginByUsername(String username) {

        Query<UserLogin> query = getCurrentSession().createQuery("from UserLogin u where" +
                " u.userName=:username", UserLogin.class);
        query.setParameter("username", username);

        return query.uniqueResult();
    }

    @Override
    public long saveUserLogin(UserLogin userLogin) {

        getCurrentSession().saveOrUpdate(userLogin);
        return userLogin.getUserId();
    }

}
