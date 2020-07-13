/*
 * This is a Java Program []
 * 
 * Developed by Keziah Odoi.
 */
package editEntry;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author kezia
 */
public class EditEntryController implements Initializable {

   
    @FXML
    private TextField txtBatchNo;
    
    @FXML
    private TextField txtItemType;
    
    @FXML
    private TextField txtItemName;
    
    @FXML
    private TextField txtUnitPrice;
    
    @FXML
    private TextField txtItemQuan;
    
    @FXML
    private Button btnUpdate;

    Connection connection;
    PreparedStatement pst;
    

    public EditEntryController() {
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      
    }    
    
    @FXML
    private void handleUpdate(ActionEvent event) throws ClassNotFoundException, SQLException {
        
   
    }
    
    
                
    public void setData(String name, int number, double price){
//        txtBatchNo.setText(String.valueOf(number));
//        txtItemName.setText(name);
//        txtUnitPrice.setText(String.valueOf(price));
System.out.println(name);
System.out.println(number);
System.out.println(price);
    }
    }