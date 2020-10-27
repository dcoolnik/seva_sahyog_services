package seva.sahyog.sahashiksha.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seva.sahyog.sahashiksha.dao.SchoolDao;
import seva.sahyog.sahashiksha.dto.School;
import seva.sahyog.sahashiksha.model.Organization;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationService.class);

    @Autowired
    private SchoolDao schoolDao;

    public School addNewOrganization(Organization orgRequest){
        School school = new School();
        school.setSchoolCode(orgRequest.getSchoolCode());
        school.setSchoolName(orgRequest.getSchoolName());
        school.setActive(true);
        school.setCreatedBy("prince");

        LocalDateTime currentUTCTime = LocalDateTime.now(ZoneOffset.UTC);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        school.setCreatedDatetime(currentUTCTime.format(dateTimeFormatter));
        return schoolDao.save(school);
    }

    public List<Organization> getAllOrganizations(){
        List<Organization> organizationList = new ArrayList<>();
        schoolDao.findAll().forEach(school -> {
            Organization org = new Organization();
            org.setSchoolCode(school.getSchoolCode());
            org.setSchoolName(school.getSchoolName());
            organizationList.add(org);
        });

        return organizationList;
    }
}
