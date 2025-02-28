package com.bms.request.mypage;

import com.bms.dto.member.MemberVO;

public class MypageModifyRequest {
	

	private String member_id;
	private String member_pwd;
	private String member_name;
	private String member_ssn;
	private String member_address;
	private String member_email;
	private String member_phone;

	public MemberVO toMemberVO() {
		MemberVO member = new MemberVO();
		
		member.setMember_id(member_id);
		member.setMember_pwd(member_pwd);
		member.setMember_name(member_name);
		member.setMember_ssn(member_ssn);
		member.setMember_address(member_address);
		member.setMember_email(member_email);
		member.setMember_phone(member_phone);
		
		return member;
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

	@Override
	public String toString() {
		return "MypageModifyRequest [member_id=" + member_id + ", member_pwd=" + member_pwd + ", member_name="
				+ member_name + ", member_ssn=" + member_ssn + ", member_address=" + member_address + ", member_email="
				+ member_email + ", member_phone=" + member_phone + "]";
	}
	
	
	

}
