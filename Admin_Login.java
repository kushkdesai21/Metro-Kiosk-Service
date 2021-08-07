import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


class Admin_Login  implements ActionListener{
	JFrame frame = new JFrame("Metro Kiosk Service");
	JButton button = new JButton();
	JTextField textfield = new JTextField();
	JLabel lgn = new JLabel();
	JLabel entername = new JLabel();
	JLabel password = new JLabel();
	JPasswordField pass = new JPasswordField();
	String username, passwd;
	
	public Admin_Login(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1300,650);
		frame.getContentPane().setBackground(new Color(0,153,76));
		frame.setLayout(null);
		frame.setResizable(false);
		
		
		lgn.setBounds(0,150,1300,150);
		lgn.setForeground(Color.WHITE);
		lgn.setFont(new Font("SUKHUMVIT SET",Font.PLAIN,75));
		lgn.setHorizontalAlignment(JTextField.CENTER);
		lgn.setText("Admin Login");
		
		
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
		
		
		frame.add(lgn);
		frame.add(textfield);
		frame.add(password);
		frame.add(pass);
		frame.add(entername);
		frame.add(button);
		frame.setVisible(true);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		username = textfield.getText();
		passwd= pass.getText().toString();
		if(username.equals("admin") && passwd.equals("admin")) {
			Admin_Choice ac = new Admin_Choice();
			frame.dispose();
			ac.choice();
		}
		else {
			@SuppressWarnings("unused")
			Admin_Login alg = new Admin_Login();
			JOptionPane.showMessageDialog(null, "Incorrect UserID and Password");
		}
		
	}
}