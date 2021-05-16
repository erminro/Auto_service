package repository;

import domain.Appointment;
import domain.AutoService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class RepoDbAppointments {
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

    public List<Appointment> getAllAutoAppointments(String username)
    {
        this.initialize();
        List<Appointment> appointmentservice = null;
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Appointment where username=:username");
            query.setParameter("username",username);
            appointmentservice = query.getResultList();
            session.getTransaction().commit();
            this.close();
        }
        catch (Exception e){
            this.close();
        }
        return appointmentservice;
    }
    public List<Appointment> getAllAutoAppointmentsbyserviceusername(String usernameservice)
    {
        this.initialize();
        List<Appointment> appointmentservice = null;
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Appointment where usernameservice=:usernameservice");
            query.setParameter("usernameservice",usernameservice);
            appointmentservice = query.getResultList();
            session.getTransaction().commit();
            this.close();
        }
        catch (Exception e){
            this.close();
        }
        return appointmentservice;
    }
    public List<Appointment> getAllAutoAppointmentsbyusernameandstatus(String username,String situation)
    {
        this.initialize();
        List<Appointment> appointmentservice = null;
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Appointment where username=:username and situation=:situation");
            query.setParameter("username",username);
            query.setParameter("situation",situation);
            appointmentservice = query.getResultList();
            session.getTransaction().commit();
            this.close();
        }
        catch (Exception e){
            this.close();
        }
        return appointmentservice;
    }

    public List<Appointment> getAllAutoAppointmentsbystatus(String usernameservice,String situation)
    {
        this.initialize();
        List<Appointment> appointmentservice = null;
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Appointment where usernameservice=:usernameservice and situation=:situation");
            query.setParameter("usernameservice",usernameservice);
            query.setParameter("situation",situation);
            appointmentservice = query.getResultList();
            session.getTransaction().commit();
            this.close();
        }
        catch (Exception e){
            this.close();
        }
        return appointmentservice;
    }
    public void addAppointment(Appointment appointmentservice){
        this.initialize();
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(appointmentservice);
            session.getTransaction().commit();
            this.close();
        }
        catch (Exception e){
            this.close();
        }
    }
    public void updateAppointment(Appointment appointmentservice){
        this.initialize();
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(appointmentservice);
            session.getTransaction().commit();
            this.close();
        }
        catch (Exception e){
            this.close();
        }
    }
}
