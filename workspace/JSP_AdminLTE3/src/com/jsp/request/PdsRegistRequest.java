package com.jsp.request;

import com.jsp.dto.PdsVO;

public class PdsRegistRequest {

	private int pno;          
	private String title;
	private String writer;		
	private String content;
	
	
	public PdsRegistRequest() {}


	public PdsRegistRequest(String pno, String title, String writer, String content) {
		super();
		this.pno = Integer.parseInt(pno);
		this.title = title;
		this.writer = writer;
		this.content = content;
	}


	public int getPno() {
		return pno;
	}


	public void setPno(int pno) {
		this.pno = pno;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "PdsRegistRequest [pno=" + pno + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ "]";
	}	
	
	public PdsVO toPdsVO() {
		PdsVO pds = new PdsVO();
		pds.setPno(pno);
		pds.setContent(content);
		pds.setTitle(title);
		pds.setWriter(writer);
		
		return pds;
	}
	
	
	
	
}
