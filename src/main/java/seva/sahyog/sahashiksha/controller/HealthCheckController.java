package seva.sahyog.sahashiksha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Controller
@Produces(MediaType.APPLICATION_JSON)
@Path("/healthcheckservice")
public class HealthCheckController {

    @Autowired
    private Environment env;

    @GET
    @Path("/status")
    public Response getApplicationStatus(){
        return Response.ok().build();
    }
}