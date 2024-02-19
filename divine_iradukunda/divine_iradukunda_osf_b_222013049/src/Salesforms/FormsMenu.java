package Salesforms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FormsMenu implements ActionListener{
	JFrame frame;
	JMenu home,  Furniture, Customer, Command, Payment,Stock ,more;
	JMenuItem i1, i2, i3, i4, i5, i6, item1, item2,FurnitureRead;
	JMenuItem CustomerRead;
	JMenuItem CommandRead;
	JMenuItem PaymentRead;
	JMenuItem StockRead;
	
	public FormsMenu() {
		createWindow();
	}
	
	private void createWindow() {
		frame = new JFrame("Menu form with main Menu");
		frame.setSize(400, 400);

		JMenuBar mb = new JMenuBar(); // Create a new menu bar
		home = new JMenu("Home");
		Furniture = new JMenu("Furniture");
		Customer= new JMenu("Customer");
		Command = new JMenu("Command");
		Payment=new JMenu("Payment");
		Stock=new JMenu("Stock");
		

		more = new JMenu("More");
		i1 = new JMenuItem("Insert");
		i2 = new JMenuItem("VIEW");
		i3 = new JMenuItem("Update");
		i4 = new JMenuItem("Delete");
		i5 = new JMenuItem("Item 5");
		i6 = new JMenuItem("Item 6");
		more.add(i5);
		more.add(i6);

		home.add(i1);
		home.add(more); // Add the 'more' submenu to the 'home' menu
		
		FurnitureRead = new JMenuItem("VIEW");
		Furniture.add(FurnitureRead);
		

		CustomerRead =new JMenuItem("VIEW");
		Customer.add(CustomerRead);
		
		
		CommandRead =new JMenuItem("VIEW");
		Command.add(CommandRead);
		
		PaymentRead =new JMenuItem("VIEW");
		Payment.add(PaymentRead);
		
		StockRead =new JMenuItem("VIEW");
        Stock.add(StockRead);
		
		mb.add(home);
		mb.add(Furniture);
		mb.add(Customer);
		mb.add(Command);
		mb.add(Payment);
		mb.add(Stock);
	
		frame.setJMenuBar(mb);// Set the menu bar to the frame

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		componentsOnFrame();
		
	}

	private void componentsOnFrame() {
		home = new JMenu("Home");
		Furniture = new JMenu("Furniture");
		Customer = new JMenu("Customer");
		Command =new JMenu("Command");
		Payment =new JMenu("Payment");
		Stock=new JMenu("Stock");
		
		
		
		more = new JMenu("More");
		i1 = new JMenuItem("Create");
		i2 = new JMenuItem("VIEW");
		i3 = new JMenuItem("Update");
		i4 = new JMenuItem("Delete");
		i5 = new JMenuItem("Item 5");
		i6 = new JMenuItem("Item 6");
		more.add(i5);
		more.add(i6);

		home.add(i1);
		home.add(more);
		Furniture.add(i2);
		Customer.add(i2);
		Command.add(i2);
		Payment.add(i2);
		Stock.add(i2);
		
	
		addactionEvent();

		
	}

	private void addactionEvent() {
		FurnitureRead.addActionListener(this);
		CustomerRead.addActionListener(this);
		CommandRead.addActionListener(this);
		PaymentRead.addActionListener(this);
		StockRead.addActionListener(this);
		
		
		
		
	}

	public static void main(String[] args) {
		new FormsMenu();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==FurnitureRead) {
			Furnitureform ff=new Furnitureform();
			frame.dispose();
		}else if (e.getSource()==CustomerRead) {
			Customerform df=new Customerform();
			frame.dispose();
		}else if (e.getSource()==CommandRead) {
			Commandform nf=new Commandform();
			frame.dispose();
		}else if (e.getSource()==PaymentRead) {
			Paymentform cf=new Paymentform();
			frame.dispose();
			}else if (e.getSource()==StockRead) {
				Stockform af=new Stockform();
				frame.dispose();
				}
	}
		
	}


