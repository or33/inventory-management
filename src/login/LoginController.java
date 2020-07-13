/*
 * This is a Java Program []
 * 
 * Developed by Keziah Odoi.
 */
package login;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author kezia
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnLogin;
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleLogin(ActionEvent event) throws SQLException, IOException {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/inventory_management", "root", "");
            pst = connection.prepareStatement("select * from admin_login where username=? and password=?");
            
            pst.setString(1, username);
            pst.setString(2, password);
            
            rs= pst.executeQuery();
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Login Successful!");
                System.out.println("Hello loginpage controller1");
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/dashboard/Dashboard.fxml"));
                System.out.println("Hello loginpage controller2");
                Parent root1 = (Parent)fxmlLoader.load();
                
                System.out.println("Hello loginpage controller333++");

                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        finally {
        pst.close();
        ((Node)(event.getSource())).getScene().getWindow().hide();

        }
    }
    
}
