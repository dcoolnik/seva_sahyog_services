package seva.sahyog.sahashiksha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seva.sahyog.sahashiksha.dao.LoginDAO;
import seva.sahyog.sahashiksha.dto.UserLogin;
import seva.sahyog.sahashiksha.exception.UserAuthenticationException;

@Service
public class LoginService {

    @Autowired
    private LoginDAO loginDAO;

    public boolean checkUserLogin(String username, String password) throws UserAuthenticationException {
        UserLogin userLogin = loginDAO.getUserLoginByUsername(username);
        if(null!=userLogin){
            if(userLogin.getCurrentPassword().equals(password))
                return true;
            else
                throw new UserAuthenticationException("Wrong Password");
        }
        else
            throw new UserAuthenticationException("User does not exist");

    }
}
