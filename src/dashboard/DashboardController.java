/*
 * This is a Java Program []
 * 
 * Developed by Keziah Odoi.
 */
package dashboard;

import editEntry.EditEntryController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kezia
 */
public class DashboardController implements Initializable {

    @FXML
    private Button btnExport;
    @FXML
    private TableView<ProductInfo> tbViewItems;
    @FXML
    private TableColumn<ProductInfo, Number> colnRowNo;

    @FXML
    private TableColumn<ProductInfo, Number> colnBatchNo;

    @FXML
    private TableColumn<ProductInfo, String> colnItemType;

    @FXML
    private TableColumn<ProductInfo, String> colnItemName;

    @FXML
    private TableColumn<ProductInfo, Number> colnUnitPrice;

    @FXML
    private TableColumn<ProductInfo, Number> colnItemQuantity;

    @FXML
    private TableColumn<ProductInfo, Date> colnDateLogged;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    ObservableList<ProductInfo> list = FXCollections.observableArrayList();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("editEntry/EditEntry.fxml"));
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("DB Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/inventory_management", "root", "");
            System.out.println("Get connection");

            rs = connection.createStatement().executeQuery("select * from items_log");
            System.out.println("execute query");
            
            while (rs.next()) {
            ProductInfo pi = new ProductInfo();
            pi.setRowNo(rs.getInt("rowNumber"));
            pi.setBatchNo(rs.getInt("batchNumber"));
            pi.setItemType(rs.getString("itemType"));
            pi.setItemName(rs.getString("itemName"));
            pi.setUnitPrice(rs.getDouble("unitPrice"));
            pi.setIQuan(rs.getInt("itemQuantity"));    
            pi.setDate(rs.getDate("dateLogged"));
            
            list.add(pi);
            }

            
        } 
        catch (Exception ex) {
        ex.printStackTrace();        
        } 
        
        colnRowNo.setCellValueFactory(cellData -> cellData.getValue().getRowNoIntegerProperty());
        colnBatchNo.setCellValueFactory(cellData -> cellData.getValue().getBatchNoIntegerProperty());
        colnItemType.setCellValueFactory(cellData -> cellData.getValue().getItemTypeStringProperty());
        colnItemName.setCellValueFactory(cellData -> cellData.getValue().getItemNameStringProperty());
        colnUnitPrice.setCellValueFactory(cellData -> cellData.getValue().getUnitPriceDoubleProperty());
        colnItemQuantity.setCellValueFactory(cellData -> cellData.getValue().getItemQuanIntegerProperty());
        colnDateLogged.setCellValueFactory(new PropertyValueFactory<>("dateLogged"));
        
        tbViewItems.setItems(list);
        
    }    

    @FXML
    private void handleExportExcel(ActionEvent event) {
    }

    @FXML
    private void handleAddItem(ActionEvent event) throws IOException {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/addItem/AddItem.fxml"));
                System.out.println("Hello dashboard controller2");
                Parent root1 = (Parent)fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
    }

    @FXML
    private void handleUpdate(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/editEntry/EditEntry.fxml"));
                System.out.println("Hello dashboard controller2");
                Parent root1 = (Parent)fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();   
              
                
           ProductInfo pi = tbViewItems.getSelectionModel().getSelectedItem();
           String item = pi.getItemName();
           int bNumber = pi.getBatchNo();
           System.out.println(item);
           System.out.println(bNumber);

           Class.forName("com.mysql.jdbc.Driver");
           connection = DriverManager.getConnection("jdbc:mysql://localhost/inventory_management", "root", "");
           pst = connection.prepareStatement("select * from items_log where batchNumber="+ bNumber);
           rs= pst.executeQuery();
            if (rs.next()) {
//                System.out.println(rs.getInt("batchNumber") +  "\t" + 
//                                   rs.getString("itemName") + "\t" +
//                                   rs.getDouble("unitPrice"));
                
//                EditEntryController eeController = loader.getController();
                int number =rs.getInt("batchNumber");
                System.out.println(number);
                String name = rs.getString("itemName");
                System.out.println(name);
                double price = rs.getDouble("unitPrice");
      
//                eeController.setData(name, number, price);
            }
           
            
    }
  
    
    @FXML
    private void handleDeleteEntry(ActionEvent event) {
    }
    
}
