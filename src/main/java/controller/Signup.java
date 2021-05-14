package controller;

import domain.AbstractUser;
import domain.AutoService;
import domain.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import service.Service;

public class Signup {
    private Service service;
    @FXML
    private TextField textfieldusername;
    @FXML
    private TextField textfiledname;
    @FXML
    private TextField textfiledpassword;
    @FXML
    private ComboBox<String> comboboxtype;

    public void setService(Service service) {
        this.service = service;
        ObservableList<String> options = FXCollections.observableArrayList(
                "user",
                "auto service"
        );
        this.comboboxtype.setItems(options);
        this.comboboxtype.setValue("user");
    }

    public void buttoncreateaccountclicked(MouseEvent mouseEvent) {
        String username=this.textfieldusername.getText();
        String name=this.textfiledname.getText();
        String pass=this.textfiledpassword.getText();
        String type=this.comboboxtype.getValue();
        AbstractUser user = null;
        AbstractUser absuser=this.service.getUserByUsername(username);
        if(absuser==null) {
            if (username != "" && name != "" && pass != "") {
                if (pass.length() > 4) {
                    if(username.length()>2) {
                        if (type.equals("user")) {
                            user = new User(username, name, pass.hashCode(), type);
                        } else if (type.equals("auto service")) {
                            user = new AutoService(username, name, pass.hashCode(), type);
                        }
                        this.service.addUser(user);
                    }else{
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Username must have at least 3 characters!");
                        alert.setContentText("Username must have at least 3 characters");
                        alert.showAndWait();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Password must have at least 5 characters!");
                    alert.setContentText("Password must have at least 5 characters!");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Empty fields (all fields must be completed)!");
                alert.setContentText("Empty fields (all fields must be completed!");
                alert.showAndWait();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Username taken!");
            alert.setContentText("Username taken!");
            alert.showAndWait();
        }
    }
}
