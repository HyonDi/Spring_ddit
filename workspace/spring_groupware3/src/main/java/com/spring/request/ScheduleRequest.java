package com.spring.request;

public class ScheduleRequest {
	
	private String startDate;
	private String endDate;
	private String sche_no;
	private String workType;
	
	
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	
	public String getSche_no() {
		return sche_no;
	}
	public void setSche_no(String sche_no) {
		this.sche_no = sche_no;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}	
	
}
