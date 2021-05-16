package controller;

import domain.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import service.Service;

public class Appointmentc {
    @FXML
    private ComboBox<String> comboboxtime;

    @FXML
    private DatePicker datepickerdate;

    @FXML
    private Button buttonmakeappointemnt;

    @FXML
    private TextField textmakecar;

    @FXML
    private TextField textmodelcar;

    @FXML
    private TextField textcaryear;

    @FXML
    private TextField textfullname;

    @FXML
    private ComboBox<String> texttypeofworkrequired;
    private Service service;
    private String userusername;
    private String usernameservice;
    public void Usernameandserviceusername(String username,String usernameservice){
        this.userusername=username;
        this.usernameservice=usernameservice;
    }
    public void setService(Service service) {
        this.service = service;
        ObservableList<String> options2 = FXCollections.observableArrayList(
                "9:00", "10:00", "11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00");
        this.comboboxtime.setItems(options2);
        ObservableList<String> options1 = FXCollections.observableArrayList(
                "Inspection", "Maintenance", "Mechanical","Electrical","Bodywork");
        this.texttypeofworkrequired.setItems(options1);
    }

    public void buttonmakeappointmentpressed(MouseEvent mouseEvent) {
        String caryear=this.textcaryear.getText();
        String carmake=this.textmakecar.getText();
        String carmodel=this.textmodelcar.getText();
        String fullname=this.textfullname.getText();
        String time=this.comboboxtime.getValue();
        String typeofwork=this.texttypeofworkrequired.getValue();
        String date=this.datepickerdate.getValue().toString();
        String status="Pending";
        Appointment appointment=new Appointment(userusername,fullname,caryear,carmake,carmodel,date,typeofwork,time,status,usernameservice);
        this.service.addAppointment(appointment);
    }
}
