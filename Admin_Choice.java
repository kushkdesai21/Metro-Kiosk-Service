import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Admin_Choice {
	JFrame frame = new JFrame("Metro Kiosk Service");
	JButton user = new JButton();
	JButton allstats = new JButton();
	public void choice() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1300,650);
		frame.getContentPane().setBackground(new Color(0,153,76));
		frame.setLayout(null);
		frame.setResizable(false);
		
		user.setBounds(500,200,300,100);
		user.setFont(new Font("SUKHUMVIT SET",Font.BOLD,25));
		user.setFocusable(false);
		user.setForeground(Color.WHITE);
		user.setText("User Details");
		user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_Details ud = new User_Details();
				frame.dispose();
				ud.user_choice();
			}
		});
		
		
		allstats.setBounds(500,350,300,100);
		allstats.setFont(new Font("SUKHUMVIT SET",Font.BOLD,25));
		allstats.setFocusable(false);
		allstats.setForeground(Color.WHITE);
		allstats.setText("All Details");
		allstats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				All_Details ad = new All_Details();
				frame.dispose();
				ad.display();
			}
		});
		
		frame.add(user);
		frame.add(allstats);
		frame.setVisible(true);
	}
}
