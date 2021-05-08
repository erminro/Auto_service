package domain;

public abstract class AbstractUser extends Entity<Long>{
    private String username;
    private String Name;
    private Integer hashing;
    private String type;
    public AbstractUser(String username, String Name, Integer hashing,String type) {
        this.username = username;
        this.Name = Name;
        this.hashing = hashing;
        this.type=type;
    }
    public AbstractUser(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getHashing() {
        return hashing;
    }

    public void setHashing(Integer hashing) {
        this.hashing = hashing;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AbstractUser{" +
                "username='" + username + '\'' +
                ", Name='" + Name + '\'' +
                ", hashing=" + hashing +
                ", type='" + type + '\'' +
                '}';
    }
}
