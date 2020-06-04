package com.bms.dto.schedule;

import java.util.Date;

public class ScheduleVO {
	private String schedule_code;
	private String schedule_sort_code;
	private String schedule_name;
	private String schedule_contents;
	private Date schedule_start_date;
	private Date schedule_end_date;
	private String schedule_start_time;
	private String schedule_end_time;
	private int schedule_istodolist;
	private int schedule_isallday;
	public String getSchedule_code() {
		return schedule_code;
	}
	public void setSchedule_code(String schedule_code) {
		this.schedule_code = schedule_code;
	}
	public String getSchedule_sort_code() {
		return schedule_sort_code;
	}
	public void setSchedule_sort_code(String schedule_sort_code) {
		this.schedule_sort_code = schedule_sort_code;
	}
	public String getSchedule_name() {
		return schedule_name;
	}
	public void setSchedule_name(String schedule_name) {
		this.schedule_name = schedule_name;
	}
	public String getSchedule_contents() {
		return schedule_contents;
	}
	public void setSchedule_contents(String schedule_contents) {
		this.schedule_contents = schedule_contents;
	}
	public Date getSchedule_start_date() {
		return schedule_start_date;
	}
	public void setSchedule_start_date(Date schedule_start_date) {
		this.schedule_start_date = schedule_start_date;
	}
	public Date getSchedule_end_date() {
		return schedule_end_date;
	}
	public void setSchedule_end_date(Date schedule_end_date) {
		this.schedule_end_date = schedule_end_date;
	}
	public String getSchedule_start_time() {
		return schedule_start_time;
	}
	public void setSchedule_start_time(String schedule_start_time) {
		this.schedule_start_time = schedule_start_time;
	}
	public String getSchedule_end_time() {
		return schedule_end_time;
	}
	public void setSchedule_end_time(String schedule_end_time) {
		this.schedule_end_time = schedule_end_time;
	}
	public int getSchedule_istodolist() {
		return schedule_istodolist;
	}
	public void setSchedule_istodolist(int schedule_istodolist) {
		this.schedule_istodolist = schedule_istodolist;
	}
	public int getSchedule_isallday() {
		return schedule_isallday;
	}
	public void setSchedule_isallday(int schedule_isallday) {
		this.schedule_isallday = schedule_isallday;
	}
	
	@Override
	public String toString() {
		return "ScheduleVO [schedule_code=" + schedule_code + ", schedule_sort_code=" + schedule_sort_code
				+ ", schedule_name=" + schedule_name + ", schedule_contents=" + schedule_contents
				+ ", schedule_start_date=" + schedule_start_date + ", schedule_end_date=" + schedule_end_date
				+ ", schedule_start_time=" + schedule_start_time + ", schedule_end_time=" + schedule_end_time
				+ ", schedule_istodolist=" + schedule_istodolist + ", schedule_isallday=" + schedule_isallday + "]";
	}
	
	
}
