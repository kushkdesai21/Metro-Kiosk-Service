import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


class New_Acc implements ActionListener{
	JFrame frame = new JFrame("QuizIt");
	JButton button = new JButton();
	JTextField uname = new JTextField();
	JTextField uph = new JTextField();
	JTextField uage = new JTextField();
	JLabel metro = new JLabel();
	JLabel entername = new JLabel();
	JLabel enterph = new JLabel();
	JLabel enterage = new JLabel();
	JLabel password = new JLabel();
	JPasswordField pass = new JPasswordField();
	String username , passwd;
	String userph , userage;
	
	public New_Acc() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1300,650);
		frame.getContentPane().setBackground(new Color(0,153,76));
		frame.setLayout(null);
		frame.setResizable(false);
		
		
		metro.setBounds(0,0,1300,150);
		metro.setForeground(Color.WHITE);
		metro.setFont(new Font("SUKHUMVIT SET",Font.PLAIN,100));
		metro.setHorizontalAlignment(JTextField.CENTER);
		metro.setText("Namma Metro");
		
		
		entername.setBounds(400,200,200,50);
		entername.setForeground(Color.WHITE);
		entername.setFont(new Font("SUKHUMVIT SET",Font.BOLD,25));
		entername.setText("Enter Name");
		entername.setHorizontalAlignment(JTextField.CENTER);
		
		
		enterph.setBounds(400,300,200,50);
		enterph.setForeground(Color.WHITE);
		enterph.setFont(new Font("SUKHUMVIT SET",Font.BOLD,25));
		enterph.setText("Enter Phone No.");
		enterph.setHorizontalAlignment(JTextField.CENTER);
		
		
		enterage.setBounds(400,400,200,50);
		enterage.setForeground(Color.WHITE);
		enterage.setFont(new Font("SUKHUMVIT SET",Font.BOLD,25));
		enterage.setText("Enter Age");
		enterage.setHorizontalAlignment(JTextField.CENTER);

		
		password.setBounds(400,500,200,50);
		password.setForeground(Color.WHITE);
		password.setFont(new Font("SUKHUMVIT SET",Font.BOLD,25));
		password.setText("Password");
		password.setHorizontalAlignment(JTextField.CENTER);
		

		uname.setBounds(700,200,200,50);
		uname.setForeground(new Color(25,25,0));
		uname.setFont(new Font("SUKHUMVIT SET",Font.BOLD,25));
		uname.setBorder(BorderFactory.createBevelBorder(1));
		uname.setEditable(true);
		
		uph.setBounds(700,300,200,50);
		uph.setForeground(new Color(25,25,0));
		uph.setFont(new Font("SUKHUMVIT SET",Font.BOLD,25));
		uph.setBorder(BorderFactory.createBevelBorder(1));
		uph.setEditable(true);
		
		uage.setBounds(700,400,200,50);
		uage.setForeground(new Color(25,25,0));
		uage.setFont(new Font("SUKHUMVIT SET",Font.BOLD,25));
		uage.setBorder(BorderFactory.createBevelBorder(1));
		uage.setEditable(true);
		
		
		pass.setBounds(700, 500, 200, 50);
		pass.setForeground(new Color(25,25,0));
		pass.setFont(new Font("SUKHUMVIT SET",Font.BOLD,25));
		pass.setBorder(BorderFactory.createBevelBorder(1));
		
		
		button.setBounds(950,550,200,50);
		button.setFont(new Font("SUKHUMVIT SET",Font.BOLD,25));
		button.setFocusable(false);
		button.setForeground(Color.WHITE);
		button.setText("Create Account");
		button.addActionListener((ActionListener) this);

		
		frame.add(metro);
		frame.add(uname);
		frame.add(uph);
		frame.add(uage);
		frame.add(password);
		frame.add(pass);
		frame.add(entername);
		frame.add(enterph);
		frame.add(enterage);
		frame.add(button);
		frame.setVisible(true);
	}
	
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e){
		username = uname.getText();
		userph = uph.getText();
		if(userph.length()!=10) {
			JOptionPane.showMessageDialog(null, "Phone Number must have 10 digits");
		}
		else {
		userage = uage.getText();
		passwd= pass.getText().toString();
		String query = "INSERT INTO user values(?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Metro","root","asdfghjkl;'");
			Statement st1 = con.createStatement();
			ResultSet rs1 = st1.executeQuery("Select * From user where Username='"+username+"'");
			if(rs1.next()) {
				@SuppressWarnings("unused")
				Login l = new Login();
				JOptionPane.showMessageDialog(null, "User already exists!");
			}
			else {
				PreparedStatement st = con.prepareStatement(query);
				st.setString(1, username);
				st.setString(2, userph);
				st.setString(3, userage);
				st.setString(4, passwd);
				@SuppressWarnings("unused")
				int count =st.executeUpdate();
				st.close();
				frame.dispose();
				returning();
			}
			con.close();
		}
		catch(Exception ex) {
			System.out.println("");
		
		}
		}
		
	}
	
	
	public void returning() {
		@SuppressWarnings("unused")
		Login l = new Login();
	}

}