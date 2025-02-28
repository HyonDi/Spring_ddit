package com.bms.dto.item;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ItemVO {
	
	private String item_code;
	private String item_name;
	private String facility_code;
	private int item_price;
	private String member_code;
	private int item_cnt;
	private Date regdate;
	private String attach_code;
	private String board_sort_code;
	private String item_picture;
	private String facility_name;
	private String facility_url;
	
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getFacility_code() {
		return facility_code;
	}
	public void setFacility_code(String facility_code) {
		this.facility_code = facility_code;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public String getMember_code() {
		return member_code;
	}
	public void setMember_code(String member_code) {
		this.member_code = member_code;
	}
	public int getItem_cnt() {
		return item_cnt;
	}
	public void setItem_cnt(int item_cnt) {
		this.item_cnt = item_cnt;
	}
	public Date getRegdate() {
		return regdate;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getAttach_code() {
		return attach_code;
	}
	public void setAttach_code(String attach_code) {
		this.attach_code = attach_code;
	}
	public String getBoard_sort_code() {
		return board_sort_code;
	}
	public void setBoard_sort_code(String board_sort_code) {
		this.board_sort_code = board_sort_code;
	}
	
	public String getItem_picture() {
		return item_picture;
	}
	public void setItem_picture(String item_picture) {
		this.item_picture = item_picture;
	}
	
	public String getFacility_name() {
		return facility_name;
	}
	public void setFacility_name(String facility_name) {
		this.facility_name = facility_name;
	}
	public String getFacility_url() {
		return facility_url;
	}
	public void setFacility_url(String facility_url) {
		this.facility_url = facility_url;
	}
	@Override
	public String toString() {
		return "ItemVO [item_code=" + item_code + ", item_name=" + item_name + ", facility_code=" + facility_code
				+ ", item_price=" + item_price + ", member_code=" + member_code + ", item_cnt=" + item_cnt
				+ ", regdate=" + regdate + ", attach_code=" + attach_code + ", board_sort_code=" + board_sort_code
				+ ", item_picture=" + item_picture + ", facility_name=" + facility_name + ", facility_url="
				+ facility_url + ", getItem_code()=" + getItem_code() + ", getItem_name()=" + getItem_name()
				+ ", getFacility_code()=" + getFacility_code() + ", getItem_price()=" + getItem_price()
				+ ", getMember_code()=" + getMember_code() + ", getItem_cnt()=" + getItem_cnt() + ", getRegdate()="
				+ getRegdate() + ", getAttach_code()=" + getAttach_code() + ", getBoard_sort_code()="
				+ getBoard_sort_code() + ", getItem_picture()=" + getItem_picture() + ", getFacility_name()="
				+ getFacility_name() + ", getFacility_url()=" + getFacility_url() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}   
    