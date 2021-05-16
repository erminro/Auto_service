package service;

import domain.*;
import repository.RepoDBServiceProfile;
import repository.RepoDbAppointments;
import repository.RepoDbAutoService;
import repository.RepoDbUser;

import java.util.List;

public class Service {
    private RepoDbAutoService repoauto;
    private RepoDbUser repouser;
    private RepoDBServiceProfile repoprofile;
    private RepoDbAppointments repoappointments;
    public Service(RepoDbAutoService repoauto, RepoDbUser repouser, RepoDBServiceProfile repoDBServiceProfile,RepoDbAppointments repoappointments) {
        this.repoauto = repoauto;
        this.repouser = repouser;
        this.repoprofile=repoDBServiceProfile;
        this.repoappointments=repoappointments;
    }
    public List<Appointment> getAllAutoAppointments(String username){
        return this.repoappointments.getAllAutoAppointments(username);
    }
    public List<Appointment> getAllAutoAppointmentsbyserviceusername(String usernameservice){
        return this.repoappointments.getAllAutoAppointmentsbyserviceusername(usernameservice);
    }
    public void addAppointment(Appointment appointment){
        this.repoappointments.addAppointment(appointment);
    }
    public List<Appointment> getAllAutoAppointmentsbyusernameandstatus(String username,String status){
        return this.repoappointments.getAllAutoAppointmentsbyusernameandstatus(username,status);
    }
    public List<Appointment> getAllAutoAppointmentsbystatus(String usernameservice,String status){
        return this.repoappointments.getAllAutoAppointmentsbystatus(usernameservice,status);
    }
    public AbstractUser getUserByUsername(String username){
        AutoService autoService = this.repoauto.getAutoServiceByUsername(username);
        User user = this.repouser.getUserByUsername(username);
        return autoService == null ? user : autoService;
    }
    public void addProfile(AutoServiceProfile autoServiceProfile){
        this.repoprofile.addAutoServiceProfile(autoServiceProfile);
    }
    public AutoServiceProfile getServiceProfileByUsername(String username){
        return this.repoprofile.getAutoServiceProfileByUsername(username);
    }
    public List<AutoService> getAllAutoService(){
        return this.repoauto.getAllAutoService();
    }
    public void addUser(AbstractUser user){
        if(user instanceof User){
            this.repouser.addUser((User) user);
        }
        else if(user instanceof AutoService){
            this.repoauto.addAutoService((AutoService) user);
        }
    }
}
