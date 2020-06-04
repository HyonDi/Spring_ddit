package com.bms.dto.member;

import java.util.Date;

public class MemberVO {
	
	private String member_code;
	private String member_id;
	private String member_pwd;
	private String member_name;
	private String member_ssn;
	private String member_address;
	private String member_email;
	private String member_phone;
	private Date member_recent_login_time;
	private String member_sort_code;
	private String member_up_code;
	private String member_authority;
	public String getMember_code() {
		return member_code;
	}
	public void setMember_code(String member_code) {
		this.member_code = member_code;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pwd() {
		return member_pwd;
	}
	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_ssn() {
		return member_ssn;
	}
	public void setMember_ssn(String member_ssn) {
		this.member_ssn = member_ssn;
	}
	public String getMember_address() {
		return member_address;
	}
	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	public Date getMember_recent_login_time() {
		return member_recent_login_time;
	}
	public void setMember_recent_login_time(Date member_recent_login_time) {
		this.member_recent_login_time = member_recent_login_time;
	}
	public String getMember_sort_code() {
		return member_sort_code;
	}
	public void setMember_sort_code(String member_sort_code) {
		this.member_sort_code = member_sort_code;
	}
	public String getMember_up_code() {
		return member_up_code;
	}
	public void setMember_up_code(String member_up_code) {
		this.member_up_code = member_up_code;
	}
	public String getMember_authority() {
		return member_authority;
	}
	public void setMember_authority(String member_authority) {
		this.member_authority = member_authority;
	}
	
	@Override
	public String toString() {
		return "MemberVO [member_code=" + member_code + ", member_id=" + member_id + ", member_pwd=" + member_pwd
				+ ", member_name=" + member_name + ", member_ssn=" + member_ssn + ", member_address=" + member_address
				+ ", member_email=" + member_email + ", member_phone=" + member_phone + ", member_recent_login_time="
				+ member_recent_login_time + ", member_sort_code=" + member_sort_code + ", member_up_code="
				+ member_up_code + ", member_authority=" + member_authority + "]";
	}
	
	
	
}
