package service;

import domain.AbstractUser;
import domain.AutoService;
import domain.AutoServiceProfile;
import domain.User;
import repository.RepoDBServiceProfile;
import repository.RepoDbAutoService;
import repository.RepoDbUser;

import java.util.List;

public class Service {
    private RepoDbAutoService repoauto;
    private RepoDbUser repouser;
    private RepoDBServiceProfile repoprofile;
    public Service(RepoDbAutoService repoauto, RepoDbUser repouser, RepoDBServiceProfile repoDBServiceProfile) {
        this.repoauto = repoauto;
        this.repouser = repouser;
        this.repoprofile=repoDBServiceProfile;
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
