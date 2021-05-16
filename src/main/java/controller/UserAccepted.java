package controller;

import domain.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.Service;

public class UserAccepted {
    @FXML
    private TableView<Appointment> tableaccepted;

    @FXML
    private TableColumn<Appointment, String> acceptedservicename;

    @FXML
    private TableColumn<Appointment, String> acceptedstatus;

    @FXML
    private TableColumn<Appointment, String> accepteddate;

    @FXML
    private TableColumn<Appointment, String> acceptedtime;

    @FXML
    private TableColumn<Appointment, String> acceptedtypeofwork;
    private Service service;
    private String useruserusername;
    public void Useruser(String useruserusername)
    {
        this.useruserusername=useruserusername;
    }

    private ObservableList<Appointment> model1= FXCollections.observableArrayList();
    public void setService(Service service) {

        this.service = service;
        inittable1();
    }
    private void inittable1(){
        this.acceptedservicename.setCellValueFactory(new PropertyValueFactory<>("servicename"));
        this.acceptedstatus.setCellValueFactory(new PropertyValueFactory<>("situation"));
        this.accepteddate.setCellValueFactory(new PropertyValueFactory<>("dateofappointment"));
        this.acceptedtime.setCellValueFactory(new PropertyValueFactory<>("timeofappointment"));
        this.acceptedtypeofwork.setCellValueFactory(new PropertyValueFactory<>("typeofwork"));
        loadmodel1();
        if(model1!=null) {
            this.tableaccepted.setItems(model1);
        }
    }
    private void loadmodel1(){
        this.model1.setAll(this.service.getAllAutoAppointmentsbyusernameandstatus(useruserusername,"Accept"));
    }
}
