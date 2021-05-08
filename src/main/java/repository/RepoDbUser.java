package repository;

import domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class RepoDbUser {
    private SessionFactory sessionFactory;

    private void initialize() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            System.err.println("Exception "+e);
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    private void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
    public User getUserByUsername(String username){
        this.initialize();
        User user = null;
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from User where username=:username");
            query.setParameter("username",username);
            user = (User) query.uniqueResult();
            session.getTransaction().commit();
            this.close();
        }
        catch (Exception e){
            this.close();
        }
        return user;
    }

    public void addUser(User user){
        this.initialize();
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            this.close();
        }
        catch (Exception e){
            this.close();
        }
    }

}
