package controller;

import domain.Appointment;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.hibernate.Session;
import service.Service;

public class AppointmentServiceView {

    @FXML
    private TextField textmakecara;

    @FXML
    private TextField textmodelcara;

    @FXML
    private TextField textcaryeara;

    @FXML
    private TextField textfullnamea;

    @FXML
    private TextField texttypea;

    @FXML
    private TextField textdatea;

    @FXML
    private TextField texttimea;
    @FXML
    private Button buttondecline;
    @FXML
    private Button buttonaccepted;
    private Appointment appointment;
    private Service service;
    public void GetAppointments(Appointment appointment){
        this.appointment=appointment;
    }
    public void setService(Service service) {
        this.service = service;
        this.textfullnamea.setText(appointment.getFullname());
        this.textcaryeara.setText(appointment.getYearofthecar());
        this.textmakecara.setText(appointment.getMakeofthecar());
        this.textmodelcara.setText(appointment.getModelofthecar());
        this.textdatea.setText(appointment.getDateofappointment());
        this.texttimea.setText(appointment.getTimeofappointment());
        this.texttypea.setText(appointment.getTypeofwork());
        this.textfullnamea.setEditable(false);
        this.textcaryeara.setEditable(false);
        this.textmakecara.setEditable(false);
        this.textmodelcara.setEditable(false);
        this.textdatea.setEditable(false);
        this.texttimea.setEditable(false);
        this.texttypea.setEditable(false);

    }

    public void buttondeclineclicked(MouseEvent mouseEvent) {
        Stage stage=(Stage) buttondecline.getScene().getWindow();
        appointment.setSituation("Declined");
        this.service.updateAppointment(appointment);
        stage.close();
    }

    public void buttonacceptclicked(MouseEvent mouseEvent) {
        Stage stage=(Stage) buttonaccepted.getScene().getWindow();
        appointment.setSituation("Accepted");
        this.service.updateAppointment(appointment);
        stage.close();

    }
}
