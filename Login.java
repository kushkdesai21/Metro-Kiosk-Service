import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


class Login  implements ActionListener{
	JFrame frame = new JFrame("Metro Kiosk Service");
	JButton button = new JButton();
	JButton admin = new JButton();
	JButton newacc = new JButton();
	JTextField textfield = new JTextField();
	JLabel metro = new JLabel();
	JLabel lgn = new JLabel();
	JLabel entername = new JLabel();
	JLabel password = new JLabel();
	JPasswordField pass = new JPasswordField();
	String username, passwd;
	
	public Login(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1300,650);
		frame.getContentPane().setBackground(new Color(0,153,76));
		frame.setLayout(null);
		frame.setResizable(false);
		
		
		metro.setBounds(0,0,1300,150);
		metro.setForeground(Color.WHITE);
		metro.setFont(new Font("SUKHUMVIT SET",Font.PLAIN,100));
		metro.setHorizontalAlignment(JTextField.CENTER);
		metro.setText("Welcome to Namma Metro");
		
		
		lgn.setBounds(0,150,1300,150);
		lgn.setForeground(Color.WHITE);
		lgn.setFont(new Font("SUKHUMVIT SET",Font.PLAIN,75));
		lgn.setHorizontalAlignment(JTextField.CENTER);
		lgn.setText("Login");
		
		
		entername.setBounds(400,300,200,50);
		entername.setForeground(Color.WHITE);
		entername.setFont(new Font("SUKHUMVIT SET",Font.BOLD,25));
		entername.setText("Enter Name");
		entername.setHorizontalAlignment(JTextField.CENTER);
		

		textfield.setBounds(700,300,200,50);
		textfield.setForeground(new Color(25,25,0));
		textfield.setFont(new Font("SUKHUMVIT SET",Font.BOLD,25));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setEditable(true);
		
		
		password.setBounds(400,375,200,50);
		password.setForeground(Color.WHITE);
		password.setFont(new Font("SUKHUMVIT SET",Font.BOLD,25));
		password.setText("Password");
		password.setHorizontalAlignment(JTextField.CENTER);
		
		pass.setBounds(700, 375, 200, 50);
		pass.setForeground(new Color(25,25,0));
		pass.setFont(new Font("SUKHUMVIT SET",Font.BOLD,25));
		pass.setBorder(BorderFactory.createBevelBorder(1));
		
		
		button.setBounds(700,500,200,50);
		button.setFont(new Font("SUKHUMVIT SET",Font.BOLD,25));
		button.setFocusable(false);
		button.setForeground(Color.WHITE);
		button.setText("Login");
		button.addActionListener((ActionListener) this);
		
		
		admin.setBounds(1100,550,100,50);
		admin.setFont(new Font("SUKHUMVIT SET",Font.BOLD,25));
		admin.setFocusable(false);
		admin.setForeground(Color.WHITE);
		admin.setText("Admin");
		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username = textfield.getText();
				frame.dispose();
				adminln();
			}
		});
		
		
		newacc.setBounds(400,500,200,50);
		newacc.setFont(new Font("SUKHUMVIT SET",Font.BOLD,25));
		newacc.setFocusable(false);
		newacc.setForeground(Color.WHITE);
		newacc.setText("Create Account");
		newacc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username = textfield.getText();
				frame.dispose();
				newaccount();
			}
		});
		
		
		frame.add(lgn);
		frame.add(textfield);
		frame.add(newacc);
		frame.add(password);
		frame.add(pass);
		frame.add(metro);
		frame.add(entername);
		frame.add(button);
		frame.add(admin);
		frame.setVisible(true);
	}
	
	
	
	public void send() {
		Ticket tc = new Ticket();
		tc.ticket_calc(username);
	}
	public void newaccount() {
		@SuppressWarnings("unused")
		New_Acc na = new New_Acc();
	}
	public void adminln() {
		@SuppressWarnings("unused")
		Admin_Login adl= new Admin_Login();
	}



	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e){
		username = textfield.getText();
		passwd= pass.getText().toString();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Metro","root","asdfghjkl;'");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * From user where Username='"+username+"' and Binary Password= '"+passwd+"'");
			if(rs.next()) {
				frame.dispose();
				send();
			}
			else {
				@SuppressWarnings("unused")
				Login l = new Login();
				JOptionPane.showMessageDialog(null, "Incorrect UserID and Password");
			}
			st.close();
			con.close();
		}
		catch(Exception ex) {
			System.out.println("");
		
		}
			
		
	}

}