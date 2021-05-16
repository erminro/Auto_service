package controller;

import domain.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.Service;

public class UserPending {
    @FXML
    private TableView<Appointment> tablepending;

    @FXML
    private TableColumn<Appointment, String> pendingservicename;

    @FXML
    private TableColumn<Appointment, String> pendingstatus;

    @FXML
    private TableColumn<Appointment, String> pendingdate;

    @FXML
    private TableColumn<Appointment, String> pendingtime;

    @FXML
    private TableColumn<Appointment, String> pendingtypeofwork;
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
        this.pendingservicename.setCellValueFactory(new PropertyValueFactory<>("servicename"));
        this.pendingstatus.setCellValueFactory(new PropertyValueFactory<>("situation"));
        this.pendingdate.setCellValueFactory(new PropertyValueFactory<>("dateofappointment"));
        this.pendingtime.setCellValueFactory(new PropertyValueFactory<>("timeofappointment"));
        this.pendingtypeofwork.setCellValueFactory(new PropertyValueFactory<>("typeofwork"));
        loadmodel1();
        if(model1!=null) {
            this.tablepending.setItems(model1);
        }
    }
    private void loadmodel1(){
        this.model1.setAll(this.service.getAllAutoAppointmentsbyusernameandstatus(useruserusername,"Pending"));
    }
}
