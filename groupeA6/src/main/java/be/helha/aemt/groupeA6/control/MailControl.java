package be.helha.aemt.groupeA6.control;

import java.util.Properties;

import jakarta.mail.Session;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class MailControl {
	   public static void main(String[] args) {

	        // Recipient's email ID needs to be mentioned.
	        String to = "lucas.dorchy@gmail.com";

	        // Sender's email ID needs to be mentioned
	        String from = "rifamon840@quamox.com";

	        // Assuming you are sending email from through gmails smtp
	        String host = "smtp.gmail.com";
	        String port = "465";

	        // Get system properties
	        Properties properties = System.getProperties();

	        // Setup mail server
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", port);
	        
	        properties.put("mail.smtp.ssl.enable", "true");
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable","true");
	        properties.put("mail.smtp.debug", "true");
	        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        
	        // Get the Session object.// and pass username and password
	        Session session = Session.getInstance(properties, new Authenticator() {

	            protected PasswordAuthentication getPasswordAuthentication() {

	                return new PasswordAuthentication("lucas.dorchy@gmail.com", "tpxqujdqxoyxbeou");

	            }
	            
	        });

	        // Used to debug SMTP issues
	        session.setDebug(true);

	        try {
	            // Create a default MimeMessage object.
	            MimeMessage message = new MimeMessage(session);

	            // Set From: header field of the header.
	            message.setFrom(new InternetAddress(from));

	            // Set To: header field of the header.
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	            // Set Subject: header field
	            message.setSubject("This is the Subject Line!");

	            // Now set the actual message
	            message.setText("This is actual message");

	            System.out.println("sending...");
	            // Send message
	            Transport.send(message);
	            System.out.println("Sent message successfully....");
	        } catch (MessagingException mex) {
	            mex.printStackTrace();
	        }

	    }

	}