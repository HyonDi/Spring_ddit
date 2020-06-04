package com.bms.dto.menu;

public class MenuVO {
	private String menu_code;
	private String menu_name;
	private String menu_url;
	private String menu_icon;
	private int menu_is_category;
	private int menu_code_level;
	private String menu_up_code;
	private String menu_enable;
	
	public String getMenu_code() {
		return menu_code;
	}
	public void setMenu_code(String menu_code) {
		this.menu_code = menu_code;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getMenu_url() {
		return menu_url;
	}
	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}
	public String getMenu_icon() {
		return menu_icon;
	}
	public void setMenu_icon(String menu_icon) {
		this.menu_icon = menu_icon;
	}
	public int getMenu_is_category() {
		return menu_is_category;
	}
	public void setMenu_is_category(int menu_is_category) {
		this.menu_is_category = menu_is_category;
	}
	public int getMenu_code_level() {
		return menu_code_level;
	}
	public void setMenu_code_level(int menu_code_level) {
		this.menu_code_level = menu_code_level;
	}
	public String getMenu_up_code() {
		return menu_up_code;
	}
	public void setMenu_up_code(String menu_up_code) {
		this.menu_up_code = menu_up_code;
	}
	public String getMenu_enable() {
		return menu_enable;
	}
	public void setMenu_enable(String menu_enable) {
		this.menu_enable = menu_enable;
	}
	
	@Override
	public String toString() {
		return "MenuVO [menu_code=" + menu_code + ", menu_name=" + menu_name + ", menu_url=" + menu_url + ", menu_icon="
				+ menu_icon + ", menu_is_category=" + menu_is_category + ", menu_code_level=" + menu_code_level
				+ ", menu_up_code=" + menu_up_code + ", menu_enable=" + menu_enable + "]";
	}
	
	
}
