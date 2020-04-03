package com.jsp.dto;

public class MemberVO {
	// db에 테이블 만들어오기!! + 연동 + 정규식 + 화면예쁘게 만들어오기(부트스트랩) => 로그인, 로그인success 2개.
	
	// table : member
	private String id;	// 아이디(varchar2 50byte)
	private String pwd;	// 패스워드(varchar2 60byte)
	//private String name; // 이름(varchar2 30byte)
	private String phone;	// 전화번호(varchar2 40byte)
	private String email;	// 이메일(varchar2 50byte)
	//private String address; // 주소 (varchar2 150byte)
	private String picture;	// 사진파일명(varchar2 150byte)
	private String authority;	// 권한(varchar2 30byte)
	private int enabled;	// 사용여부(number)

	public MemberVO() {}

	public MemberVO(String id, String pwd, String phone, String email, String picture, String authority, int enabled) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.phone = phone;
		this.email = email;
		this.picture = picture;
		this.authority = authority;
		this.enabled = enabled;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", phone=" + phone + ", email=" + email + ", picture=" + picture
				+ ", authority=" + authority + ", enabled=" + enabled + "]";
	}

}