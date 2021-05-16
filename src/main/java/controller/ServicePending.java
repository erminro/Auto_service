package controller;

import domain.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ServicePending {

    @FXML
    private TableView<Appointment> tablependingservice;

    @FXML
    private TableColumn<Appointment, String> pendingfullname;

    @FXML
    private TableColumn<Appointment, String> pendingtypeofworkservice;

    @FXML
    private TableColumn<Appointment, String> pendingtimeservice;

    @FXML
    private TableColumn<Appointment, String> pendingdateserive;
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
        this.pendingfullname.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        this.pendingdateserive.setCellValueFactory(new PropertyValueFactory<>("dateofappointment"));
        this.pendingtimeservice.setCellValueFactory(new PropertyValueFactory<>("timeofappointment"));
        this.pendingtypeofworkservice.setCellValueFactory(new PropertyValueFactory<>("typeofwork"));
        loadmodel1();
        if(model1!=null) {
            this.tablependingservice.setItems(model1);
        }
    }
    private void loadmodel1(){
        this.model1.setAll(this.service.getAllAutoAppointmentsbystatus(username,"Pending"));
    }

    public void mouseclickedtableappointments(MouseEvent mouseEvent) throws IOException {
                Appointment appointment = this.tablependingservice.getSelectionModel().getSelectedItem();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/Views/viewappointmentservice.fxml"));
                Parent root = loader.load();
                AppointmentServiceView controllerLogIn = loader.getController();
                controllerLogIn.GetAppointments(appointment);
                controllerLogIn.setService(this.service);
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Pending history");
                stage.show();
    }
}
