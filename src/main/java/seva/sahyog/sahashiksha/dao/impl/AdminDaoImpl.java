package seva.sahyog.sahashiksha.dao.impl;

import org.hibernate.query.Query;
import seva.sahyog.sahashiksha.dao.AdminDao;
import seva.sahyog.sahashiksha.dao.DaoTemplate;
import seva.sahyog.sahashiksha.dto.Admin;

public class AdminDaoImpl extends DaoTemplate implements AdminDao {

    @Override
    public Admin getAdminForId(long id) {

        Query<Admin> query = getCurrentSession().createQuery("from admin a where" +
                " a.adminId=:id", Admin.class);
        query.setParameter("id", id);
        return query.uniqueResult();
    }

    @Override
    public long saveAdmin(Admin admin) {

        getCurrentSession().saveOrUpdate(admin);
        return admin.getAdminId();
    }
}
