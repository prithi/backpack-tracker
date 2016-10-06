package backpack.server;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Notify {
	
	public String recipient;
	
	
	

	public Notify(String recipient){
		this.recipient = recipient;
	}

	public void email() throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("backpacktracker", "12136112"));
		email.setSSLOnConnect(true);
		email.setFrom("backpacktracker@gmail.com", "Backpack Tracker");
		email.setSubject("Backpack is now open");
		email.setMsg("Happy Shopping!");
		email.addTo(recipient);

		email.send();
	}
}
