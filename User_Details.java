import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class User_Details {
	JFrame frame = new JFrame("metro Kiosk Service");
	JButton usertry = new JButton();
	JLabel entername = new JLabel();
	JTextField textfield = new JTextField();
	String username;
	public void user_choice() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1300,650);
		frame.getContentPane().setBackground(new Color(0,153,76));
		frame.setLayout(null);
		frame.setResizable(false);
		
		textfield.setBounds(700,250,200,50);
		textfield.setForeground(new Color(25,25,0));
		textfield.setFont(new Font("SUKHUMVIT SET",Font.BOLD,25));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setEditable(true);
		
		entername.setBounds(400,250,200,50);
		entername.setForeground(Color.WHITE);
		entername.setFont(new Font("SUKHUMVIT SET",Font.BOLD,25));
		entername.setText("Enter Username");
		entername.setHorizontalAlignment(JTextField.CENTER);
		
		
		usertry.setBounds(550,500,200,50);
		usertry.setFont(new Font("SUKHUMVIT SET",Font.BOLD,35));
		usertry.setFocusable(false);
		usertry.setForeground(Color.WHITE);
		usertry.setText("Submit");
		usertry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username = textfield.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Metro","root","asdfghjkl;'");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("Select * From user where Username='"+username+"'");
					if(rs.next()) {
						frame.dispose();
						send();
					}
					else {
						User_Details usd = new User_Details();
						usd.user_choice();
						JOptionPane.showMessageDialog(null, "Incorrect Username");
					}
					st.close();
					con.close();
				}
				catch(Exception ex) {
					System.out.println("");
				
				}
				
			}
		});
		
		frame.add(textfield);
		frame.add(entername);
		frame.add(usertry);
		frame.setVisible(true);
		
	}
	public void send() {
		User_Table ut = new User_Table();
		ut.table_display(username);
	}
}
