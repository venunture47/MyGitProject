package com.config;

import java.util.Properties;

import javax.activation.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import com.model.Employee;

public class RepositoryConfig {
	
	  //${jdbc.driverClassName}
    @Value("${jdbc.driverClassName}")     private String driverClassName;
    @Value("${jdbc.url}")                 private String url;
    @Value("${jdbc.username}")             private String username;
    @Value("${jdbc.password}")             private String password;
    
    @Value("${hibernate.dialect}")         private String hibernateDialect;
    @Value("${hibernate.show_sql}")     private String hibernateShowSql;
    @Value("${hibernate.hbm2ddl.auto}") private String hibernateHbm2ddlAuto;
        
    @Bean()    
    public javax.sql.DataSource getDataSource()
    {
        DriverManagerDataSource ds = new DriverManagerDataSource();        
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);        
        return  ds;
    }
    
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
    {
        HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setSessionFactory(sessionFactory);
        return htm;
    }
    
    @Bean
    @Autowired
    public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory)
    {
        HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
        return hibernateTemplate;
    }
        
    @Bean(name="sessionFactor")
    @Autowired
    public LocalSessionFactoryBean getSessionFactory()
    {
        LocalSessionFactoryBean asfb = new LocalSessionFactoryBean();
        asfb.setDataSource((javax.sql.DataSource) getDataSource());
        asfb.setHibernateProperties(getHibernateProperties());        
        asfb.setPackagesToScan(new String[]{"com.model"});
        return asfb;
    }
   /* @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(javax.sql.DataSource dataSource) {
     
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
     
        sessionBuilder.addAnnotatedClasses(Employee.class);
     
        return sessionBuilder.buildSessionFactory();
    }
*/
    @Bean
    public Properties getHibernateProperties()
    {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.show_sql", hibernateShowSql);
        properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        
        return properties;
    }
    


}
