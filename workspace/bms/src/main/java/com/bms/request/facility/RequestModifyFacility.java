package com.bms.request.facility;

import com.bms.dto.facility.FacilityManageVO;

public class RequestModifyFacility {
	
	private String facility_name;
	private String facility_picture;
	
	public String getFacility_name() {
		return facility_name;
	}
	public void setFacility_name(String facility_name) {
		this.facility_name = facility_name;
	}
	public String getFacility_picture() {
		return facility_picture;
	}
	public void setFacility_picture(String facility_picture) {
		this.facility_picture = facility_picture;
	}
	
	@Override
	public String toString() {
		return "RequestModifyFacility [facility_name=" + facility_name + ", facility_picture=" + facility_picture
				+ ", getFacility_name()=" + getFacility_name() + ", getFacility_picture()=" + getFacility_picture()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	public FacilityManageVO toFacilityVO() {
		
		FacilityManageVO facility = new FacilityManageVO();
		facility.setFacility_name(facility_name);
		facility.setFacility_picture(facility_picture);
		
		return facility;
	}
}
