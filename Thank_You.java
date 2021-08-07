import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
	
public class Thank_You implements ActionListener{
	
	JFrame frame = new JFrame();
	JTextArea thanks = new JTextArea();
	JButton exiting = new JButton();
	
	public void print() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1300,650);
		frame.getContentPane().setBackground(new Color(0,153,76));
		frame.setLayout(null);
		frame.setResizable(false);
		
		
		thanks.setBounds(0,0,1300,650);
		thanks.setForeground(Color.WHITE);
		thanks.setFont(new Font("SUKHUMVIT SET",Font.PLAIN,100));
		thanks.setBackground(new Color(0,153,76));
		thanks.setText("Thank You for Visiting Namma Metro...");
		thanks.setEditable(false);
		thanks.setWrapStyleWord(true);
		thanks.setLineWrap(true);
		
		
		exiting.setBounds(550,550,200,50);
		exiting.setFont(new Font("SUKHUMVIT SET",Font.BOLD,35));
		exiting.setFocusable(false);
		exiting.setForeground(Color.WHITE);
		exiting.setText("Exit");
		exiting.addActionListener((ActionListener) this);
		
		
		frame.add(exiting);
		frame.add(thanks);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
		frame.setVisible(false);
		frame.dispose();
	}
}
