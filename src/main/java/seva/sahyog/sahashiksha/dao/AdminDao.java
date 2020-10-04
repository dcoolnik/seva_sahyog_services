package seva.sahyog.sahashiksha.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import seva.sahyog.sahashiksha.dto.Admin;

@Repository
public interface AdminDao extends CrudRepository<Admin, Integer> {

}
