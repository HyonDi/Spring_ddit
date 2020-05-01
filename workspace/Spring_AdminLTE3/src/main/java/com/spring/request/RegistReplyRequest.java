package com.spring.request;

import java.util.Date;

import com.spring.dto.ReplyVO;

public class RegistReplyRequest {
	private int bno; //잭슨형이 자동변환해주기에 int 여도된당. 결국오는건 String. client 에서 server로오는건 뭐든 String
	private String replyer;
	private String replytext;
	
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	
	/**
	 * requst 를 vo로 바꾸는 함수
	 * @return
	 */
	public ReplyVO toReplyVO() {
		ReplyVO reply = new ReplyVO();
		reply.setBno(bno);
		reply.setReplyer(replyer);
		reply.setReplytext(replytext);
		reply.setRegdate(new Date());
		reply.setUpdatedate(new Date());
		
		return reply;
	}
	
}
