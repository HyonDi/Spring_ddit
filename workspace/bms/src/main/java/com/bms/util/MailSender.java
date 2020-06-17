package com.bms.util;



import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import com.bms.request.mail.MailRequest;

public class MailSender {
	
	@Autowired
	private JavaMailSender mailSender;
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void SendEmail(MailRequest email) throws Exception {
		System.out.println("테스트");
		MimeMessage msg = mailSender.createMimeMessage();
		
		try {
			//메시지 작성헬퍼
	        msg.setSubject(email.getTitle());
	        msg.setText(email.getContent());
	        msg.setRecipient(RecipientType.TO , new InternetAddress(email.getReceiver()));
	        
	   		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mailSender.send(msg);
	}
}
