package Salesforms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Salesdetails.Customer;
import Salesdetails.User_account;

public class Customerform implements ActionListener{
	JFrame frame;
	JLabel customer_id_lb=new JLabel("FURNITURE_ID");
	JLabel name_lb=new JLabel("NAME");
	JLabel email_lb=new JLabel("EMAIL");
	JLabel phonenumber_lb=new JLabel("PHONENUMBER");
	JLabel address_lb=new JLabel("ADDRESS");
	
	JTextField customer_id_txf=new JTextField();
	JTextField name_txf=new JTextField();
	JTextField email_txf=new JTextField();
	JTextField phonenumber_txf=new JTextField();
	JTextField address_txf=new JTextField();
	
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	JTable table=new JTable();
	JScrollPane scrollPane = new JScrollPane(table);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	
	public Customerform() {
		creatForm();
		
	}
	private void creatForm() {
		frame=new JFrame();
		frame.setTitle("CUSTOMER_ID");
		frame.setBounds(0,0,600,600);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		setLocationandSize();
		
	}
	private void setLocationandSize() {
		customer_id_lb.setBounds(10,60,100,30);
		name_lb.setBounds(10,100,100,30);
		email_lb.setBounds(10,140,100,30);
		phonenumber_lb.setBounds(10,180,100,30);
		address_lb.setBounds(10,220,100,30);
		
		customer_id_txf.setBounds(200,60,150,30);
		name_txf.setBounds(200,100,150,30);
		email_txf.setBounds(200,140,150,30);
		phonenumber_txf.setBounds(200,180,150,30);
		address_txf.setBounds(200,220,150,30);
		
		insert_btn.setBounds(10,290,90,30);
		Read_btn.setBounds(110,290,90,30);
		update_btn.setBounds(210,290,90,30);
		delete_btn.setBounds(310,290,90,30);
		table.setBounds(400,10,500,300);
		setFontforall();
		
	}
	private void setFontforall() {
		frame.add(customer_id_lb);
		frame.add(name_lb);
		frame.add(email_lb);
		frame.add(phonenumber_lb);
		frame.add(address_lb);
		frame.add(customer_id_txf);
		frame.add(name_txf);
		frame.add(email_txf);
		frame.add(phonenumber_txf);
		frame.add(address_txf);
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		ActionEvent();
		
	}
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
		addComponentforFrame();
		
	}
	private void addComponentforFrame() {
		frame.add(customer_id_lb);
		frame.add(name_lb);
		frame.add(email_lb);
		frame.add(phonenumber_lb);
		frame.add(address_lb);
		frame.add(customer_id_txf);
		frame.add(name_txf);
		frame.add(email_txf);
		frame.add(phonenumber_txf);
		frame.add(address_txf);
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		frame.add(table);
	}
	public static void main(String[]args) {
		Customerform u_f=new Customerform();
	}
	public void actionPerformed(ActionEvent e) {
		Customer u=new Customer(0, null, null, null, null);
		if(e.getSource()==insert_btn) {
			u.setName(name_txf.getText());
			u.setEmail(email_txf.getText());
			u.setPhonenumber(phonenumber_txf.getText());
			u.setAddress(address_txf.getText());
			u.insertData();
		}
		else if ((e.getSource()==Read_btn)) {
			DefaultTableModel tableModel=u.populateTable();
			table.setModel(tableModel);
	}
		 else if (e.getSource() == update_btn) {
	         int Customer_id = Integer.parseInt(customer_id_txf.getText());
	         u.setName(name_txf.getText());
	         u.setEmail(email_txf.getText());
	         u.setPhonenumber(phonenumber_txf.getText());
	         u.setAddress(address_txf.getText());

	         u.update(Customer_id);
		 }
		  else {
		         int id = Integer.parseInt(customer_id_txf.getText());
		         u.delete(id);
		     }
		 }
			
		
}
			
		
				
		
	


