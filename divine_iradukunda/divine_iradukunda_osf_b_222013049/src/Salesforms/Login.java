package Salesforms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Salesdetails.User_account;

public class Login extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField emailtext;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */

public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				Login frame = new Login();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

/**
 * Create the frame.
 */
public Login() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 406, 329);
	setTitle("LOGIN FORM");
	contentPane = new JPanel();
	contentPane.setBackground(new Color(255, 255, 255));
	contentPane.setBackground(Color.pink);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(216, 10, 2, 2);
	contentPane.add(scrollPane);
	
	JLabel lblNewLabel = new JLabel("Password");
	lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
	lblNewLabel.setBounds(86, 135, 91, 14);
	contentPane.add(lblNewLabel);
	
	emailtext = new JTextField();
	emailtext.setBackground(new Color(245, 245, 245));
	emailtext.setBounds(86, 94, 214, 34);
	contentPane.add(emailtext);
	emailtext.setColumns(10);
	
	JLabel lblNewLabel_1 = new JLabel("Email");
	lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
	lblNewLabel_1.setBounds(87, 69, 46, 14);
	contentPane.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("LOGIN");
	lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
	lblNewLabel_2.setBounds(133, 10, 116, 29);
	contentPane.add(lblNewLabel_2);
	
	JButton login = new JButton("LOGIN");
	login.setBackground(new Color(25, 25, 112));
	login.setForeground(new Color(255, 255, 255));
	login.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			FormsMenu menuForm = new FormsMenu();
             // Hide the current login frame
             setVisible(false);
         
			User_account a = new User_account();
			if(e.getSource()==login) {
				a.setUser_email(emailtext.getText());
				char[] passwordChars = passwordField.getPassword();
				String passwordString = new String(passwordChars);
				a.setPassword(passwordString);
				a.login();
			}
		}
	});
	login.setBounds(88, 225, 212, 39);
	contentPane.add(login);
	
	passwordField = new JPasswordField();
	passwordField.setBackground(new Color(245, 245, 245));
	passwordField.setBounds(88, 160, 212, 34);
	contentPane.add(passwordField);
	 JButton forgotPasswordButton = new JButton("Forgot Password?");
     forgotPasswordButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // When the "Forgot Password" button is clicked, show a dialog to input email
             String email = JOptionPane.showInputDialog(Login.this, "Enter your email:");
             if (email != null && !email.isEmpty()) {
                 // Perform the logic to handle forgot password functionality
                 // For example, you can send an email to the user with a password reset link
                 // Here, we'll just display a message indicating that the password reset link has been sent
                 JOptionPane.showMessageDialog(Login.this, "A password reset link has been sent to your email.");
             } else {
                 JOptionPane.showMessageDialog(Login.this, "Please enter a valid email.");
             }
         }
     });
     forgotPasswordButton.setBounds(115, 275, 150, 30);
     contentPane.add(forgotPasswordButton);
     // Create New Account Button
     JButton createAccountButton = new JButton("Create New Account");
     createAccountButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Create a new frame for registration form
        	 User_accountform registrationForm = new User_accountform();
             
             // Hide the current login frame
             setVisible(false);
         }
     });
     createAccountButton.setBounds(88, 320, 212, 39);
     contentPane.add(createAccountButton);
 }}

