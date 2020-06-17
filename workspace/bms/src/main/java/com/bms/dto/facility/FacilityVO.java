package com.bms.dto.facility;

public class FacilityVO {
	private String facility_code;
	private String member_code;
	private String facility_name;
	private String facility_url;
	private String facility_picture;
	
	
	
	public FacilityVO() {}
	public FacilityVO(String facility_code, String member_code, String facility_name, String facility_url,
			String facility_picture) {
		super();
		this.facility_code = facility_code;
		this.member_code = member_code;
		this.facility_name = facility_name;
		this.facility_url = facility_url;
		this.facility_picture = facility_picture;
	}
	public String getFacility_code() {
		return facility_code;
	}
	public void setFacility_code(String facility_code) {
		this.facility_code = facility_code;
	}
	public String getMember_code() {
		return member_code;
	}
	public void setMember_code(String member_code) {
		this.member_code = member_code;
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
	public String getFacility_picture() {
		return facility_picture;
	}
	public void setFacility_picture(String facility_picture) {
		this.facility_picture = facility_picture;
	}
	@Override
	public String toString() {
		return "FacilityVO [facility_code=" + facility_code + ", member_code=" + member_code + ", facility_name="
				+ facility_name + ", facility_url=" + facility_url + ", facility_picture=" + facility_picture + "]";
	}
	
	
}
