package co.edu.eam.ingesoft.products_ms.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	

	public boolean create(String subject, String[] to, String message) throws MessagingException, IOException {
		System.out.println("Sending Email...");
		try {
			MimeMessage msg = javaMailSender.createMimeMessage();

			// true = multipart message
			MimeMessageHelper helper = new MimeMessageHelper(msg, true);
			helper.setSubject(subject);
			helper.setText(message, true);
			for (String aux : to) {
				helper.setTo(aux);
				javaMailSender.send(msg);
			}

			// helper.setSubject("Testing from Spring Boot");

			// default = text/plain
			// helper.setText("Check attachment for image!");

			// true = text/html
			// helper.setText("<h1>Check attachment!</h1>", true);
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
		System.out.println("Done");
		return true;

	}

}
