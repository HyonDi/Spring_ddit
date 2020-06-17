package com.bms.request.member;

import com.bms.dto.member.MemberVO;

public class FindIdRequest {
	
	private String member_email;
	private String member_name;
	private String member_phone;
	
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	@Override
	public String toString() {
		return "FindIdRequest [member_email=" + member_email + ", member_name=" + member_name + ", member_phone="
				+ member_phone + "]";
	}
	
	public MemberVO findIdVO() {
		
		MemberVO vo = new MemberVO();
		vo.setMember_email(member_email);
		vo.setMember_name(member_name);
		vo.setMember_phone(member_phone);
		
		return vo;
	}
	
}
