/**
 * 
 */
package in.ifms.employee.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Sharat Pradhan
 *
 *
 *
 */
//@Configuration
//@EnableTransactionManagement
public class HibernateConfig {

    //@Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("in.ifms.employee.entity");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

  //  @Bean
    public DataSource dataSource() {
        DataSource dataSource = null;
        //dataSource.setDriverClassName("");
        //dataSource.setUrl("");
        //dataSource.setUsername("");
        //dataSource.setPassword("");

        return dataSource;
    }

    //@Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
          = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
          "hibernate.hbm2ddl.auto", "validate");
        hibernateProperties.setProperty(
          "hibernate.dialect", "org.hibernate.dialect.Oracle8iDialect");

        return hibernateProperties;
    }
}
