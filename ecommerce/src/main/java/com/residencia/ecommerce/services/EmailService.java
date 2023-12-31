package com.residencia.ecommerce.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EmailService {

	@Autowired
	public JavaMailSender emailSender;

	public EmailService(JavaMailSender javaMailSender) {
		this.emailSender = javaMailSender;
	}

	public void enviarEmail(String destinatario, String assunto, String mensagem) {
		var mailMessage = new SimpleMailMessage();

		mailMessage.setTo(destinatario);
		mailMessage.setSubject(assunto);
		mailMessage.setText(mensagem);
		mailMessage.setFrom("grupo5deapi2023.2@gmail.com");
		try {
			emailSender.send(mailMessage);
		} catch (Exception ex) {
			System.out.println("Ocorreu um erro ao tentar enviar o e-mail: " + ex.getMessage());
		}

	}
}
