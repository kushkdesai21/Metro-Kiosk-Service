import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;

public class All_Details implements ActionListener {
	JFrame frame = new JFrame("Metro Kiosk Service");
	JButton exiting = new JButton();
	JLabel detail = new JLabel();
	JTable table = new JTable(2,10000);
	JTextField results = new JTextField();
	JScrollPane s = new JScrollPane(results,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	public void display() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1300,650);
		frame.getContentPane().setBackground(new Color(0,153,76));
		frame.setLayout(null);
		frame.setResizable(false);
		
		
		detail.setBounds(0,0,1300,150);
		detail.setForeground(Color.WHITE);
		detail.setFont(new Font("SUKHUMVIT SET",Font.PLAIN,100));
		detail.setHorizontalAlignment(JTextField.CENTER);
		detail.setText("Details of all users");

		results.setBounds(150,250,1000,250);
		results.setForeground(new Color(25,25,0));
		results.setFont(new Font("SUKHUMVIT SET",Font.BOLD,25));
		results.setBorder(BorderFactory.createBevelBorder(1));
		results.setEditable(false);
		
		
		exiting.setBounds(550,550,200,50);
		exiting.setFont(new Font("SUKHUMVIT SET",Font.BOLD,35));
		exiting.setFocusable(false);
		exiting.setForeground(Color.WHITE);
		exiting.setText("Exit");
		exiting.addActionListener((ActionListener) this);
		
		
		s.setBounds(100,250,1100,250);
		s.setViewportView(table);
		s.setBorder(BorderFactory.createEmptyBorder());
		
		
		table.setFont(new Font("SUKHUMVIT SET", Font.PLAIN, 20));
	    table.setRowHeight(30);
	    table.setBackground(new Color(0,153,76));
	    table.setForeground(Color.white);
	    JTableHeader tableHeader = table.getTableHeader();
	    tableHeader.setFont(new Font("SUKHUMVIT SET", Font.BOLD, 30));
	    tableHeader.setBackground(new Color(0,153,76));
	    tableHeader.setForeground(Color.white);
	    
	    
	    frame.add(s);
		frame.add(results);
		frame.add(exiting);
		frame.add(detail);
		frame.setVisible(true);
	    
		 try{
			 Class.forName("com.mysql.cj.jdbc.Driver");
             String query= "select username, phno, age from user";
             Class.forName("com.mysql.cj.jdbc.Driver");
 			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Metro","root","asdfghjkl;'");
             PreparedStatement st = con.prepareStatement(query);
             ResultSet rs = st.executeQuery();
             table.setModel(DbUtils.resultSetToTableModel(rs));
             
             st.close();
             con.close();
       	 }
		 catch(Exception ee){
			 System.out.println("");
       }

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
		frame.setVisible(false);
		frame.dispose();
	}

}

