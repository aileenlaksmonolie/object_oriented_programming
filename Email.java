package project;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

	public static void send_email( Index Index, String Username) {

		final String username = "cz2002.happy@gmail.com"; // to be added
		final String password = "welovecz2002"; // to be added
		
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		System.out.println("sending...");

		try {
		    String to = Username.concat("@e.ntu.edu.sg");
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("cz2002.happy")); // add username
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to)); // to be added an email addr
			message.setSubject("Out of Waitlist!!!");
			message.setText("Dear Student, "
		    		+ ""
		    		+ "You have successfully added Index "+Index);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}