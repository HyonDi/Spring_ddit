package com.spring.dto.holiday;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="body")
public class HolidayItems {

	private List<HolidayItem> items;
	
	@XmlElementWrapper(name="items")
	@XmlElement(name="item")
	public List<HolidayItem> getItems() {
		return items;
	}

	public void setItems(List<HolidayItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "HolidayItems [items=" + items + "]";
	}
	
	
	
	
}
