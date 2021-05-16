package controller;

import domain.AutoService;
import domain.AutoServiceProfile;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.Service;

import java.io.IOException;

public class Servicedescriptionforuser {
    @FXML
    private Button buttonmakeappointemnt;

    @FXML
    private TextField textfieldservicedescription;

    @FXML
    private TextField textfieldserviceaddress;

    @FXML
    private TextField texfieldservicename;
    private Service service;
    private AutoService autoService;
    private String userusername;
    private String usernameservice;
    public void UserUsername1(String username,String usernameservice)
    {
        this.userusername=username;
        this.usernameservice=usernameservice;
    }
    public void getAutoS(AutoService autoService)
    {
        this.autoService=autoService;
    }
    public void setService(Service service) {
        this.service = service;
        this.texfieldservicename.setText(autoService.getName());
        this.texfieldservicename.setEditable(false);
        AutoServiceProfile autoServiceProfile= service.getServiceProfileByUsername(autoService.getUsername());
        if(autoServiceProfile!=null)
        {
            textfieldserviceaddress.setText(autoServiceProfile.getAddress());
            textfieldservicedescription.setText(autoServiceProfile.getDescription());
        }
        this.textfieldservicedescription.setEditable(false);
        this.textfieldserviceaddress.setEditable(false);
    }

    public void buttonmakeappointmentcliked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/viewappointment.fxml"));
        Parent root = loader.load();
        Appointmentc controllerLogIn = loader.getController();
        controllerLogIn.Usernameandserviceusername(userusername,usernameservice);
        controllerLogIn.setService(this.service);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Log In");
        stage.show();
    }
}
