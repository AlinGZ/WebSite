package licenta.util;

import licenta.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Logger logger = Logger.getLogger(HibernateUtil.class);

    private static SessionFactory buildSessionFactory() {
        try{
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(User.class);

            //driver
            configuration.setProperty("connection.driver_class","com.mysql.jdbc.Driver");

            //url
            configuration.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/licenta?verifyServerCertificate=false&useSSL=true");

            //user name
            configuration.setProperty("hibernate.connection.username","root");

            //password
            configuration.setProperty("hibernate.connection.password","root");

            //dialect
            configuration.setProperty("dialect","org.hibernate.dialect.MySQLDialect");

            configuration.setProperty("show_sql", "true");

            //schema auto update
            configuration.setProperty("hibernate.hbm2ddl.auto","none");
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());

            System.out.println("Hibernate Java Config created.");
            return sessionFactory;

        }catch (Throwable ex){
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null)
            getSessionFactory().close();
        System.out.println("Hibernate Session closed.");
    }
}
