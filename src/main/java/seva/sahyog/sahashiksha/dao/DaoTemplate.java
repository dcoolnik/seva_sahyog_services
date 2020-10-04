package seva.sahyog.sahashiksha.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

public abstract class DaoTemplate {

    @Autowired
    protected LocalSessionFactoryBean sessionFactory;

    public LocalSessionFactoryBean getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getCurrentSession(){
        return sessionFactory.getConfiguration().buildSessionFactory().getCurrentSession();
    }
}
