package seva.sahyog.sahashiksha.dao;

import seva.sahyog.sahashiksha.dto.Admin;

public interface AdminDao {

    public Admin getAdminForId(long id);
    public long saveAdmin(Admin admin);
}
