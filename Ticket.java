import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ticket{
	JFrame frame = new JFrame("Metro Kiosk Service");   
	JButton book=new JButton("Purchase");
	JLabel srcstn = new JLabel();
	JLabel dststn = new JLabel();
	int data1;
	int data2;
	int amt=0;
	String value1;
	String value2;
	String username;
	
	public void ticket_calc(String usn) {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1300,650);
		frame.getContentPane().setBackground(new Color(0,153,76));
		frame.setLayout(null);
		frame.setResizable(false);
		
		
		srcstn.setBounds(0,100,1300,75);
		srcstn.setForeground(Color.WHITE);
		srcstn.setFont(new Font("SUKHUMVIT SET",Font.PLAIN,50));
		srcstn.setHorizontalAlignment(JTextField.CENTER);
		srcstn.setText("Select Source Station");
		
		
		dststn.setBounds(0,325,1300,75);
		dststn.setForeground(Color.WHITE);
		dststn.setFont(new Font("SUKHUMVIT SET",Font.PLAIN,50));
		dststn.setHorizontalAlignment(JTextField.CENTER);
		dststn.setText("Select Destination Station");
		
		
		book.setBounds(1110, 550, 150, 50);  
		
		String stations[]={"Chickpete","KR Market","National College","Lalbagh","South End Circle","Jayanagar","RV Road","Banashankari","JP Nagar","Yelachenahalli"};        
		@SuppressWarnings({ "unchecked", "rawtypes" })
		
		JComboBox src=new JComboBox(stations);    
		src.setBounds(575,200,200,100); 
		src.setBackground(new Color(128,128,128));
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox dst=new JComboBox(stations);    
		dst.setBounds(575,425,200,100);
		dst.setBackground(new Color(128,128,128));
		
		
		frame.add(src);
		frame.add(book); 
		frame.add(srcstn);
		frame.add(dststn);
		frame.add(dst);
		frame.setLayout(null);   
		frame.setVisible(true);       
		book.addActionListener(new ActionListener() {  
		        public void actionPerformed(ActionEvent e) {  
		        	username = usn;
		        	data1 = src.getSelectedIndex();
		        	data2 = dst.getSelectedIndex(); 
		        	value1 = src.getSelectedItem().toString();
		        	value2 = dst.getSelectedItem().toString();
		        	if(data1 == data2) {
		        		Ticket tct = new Ticket();
		        		tct.ticket_calc(username);
		        		JOptionPane.showMessageDialog(null, "Source and Destination cannot be same");
		        	}
		        	else {
		        		amt = Math.abs((data1 - data2)*5);
		        		Transaction tr = new Transaction();
		        		frame.dispose();
		        		tr.amount(amt , value1 , value2 , username);
		        	}
		        	
		        }
			});
		
		}
}
