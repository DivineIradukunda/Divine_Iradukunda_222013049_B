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

import Salesdetails.Command;
import Salesdetails.Furniture;

public class Commandform implements ActionListener{
	JFrame frame;
	JLabel command_id_lb=new JLabel("COMMAND_ID");
	JLabel command_date_lb=new JLabel ("COMMAND_DATE");
	JLabel status_lb=new JLabel("STATUS");
	JLabel furniture_id_lb=new JLabel("FURNITURE_ID");
	JLabel customer_id_lb=new JLabel("CUSTOMER_ID");
	
	JTextField command_id_txf=new JTextField();
	JTextField command_date_txf=new JTextField();
	JTextField status_txf=new JTextField();
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
	
	
	public Commandform() {
		creatForm();
	}
	private void creatForm() {
		frame=new JFrame();
	     frame.setTitle("COMMAND_ID");
	     frame.setBounds(0,0,600,600);
	     frame.getContentPane().setLayout(null);
	     frame.getContentPane().setBackground(Color.BLUE);
	     frame.setVisible(true);
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.setResizable(true);
	     setLocationandSize();
		
	}
	private void setLocationandSize() {
		command_id_lb.setBounds(10,60,100,30);
		command_date_lb.setBounds(10,100,100,30);
	    status_lb.setBounds(10,140,100,30);
		furniture_id_lb.setBounds(10,180,100,30);
		customer_id_lb.setBounds(10,220,100,30);
		
		command_id_txf.setBounds(200,60,150,30);
		command_date_txf.setBounds(200,100,150,30);
		status_txf.setBounds(200,140,100,30);
		furniture_id_txf.setBounds(200,180,150,30);
		customer_id_txf.setBounds(200,220,150,30);
		
		insert_btn.setBounds(10,290,90,30);
		Read_btn.setBounds(110,290,90,30);
		update_btn.setBounds(210,290,90,30);
		delete_btn.setBounds(310,290,90,30);
		table.setBounds(400,10,500,300);
		setFontforall();
		
	}
	private void setFontforall() {
		frame.add(command_date_lb);
	       frame.add(command_date_lb);
	       frame.add(status_lb);
	       frame.add(furniture_id_lb);
	       frame.add(customer_id_lb);
	       
	       frame.add(command_id_txf);
	       frame.add(command_date_txf);
	       frame.add(status_txf);
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
		addComponentforFrame();
		
	}
	private void addComponentforFrame() {
		frame.add(command_id_lb);
		frame.add(command_date_lb);
		frame.add(status_lb);
		frame.add(furniture_id_lb);
		frame.add(customer_id_lb);
		
		frame.add(command_id_txf);
		frame.add(command_date_txf);
		frame.add(status_txf);
		frame.add(furniture_id_txf);
		frame.add(customer_id_txf);
		
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		frame.add(table);
	}
	public static void main(String[]args) {
		Commandform cf=new Commandform();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Command s=new Command(0, null, null, null, null);
		if(e.getSource()==insert_btn) {
			s.setCommand_date(command_date_txf.getText());
			s.setStatus(status_txf.getText());
			s.setFurniture_id(furniture_id_txf.getText());
			s.setCustomer_id(customer_id_txf.getText());
			s.insertData();
		}
		else if ((e.getSource()==Read_btn)) {
			DefaultTableModel tableModel=s.populateTable();
			table.setModel(tableModel);	
		}
	
	 else if (e.getSource() == update_btn) {
         int Command_id = Integer.parseInt(command_id_txf.getText());
         s.setCommand_date(command_date_txf.getText());
         s.setStatus(status_txf.getText());
         s.setFurniture_id(furniture_id_txf.getText());
         s.setCustomer_id(customer_id_txf.getText());

         s.update(Command_id);
     }  else {
         int id = Integer.parseInt(command_id_txf.getText());
         s.delete(id);
     }
 }
	
}

	
