import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.util.Scanner;
import java.io.*;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Date;
import javax.mail.*;
import java.awt.event.*;
import javax.mail.internet.*;
import java.util.ArrayList;
import com.sun.mail.smtp.*;

public class webpanel extends JPanel {
      InternetAddress[] patheticGriefers;
      JTextField addressBook;
      JTextField subi;
      JTextArea  input;
      Properties prop;
      Message msg;
      Session session;
      SMTPTransport transfer;
	public webpanel(InternetAddress[] x) {
	  super(new GridBagLayout());
	  patheticGriefers = x;
	  GridBagConstraints cunts = new GridBagConstraints();
	  cunts.anchor = GridBagConstraints.CENTER;
	  cunts.insets = new Insets(16,16,16,16);
	  JLabel title = new JLabel("Buckshot Spam Emailer");
	  JLabel mass = new JLabel("Buckshot Spam Content");
	  JLabel sub = new JLabel("Buckshot Subject");
	  JLabel simpleM = new JLabel("Optional: Enter contacts list file name.. The format is one email address per line");
	  addressBook = new JTextField(20);
	   subi = new JTextField(20);
	  input = new JTextArea(10, 36);
	  input.setLineWrap(true);
      JScrollPane pane = new JScrollPane(input);
	  cunts.gridx = 0;
	  cunts.gridy = 0;
	  this.add(title, cunts);
		cunts.gridx = 0;
		cunts.gridy = 2;
		add(simpleM, cunts);
		cunts.gridy = 3;
		add(addressBook, cunts);
		cunts.gridy = 4;
		add(sub, cunts);
		cunts.gridy = 5;
		add(subi, cunts);
		cunts.gridy = 6;
	  this.add(mass, cunts);
        cunts.gridy = 7;
	 add(pane, cunts);
     cunts.gridy = 15;
     JButton submit = new JButton("send");
      prop = System.getProperties();
     prop.put("mail.smtps.host", "smtps.gmail.com");
	 prop.put("mail.smtps.auth", "true");
	  session = Session.getInstance(prop);
	  msg = new MimeMessage(session);
	 try {
		 InternetAddress from = new InternetAddress("buckshot.heron@gmail.com");
		 msg.setFrom(from);
	 }catch(Exception e) {}
	 submit.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 try {
	        	 Scanner modress = new Scanner(new File(addressBook.getText()));
	        	 ArrayList<InternetAddress> compound = new ArrayList<InternetAddress>();
	        	 while(modress.hasNext()) {
	        		String descript = modress.next();
	        		try {
	        			InternetAddress add = new InternetAddress(descript);
	        			compound.add(add);
	        			
	        		}catch(Exception r) {}
	        	 }
	        	 InternetAddress[] swap = new InternetAddress[patheticGriefers.length + compound.size()];
	        	 int start = 0;
	        	 for(int i = 0; i < patheticGriefers.length; i++) {
	        		 swap[start] = patheticGriefers[i];
	        		 start = start + 1;
	        	 }
	        	 for(int j = 0; j < compound.size(); j++) {
	        		 swap[start] = compound.get(j);
	        		 start = start + 1;
	        	 }
	        	 patheticGriefers = swap;
	        	 }catch(Exception n) {}
	        	 try {
	        	msg.addRecipients(Message.RecipientType.TO, patheticGriefers);
	        	 msg.setSubject(subi.getText());
	        	 msg.setText(input.getText());
	        	 msg.setHeader("X-Mailer", "Buckshot spam cannon");
	        	 msg.setSentDate(new Date());
	        	 transfer =(SMTPTransport) session.getTransport("smtps");
	        	 transfer.connect("smtp.gmail.com", "buckshot.heron@gmail.com", "Lactatingweaver");
	        	 transfer.sendMessage(msg, msg.getAllRecipients());
	        	 System.out.println(transfer.getLastServerResponse());
	        	 transfer.close();
	        	 }catch(Exception x) {}
	        	
	         }
	         
	         
		 	 }
	 );
	 
	add(submit, cunts);
	// msg.setRecipients(Message.RecipientType.TO, );
	}
	
	
}
