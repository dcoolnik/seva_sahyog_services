package seva.sahyog.sahashiksha.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import seva.sahyog.sahashiksha.dto.UserLogin;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface LoginDAO extends CrudRepository<UserLogin, Integer> {

    @Query(value = "SELECT * from user_login ul where ul.username = :username", nativeQuery = true)
    public UserLogin findUserByUsername(@Param("username") String username);
}
