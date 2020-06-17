package com.bms.dto.member;

import java.util.Date;

public class CareerVO {
	private String career_code;
	private String member_code;
	private String career_company_name;
	private String career_work_kind;
	private String career_position;
	private Date career_start_date;
	private Date career_last_date;
	
	public String getCareer_code() {
		return career_code;
	}
	public void setCareer_code(String career_code) {
		this.career_code = career_code;
	}
	public String getMember_code() {
		return member_code;
	}
	public void setMember_code(String member_code) {
		this.member_code = member_code;
	}
	public String getCareer_company_name() {
		return career_company_name;
	}
	public void setCareer_company_name(String career_company_name) {
		this.career_company_name = career_company_name;
	}
	public String getCareer_work_kind() {
		return career_work_kind;
	}
	public void setCareer_work_kind(String career_work_kind) {
		this.career_work_kind = career_work_kind;
	}
	public String getCareer_position() {
		return career_position;
	}
	public void setCareer_position(String career_position) {
		this.career_position = career_position;
	}
	public Date getCareer_start_date() {
		return career_start_date;
	}
	public void setCareer_start_date(Date career_start_date) {
		this.career_start_date = career_start_date;
	}
	public Date getCareer_last_date() {
		return career_last_date;
	}
	public void setCareer_last_date(Date career_last_date) {
		this.career_last_date = career_last_date;
	}
	@Override
	public String toString() {
		return "CareerVO [career_code=" + career_code + ", member_code=" + member_code + ", career_company_name="
				+ career_company_name + ", career_work_kind=" + career_work_kind + ", career_position="
				+ career_position + ", career_start_date=" + career_start_date + ", career_last_date="
				+ career_last_date + "]";
	}
	
	
}
