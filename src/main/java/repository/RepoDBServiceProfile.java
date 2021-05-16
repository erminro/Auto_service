package repository;

import domain.AutoServiceProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;


public class RepoDBServiceProfile {
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
    public AutoServiceProfile getAutoServiceProfileByUsername(String username){
        this.initialize();
        AutoServiceProfile autoserviceProfile = null;
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from AutoServiceProfile where username=:username");
            query.setParameter("username",username);
            autoserviceProfile = (AutoServiceProfile) query.uniqueResult();
            session.getTransaction().commit();
            this.close();
        }
        catch (Exception e){
            this.close();
        }
        return autoserviceProfile;
    }
    public void updateAutoServiceProfile(AutoServiceProfile autoServiceProfile){
        this.initialize();
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(autoServiceProfile);
            session.getTransaction().commit();
            this.close();
        }
        catch (Exception e){
            this.close();
        }
    }
    public void addAutoServiceProfile(AutoServiceProfile autoServiceProfile){
        this.initialize();
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(autoServiceProfile);
            session.getTransaction().commit();
            this.close();
        }
        catch (Exception e){
            this.close();
        }
    }
}
