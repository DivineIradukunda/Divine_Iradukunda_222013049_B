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



import Salesdetails.Stock;

public class Stockform implements ActionListener {
	JFrame frame;
	JLabel stock_id_lb=new JLabel("STOCK_ID");
	JLabel address_lb=new JLabel("ADDRESS");
	JLabel furniture_id_lb=new JLabel("FURNITURE_ID");
	JLabel Quantity_lb=new JLabel("QUANTITY");
	
	JTextField stock_id_txf=new JTextField();
	JTextField address_txf=new JTextField();
	JTextField furniture_id_txf=new JTextField();
	JTextField quantity_txf=new JTextField();
	
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	JTable table=new JTable();
	JScrollPane scrollPane = new JScrollPane(table);

	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	
	
	public Stockform() {
		creatForm();
	}
	

	private void creatForm() {
		frame=new JFrame();
		frame.setTitle("STOCK_ID");
		frame.setBounds(0,0,600,600);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		setLocationandSize();
		
		
				
	}


	private void setLocationandSize() {
        stock_id_lb.setBounds(10,60,100,30);
        address_lb.setBounds(10,100,100,30);
        furniture_id_lb.setBounds(10,140,100,30);
        Quantity_lb.setBounds(10,180,200,30);
        stock_id_txf.setBounds(200,60,150,30);
        address_txf.setBounds(200,100,150,30);
        furniture_id_txf.setBounds(200,140,150,30);
        quantity_txf.setBounds(200,180,150,30);
        insert_btn.setBounds(10,290,90,30);
        Read_btn.setBounds(110,290,90,30);
        update_btn.setBounds(210,290,90,30);
        delete_btn.setBounds(310,290,90,30);
        table.setBounds(400,10,500,300);
        
      setFontforall();
       
	}

		
	private void setFontforall() {
		frame.add(stock_id_lb);
		frame.add(address_lb);
		frame.add(furniture_id_lb);
		frame.add(Quantity_lb);
		frame.add(stock_id_txf);
		frame.add(address_txf);
		frame.add(furniture_id_txf);
		frame.add(quantity_txf);
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
		frame.add(stock_id_lb);
		frame.add(address_lb);
		frame.add(furniture_id_lb);
		frame.add(Quantity_lb);
		frame.add(stock_id_txf);
		frame.add(address_txf);
		frame.add(furniture_id_txf);
		frame.add(quantity_txf);
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_btn);
		frame.add(quantity_txf);
		frame.add(table);
		
		
		
	}

   public static void main(String[]args) {
	   Stockform stf=new Stockform();
   }
	

	public void actionPerformed(ActionEvent e) {
		Stock h=new Stock(0, null, null, null);
		if(e.getSource()==insert_btn);
		h.setAddress(address_txf.getText());
		h.setFurniture_id(furniture_id_txf.getText());
		h.setQuantity(quantity_txf.getText());
		h.setinsertData();
	}
}







	












