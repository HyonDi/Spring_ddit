package com.bms.request.mail;


import com.bms.dto.mail.MailVO;

public class MailRequest {
	
	private String receiver;
	private String title;
	private String content;
	private String sender;

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	@Override
	public String toString() {
		return "MailRequest [receiver=" + receiver + ", title=" + title + ", content=" + content + ", sender=" + sender
				+ "]";
	}




	public MailVO toMailVO() {
		
		 MailVO vo = new MailVO();
		 vo.setContent(content);
		 vo.setReceiver(receiver);
		 vo.setTitle(title);
		 vo.setSender(sender);
		 return vo;
	}
}
