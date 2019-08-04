package licenta.repository;

import java.util.List;
import licenta.entity.User;
import licenta.repository.interfaces.UserDao;
import licenta.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    
     private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    static{
        System.out.println("Before log4j configuration");
        DOMConfigurator.configure("log4j.xml");
        System.out.println("After log4j configuration");
    }

    private static Logger logger = Logger.getLogger(UserDaoImpl.class);

    @Override
    public void insertUser(User u) {
        Transaction tx = null;
        Session session = sessionFactory.openSession();
        try{
            tx = session.beginTransaction();
            session.save(u);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteUserById(int userId) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            User u = getUserById(userId);
            session.delete(u);
            session.getTransaction().commit();
        } catch (Exception he) {
            he.printStackTrace();
        }
    }

    @Override
    public int getLatestUserId(){
        Session session = sessionFactory.openSession();
        User u = (User) session.createQuery("from User ORDER BY id DESC")
                .setMaxResults(1).uniqueResult();

        return u.getId();
    }

    @Override
    public User getUserByName(String name){
        Session session = sessionFactory.openSession();
        User u = (User) session.createQuery("from User WHERE last_name =:name")
                .setParameter("name", name)
                .setMaxResults(1).uniqueResult();

        return u;
    }

    @Override
    public User getUserById(int userId) {
        User user = null;
        try(Session session = sessionFactory.openSession()){
            user = session.get(User.class, userId);
            Hibernate.initialize(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> listUsers() {
        Session session = sessionFactory.openSession();
        List<User> users = session.createQuery("from User ").list();
        session.close();
        return users;
    }
    
}
