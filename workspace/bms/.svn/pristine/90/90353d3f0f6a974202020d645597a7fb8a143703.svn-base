package com.bms.request.facility;

import java.util.Arrays;
import java.util.List;

import com.bms.dto.facility.CheckListVO;
import com.bms.dto.facility.FacilityManageVO;

public class RequestRegistFacilityManage {
	
	private String facility_code;
	private String member_code;
	private String facility_name;
	private String facility_url;
	private String facility_picture;
	private String check_point_facility_code;
	private String check_point_facility_contents;
	private String member_name;
	private CheckListVO[] checkList;
	
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
	public String getCheck_point_facility_code() {
		return check_point_facility_code;
	}
	public void setCheck_point_facility_code(String check_point_facility_code) {
		this.check_point_facility_code = check_point_facility_code;
	}
	public String getCheck_point_facility_contents() {
		return check_point_facility_contents;
	}
	public void setCheck_point_facility_contents(String check_point_facility_contents) {
		this.check_point_facility_contents = check_point_facility_contents;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public CheckListVO[] getCheckList() {
		return checkList;
	}
	public void setCheckList(CheckListVO[] checkList) {
		this.checkList = checkList;
	}
	@Override
	public String toString() {
		return "RequestRegistFacilityManage [facility_code=" + facility_code + ", member_code=" + member_code
				+ ", facility_name=" + facility_name + ", facility_url=" + facility_url + ", facility_picture="
				+ facility_picture + ", check_point_facility_code=" + check_point_facility_code
				+ ", check_point_facility_contents=" + check_point_facility_contents + ", member_name=" + member_name
				+ ", checkList=" + Arrays.toString(checkList) + ", getFacility_code()=" + getFacility_code()
				+ ", getMember_code()=" + getMember_code() + ", getFacility_name()=" + getFacility_name()
				+ ", getFacility_url()=" + getFacility_url() + ", getFacility_picture()=" + getFacility_picture()
				+ ", getCheck_point_facility_code()=" + getCheck_point_facility_code()
				+ ", getCheck_point_facility_contents()=" + getCheck_point_facility_contents() + ", getMember_name()="
				+ getMember_name() + ", getCheckList()=" + Arrays.toString(getCheckList()) + ", toFacilityVO()="
				+ toFacilityVO() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	public FacilityManageVO toFacilityVO() {
		
		FacilityManageVO facility = new FacilityManageVO();
		facility.setCheck_point_facility_code(check_point_facility_code);
		facility.setCheck_point_facility_contents(check_point_facility_contents);
		facility.setFacility_code(check_point_facility_code);
		facility.setFacility_name(facility_name);
		facility.setFacility_picture(facility_picture);
		facility.setFacility_url(facility_url);
		facility.setMember_code(member_code);
		facility.setMember_name(member_name);
		
		return facility;
		
	}
}
