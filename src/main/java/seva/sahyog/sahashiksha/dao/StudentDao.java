package seva.sahyog.sahashiksha.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import seva.sahyog.sahashiksha.dto.School;
import seva.sahyog.sahashiksha.dto.Student;

import java.util.List;

@Repository
public interface StudentDao extends CrudRepository<Student, Integer> {

    /*public List<Student> getAllStudents();
    public List<Student> getAllActiveStudents();*/

    /*@Query(value = "SELECT * from student s where s.schoolCode = :schoolCode", nativeQuery = true)
    public School findStudentByCode(@Param("schoolCode") String schoolCode);*/
}
