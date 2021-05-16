package controller;

import domain.AutoService;
import domain.AutoServiceProfile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.Service;

import java.io.IOException;

public class MainService {

    @FXML
    private TextField profiledescription;

    @FXML
    private TextField profileaddress;

    @FXML
    private Button buttonprofilesave;


    private Service service;
    private String username;

    public void Userset(String username){
        this.username=username;
    }

    public void setService(Service service) {
        this.service = service;
        AutoServiceProfile autoServiceProfile=this.service.getServiceProfileByUsername(username);
        if(autoServiceProfile!=null){
            profiledescription.setText(autoServiceProfile.getDescription());
            profileaddress.setText(autoServiceProfile.getAddress());
        }
    }



    public void mouseclikedsave(MouseEvent mouseEvent) {
        String descripton=profiledescription.getText();
        String address=profileaddress.getText();
        AutoServiceProfile newautoserviceprofile;
        AutoServiceProfile autoServiceProfile=this.service.getServiceProfileByUsername(username);
        if(autoServiceProfile==null){
            newautoserviceprofile=new AutoServiceProfile(username,descripton,address);
            this.service.addProfile(newautoserviceprofile);
        }else{
            autoServiceProfile.setDescription(descripton);
            autoServiceProfile.setAddress(address);
            this.service.updateAutoServiceProfile(autoServiceProfile);
        }

    }

    public void mouseclickedhistory(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/viewhistoryservice.fxml"));
        Parent root = loader.load();
        ServiceHistory controllerLogIn = loader.getController();
        controllerLogIn.Userset(username);
        controllerLogIn.setService(this.service);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("History");
        stage.show();
    }

    public void mosuseclickedaccepted(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/viewacceptedservice.fxml"));
        Parent root = loader.load();
        ServiceAccepted controllerLogIn = loader.getController();
        controllerLogIn.Userset(username);
        controllerLogIn.setService(this.service);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Accepted");
        stage.show();

    }

    public void mouseclickedpending(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/viewpendingservice.fxml"));
        Parent root = loader.load();
        ServicePending controllerLogIn = loader.getController();
        controllerLogIn.Userset(username);
        controllerLogIn.setService(this.service);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Pending appointments");
        stage.show();
    }
}
