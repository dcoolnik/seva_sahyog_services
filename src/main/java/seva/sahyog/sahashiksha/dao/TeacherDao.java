package seva.sahyog.sahashiksha.dao;

import seva.sahyog.sahashiksha.dto.Teacher;

import java.util.List;

public interface TeacherDao {

    public List<Teacher> getAllTeachers();
    public List<Teacher> getAllActiveTeachers();
    public Teacher getTeacherForId(long Id);
    public long saveTeacher(Teacher teacher);
}
