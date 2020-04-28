package com.daejeon.request;

import java.util.Date;


public class DeleteReplyRequest {
	private int bno; 
	private int rno; // 지울때는 얘 하나만있으면 됨. 나머지는 페이징때문에 받는 것. 따라서 toReplyVO 메서드도 필요없다.
	private int page;
	
	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}


}
