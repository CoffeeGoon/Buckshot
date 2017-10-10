import javax.swing.JFrame;
import java.util.ArrayList;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Date;
import javax.mail.*;
import java.awt.event.*;
import javax.mail.internet.*;

import com.sun.mail.smtp.*;
public class appframe extends JFrame {
    private InternetAddress[] addressbook;
	public  appframe(ArrayList<String> contacts) {
		super("Buckshot Spam Mailer");
		addressbook = new InternetAddress[contacts.size()];
		for(int i = 0; i < contacts.size(); i++) {
			try {
			InternetAddress temp = new InternetAddress( contacts.get(i) );
			  addressbook[i] = temp;
			}
			catch(Exception e) {}
		
		}
		this.setSize(600, 600);
		add(new webpanel(addressbook));
		
		
	}
	
	
}