package seva.sahyog.sahashiksha.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seva.sahyog.sahashiksha.dto.School;
import seva.sahyog.sahashiksha.model.Organization;
import seva.sahyog.sahashiksha.model.OrganizationList;
import seva.sahyog.sahashiksha.service.OrganizationService;

import java.util.List;

@RestController
    @RequestMapping("/sahashiksha/organization")
public class OrganizationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

    @Autowired
    private OrganizationService orgService;

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> addAnOrganization(@RequestBody Organization orgRequest){
        try {
            LOGGER.debug("In OrganizationController, school-code : {} and school-name : {}", orgRequest.getSchoolCode(), orgRequest.getSchoolName());
            School school = orgService.addNewOrganization(orgRequest);
        }  catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<String>("Organization added successfully", HttpStatus.OK);
    }

    @GetMapping(path = "/getAll", produces = "application/json")
    public ResponseEntity<OrganizationList> getAllOrganization(){
        OrganizationList organizationList = new OrganizationList();
        try {
            organizationList.setOrganizations(orgService.getAllOrganizations());
        }  catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<OrganizationList>(organizationList, HttpStatus.OK);
    }
}
