package com.bms.request.member;

import com.bms.dto.member.MemberVO;

public class FindPasswordRequest {
	private String member_id;
	private String member_name;
	private String member_email;
	private int member_pwdupdatechk;
	
	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	
	public int getMember_pwdupdatechk() {
		return member_pwdupdatechk;
	}

	public void setMember_pwdupdatechk(int member_pwdupdatechk) {
		this.member_pwdupdatechk = member_pwdupdatechk;
	}

	

	@Override
	public String toString() {
		return "FindPasswordRequest [member_id=" + member_id + ", member_name=" + member_name + ", member_email="
				+ member_email + ", member_pwdupdatechk=" + member_pwdupdatechk + "]";
	}

	public MemberVO findPassword() {
		MemberVO vo = new MemberVO();
		
		vo.setMember_id(member_id);
		vo.setMember_name(member_name);
		vo.setMember_email(member_email);
		vo.setMember_pwdupdatechk(member_pwdupdatechk);
		
		return vo;
	}
}
