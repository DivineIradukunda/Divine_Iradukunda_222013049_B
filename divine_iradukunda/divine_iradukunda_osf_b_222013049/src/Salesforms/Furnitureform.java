package Salesforms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Salesdetails.Furniture;

public class Furnitureform implements ActionListener{
	JFrame frame;
	JLabel furniture_id_lb=new JLabel("FURNITURE_ID");
	JLabel type_lb=new JLabel ("TYPE");
	JLabel category_lb=new JLabel("CATEGORY");
	JLabel name_lb=new JLabel("NAME");
	JLabel size_lb=new JLabel("SIZE");
	
	JTextField furniture_id_txf=new JTextField();
	JTextField type_txf=new JTextField();
	JTextField category_txf=new JTextField();
	JTextField name_txf=new JTextField();
	JTextField size_txf=new JTextField();
	
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	JTable table=new JTable();
	JScrollPane scrollPane = new JScrollPane(table);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	
	public Furnitureform() {
		creatForm();
		
	}

	private void creatForm() {
		 frame=new JFrame();
	     frame.setTitle("FURNITURE_ID");
	     frame.setBounds(0,0,600,600);
	     frame.getContentPane().setLayout(null);
	     frame.getContentPane().setBackground(Color.BLUE);
	     frame.setVisible(true);
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.setResizable(true);
	     SetLocationandSize();
		  
			
	}
		
	private void SetLocationandSize() {
		furniture_id_lb.setBounds(10,60,100,30);
		type_lb.setBounds(10,100,100,30);
		category_lb.setBounds(10,140,100,30);
		name_lb.setBounds(10,180,100,30);
		size_lb.setBounds(10,220,100,30);
		furniture_id_txf.setBounds(200,60,150,30);
		type_txf.setBounds(200,100,150,30);
		category_txf.setBounds(200,140,150,30);
		name_txf.setBounds(200,180,150,30);
		size_txf.setBounds(200,220,150,30);
		insert_btn.setBounds(10,290,90,30);
		Read_btn.setBounds(110,290,90,30);
		update_btn.setBounds(210,290,90,30);
		delete_btn.setBounds(310,290,90,30);
		table.setBounds(400, 10, 500, 300);
setFontforall();
		
	}
		
	private void setFontforall() {
		frame.add(furniture_id_lb);
	       frame.add(type_lb);
	       frame.add(category_lb);
	       frame.add(name_lb);
	       frame.add(size_lb);
	       frame.add(furniture_id_txf);
	       frame.add(type_txf);
	       frame.add(category_txf);
	       frame.add(name_txf);
	       frame.add(size_txf);
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
		frame.add(furniture_id_lb);
		frame.add(type_lb);
		frame.add(category_lb);
		frame.add(name_lb);
		frame.add(size_lb);
		frame.add(furniture_id_txf);
		frame.add(type_txf);
		frame.add(category_txf);
		frame.add(name_txf);
		frame.add(size_txf);
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		frame.add(table);
	}
		public static void main(String[]args) {
			Furnitureform ff=new Furnitureform();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Furniture g=new Furniture(0, null, null, null, null);
		if(e.getSource()==insert_btn) {
			g.setType(type_txf.getText());
			g.setCategory(category_txf.getText());
			g.setName(name_txf.getText());
			g.setSize(size_txf.getText());
			g.insertData();
		}
	
		else if ((e.getSource()==Read_btn)) {
			DefaultTableModel tableModel=g.populateTable();
			table.setModel(tableModel);
		
        } else if (e.getSource() == update_btn) {
    int furniture_id = Integer.parseInt(furniture_id_txf.getText());
    g.setType(type_txf.getText());
    g.setCategory(category_txf.getText());
    g.setName(name_txf.getText());
    g.setSize(size_txf.getText());

    g.update(furniture_id);
        
}  else {
	            int id = Integer.parseInt(furniture_id_txf.getText());
	            g.delete(id);
	        }
	    }
		
	}


		

	


