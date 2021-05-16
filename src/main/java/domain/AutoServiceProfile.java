package domain;

import java.util.List;

public class AutoServiceProfile extends Entity<Long>{
    private String username;
    private String description;
    private String address;

    public AutoServiceProfile(String username, String description, String address) {
        this.username=username;
        this.description=description;
        this.address=address;

    }
    public AutoServiceProfile(){

    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }


    @Override
    public String toString() {
        return "AutoServiceProfile{" +
                "username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
