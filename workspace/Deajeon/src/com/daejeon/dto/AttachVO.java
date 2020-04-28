package com.daejeon.dto;

import java.util.Date;

public class AttachVO {
	private int ano;
	private String uploadPath;
	private String fileName;
	private int bno;
	private String attacher;
	private Date regDate;
	private String fileType;
	
	public AttachVO() {}

	public AttachVO(int ano, String uploadPath, String fileName, int bno, String attacher, Date regDate,
			String fileType) {
		super();
		this.ano = ano;
		this.uploadPath = uploadPath;
		this.fileName = fileName;
		this.bno = bno;
		this.attacher = attacher;
		this.regDate = regDate;
		this.fileType = fileType;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getAttacher() {
		return attacher;
	}

	public void setAttacher(String attacher) {
		this.attacher = attacher;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@Override
	public String toString() {
		return "AttachVO [ano=" + ano + ", uploadPath=" + uploadPath + ", fileName=" + fileName + ", bno=" + bno
				+ ", attacher=" + attacher + ", regDate=" + regDate + ", fileType=" + fileType + "]";
	}

	
	

	
	
	
}
