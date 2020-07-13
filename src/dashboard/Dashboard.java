/*
 * This is a Java Program []
 * 
 * Developed by Keziah Odoi.
 */
package dashboard;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author kezia
 */
public class Dashboard extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root;
        root = (Parent)FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
