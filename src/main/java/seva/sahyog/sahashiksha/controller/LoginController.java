package seva.sahyog.sahashiksha.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seva.sahyog.sahashiksha.exception.UserAuthenticationException;
import seva.sahyog.sahashiksha.service.LoginService;

@RestController
@RequestMapping("/sahashiksha")
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> checkUserLogin(@RequestBody Login login){
        try {
            String username = login.getUsername();
            String password = login.getPassword();
            LOGGER.debug("In LoginController, username : {} and password : {}", username, password);
            boolean isLoginSuccessful = loginService.checkUserLogin(username, password);
        } catch (UserAuthenticationException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<String>("Login Successful", HttpStatus.OK);
    }
}

class Login{
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}