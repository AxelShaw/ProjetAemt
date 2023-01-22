
package be.helha.aemt.groupeA6.control;

import java.io.Serializable;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.groupeA6.ejb.IGestionAttributionEJB;
import be.helha.aemt.groupeA6.entities.AA;
import be.helha.aemt.groupeA6.entities.Attribution;
import be.helha.aemt.groupeA6.entities.Mission;
import jakarta.mail.Session;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;



public class MailControl {
			
		public static void sendMail(String toEmail, String contenu,String contenu2) 
		{
			
	        // Sender's email ID needs to be mentioned
	        String emailAccount = "lucas.dorchy@gmail.com";
	        String password = "tpxqujdqxoyxbeou";

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

	                return new PasswordAuthentication(emailAccount, password);

	            }
	            
	        });

	        

	        Message message = setMessage(session,emailAccount,toEmail,contenu, contenu2 );
	        


		    }
		
		private static Message setMessage(Session session, String emailAccount, String toEmail,String contenu, String contenu2) {
			
	        
			  try {
		            // Create a default MimeMessage object.
		            MimeMessage message = new MimeMessage(session);

		            // Set From: header field of the header.
		            message.setFrom(new InternetAddress(emailAccount));

		            // Set To: header field of the header.
		            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

		            // Set Subject: header field
		            message.setSubject("Attribution :");

		            // Now set the actual message
		            message.setText(contenu + "\n" + contenu2);
			        // Send message
		            Transport.send(message);
		            


		        } catch (MessagingException mex) {
		            mex.printStackTrace();
		        }
			  return null;
				
			}
	}