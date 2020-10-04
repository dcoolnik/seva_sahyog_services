package seva.sahyog.sahashiksha.dao;

import seva.sahyog.sahashiksha.dto.Student;

import java.util.List;

public interface StudentDao {

    public List<Student> getAllStudents();
    public List<Student> getAllActiveStudents();
    public Student getStudentForId(long id);
    public long saveStudent(Student student);
}
