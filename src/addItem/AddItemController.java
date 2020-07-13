/*
 * This is a Java Program []
 * 
 * Developed by Keziah Odoi.
 */
package addItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.time.ZoneId;
import javafx.scene.Node;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author kezia
 */
public class AddItemController implements Initializable {

    @FXML
    private TextField txtBatchNumber;
    @FXML
    private TextField txtItemName;
    @FXML
    private TextField txtUnitPrice;
    @FXML
    private TextField txtItemQuan;
    @FXML
    private DatePicker dateDate;
    @FXML
    private ComboBox<String> comboItemType;
    @FXML
    private Button btnSave;
    
    Connection connection;
    PreparedStatement pst;
   
    ObservableList<String> list = FXCollections.observableArrayList(
    "Food Stuff", "Clothing", "Detergents", "Furniture");
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboItemType.setItems(list);
        
    }    

    @FXML
    private void handleSave(ActionEvent event) throws SQLException {
        int bNumber = Integer.parseInt(txtBatchNumber.getText());
        String iName = txtItemName.getText();
        double uPrice = Double.parseDouble(txtUnitPrice.getText());
        String iType = comboItemType.getValue();
        int iQUan = Integer.parseInt(txtItemQuan.getText());
        java.util.Date date = java.util.Date.from(dateDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        
        try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/inventory_management", "root", "");
                pst = connection.prepareStatement("insert into items_log(batchNumber, itemType, itemName, unitPrice, itemQuantity, dateLogged)values(?,?,?,?,?,?)");
                pst.setInt(1, bNumber);
                pst.setString(2, iType);
                pst.setString(3, iName);
                pst.setDouble(4, uPrice);
                pst.setInt(5, iQUan);
                pst.setDate(6, sqlDate);
                
                int i = pst.executeUpdate();
                System.out.println("Execute Update");
                if (i==1) {
                    System.out.println("Person registered!");
                    JOptionPane.showMessageDialog(null, "Item Added Successfully");
                    ((Node)(event.getSource())).getScene().getWindow().hide();
        } }
        catch (Exception ex) {
            ex.printStackTrace();
            } 
        finally {
        pst.close();
        }
        
    }  
 
}
