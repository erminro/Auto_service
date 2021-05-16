package controller;

import domain.AutoService;
import domain.AutoServiceProfile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import service.Service;

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
            autoServiceProfile.setAddress(address);
            autoServiceProfile.setDescription(descripton);
        }

    }
}
