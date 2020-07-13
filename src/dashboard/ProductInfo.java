/*
 * This is a Java Program []
 * 
 * Developed by Keziah Odoi.
 */
package dashboard;

import java.sql.Date;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author kezia
 */
public class ProductInfo {
    
    private IntegerProperty rowNo, batchNo, itemQuan;
    private StringProperty iType, iName;
    private DoubleProperty uPrice;
    private Date date;

    public ProductInfo() {
        this.rowNo = new SimpleIntegerProperty();
        this.batchNo = new SimpleIntegerProperty();
        this.itemQuan = new SimpleIntegerProperty();
        this.iType = new SimpleStringProperty();
        this.iName = new SimpleStringProperty();
        this.uPrice = new SimpleDoubleProperty();
        this.date = new Date(10);
    }
    
   public void setBatchNo(int number) {
       this.batchNo.set(number);
   } 
   
   public int getBatchNo() {
        return batchNo.get();
   }
   public IntegerProperty getBatchNoIntegerProperty() {
        return  batchNo;        
   }
    
   
   public int getRowNo() {
        return rowNo.get();
   }
   
   public void setRowNo(int row) {
   this.rowNo.set(row);
   }
   
   public IntegerProperty getRowNoIntegerProperty() {
        return  rowNo;        
   }
   
   public void setIQuan(int quantity) {
       this.itemQuan.set(quantity);
   } 
   
   public int getIQuan() {
        return itemQuan.get();
   }
   public IntegerProperty getItemQuanIntegerProperty() {
        return  itemQuan;        
   }
    
   public void setItemType(String type) {
       this.iType.set(type);
   } 
   
   public String getItemType() {
        return iType.get();
   }
   public StringProperty getItemTypeStringProperty() {
        return  iType;        
   }
   
   public void setItemName(String name) {
       this.iName.set(name);
   } 
   
   public String getItemName() {
        return iName.get();
   }
   public StringProperty getItemNameStringProperty() {
        return  iName;        
   }
   
   public void setUnitPrice(double price) {
       this.uPrice.set(price);
   } 
   
   public Double getUnitPrice() {
        return uPrice.get();
   }
   public DoubleProperty getUnitPriceDoubleProperty() {
        return  uPrice;        
   }
   
   public void setDate(Date newDate) {
       this.date = newDate;
   } 
   
   public Date getDate() {
        return date;
   }
   
    
}
