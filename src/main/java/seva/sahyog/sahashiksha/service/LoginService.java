package seva.sahyog.sahashiksha.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seva.sahyog.sahashiksha.dao.LoginDAO;
import seva.sahyog.sahashiksha.dto.UserLogin;
import seva.sahyog.sahashiksha.exception.UserAuthenticationException;

@Service
public class LoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private LoginDAO loginDAO;

    public boolean checkUserLogin(String username, String password) throws UserAuthenticationException {
        LOGGER.debug("In LoginService username : {} and password : {}", username, password);
        UserLogin userLogin = loginDAO.findUserByUsername(username);
        LOGGER.debug("userLogin : {}", userLogin.toString());

        if(null!=userLogin){
            LOGGER.debug("userLogin.getCurrentPassword() : {}", userLogin.getCurrentPassword());
            if(userLogin.getCurrentPassword().equals(password))
                return true;
            else
                throw new UserAuthenticationException("Wrong Password");
        }
        else
            throw new UserAuthenticationException("User does not exist");

    }
}
