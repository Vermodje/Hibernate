package service.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import service.users.Users;


public class Utils {
    private Configuration configuration;
    private SessionFactory sessionFactory;

    public Utils() {
        configuration = getH2Configuration();
        sessionFactory = createSessionFactory(configuration);
    }

    public Configuration getConfiguration() {
        return configuration;
    }
    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    private Configuration getH2Configuration() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.addAnnotatedClass(Users.class);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:./h2db");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:tcp://localhost/~/test");
        configuration.setProperty("hibernate.connection.username", "sa");
        configuration.setProperty("hibernate.connection.password", "");
        configuration.setProperty("hibernate.show_sql","true" );
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        return configuration;
    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

}
