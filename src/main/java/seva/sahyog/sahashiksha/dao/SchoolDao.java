package seva.sahyog.sahashiksha.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import seva.sahyog.sahashiksha.dto.School;

@Repository
public interface SchoolDao extends CrudRepository<School, Integer> {

    @Query(value = "SELECT * from school s where s.schoolCode = :schoolCode", nativeQuery = true)
    public School findSchoolByCode(@Param("schoolCode") String schoolCode);
}
