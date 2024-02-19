package Salesdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Payment {
private int payment_id;
private String total_amount;
private String payment_method;
private String date;
private String furniture_id;
private String customer_id;


public Payment(int payment_id, String total_amount, String payment_method, String date, String furniture_id,
		String customer_id) {
	super();
	this.payment_id = payment_id;
	this.total_amount = total_amount;
	this.payment_method = payment_method;
	this.date = date;
	this.furniture_id = furniture_id;
	this.customer_id = customer_id;
}


public int getPayment_id() {
	return payment_id;
}


public void setPayment_id(int payment_id) {
	this.payment_id = payment_id;
}


public String getTotal_amount() {
	return total_amount;
}


public void setTotal_amount(String total_amount) {
	this.total_amount = total_amount;
}


public String getPayment_method() {
	return payment_method;
}


public void setPayment_method(String payment_method) {
	this.payment_method = payment_method;
}


public String getDate() {
	return date;
}


public void setDate(String date) {
	this.date = date;
}


public String getFurniture_id() {
	return furniture_id;
}


public void setFurniture_id(String furniture_id) {
	this.furniture_id = furniture_id;
}


public String getCustomer_id() {
	return customer_id;
}


public void setCustomer_id(String customer_id) {
	this.customer_id = customer_id;
}
public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/onlinesalesfurniture";
    String user = "root";
    String password = "";

    // SQL query to insert data
    String sql = "INSERT INTO Payment (	total_amount, payment_method, date, furniture_id, customer_id) VALUES (?,?,?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.total_amount);
       preparedStatement.setString(2, this.payment_method);
       preparedStatement.setString(3, this.date);
       preparedStatement.setString(4, this.furniture_id);
       preparedStatement.setString(5, this.customer_id);
       
        
        // Execute the query
        int rowsAffected = preparedStatement.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
        	System.out.println("Data insert successfully!");
            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to insert data.");
            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

        }

    } catch (SQLException e) {
        e.printStackTrace();
    }}
 

public void delete(int inputpid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/onlinesalesfurniture";
    String user = "root";
    String password = "";

    // SQL query to delete data
    String sql = "DELETE FROM Payment WHERE  Payment_id = ?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputpid); // Assuming there is a column named 'id' for the WHERE clause

        // Execute the delete
        int rowsAffected = pl.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
            System.out.println("Data deleted successfully!");
            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to delete data. No matching record found.");
            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public void readwithPayment_id(int payment_id2) {
    	String url = "jdbc:mysql://localhost:3306/onlinesalesfurniture";
        String user = "root";
        String password = "";
        String sql = "SELECT * FROM payment WHERE payment_id= ?";
        try {
        	Connection connection = DriverManager.getConnection(url, user, password);
        	PreparedStatement preparedStatement = connection.prepareStatement(sql);
        	preparedStatement.setInt(1, payment_id2);
        	ResultSet resultSet = preparedStatement.executeQuery();
        	 while (resultSet.next()) {
        		  this.setPayment_id(resultSet.getInt("Payment_id"));
    	             this.setTotal_amount(resultSet.getString("Total_amount"));
    	             this.setPayment_method(resultSet.getString("Payment_method"));
    	             this.setDate(resultSet.getString("Date"));
    	             this.setFurniture_id(resultSet.getString("Furniture_id"));
    	             this.setCustomer_id(resultSet.getString("Customer_id"));
    	             
    	             
    	             System.out.println("Payment_id: " + getPayment_id() + ", Total_amount: " + getTotal_amount() + ", Payment_method: " + getPayment_method()+",Date:"+getDate()
		             +",Furniture_id:"+getFurniture_id() + ", Customer_id: " + getCustomer_id());
        	 }
    	} catch (Exception e) {
    		// TODO: handle exception
    	}
    }



public DefaultTableModel populateTable() {
	String host = "jdbc:mysql://localhost/onlinesalesfurniture";
    String user = "root";
    String password = "";
    String query= "SELECT * FROM payment";
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


public void update(int payment_id2) {
	 String url = "jdbc:mysql://localhost/onlinesalesfurniture";
     String user = "root";
     String password = "";
     String sql = "UPDATE payment SET total_amount=?, payment_method=?, date=?, furniture_id=?,customer_id=? WHERE payment_id=?";
     try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, this.total_amount);
            stm.setString(2, this.payment_method);
            stm.setString(3, this.date);
            stm.setString(4, this.furniture_id);
            stm.setString(5, this.customer_id);
            stm.setInt(6, payment_id2);

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
	
}
