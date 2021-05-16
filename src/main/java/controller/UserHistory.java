package controller;

import domain.Appointment;
import domain.AutoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.Service;

public class UserHistory {
    @FXML
    private TableView<Appointment> tablehistory;

    @FXML
    private TableColumn<Appointment, String> historyservicename;

    @FXML
    private TableColumn<Appointment, String> historystatus;

    @FXML
    private TableColumn<Appointment, String> hisotrydate;

    @FXML
    private TableColumn<Appointment, String> historytime;

    @FXML
    private TableColumn<Appointment, String> historytypeofwork;
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
        this.historyservicename.setCellValueFactory(new PropertyValueFactory<>("servicename"));
        this.historystatus.setCellValueFactory(new PropertyValueFactory<>("situation"));
        this.hisotrydate.setCellValueFactory(new PropertyValueFactory<>("dateofappointment"));
        this.historytime.setCellValueFactory(new PropertyValueFactory<>("timeofappointment"));
        this.historytypeofwork.setCellValueFactory(new PropertyValueFactory<>("typeofwork"));
        loadmodel1();
        if(model1!=null) {
            this.tablehistory.setItems(model1);
        }
    }
    private void loadmodel1(){
        this.model1.setAll(this.service.getAllAutoAppointments(useruserusername));
    }
}
