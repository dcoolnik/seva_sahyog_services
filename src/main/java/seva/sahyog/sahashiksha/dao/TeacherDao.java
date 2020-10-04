package seva.sahyog.sahashiksha.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import seva.sahyog.sahashiksha.dto.Teacher;

@Repository
public interface TeacherDao extends CrudRepository<Teacher, Integer> {

    /*public List<Teacher> getAllTeachers();
    public List<Teacher> getAllActiveTeachers();
    public Teacher getTeacherForId(long Id);
    public long saveTeacher(Teacher teacher);*/
}
