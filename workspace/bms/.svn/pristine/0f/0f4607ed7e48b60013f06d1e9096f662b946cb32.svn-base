package com.bms.request.facility;

import java.util.Arrays;

import com.bms.dto.facility.CheckListVO;

public class RequestRegistCheckList {
	
	private String facility_code;
	private String check_point_facility_code;
	private String check_point_facility_contents;
	private CheckListVO[] checkList;
	public String getFacility_code() {
		return facility_code;
	}
	public void setFacility_code(String facility_code) {
		this.facility_code = facility_code;
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
	public CheckListVO[] getCheckList() {
		return checkList;
	}
	public void setCheckList(CheckListVO[] checkList) {
		this.checkList = checkList;
	}
	
	@Override
	public String toString() {
		return "RequestRegistCheckList [facility_code=" + facility_code + ", check_point_facility_code="
				+ check_point_facility_code + ", check_point_facility_contents=" + check_point_facility_contents
				+ ", checkList=" + Arrays.toString(checkList) + ", getFacility_code()=" + getFacility_code()
				+ ", getCheck_point_facility_code()=" + getCheck_point_facility_code()
				+ ", getCheck_point_facility_contents()=" + getCheck_point_facility_contents() + ", getCheckList()="
				+ Arrays.toString(getCheckList()) + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	public CheckListVO toCheckVO() {
		
		CheckListVO check = new CheckListVO();
		check.setCheck_point_facility_code(check_point_facility_code);
		check.setCheck_point_facility_contents(check_point_facility_contents);
		check.setFacility_code(facility_code);
		
		return check;
	}
}
