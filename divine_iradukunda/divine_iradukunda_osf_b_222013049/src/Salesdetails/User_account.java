package Salesdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class User_account {
private int user_id;
private String user_name;
private String password;
private String user_email;
private String phone_number;
public User_account(int user_id, String user_name, String password, String user_email, String phone_number) {
	super();
	this.user_id = user_id;
	this.user_name = user_name;
	this.password = password;
	this.user_email = user_email;
	this.phone_number = phone_number;
}
public User_account() {
	// TODO Auto-generated constructor stub
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUser_email() {
	return user_email;
}
public void setUser_email(String user_email) {
	this.user_email = user_email;
}
public String getPhone_number() {
	return phone_number;
}
public void setPhone_number(String phone_number) {
	this.phone_number = phone_number;
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
	String sql="INSERT INTO user_account (User_name,Password,Email,Phonenumber) VALUES(?,?,?,?)";
	try {
		Connection con = DriverManager.getConnection(host, user, password);
	   	 PreparedStatement stm= con.prepareStatement(sql);
	   	stm.setString(1, user_name);
	   	stm.setString(2,password);
	   	stm.setString(3, user_email);
	   	stm.setString(4,phone_number );
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
public void readwithUser_id(int User_id2) {
	String url = "jdbc:mysql://localhost:3306/onlinesalesfurniture";
    String user = "root";
    String password = "";
    String sql = "SELECT * FROM user_account WHERE user_id= ?";
    try {
    	Connection connection = DriverManager.getConnection(url, user, password);
    	PreparedStatement preparedStatement = connection.prepareStatement(sql);
    	preparedStatement.setInt(1, User_id2);
    	ResultSet resultSet = preparedStatement.executeQuery();
    	 while (resultSet.next()) {
    		  this.setUser_id(resultSet.getInt("User_id"));
	             this.setUser_name(resultSet.getString("User_name"));
	             this.setPassword(resultSet.getString("Passsword"));
	             this.setUser_email(resultSet.getString("Email"));
	             this.setPhone_number(resultSet.getString("Phonenumber"));
	             
	             
	             System.out.println("User_id: " + getUser_id() + ", User_name: " + getUser_name() + ", Password: " + getPassword()+",Email:"+getUser_email()
	             +",Phonenumber:"+getPhone_number());
    	 }
	} catch (Exception e) {
		// TODO: handle exception
	}
}
public DefaultTableModel populateTable() {
	String host = "jdbc:mysql://localhost/onlinesalesfurniture";
    String user = "root";
    String password = "";
    String query= "SELECT * FROM user_account";
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

    
public void login() {
	makeconnection();
	String host = "jdbc:mysql://localhost/onlinesalesfurniture";
    String user = "root";
    String password = "";
    String sql = "SELECT * FROM user_account WHERE  	Email  = ? AND Password = ?";
    
	try(
			Connection con = DriverManager.getConnection(host, user, password);
        		
            PreparedStatement stm= con.prepareStatement(sql);
			
			) {
		
		stm.setString(1, this.user_email);
		stm.setString(2, this.password);
		ResultSet rs = stm.executeQuery();
		if(rs.next()) {
			System.out.println("Data inserted successfully!");
            JOptionPane.showMessageDialog(null, "Login successfully!","After login",JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Incorect Email and password!","After login",JOptionPane.INFORMATION_MESSAGE);
		}
		con.close();
		
} catch (SQLException e) {
    e.printStackTrace();
}
	
}
public void update(int user_id2) {
	 String url = "jdbc:mysql://localhost/onlinesalesfurniture";
     String user = "root";
     String password = "";
     String sql = "UPDATE user_account SET user_name=?, password=?, user_email=?, phonenumber=? WHERE user_id=?";
     try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, this.user_name);
            stm.setString(2, this.password);
            stm.setString(3, this.user_email);
            stm.setString(4, this.phone_number);

            stm.setInt(5, user_id2);

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
public void delete(int User_id2) {
	 String url = "jdbc:mysql://localhost/onlinesalesfurniture";
     String user = "root";
     String password = "";
     String sql = "DELETE FROM user_account WHERE user_id = ?";

     try (Connection con = DriverManager.getConnection(url, user, password);
          PreparedStatement pl = con.prepareStatement(sql)) {

         pl.setInt(1, User_id2);

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
	

	



 	


	
	






