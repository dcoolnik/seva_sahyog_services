package seva.sahyog.sahashiksha.dao.impl;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import seva.sahyog.sahashiksha.dao.DAOTemplate;
import seva.sahyog.sahashiksha.dao.LoginDAO;
import seva.sahyog.sahashiksha.dto.UserLogin;

@Repository
public class LoginDAOImpl extends DAOTemplate implements LoginDAO {

    @Override
    public UserLogin getUserLoginByUsername(String username) {
        Query<UserLogin> query = getCurrentSession().createQuery("from UserLogin u where" +
                " u.userName=:username", UserLogin.class);
        query.setParameter("username", username);

        return query.uniqueResult();
    }
}
