package Salesdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class Stock {
private int stock_id;
private String address;
private String furniture_id;
private String quantity;


public Stock(int stock_id, String address, String furniture_id, String quantity) {
	super();
	this.stock_id = stock_id;
	this.address = address;
	this.furniture_id = furniture_id;
	this.quantity = quantity;
}


public int getStock_id() {
	return stock_id;
}


public void setStock_id(int stock_id) {
	this.stock_id = stock_id;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}
public String getFurniture_id() {
	return furniture_id;
}


public void setFurniture_id(String furniture_id) {
	this.furniture_id = furniture_id;
}


public String getQuantity() {
	return quantity;
}


public void setQuantity(String quantity) {
	this.quantity = quantity;
}
public void  makeconnection() {
	String host = "jdbc:mysql://localhost/onlinesalesfurniture";
    String user = "root";
    String password = "";
}

public void setinsertData() {
	String host = "jdbc:mysql://localhost/onlinesalesfurniture";
    String user = "root";
    String password = "";
    String sql="INSERT INTO stock(Address,Furniture_id,Quantity) VALUES(?,?,?)";
    try {
    	Connection con = DriverManager.getConnection(host, user, password);
	   	 PreparedStatement stm= con.prepareStatement(sql);
	   	stm.setString(1, address);
	   	stm.setString(2,furniture_id);
	   	stm.setString(3, quantity);
	   	int rowsAffected = stm.executeUpdate();
	    if (rowsAffected > 0) {
	   	 System.out.println("data inserted succeccful");
	   	 JOptionPane.showMessageDialog(null, "data inserted successful","After insert",JOptionPane.INFORMATION_MESSAGE);
	    }
	   	 else {
	   		 System.out.println("Failed to insert data!!!");
	            JOptionPane.showMessageDialog(null, "Failed to insert data!!!","After insert",JOptionPane.ERROR_MESSAGE);
	            }
	   	 
	   	 
	} catch (Exception e) {
		// TODO: handle exception
	}
	
}



}
