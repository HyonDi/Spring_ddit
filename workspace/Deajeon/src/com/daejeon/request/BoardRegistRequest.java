package com.daejeon.request;

import java.util.Date;

import com.daejeon.dto.BoardVO;


public class BoardRegistRequest {
	private int bno;          // 게시판번호
	private String title;
	private String writer;		// member 의 id. 로그인한사람.
	private String content;	
	//private int viewcnt;      // 조회수
	//private Date regDate;     // 등록날짜
	//private Date updatedate;  // 수정날짜
	

	public BoardRegistRequest() {}
	
	public BoardRegistRequest(String bno,String title, String writer, String content) {
		super();
		this.bno = Integer.parseInt(bno);
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
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
		return "BoardRegistRequest [bno=" + bno + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ "]";
	}

	public BoardVO toBoardVO() {
		BoardVO board = new BoardVO();
		board.setBno(bno);
		board.setContent(content);
		board.setTitle(title);
		board.setWriter(writer);
		
		return board;
	}


}
