package Salesdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Furniture {
private int furniture_id;
private String type;
private String category;
private String name;
private String size;


public Furniture(int furniture_id, String type, String category, String name, String size) {
	super();
	this.furniture_id = furniture_id;
	this.type = type;
	this.category = category;
	this.name = name;
	this.size = size;
}


public int getFurniture_id() {
	return furniture_id;
}


public void setFurniture_id(int furniture_id) {
	this.furniture_id = furniture_id;
}


public String getType() {
	return type;
}


public void setType(String type) {
	this.type = type;
}


public String getCategory() {
	return category;
}


public void setCategory(String category) {
	this.category = category;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getSize() {
	return size;
}


public void setSize(String size) {
	this.size = size;
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
    String sql="INSERT INTO furniture (Type,Category,Name,Size) VALUES(?,?,?,?)";
    try {
    	Connection con = DriverManager.getConnection(host, user, password);
	   	 PreparedStatement stm= con.prepareStatement(sql);
	   	stm.setString(1, type);
	   	stm.setString(2,category);
	   	stm.setString(3, name);
	   	stm.setString(4,size );
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
	public void readwithFurniture_id(int furniture_id2) {
		String url = "jdbc:mysql://localhost:3306/onlinesalesfurniture";
	    String user = "root";
	    String password = "";
	    String sql = "SELECT * FROM furniture WHERE Furniture_id= ?";
	    try {
	    	Connection connection = DriverManager.getConnection(url, user, password);
	    	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    	preparedStatement.setInt(1, furniture_id2);
	    	ResultSet resultSet = preparedStatement.executeQuery();
	    	 while (resultSet.next()) {
	    		  this.setFurniture_id(resultSet.getInt("Furniture_id"));
		             this.setType(resultSet.getString("Type"));
		             this.setCategory(resultSet.getString("Category"));
		             this.setName(resultSet.getString("Name"));
		             this.setSize(resultSet.getString("Size"));
		             
		             
		             System.out.println("Furniture_id: " + getFurniture_id() + ", Type: " + getType() + ", Category: " + getCategory()+",Name:"+getName()
		             +",Size:"+getSize());
	    	 }
		} catch (Exception e) {
			// TODO: handle exception
		}
} 

public DefaultTableModel populateTable() {
	
	String host = "jdbc:mysql://localhost/onlinesalesfurniture";
    String user = "root";
    String password = "";
    String query= "SELECT * FROM furniture";
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

public void update(int furniture_id2) {
    String url = "jdbc:mysql://localhost/onlinesalesfurniture";
    String user = "root";
    String password = "";
    String sql = "UPDATE furniture SET type=?, category=?, name=?, size=? WHERE furniture_id=?";

    try (Connection con = DriverManager.getConnection(url, user, password);
         PreparedStatement stm = con.prepareStatement(sql)) {

        stm.setString(1, this.type);
        stm.setString(2, this.category);
        stm.setString(3, this.name);
        stm.setString(4, this.size);
        stm.setInt(5, furniture_id2);

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


public void delete(int furniture_id2) {
    String url = "jdbc:mysql://localhost/onlinesalesfurniture";
    String user = "root";
    String password = "";
    String sql = "DELETE FROM furniture WHERE furniture_id = ?";

    try (Connection con = DriverManager.getConnection(url, user, password);
         PreparedStatement pl = con.prepareStatement(sql)) {

        pl.setInt(1, furniture_id2);

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




