package seva.sahyog.sahashiksha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;

@RestController
@RequestMapping(path = "/healthcheck")
public class HealthCheckController {

    @Autowired
    private Environment env;

    @GetMapping(path="/", produces = "application/json")
    public String getApplicationStatus(){
        String status = "{\"status\": \"success\"}";
        return status;
    }
}