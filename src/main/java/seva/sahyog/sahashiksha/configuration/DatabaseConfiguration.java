package seva.sahyog.sahashiksha.configuration;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class DatabaseConfiguration {

    @Value("${spring.datasource.url}")
    private String datasourceURL;

    @Value("${spring.datasource.username}")
    private String datasourceUserName;

    @Value("${spring.datasource.password}")
    private String datasourcePassword;

    @Bean
    public MysqlDataSource mysqlDataSource(){
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL(datasourceURL);
        mysqlDataSource.setUser(datasourceUserName);
        mysqlDataSource.setPassword(datasourcePassword);
        return mysqlDataSource;
    }

 /*   @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(mysqlDataSource());
        sessionFactory.setPackagesToScan("seva.sahyog.sahashiksha");
        //sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }*/

    /*@Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
                = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put(
                "hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        hibernateProperties.put("hibernate.show_sql", true);
        hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
        return hibernateProperties;
    }*/
}