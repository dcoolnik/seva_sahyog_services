package seva.sahyog.sahashiksha.dao.impl;

import org.hibernate.query.Query;
import seva.sahyog.sahashiksha.dao.DaoTemplate;
import seva.sahyog.sahashiksha.dao.SchoolDao;
import seva.sahyog.sahashiksha.dto.School;

import java.util.List;
import java.util.stream.Collectors;

public class SchoolDaoImpl extends DaoTemplate implements SchoolDao {

    @Override
    public List<School> getAllSchools() {
        Query<School> query = getCurrentSession().createQuery("from School s", School.class);
        return query.getResultList();

    }

    @Override
    public List<School> getAllActiveSchools() {
        return getAllSchools().stream()
                .filter(School::isActive)
                .collect(Collectors.toList());
    }

    @Override
    public School getSchoolForId(long id) {
        Query<School> query = getCurrentSession().createQuery("from School s where" +
                " s.schoolId=:schoolId", School.class);
        query.setParameter("schoolId", id);
        return query.uniqueResult();
    }

    @Override
    public School getSchoolForCode(String code) {
        Query<School> query = getCurrentSession().createQuery("from School s where" +
                " s.schoolCode=:schoolCode", School.class);
        query.setParameter("schoolCode", code);
        return query.uniqueResult();
    }

    @Override
    public long saveSchool(School school) {
        getCurrentSession().saveOrUpdate(school);
        return school.getSchoolId();
    }
}
