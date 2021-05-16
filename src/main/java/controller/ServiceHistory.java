package controller;

import domain.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.Service;

public class ServiceHistory {

    @FXML
    private TableView<Appointment> tablehistoryservice;

    @FXML
    private TableColumn<Appointment, String> historyfullname;

    @FXML
    private TableColumn<Appointment, String> hystorytypeofworkservice;

    @FXML
    private TableColumn<Appointment, String> historytimeservice;

    @FXML
    private TableColumn<Appointment, String> historydateserive;
    @FXML
    private TableColumn<Appointment, String> historystatus;
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
        this.historyfullname.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        this.historystatus.setCellValueFactory(new PropertyValueFactory<>("situation"));
        this.historydateserive.setCellValueFactory(new PropertyValueFactory<>("dateofappointment"));
        this.historytimeservice.setCellValueFactory(new PropertyValueFactory<>("timeofappointment"));
        this.hystorytypeofworkservice.setCellValueFactory(new PropertyValueFactory<>("typeofwork"));
        loadmodel1();
        if(model1!=null) {
            this.tablehistoryservice.setItems(model1);
        }
    }
    private void loadmodel1(){
        this.model1.setAll(this.service.getAllAutoAppointmentsbyserviceusername(username));
    }
}
