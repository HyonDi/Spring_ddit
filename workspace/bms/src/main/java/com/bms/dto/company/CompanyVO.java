package com.bms.dto.company;

public class CompanyVO {
	
	private String company_code;
	private String company_name;
	private String company_work_kind;
	private String company_address;
	private String company_charge_name;
	private String company_charge_phone;
	private String company_charge_email;
	public String getCompany_code() {
		return company_code;
	}
	public void setCompany_code(String company_code) {
		this.company_code = company_code;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_work_kind() {
		return company_work_kind;
	}
	public void setCompany_work_kind(String company_work_kind) {
		this.company_work_kind = company_work_kind;
	}
	public String getCompany_address() {
		return company_address;
	}
	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}
	public String getCompany_charge_name() {
		return company_charge_name;
	}
	public void setCompany_charge_name(String company_charge_name) {
		this.company_charge_name = company_charge_name;
	}
	public String getCompany_charge_phone() {
		return company_charge_phone;
	}
	public void setCompany_charge_phone(String company_charge_phone) {
		this.company_charge_phone = company_charge_phone;
	}
	public String getCompany_charge_email() {
		return company_charge_email;
	}
	public void setCompany_charge_email(String company_charge_email) {
		this.company_charge_email = company_charge_email;
	}
	@Override
	public String toString() {
		return "CompanyVO [company_code=" + company_code + ", company_name=" + company_name + ", company_work_kind="
				+ company_work_kind + ", company_address=" + company_address + ", company_charge_name="
				+ company_charge_name + ", company_charge_phone=" + company_charge_phone + ", company_charge_email="
				+ company_charge_email + "]";
	}
	
	

}
