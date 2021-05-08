package service;

import domain.AbstractUser;
import domain.AutoService;
import domain.User;
import repository.RepoDbAutoService;
import repository.RepoDbUser;

public class Service {
    private RepoDbAutoService repoauto;
    private RepoDbUser repouser;

    public Service(RepoDbAutoService repoauto, RepoDbUser repouser) {
        this.repoauto = repoauto;
        this.repouser = repouser;
    }

    public AbstractUser getUserByUsername(String username){
        AutoService autoService = this.repoauto.getAutoServiceByUsername(username);
        User user = this.repouser.getUserByUsername(username);
        return autoService == null ? user : autoService;
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
