package com.zohocrm.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
@Component
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	@Override
	public void sendSimpleMail(String to, String sub, String emailBody) {
		SimpleMailMessage mailmessage = new SimpleMailMessage();
		mailmessage.setTo(to);
		mailmessage.setSubject(sub);
		mailmessage.setText(emailBody);
		
		javaMailSender.send(mailmessage);

	}

}
