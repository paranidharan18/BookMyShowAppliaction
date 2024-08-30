package com.webServerProject.SpringProject1.NotificationService;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
	public String notificationViaEmail(String bookingDetailsResponse) {
		// Set up the properties for the mail session
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP server
		props.put("mail.smtp.port", "587"); // TLS Port
		props.put("mail.smtp.auth", "true"); // Enable Authentication
		props.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS

		// Create a session with an Authenticator
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("dharan18062001@gmail.com", "jesd svel awsk heut");
			}
		});
		String result = "Failed to send Email";
		try {
			// Create a default MimeMessage object
			Message message = new MimeMessage(session);

			// Set From: header field
			message.setFrom(new InternetAddress("dharan18062001@gmail.com"));

			// Set To: header field
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("dharan18062001@gmail.com"));

			// Set Subject: header field
			message.setSubject("Notification for Booking Confirmation");

			// Set the actual message
			message.setText(bookingDetailsResponse);
			Transport.send(message);

			result = "Email sent successfully!";

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return result;
	}

	public String receiptViaEmail(String BookingDetailsResponse) {
		// Set up the properties for the mail session
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP server
		props.put("mail.smtp.port", "587"); // TLS Port
		props.put("mail.smtp.auth", "true"); // Enable Authentication
		props.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS

		// Create a session with an Authenticator
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("dharan18062001@gmail.com", "jesd svel awsk heut");
			}
		});
		String result = "Failed to send Receipt";
		try {
			// Create a default MimeMessage object
			Message message = new MimeMessage(session);

			// Set From: header field
			message.setFrom(new InternetAddress("dharan18062001@gmail.com"));

			// Set To: header field
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("dharan18062001@gmail.com"));

			// Set Subject: header field
			message.setSubject("Test Email with PDF Attachment");

			// Create the message body part
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(BookingDetailsResponse + "\n" + "Please find the attached Receipt.");

			// Create a multipart message
			Multipart multipart = new MimeMultipart();

			// Set the text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is the attachment
			messageBodyPart = new MimeBodyPart();
			String filename = "C:\\Users\\LENOVO\\Downloads\\Ticket Booking Receipt.pdf"; // The path to the PDF file
																							// you want to attach
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(new File(filename).getName());
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart);

			// Send the message
			Transport.send(message);

			result = "Email with PDF attachment sent successfully!";

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
