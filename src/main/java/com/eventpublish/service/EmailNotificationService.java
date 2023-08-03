package com.eventpublish.service;

import java.util.Objects;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventpublish.model.SmtpCredentials;
import com.eventpublish.repositories.CollegeRecepientRepository;
import com.eventpublish.repositories.SmptRepositories;

/**
 * 
 * @author
 *
 */
@Service
public class EmailNotificationService {

	public static final Logger emaillog = LoggerFactory.getLogger(EmailNotificationService.class);

	@Autowired
	private SmptRepositories smptRepositories;

	@Autowired
	private CollegeRecepientRepository collegeRecepientRepository;

	/**
	 * Utility method to send simple HTML email
	 * 
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body
	 */
	public void sendEmail(String subject, String body) {
		/** SpringApplication.run(EventpublishAppApplication.class, args); */
		SmtpCredentials smtpUser = smptRepositories.findBySmtpSource("gmail");

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(smtpUser.getSmtpUserId(), smtpUser.getSmtpUserPassword());
			}
		});

		try {

			for (String toRecepient : collegeRecepientRepository.findEmail().stream().filter(Objects::nonNull)
					.collect(Collectors.toList())) {
				emaillog.info("sending email to recepient - {}", toRecepient);
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(smtpUser.getSmtpUserEmail() /* from Email */));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toRecepient));
				message.setSubject(subject);
				message.setText(body);

				Transport.send(message);

				emaillog.info("email sent done ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
