package controller;

import domain.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.Service;

public class ServiceAccepted {
    @FXML
    private TableView<Appointment> tableacceptedservice;

    @FXML
    private TableColumn<Appointment, String> acceptedfullname;

    @FXML
    private TableColumn<Appointment, String>  acceptedtypeofworkservice;

    @FXML
    private TableColumn<Appointment, String>  acceptedtimeservice;

    @FXML
    private TableColumn<Appointment, String> accepteddateserive;

    @FXML
    private TableColumn<Appointment, String>  acceptedstatus;
    private Service service;
    private String username;
    public void Userset(String username){
        this.username=username;
    }
    private ObservableList<Appointment> model1= FXCollections.observableArrayList();
    public void setService(Service service) {
        this.service = service;
        inittable1();
    }
    private void inittable1(){
        this.acceptedfullname.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        this.acceptedstatus.setCellValueFactory(new PropertyValueFactory<>("situation"));
        this.accepteddateserive.setCellValueFactory(new PropertyValueFactory<>("dateofappointment"));
        this.acceptedtimeservice.setCellValueFactory(new PropertyValueFactory<>("timeofappointment"));
        this.acceptedtypeofworkservice.setCellValueFactory(new PropertyValueFactory<>("typeofwork"));
        loadmodel1();
        if(model1!=null) {
            this.tableacceptedservice.setItems(model1);
        }
    }
    private void loadmodel1(){
        this.model1.setAll(this.service.getAllAutoAppointmentsbystatus(username,"Accepted"));
    }
}
