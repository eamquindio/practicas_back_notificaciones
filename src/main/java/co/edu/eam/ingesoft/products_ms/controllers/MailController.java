package co.edu.eam.ingesoft.products_ms.controllers;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eam.ingesoft.notifications_ms.models.Email;
import co.edu.eam.ingesoft.products_ms.routes.Router;
import co.edu.eam.ingesoft.products_ms.services.EmailService;

@RestController
@RequestMapping(Router.NOTIFICATION_PATH)
public class MailController {

	@Autowired
	private EmailService emailService;

	@PostMapping(value = Router.CREATE_EMAIL, consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean create(@RequestBody Email email)
			throws MessagingException, IOException {
		return emailService.create(email.getSubject(), email.getTo(), email.getMessage());
	}
}
