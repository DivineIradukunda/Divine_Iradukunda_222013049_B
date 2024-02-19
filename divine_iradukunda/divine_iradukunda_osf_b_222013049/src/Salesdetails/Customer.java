package Salesdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Customer {
private int customer_id;
private String name;
private String email;
private String phonenumber;
private String address;


public Customer(int customer_id, String name, String email, String phonenumber, String address) {
	super();
	this.customer_id = customer_id;
	this.name = name;
	this.email = email;
	this.phonenumber = phonenumber;
	this.address = address;
}


public int getCustomer_id() {
	return customer_id;
}


public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getPhonenumber() {
	return phonenumber;
}


public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}
public void makeconnection() {
	String host = "jdbc:mysql://localhost/onlinesalesfurniture";
    String user = "root";
    String password = "";
}

public void insertData() {
	String host = "jdbc:mysql://localhost/onlinesalesfurniture";
    String user = "root";
    String password = "";
    String sql="INSERT INTO customer(Name,Email,Phonenumber,Address) VALUES(?,?,?,?)";
    try {
    	Connection con = DriverManager.getConnection(host, user, password);
   	 PreparedStatement stm= con.prepareStatement(sql);
    	stm.setString(1, name);
    	stm.setString(2,email);
    	stm.setString(3, phonenumber);
    	stm.setString(4,address);
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

public void readwithCustomer_id(int customer_id2) {
	String url = "jdbc:mysql://localhost:3306/onlinesalesfurniture";
    String user = "root";
    String password = "";
    String sql = "SELECT * FROM furniture WHERE Customer_id= ?";
    try {
    	Connection connection = DriverManager.getConnection(url, user, password);
    	PreparedStatement preparedStatement = connection.prepareStatement(sql);
    	preparedStatement.setInt(1, customer_id2);
    	ResultSet resultSet = preparedStatement.executeQuery();
    	 while (resultSet.next()) {
   		  this.setCustomer_id(resultSet.getInt("Customer_id"));
	             this.setName(resultSet.getString("Name"));
	             this.setEmail(resultSet.getString("Email"));
	             this.setPhonenumber(resultSet.getString("Phonenumber"));
	             this.setAddress(resultSet.getString("Address"));
	             
	             System.out.println("Customer_id: " + getCustomer_id() + ", Name: " + getName() + ", Email: " + getEmail()+",Phonenumber:"+getPhonenumber()
	             +",Address:"+getAddress());
    	 }
	             
	} catch (Exception e) {
		// TODO: handle exception
	}
}
public DefaultTableModel populateTable() {
	String host = "jdbc:mysql://localhost/onlinesalesfurniture";
    String user = "root";
    String password = "";
    String query= "SELECT * FROM customer";
    DefaultTableModel tableModel = null;
    try {
    	Connection con = DriverManager.getConnection(host, user, password);
        PreparedStatement stm = con.prepareStatement(query);
        ResultSet resultSet = stm.executeQuery();
        
        int columnCount = resultSet.getMetaData().getColumnCount();
        Vector<String> columnNames = new Vector<>();
        for (int i = 1; i <= columnCount; i++) {
            columnNames.add(resultSet.getMetaData().getColumnName(i));
        }
        Vector<Vector<Object>> data = new Vector<>();
        while (resultSet.next()) {
            Vector<Object> row = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                row.add(resultSet.getObject(i));
            }
            data.add(row);
        }
        tableModel = new DefaultTableModel(data, columnNames);
        con.close(); // Close the connection when done to release resources
	} catch (Exception e) {
		e.printStackTrace(); // Print the exception details for debugging purposes
	}
    return tableModel;
}


public void update(int customer_id2) {
	 String url = "jdbc:mysql://localhost/onlinesalesfurniture";
     String user = "root";
     String password = "";
     String sql = "UPDATE customer SET name=?, email=?, phonenumber=?, address=? WHERE customer_id=?";
     try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, this.name);
            stm.setString(2, this.email);
            stm.setString(3, this.phonenumber);
            stm.setString(4, this.address);
            stm.setInt(5, customer_id2);

            int rowsAffected = stm.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data updated successfully!");
                JOptionPane.showMessageDialog(null, "Data updated successfully!", "After update", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to update data. No matching record found.");
                JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found!", "After insert", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


public void delete(int customer_id2) {
	 String url = "jdbc:mysql://localhost/onlinesalesfurniture";
     String user = "root";
     String password = "";
     String sql = "DELETE FROM customer WHERE customer_id = ?";

     try (Connection con = DriverManager.getConnection(url, user, password);
          PreparedStatement pl = con.prepareStatement(sql)) {

         pl.setInt(1, customer_id2);

         int rowsAffected = pl.executeUpdate();

         if (rowsAffected > 0) {
             System.out.println("Data deleted successfully!");
             JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete", JOptionPane.INFORMATION_MESSAGE);
         } else {
             System.out.println("Failed to delete data. No matching record found.");
             JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found!", "After insert", JOptionPane.ERROR_MESSAGE);
         }

     } catch (SQLException e) {
         e.printStackTrace();
     }
 }

	

	
}
	


	

	



