package Salesdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Command {
private int command_id;
private String command_date;
private String status;
private String furniture_id;
private String customer_id;


public Command(int command_id, String command_date, String status, String furniture_id, String customer_id) {
	super();
	this.command_id = command_id;
	this.command_date = command_date;
	this.status = status;
	this.furniture_id = furniture_id;
	this.customer_id = customer_id;
}


public int getCommand_id() {
	return command_id;
}


public void setCommand_id(int command_id) {
	this.command_id = command_id;
}


public String getCommand_date() {
	return command_date;
}


public void setCommand_date(String command_date) {
	this.command_date = command_date;
}


public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
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
	String host = "jdbc:mysql://localhost/onlinesalesfurniture";
    String user = "root";
    String password = "";
}

public void insertData() {
	String host = "jdbc:mysql://localhost/onlinesalesfurniture";
    String user = "root";
    String password = "";
    String sql="INSERT INTO command(Command_date,Status,Furniture_id,Customer_id) VALUES(?,?,?,?)";
    try {
    	Connection con = DriverManager.getConnection(host, user, password);
      	 PreparedStatement stm= con.prepareStatement(sql);
      	stm.setString(1,this.command_date);
   	stm.setString(2, this.status);
   	stm.setString(3, this.furniture_id);
   	stm.setString(4, this.customer_id);
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

public void readwithCommand_id(int Command_id2) {
	String url = "jdbc:mysql://localhost:3306/onlinesalesfurniture";
    String user = "root";
    String password = "";
    String sql = "SELECT * FROM command WHERE Command_id= ?";
    try {
    	Connection connection = DriverManager.getConnection(url, user, password);
    	PreparedStatement preparedStatement = connection.prepareStatement(sql);
    	preparedStatement.setInt(1, Command_id2);
    	ResultSet resultSet = preparedStatement.executeQuery();
    	 while (resultSet.next()) {
    		  this.setCommand_id(resultSet.getInt("Command_id"));
	             this.setCommand_date(resultSet.getString("Command_id"));
	             this.setStatus(resultSet.getString("Status"));
	             this.setFurniture_id(resultSet.getString("Furniture_id"));
	             this.setCustomer_id(resultSet.getString("Customer_id"));
	             
	             System.out.println("Command_id: " + getCommand_id() + ", Command_date: " + getCommand_date() + ", Status: " + getStatus()+",Furniture_id:"+getFurniture_id()
	             +",Customer_id:"+getCustomer_id());
    	 }
	             
	} catch (Exception e) {
		// TODO: handle exception
	}
}
public DefaultTableModel populateTable() {
	String host = "jdbc:mysql://localhost/onlinesalesfurniture";
    String user = "root";
    String password = "";
    String query= "SELECT * FROM command";
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


public void update(int command_id2) {
	 String url = "jdbc:mysql://localhost/onlinesalesfurniture";
     String user = "root";
     String password = "";
     String sql = "UPDATE command SET command_date=?, status=?, furniture_id=?, customer_id=? WHERE command_id=?";
     try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, this.command_date);
            stm.setString(2, this.status);
            stm.setString(3, this.furniture_id);
            stm.setString(4, this.customer_id);
            stm.setInt(5, command_id2);

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


public void delete(int command_id2) {
	 String url = "jdbc:mysql://localhost/onlinesalesfurniture";
     String user = "root";
     String password = "";
     String sql = "DELETE FROM command WHERE command_id = ?";

     try (Connection con = DriverManager.getConnection(url, user, password);
          PreparedStatement pl = con.prepareStatement(sql)) {

         pl.setInt(1, command_id2);

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

	



