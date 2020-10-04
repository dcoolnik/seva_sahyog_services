package seva.sahyog.sahashiksha.dao.impl;

import org.hibernate.query.Query;
import seva.sahyog.sahashiksha.dao.DaoTemplate;
import seva.sahyog.sahashiksha.dao.StudentDao;
import seva.sahyog.sahashiksha.dto.Student;

import java.util.List;
import java.util.stream.Collectors;

public class StudentDaoImpl extends DaoTemplate implements StudentDao {
    
    @Override
    public List<Student> getAllStudents() {
        Query<Student> query = getCurrentSession().createQuery("from Student s", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> getAllActiveStudents() {
        return getAllStudents().stream()
                .filter(Student::isActive)
                .collect(Collectors.toList());
    }

    @Override
    public Student getStudentForId(long id) {
        Query<Student> query = getCurrentSession().createQuery("from Student s where" +
                " s.studentId=:studentId", Student.class);
        query.setParameter("studentId", id);
        return query.uniqueResult();
    }

    @Override
    public long saveStudent(Student student) {
        getCurrentSession().saveOrUpdate(student);
        return student.getStudentId();
    }
}
