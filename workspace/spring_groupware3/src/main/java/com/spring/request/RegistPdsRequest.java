package com.spring.request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.spring.dto.PdsAttachVO;
import com.spring.dto.PdsShareVO;
import com.spring.dto.PdsVO;

public class RegistPdsRequest {
	private int pno;
	private String title;
	private String content;
	private String writer;
	private int viewcnt;
	private Date regDate;
	private Date updatedate;
	private Date startDate;
	private Date endDate;
	private int point;

	private List<String> bbsShares;
	private List<PdsAttachVO> attachList;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public Date getStartDate() {
		return startDate;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public List<String> getBbsShares() {
		return bbsShares;
	}

	public void setBbsShares(List<String> bbsShares) {
		this.bbsShares = bbsShares;
	}

	public List<PdsAttachVO> getAttachList() {
		return attachList;
	}

	public void setAttachList(List<PdsAttachVO> attachList) {
		this.attachList = attachList;
	}

	public PdsVO toPdsVO() {
		PdsVO pds = new PdsVO();

		pds.setAttachList(attachList);
		pds.setContent(content);
		pds.setEndDate(endDate);
		pds.setPno(pno);
		pds.setPoint(point);
		pds.setRegDate(regDate);
		pds.setStartDate(startDate);
		pds.setTitle(title);
		pds.setWriter(writer);
		pds.setUpdatedate(updatedate);

		List<PdsShareVO> pdsShareList = new ArrayList<PdsShareVO>();

		for (String str : bbsShares) {
			String[] strArr = str.split(":");

			int pno = this.pno;
			String diff = strArr[0];
			String identity = strArr[3];
			String name=null;
			
			switch (diff) {
			case "D":
				name=strArr[4];
				break;
			case "P":
				name=strArr[2];
				break;
			default:
				name="손님";
			}

			pdsShareList.add(new PdsShareVO(pno, diff, identity,name));
		}

		pds.setPdsShareList(pdsShareList);

		return pds;
	}
}
