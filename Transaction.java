import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Transaction {
	JFrame frame = new JFrame("Metro Kiosk Service");
	JButton button = new JButton();
	JLabel lgn = new JLabel();
	JLabel date = new JLabel();
	JLabel time = new JLabel();
	JLabel source = new JLabel();
	JLabel destination = new JLabel();
	JLabel fare = new JLabel();
	String usn , sourcestn, deststn;
	String sysdate, systime;
	String fareamt;
	
	public void amount(int amt, String src , String dst , String username) {

		fareamt=Integer.toString(amt);
		sourcestn= src;
		deststn= dst;
		usn= username;
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1300,650);
		frame.getContentPane().setBackground(new Color(0,153,76));
		frame.setLayout(null);
		frame.setResizable(false);
		
		
		lgn.setBounds(0,0,1300,150);
		lgn.setForeground(Color.WHITE);
		lgn.setFont(new Font("SUKHUMVIT SET",Font.PLAIN,75));
		lgn.setHorizontalAlignment(JTextField.CENTER);
		lgn.setText("Confirm Booking");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localdate = LocalDate.now();
		sysdate=dtf.format(localdate);
		
		date.setBounds(0,150,650,50);
		date.setForeground(Color.WHITE);
		date.setFont(new Font("SUKHUMVIT SET",Font.BOLD,25));
		date.setText("Date: "+ sysdate );
		date.setHorizontalAlignment(JTextField.CENTER);
		
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("hh:mm:ss");
		LocalTime localtime = LocalTime.now();
		systime=dtf1.format(localtime);
		
		time.setBounds(650,150,650,50);
		time.setForeground(Color.WHITE);
		time.setFont(new Font("SUKHUMVIT SET",Font.BOLD,25));
		time.setText("Time: "+ systime);
		time.setHorizontalAlignment(JTextField.CENTER);
		
		
		source.setBounds(0,250,650,100);
		source.setForeground(Color.WHITE);
		source.setFont(new Font("SUKHUMVIT SET",Font.BOLD,50));
		source.setText("Source: "+ sourcestn);
		source.setHorizontalAlignment(JTextField.CENTER);
		
		
		destination.setBounds(650,250,650,100);
		destination.setForeground(Color.WHITE);
		destination.setFont(new Font("SUKHUMVIT SET",Font.BOLD,50));
		destination.setText("Destination: "+ deststn);
		destination.setHorizontalAlignment(JTextField.CENTER);
		
		
		fare.setBounds(0,400,1300,100);
		fare.setForeground(Color.WHITE);
		fare.setFont(new Font("SUKHUMVIT SET",Font.BOLD,40));
		fare.setText("Travel Fare: "+ fareamt);
		fare.setHorizontalAlignment(JTextField.CENTER);
		
		
		button.setBounds(550,550,200,50);
		button.setFont(new Font("SUKHUMVIT SET",Font.BOLD,25));
		button.setFocusable(false);
		button.setForeground(Color.WHITE);
		button.setText("Confirm");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Thank_You ty = new Thank_You();
				ty.print();
			}
		});
		
		
		
		frame.add(lgn);
		frame.add(date);
		frame.add(time);
		frame.add(source);
		frame.add(destination);
		frame.add(fare);
		frame.add(button);
		frame.setVisible(true);
		send();
	}

	public void send() {
		String query = "INSERT INTO Metro.transaction values(?,?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Metro","root","asdfghjkl;'");
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, usn);
			st.setString(2, sourcestn);
			st.setString(3, deststn);
			st.setString(4, fareamt);
			st.setString(5, sysdate);
			st.setString(6, systime);
			@SuppressWarnings("unused")
			int count =st.executeUpdate();
			st.close();
			con.close();
		}
		catch(Exception ex) {
			System.out.println("Error");
		
		}
	}
}
