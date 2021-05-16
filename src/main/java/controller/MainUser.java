package controller;

import domain.AutoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import service.Service;

public class MainUser {
    @FXML
    private TableView<AutoService> tablemainuser;

    @FXML
    private TableColumn<AutoService, String> servicenamemainuser;

    private Service service;
    private ObservableList<AutoService> model= FXCollections.observableArrayList();
    public void setService(Service service) {

        this.service = service;
        inittable();
    }
    private void inittable(){
        this.servicenamemainuser.setCellValueFactory(new PropertyValueFactory<>("Name"));
        loadmodel();
        this.tablemainuser.setItems(model);
    }
    private void loadmodel(){
        this.model.setAll(this.service.getAllAutoService());
    }

    public void mouseclickedtable(MouseEvent mouseEvent) {
        AutoService autoService=this.tablemainuser.getSelectionModel().getSelectedItem();
    }
}
