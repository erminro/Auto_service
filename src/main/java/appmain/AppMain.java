package appmain;

import controller.Login;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import repository.RepoDbAutoService;
import repository.RepoDbUser;
import service.Service;

public class AppMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try{
            FXMLLoader loader = new FXMLLoader(AppMain.class.getResource("/views/viewlogin.fxml"));
            Parent root = loader.load();
            Login controllerLogIn = loader.getController();
            controllerLogIn.setService(getService());
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Log In");
            primaryStage.show();
        }
        catch (Exception e){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error ");
            alert.setContentText("Error while starting app "+e);
            alert.showAndWait();
        }
    }

    private static Service getService() {
        RepoDbUser repoDbUser = new RepoDbUser();
        RepoDbAutoService repoDbAutoService = new RepoDbAutoService();
        return new Service(repoDbAutoService,repoDbUser);
    }
}