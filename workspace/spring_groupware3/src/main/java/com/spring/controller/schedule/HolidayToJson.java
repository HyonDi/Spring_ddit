package com.spring.controller.schedule;

public class HolidayToJson {
	private String title;
	private boolean allDay;
	private boolean isfreeday;
	private String backgroundColor;
	private String descript;
	private String className;
	private String start;
	
	public HolidayToJson() {
		allDay = true;
		isfreeday = true;
		backgroundColor = "#b74635";		
		className = "holiday";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isAllDay() {
		return allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}

	public boolean isIsfreeday() {
		return isfreeday;
	}

	public void setIsfreeday(boolean isfreeday) {
		this.isfreeday = isfreeday;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	@Override
	public String toString() {
		return "HolidayToJson [title=" + title + ", allDay=" + allDay + ", isfreeday=" + isfreeday
				+ ", backgroundColor=" + backgroundColor + ", descript=" + descript + ", className=" + className
				+ ", start=" + start + "]";
	}
	
	
}
