package com.jsp.request;

import com.jsp.dto.MemberVO;

public class LoginRequest{
	// db에 없는 것도 올 수 있음.
	// 화면전환시 필요한 정보가 들어있을 수도 있음/
	private String id;
	private String pwd;
	
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return this.id;
	}
	public void setPwd(String pwd){
		this.pwd=pwd;
	}
	public String getPwd(){
		return this.pwd;
	}
	
	public MemberVO toMemberVO() {
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		
		return member;
	}
}
