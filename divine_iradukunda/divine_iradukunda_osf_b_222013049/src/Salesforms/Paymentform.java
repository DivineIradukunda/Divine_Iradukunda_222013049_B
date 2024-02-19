package Salesforms;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Salesdetails.Furniture;
import Salesdetails.Payment;

public class Paymentform implements ActionListener{
	JFrame frame;
	JLabel payment_id_lb=new JLabel("PAYMENT_ID");
	JLabel total_amount_lb=new JLabel ("TOTAL_AMOUNT");
	JLabel payment_method_lb=new JLabel("PAYMENT_METHOD");
	JLabel date_lb=new JLabel("DATE");
	JLabel furniture_id_lb=new JLabel("FURNITURE_ID");
	JLabel customer_id_lb=new JLabel("CUSTOMER_ID");
	
	
	JTextField payment_id_txf=new JTextField();
	JTextField total_amount_txf=new JTextField();
	JTextField payment_method_txf=new JTextField();
	JTextField date_txf=new JTextField();
	JTextField furniture_id_txf=new JTextField();
	JTextField customer_id_txf=new JTextField();
	
	
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	JTable table=new JTable();
	JScrollPane scrollPane = new JScrollPane(table);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	
	
	public Paymentform() {
		creatForm();
	}
	
	
	private void creatForm() {
		frame=new JFrame();
	     frame.setTitle("PAYMENT_ID");
	     frame.setBounds(0,0,600,600);
	     frame.getContentPane().setLayout(null);
	     frame.getContentPane().setBackground(Color.BLUE);
	     frame.setVisible(true);
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.setResizable(true);
		setLocationandSize();
	}


	private void setLocationandSize() {
		payment_id_lb.setBounds(10,60,100,30);
		total_amount_lb.setBounds(10,100,100,30);
	    payment_method_lb.setBounds(10,140,100,30);
		date_lb.setBounds(10,180,100,30);
		furniture_id_lb.setBounds(10,220,100,30);
		customer_id_lb.setBounds(10,260,100,30);
		
		payment_id_txf.setBounds(200,60,150,30);
		total_amount_txf.setBounds(200,100,150,30);
		payment_method_txf.setBounds(200,140,150,30);
		date_txf.setBounds(200,180,150,30);
		furniture_id_txf.setBounds(200,220,150,30);
		customer_id_txf.setBounds(200,260,150,30);
		
		insert_btn.setBounds(10,290,90,30);
		Read_btn.setBounds(110,290,90,30);
		update_btn.setBounds(210,290,90,30);
		delete_btn.setBounds(310,290,90,30);
		table.setBounds(400,10,500,300);
		setFontforall();
		
	}


	private void setFontforall() {
		frame.add(payment_id_lb);
	       frame.add(total_amount_lb);
	       frame.add(payment_id_lb);
	       frame.add(date_lb);
	       frame.add(furniture_id_lb);
	       frame.add(customer_id_lb);
	       
	       frame.add(payment_id_txf);
	       frame.add(total_amount_txf);
	       frame.add(payment_id_txf);
	       frame.add(date_txf);
	       frame.add(furniture_id_txf);
	       frame.add(customer_id_txf);
	       
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
		addcomponentforFrame();
		
	}


	private void addcomponentforFrame() {
		frame.add(payment_id_lb);
		frame.add(total_amount_lb);
		frame.add(payment_method_lb);
		frame.add(date_lb);
		frame.add(furniture_id_lb);
		frame.add(customer_id_lb);
		
		frame.add(payment_id_txf);
		frame.add(total_amount_txf);
		frame.add(payment_method_txf);
		frame.add(date_txf);
		frame.add(furniture_id_txf);
		frame.add(customer_id_txf);
		
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		frame.add(table);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Payment pt=new Payment(0, null, null, null, null, null);
		if(e.getSource()==insert_btn) {
			pt.setTotal_amount(total_amount_txf.getText());
			pt.setPayment_method(payment_method_txf.getText());
			pt.setDate(date_txf.getText());
			pt.setFurniture_id(furniture_id_txf.getText());
			pt.setCustomer_id(customer_id_txf.getText());
			pt.insertData();
			
		}
		
		else if ((e.getSource()==Read_btn)) {
			DefaultTableModel tableModel=pt.populateTable();
			table.setModel(tableModel);
		}
		
		
	    else if (e.getSource()==update_btn) {
			int Payment_id=Integer.parseInt(payment_id_txf.getText());
			pt.setTotal_amount(total_amount_txf.getText());
			pt.setPayment_method(payment_method_txf.getText());
			pt.setDate(date_txf.getText());
			pt.setFurniture_id(furniture_id_txf.getText());
			pt.setCustomer_id(customer_id_txf.getText());
			
			pt.update(Payment_id);
	    
	    }
	  else {
			int id=Integer.parseInt(payment_id_txf.getText());
			pt.delete(id);
	  }
			}

	  
		
	
	 public static void main(String[] args) {
			
			Paymentform Prf= new Paymentform();
			System.out.println(Prf);
			
		}
	}



	