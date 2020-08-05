package com.web.service;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

import com.web.DAO.SendEmail;

@Service
public class SendGmail implements SendEmail {

	@Override
		public String sendEmail(String email, int code) throws AddressException, MessagingException, IOException {
		
		sendmail(email, code);
		return "Email sent successfully";
		
	}

	private void sendmail(String email, int code) throws AddressException, MessagingException {
		Properties props = new Properties();
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("fullstackjavalink01@gmail.com", "smcxuekxkudjykbd");
			}
		});
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("fullstackjavalink01@gmail.com",false));
		
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("fullstackjavalink01@gmail.com"));
		msg.setSubject("Confirmation");
		msg.setContent("Confirmation","text/html");
		msg.setSentDate(new Date());
		
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent("Your verification code: " +code, "text/html");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		
		
		msg.setContent(multipart);
		
		Transport.send(msg);
		
	}

}
