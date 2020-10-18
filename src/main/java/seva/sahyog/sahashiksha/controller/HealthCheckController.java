package seva.sahyog.sahashiksha.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sahashiksha")
public class HealthCheckController {

    @GetMapping("/status")
    public String getApplicationStatus(){
        return "Application is up!";
    }
}