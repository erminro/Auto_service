package domain;

public class Appointment extends Entity<Long> {
    private String username;
    private String fullname;
    private String yearofthecar;
    private String makeofthecar;
    private String modelofthecar;
    private String dateofappointment;
    private String typeofwork;
    private String situation;
    private String usernameservice;
    private String timeofappointment;
    public Appointment(String username, String fullname, String yearofthecar, String makeofthecar, String modelofthecar, String dateofappointment, String typeofwork,String timeofappointment, String situation,String usernameservice) {
        this.username = username;
        this.fullname = fullname;
        this.yearofthecar = yearofthecar;
        this.makeofthecar = makeofthecar;
        this.modelofthecar = modelofthecar;
        this.dateofappointment = dateofappointment;
        this.typeofwork = typeofwork;
        this.situation = situation;
        this.usernameservice=usernameservice;
        this.timeofappointment=timeofappointment;
    }
    public Appointment(){

    }

    public String getTimeofappointment() {
        return timeofappointment;
    }

    public void setTimeofappointment(String timeofappointment) {
        this.timeofappointment = timeofappointment;
    }

    public String getUsernameservice() {
        return usernameservice;
    }

    public void setUsernameservice(String usernameservice) {
        this.usernameservice = usernameservice;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getYearofthecar() {
        return yearofthecar;
    }

    public void setYearofthecar(String yearofthecar) {
        this.yearofthecar = yearofthecar;
    }

    public String getMakeofthecar() {
        return makeofthecar;
    }

    public void setMakeofthecar(String makeofthecar) {
        this.makeofthecar = makeofthecar;
    }

    public String getModelofthecar() {
        return modelofthecar;
    }

    public void setModelofthecar(String modelofthecar) {
        this.modelofthecar = modelofthecar;
    }

    public String getDateofappointment() {
        return dateofappointment;
    }

    public void setDateofappointment(String dateofappointment) {
        this.dateofappointment = dateofappointment;
    }

    public String getTypeofwork() {
        return typeofwork;
    }

    public void setTypeofwork(String typeofwork) {
        this.typeofwork = typeofwork;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }
}
