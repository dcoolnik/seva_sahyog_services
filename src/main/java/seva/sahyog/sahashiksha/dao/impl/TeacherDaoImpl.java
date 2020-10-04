package seva.sahyog.sahashiksha.dao.impl;

import org.hibernate.query.Query;
import seva.sahyog.sahashiksha.dao.DaoTemplate;
import seva.sahyog.sahashiksha.dao.TeacherDao;
import seva.sahyog.sahashiksha.dto.Teacher;

import java.util.List;
import java.util.stream.Collectors;

public class TeacherDaoImpl extends DaoTemplate implements TeacherDao {
    @Override
    public List<Teacher> getAllTeachers() {
        Query<Teacher> query = getCurrentSession().createQuery("from Teacher t", Teacher.class);
        return query.getResultList();
    }

    @Override
    public List<Teacher> getAllActiveTeachers() {
        return getAllTeachers().stream()
                .filter(Teacher::isActive)
                .collect(Collectors.toList());
    }

    @Override
    public Teacher getTeacherForId(long id) {
        Query<Teacher> query = getCurrentSession().createQuery("from Teacher t where" +
                " t.teacherId=:teacherId", Teacher.class);
        query.setParameter("teacherId", id);
        return query.uniqueResult();
    }

    @Override
    public long saveTeacher(Teacher teacher) {
        getCurrentSession().saveOrUpdate(teacher);
        return teacher.getTeacherId();
    }
    
}
