package domain;

public class User extends AbstractUser {

    public User(String username, String Name, Integer hashing, String type) {
        super(username, Name, hashing, type);
    }
    public User(){}
}
