/*
 * This is a Java Program []
 * 
 * Developed by Keziah Odoi.
 */
package login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author kezia
 */
public class Login extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = (Parent)FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
         
}
    public static void main(String[] args) {
        launch(args);
    }
}
