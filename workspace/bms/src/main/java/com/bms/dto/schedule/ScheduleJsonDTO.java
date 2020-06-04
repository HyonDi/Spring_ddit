package com.bms.dto.schedule;

import java.util.Calendar;
import java.util.Date;

public class ScheduleJsonDTO {
	
    private String title;
    private Date start;
    private Date end;
    private boolean allDay;
    private int d;
    private int m;
    private int y;
    private int hour;
    private int min;
    
	public ScheduleJsonDTO() {}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Date getStart() {
		return start;
	}


	public void setStart(Date start) {
		this.start = start;
	}


	public Date getEnd() {
		return end;
	}


	public void setEnd(Date end) {
		this.end = end;
	}


	public boolean isAllDay() {
		return allDay;
	}


	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}


	public int getD() {
		return d;
	}


	public void setD(int d) {
		this.d = d;
	}


	public int getM() {
		return m;
	}


	public void setM(int m) {
		this.m = m;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getHour() {
		return hour;
	}


	public void setHour(int hour) {
		this.hour = hour;
	}


	public int getMin() {
		return min;
	}


	public void setMin(int min) {
		this.min = min;
	}


	public ScheduleVO getSchedulevo() {
		return schedulevo;
	}


	public void setSchedulevo(ScheduleVO schedulevo) {
		this.schedulevo = schedulevo;
	}

	@Override
	public String toString() {
		return "ScheduleJsonDTO [title=" + title + ", start=" + start + ", end=" + end + ", allDay=" + allDay + ", d="
				+ d + ", m=" + m + ", y=" + y + ", hour=" + hour + ", min=" + min + ", schedulevo=" + schedulevo + "]";
	}

	ScheduleVO schedulevo;
	//ScheduleJsonDTO scheduleJsonDTO = null;
	
	
	// 내보낼 때.
    @SuppressWarnings("deprecation")
	public ScheduleJsonDTO scheduleVOToDto(ScheduleVO schedulevo) {
    	// vo를 dto로 바꿔준다.
    	
    	//
    	ScheduleJsonDTO sjd = new ScheduleJsonDTO();
    	
    	
    	sjd.setTitle(schedulevo.getSchedule_name());
    	
    	
    	// 시작 시간
    	if(schedulevo.getSchedule_start_time()!=null&&schedulevo.getSchedule_start_time()!="-"&&schedulevo.getSchedule_start_time()!="") {
    		
    		int startHour = Integer.parseInt(schedulevo.getSchedule_start_time().substring(0,2));
    		String startMin = schedulevo.getSchedule_start_time().substring(2,5);
    		System.out.println(startHour + " : " + startMin + " : test");
    	}
    	
    	// 끝 시간
    	if(schedulevo.getSchedule_start_time()!=null&&schedulevo.getSchedule_start_time()!="-"&&schedulevo.getSchedule_start_time()!="") {
    		
    		int endtHour = Integer.parseInt(schedulevo.getSchedule_end_time().substring(0,2));
    		String endMin = schedulevo.getSchedule_end_time().substring(2,5);
    		System.out.println(endtHour + " : " + endMin + " : test");
    	}
    	// 시작 날짜(연,월, 일)
    	int startY = Integer.parseInt(schedulevo.getSchedule_start_date().toString().substring(25, 28));
    	String startMs = schedulevo.getSchedule_start_date().toString().substring(4, 7);
    	int startM = 0;
    	
    	switch (startMs) {
		case "JAN": startM = 1; break;
		case "FEB": startM = 2; break;
		case "MAR": startM = 3; break;
		case "APR": startM = 4; break;
		case "MAY": startM = 5; break;
		case "JUN": startM = 6; break;
		case "JUL": startM = 7; break;
		case "AUG": startM = 8; break;
		case "SEP": startM = 9; break;
		case "OCT": startM = 10; break;
		case "NOV": startM = 11; break;
		case "DEC": startM = 12; break;
		}
    	
    	int startD = Integer.parseInt(schedulevo.getSchedule_start_date().toString().substring(8, 10));
    	//sjd.setStart(schedulevo.getSchedule_start_date());
    	sjd.setStart(new Date(startY, startM, startD));
    	
    	// 끝날짜
    	int endY = Integer.parseInt(schedulevo.getSchedule_end_date().toString().substring(25, 28));
    	String endMs = schedulevo.getSchedule_end_date().toString().substring(4, 7);
    	int endM = 0;
    	switch (endMs) {
		case "JAN": endM = 1; break;
		case "FEB": endM = 2; break;
		case "MAR": endM = 3; break;
		case "APR": endM = 4; break;
		case "MAY": endM = 5; break;
		case "JUN": endM = 6; break;
		case "JUL": endM = 7; break;
		case "AUG": endM = 8; break;
		case "SEP": endM = 9; break;
		case "OCT": endM = 10; break;
		case "NOV": endM = 11; break;
		case "DEC": endM = 12; break;
		}
    	int endD = Integer.parseInt(schedulevo.getSchedule_end_date().toString().substring(8, 10));
    	sjd.setEnd(new Date(endY, endM, endD));
    	
    	//sjd.setEnd(new Date(,,,));
    	
    	// start: new Date(y, m, d, 10, 30),
    	
    	// allday 이벤트인가?
    	if(schedulevo.getSchedule_isallday()==1) {
    		sjd.setAllDay(true);
    	} else if(schedulevo.getSchedule_isallday()==0) {
    		sjd.setAllDay(false);
    	}
    	
    	return sjd;
    }
    
 
    		
}
