package com.spring.mail;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.spring.request.MailRequest;

public class MimeAttachNotifier {
	// 메세지 만든다.
	
	// 메일을 받은 다른 서버에서 이미지 열려면 "http://" 까지 더해서 도메인(ip) 더해서 풀네임으로 주소 넣어주면됩니다.
	
	private JavaMailSender mailSender;
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendMail(MailRequest mail, String uploadPath) {
		// 메세지 생성
		MimeMessage message=mailSender.createMimeMessage();
		try {
			// 메세지 작성 헬퍼.
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true,"utf-8");
			
			// 받는 사람
			messageHelper.setTo(new InternetAddress(mail.getReceiver()));
			
			// 보내는 사람
			messageHelper.setFrom(mail.getSender(),"운영자");
			
			// 제목
			messageHelper.setSubject(mail.getTitle());
			
			// 내용
			messageHelper.setText(mail.getContent(),true); // html형식이면 true. 아니면 false
			
			// 첨부파일
			if(mail.getFile()!=null && !mail.getFile().isEmpty()) {
				String fileName = mail.getFile().getOriginalFilename();
				DataSource dataSource = new FileDataSource(uploadPath+"/"+fileName);
				
				messageHelper.addAttachment(MimeUtility.encodeText(fileName,"utf-8","B"),dataSource);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		mailSender.send(message);
	}
	
}
