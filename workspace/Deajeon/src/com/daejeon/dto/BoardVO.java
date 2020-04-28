package com.daejeon.dto;

import java.util.Date;
import java.util.List;

public class BoardVO {

	private int bno;
	private String title;
	private String writer;
	private Date regDate;
	private int viewcnt;
	private String content;
	private Date updatedate;
	
	private int replycnt;
	private int attachcnt;
	
	private List<AttachVO> attachList;
	
	public BoardVO() {}

	public BoardVO(int bno, String title, String writer, Date regDate, int viewcnt, String content, Date updatedate,
			int replycnt, int attachcnt, List<AttachVO> attachList) {
		super();
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.regDate = regDate;
		this.viewcnt = viewcnt;
		this.content = content;
		this.updatedate = updatedate;
		this.replycnt = replycnt;
		this.attachcnt = attachcnt;
		this.attachList = attachList;
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public int getReplycnt() {
		return replycnt;
	}

	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
	}

	public int getAttachcnt() {
		return attachcnt;
	}

	public void setAttachcnt(int attachcnt) {
		this.attachcnt = attachcnt;
	}

	public List<AttachVO> getAttachList() {
		return attachList;
	}

	public void setAttachList(List<AttachVO> attachList) {
		this.attachList = attachList;
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", writer=" + writer + ", regDate=" + regDate + ", viewcnt="
				+ viewcnt + ", content=" + content + ", updatedate=" + updatedate + ", replycnt=" + replycnt
				+ ", attachcnt=" + attachcnt + ", attachList=" + attachList + "]";
	}

	
	
	
}
