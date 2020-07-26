package seva.sahyog.sahashiksha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;

@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Component
@Path("/healthcheck")
public class HealthCheckController {

    @Autowired
    private Environment env;

    @GET
    public String getApplicationStatus() throws JSONException {
        JSONObject response = new JSONObject();
        response.put("Application", "Seva Sahyog Sahashiksha");
        response.put("Environment", Arrays.toString(env.getActiveProfiles()));
        response.put("Status", "Success");

        return response.toString();
    }
}
