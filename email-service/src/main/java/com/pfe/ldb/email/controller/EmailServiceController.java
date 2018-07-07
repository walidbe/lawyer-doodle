package com.pfe.ldb.email.controller;

import java.util.Map;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.net.MediaType;

@RestController
public class EmailServiceController {

	@Autowired
	private JavaMailSender emailSender;

	@RequestMapping(method = RequestMethod.POST, value = "/email")
	public String email(@RequestBody(required = true) final Map<String, String> map)
			throws AddressException, MessagingException {


			MimeMessage message = emailSender.createMimeMessage();
			StringBuffer messageBuffer = new StringBuffer();
			messageBuffer.append("<strong>Bienvenue à ProtoGest.</strong>");
			messageBuffer.append("<br />");
			messageBuffer.append("<p>Vous avez été convoqué a un nouvel évènement.");
			messageBuffer.append("<p><b>Veuillez vous connectez/inscrire à notre plateforme pour gérer vos évènemets</b></p>");
			messageBuffer.append("<p><b>Évènement : </b>" + map.get("eventName")+"</p>");
			messageBuffer.append("<p><b>Cause : </b>" + map.get("taskName")+"</p>");
			messageBuffer.append("<p><b>Date de l'évènement : </b>" + map.get("eventDate")+"</p>");
			messageBuffer.append("<p><b>Cause créer par: </b>" + map.get("source")+"</p>");
	        messageBuffer.append(" <p>Veuillez cliquer sur ce lien :<a href='" + map.get("link") + "'>"+map.get("link")+"</a></p>");
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(map.get("email")));
			message.setSubject("PROTOGEST, une nouvelle cause vous a été assignée !");
			message.setContent(messageBuffer.toString(), MediaType.HTML_UTF_8.toString());
			emailSender.send(message);
		

		return "Email Sent";
	}

}
