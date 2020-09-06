package seva.sahyog.sahashiksha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import seva.sahyog.sahashiksha.exception.UserAuthenticationException;
import seva.sahyog.sahashiksha.service.LoginService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Controller
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/logincontroller/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @POST
    @Path("/login")
    public Response checkUserLogin(String username, String password){
        try {
            boolean isLoginSuccessful = loginService.checkUserLogin(username, password);
        } catch (UserAuthenticationException e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }

        return Response.status(Response.Status.OK).entity("Login Successful").build();
    }
}