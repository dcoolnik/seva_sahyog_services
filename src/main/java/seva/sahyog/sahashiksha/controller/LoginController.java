package seva.sahyog.sahashiksha.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seva.sahyog.sahashiksha.exception.UserAuthenticationException;
import seva.sahyog.sahashiksha.model.LoginRequest;
import seva.sahyog.sahashiksha.model.PasswordChangeRequest;
import seva.sahyog.sahashiksha.model.RegistrationRequest;
import seva.sahyog.sahashiksha.model.RegistrationResponse;
import seva.sahyog.sahashiksha.service.LoginService;

@RestController
@RequestMapping("/sahashiksha")
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> checkUserLogin(@RequestBody LoginRequest loginRequest){
        try {
            String username = loginRequest.getUsername();
            String password = loginRequest.getPassword();
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

    @PostMapping(path = "/register", produces = "application/json")
    public ResponseEntity<RegistrationResponse> registerUser(@RequestBody final RegistrationRequest request) {
        try {
            LOGGER.info("Attempting to register ", request.getUserId());
            RegistrationResponse respone = loginService.registerUser(request);
            return new ResponseEntity<RegistrationResponse>(respone, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Exception occurred while attempting to register", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/generateOtp", produces = "application/json")
    public ResponseEntity<String> generateOtp(@RequestBody final String userName) {
        try {
            LOGGER.info("Generate OTP for user " + userName);
            loginService.generateOtp(userName);
            return new ResponseEntity<String>("OTP has been emailed", HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Exception occurred while generating OTP", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/changePassword", produces = "application/json")
    public ResponseEntity<String> changePassword(@RequestBody final PasswordChangeRequest request) {
        try {
            boolean status = loginService.changePassword(request);
            return new ResponseEntity<String>(status ? "Password successfully changed" : "Password change failed", HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Exception occurred while generating OTP", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}