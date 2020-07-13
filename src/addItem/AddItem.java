package addItem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * This is a Java Program []
 * 
 * Developed by Keziah Odoi.
 */

/**
 *
 * @author kezia
 */
public class AddItem extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = (Parent)FXMLLoader.load(getClass().getResource("AddItem.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
            }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
