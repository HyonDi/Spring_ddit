package com.jsp.dto;

public class MemberVO {
	//table : member
	private String id; //아이디 (varchar2 50byte)
	private String pwd; //패스워드 (varchar2 60byte)
	private String name; //name (varchar2 30byte)
	private String address; //address (varchar2 150byte)
	private String phone; //전화번호 (varchar2 40byte)
	private String email; //이메일 (varchar2 50byte)
	private String picture; //사진파일명 (varchar2 150byte)
	private String authority; //권한 (varchar2 30byte)
	private Integer enabled; //사용여부 (number)
	
	public MemberVO() {}

	public MemberVO(String id, String pwd, String name, String address, String phone, String email, String picture,
			String authority, Integer enabled) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.address = address;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + ", picture=" + picture + ", authority=" + authority + ", enabled=" + enabled
				+ "]";
	}
	
	
	
}
