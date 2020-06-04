package com.spring.dto.holiday;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="response")
public class HolidayResponseVO {

	private Map<String,String> header;
	private HolidayItems body;
	
	
	public Map<String, String> getHeader() {
		return header;
	}
	public void setHeader(Map<String, String> header) {
		this.header = header;
	}
	public HolidayItems getBody() {
		return body;
	}
	public void setBody(HolidayItems body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "HolidayResponseVO [header=" + header + ", body=" + body + "]";
	}
	
	
}
