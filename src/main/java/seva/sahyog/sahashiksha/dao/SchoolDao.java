package seva.sahyog.sahashiksha.dao;

import seva.sahyog.sahashiksha.dto.School;

import java.util.List;

public interface SchoolDao {

    public List<School> getAllSchools();
    public List<School> getAllActiveSchools();
    public School getSchoolForId(long id);
    public School getSchoolForCode(String code);
    public long saveSchool(School school);
}
