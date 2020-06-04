package com.spring.dto;

import java.util.Date;

public class ScheduleVO {
	
	private int sche_no;
	private char sche_gubun;
	private String sche_title;
	private int sche_import;
	private Date sche_startDate;
	private Date sche_endDate;
	private int sche_option;
	private int sche_repeat;
	private String sche_place;
	private String sche_content;
	private String id;
	public int getSche_no() {
		return sche_no;
	}
	public void setSche_no(int sche_no) {
		this.sche_no = sche_no;
	}
	
	public char getSche_gubun() {
		return sche_gubun;
	}
	public void setSche_gubun(char sche_gubun) {
		this.sche_gubun = sche_gubun;
	}
	public String getSche_title() {
		return sche_title;
	}
	public void setSche_title(String sche_title) {
		this.sche_title = sche_title;
	}
	public int getSche_import() {
		return sche_import;
	}
	public void setSche_import(int sche_import) {
		this.sche_import = sche_import;
	}
	public Date getSche_startDate() {
		return sche_startDate;
	}
	public void setSche_startDate(Date sche_startDate) {
		this.sche_startDate = sche_startDate;
	}
	public Date getSche_endDate() {
		return sche_endDate;
	}
	public void setSche_endDate(Date sche_endDate) {
		this.sche_endDate = sche_endDate;
	}
	public int getSche_option() {
		return sche_option;
	}
	public void setSche_option(int sche_option) {
		this.sche_option = sche_option;
	}
	public int getSche_repeat() {
		return sche_repeat;
	}
	public void setSche_repeat(int sche_repeat) {
		this.sche_repeat = sche_repeat;
	}
	public String getSche_place() {
		return sche_place;
	}
	public void setSche_place(String sche_place) {
		this.sche_place = sche_place;
	}
	public String getSche_content() {
		return sche_content;
	}
	public void setSche_content(String sche_content) {
		this.sche_content = sche_content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ScheduleVO [sche_no=" + sche_no + ", sche_gubun=" + sche_gubun + ", sche_title=" + sche_title
				+ ", sche_import=" + sche_import + ", sche_startDate=" + sche_startDate + ", sche_endDate="
				+ sche_endDate + ", sche_option=" + sche_option + ", sche_repeat=" + sche_repeat + ", sche_place="
				+ sche_place + ", sche_content=" + sche_content + ", id=" + id + "]";
	}
	
	
	
}
