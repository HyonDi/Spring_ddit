package com.bms.dto.faq;

import java.util.Date;

public class FaqVO {
	private String faq_code;
	private String faq_title;
	private String faq_contents;
	private int faq_view_cnt;
	private Date faq_reg_date;
	private Date faq_update_date;
	private String board_sort_code;
	
	public FaqVO() {}
	
	public FaqVO(String faq_code, String faq_title, String faq_contents, int faq_view_cnt, Date faq_reg_date,
			Date faq_update_date, String board_sort_code) {
		super();
		this.faq_code = faq_code;
		this.faq_title = faq_title;
		this.faq_contents = faq_contents;
		this.faq_view_cnt = faq_view_cnt;
		this.faq_reg_date = faq_reg_date;
		this.faq_update_date = faq_update_date;
		this.board_sort_code = board_sort_code;
	}
	
	public String getFaq_code() {
		return faq_code;
	}
	public void setFaq_code(String faq_code) {
		this.faq_code = faq_code;
	}
	public String getFaq_title() {
		return faq_title;
	}
	public void setFaq_title(String faq_title) {
		this.faq_title = faq_title;
	}
	public String getFaq_contents() {
		return faq_contents;
	}
	public void setFaq_contents(String faq_contents) {
		this.faq_contents = faq_contents;
	}
	public int getFaq_view_cnt() {
		return faq_view_cnt;
	}
	public void setFaq_view_cnt(int faq_view_cnt) {
		this.faq_view_cnt = faq_view_cnt;
	}
	public Date getFaq_reg_date() {
		return faq_reg_date;
	}
	public void setFaq_reg_date(Date faq_reg_date) {
		this.faq_reg_date = faq_reg_date;
	}
	public Date getFaq_update_date() {
		return faq_update_date;
	}
	public void setFaq_update_date(Date faq_update_date) {
		this.faq_update_date = faq_update_date;
	}
	public String getBoard_sort_code() {
		return board_sort_code;
	}
	public void setBoard_sort_code(String board_sort_code) {
		this.board_sort_code = board_sort_code;
	}
	@Override
	public String toString() {
		return "FaqVO [faq_code=" + faq_code + ", faq_title=" + faq_title + ", faq_contents=" + faq_contents
				+ ", faq_view_cnt=" + faq_view_cnt + ", faq_reg_date=" + faq_reg_date + ", faq_update_date="
				+ faq_update_date + ", board_sort_code=" + board_sort_code + "]";
	}
	
	
	
}
