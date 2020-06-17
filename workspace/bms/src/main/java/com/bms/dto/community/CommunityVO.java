package com.bms.dto.community;

import java.util.Date;

public class CommunityVO {
	
	private String community_code;
	private String member_code;
	private String community_title;
	private String community_contents;
	private int community_view_cnt;
	private Date community_reg_date;
	private Date community_update_date;
	private String board_sort_code;
	public String getCommunity_code() {
		return community_code;
	}
	public void setCommunity_code(String community_code) {
		this.community_code = community_code;
	}
	public String getMember_code() {
		return member_code;
	}
	public void setMember_code(String member_code) {
		this.member_code = member_code;
	}
	public String getCommunity_title() {
		return community_title;
	}
	public void setCommunity_title(String community_title) {
		this.community_title = community_title;
	}
	public String getCommunity_contents() {
		return community_contents;
	}
	public void setCommunity_contents(String community_contents) {
		this.community_contents = community_contents;
	}
	public int getCommunity_view_cnt() {
		return community_view_cnt;
	}
	public void setCommunity_view_cnt(int community_view_cnt) {
		this.community_view_cnt = community_view_cnt;
	}
	public Date getCommunity_reg_date() {
		return community_reg_date;
	}
	public void setCommunity_reg_date(Date community_reg_date) {
		this.community_reg_date = community_reg_date;
	}
	public Date getCommunity_update_date() {
		return community_update_date;
	}
	public void setCommunity_update_date(Date community_update_date) {
		this.community_update_date = community_update_date;
	}
	public String getBoard_sort_code() {
		return board_sort_code;
	}
	public void setBoard_sort_code(String board_sort_code) {
		this.board_sort_code = board_sort_code;
	}
	@Override
	public String toString() {
		return "CommunityVO [community_code=" + community_code + ", member_code=" + member_code + ", community_title="
				+ community_title + ", community_contents=" + community_contents + ", community_view_cnt="
				+ community_view_cnt + ", community_reg_date=" + community_reg_date + ", community_update_date="
				+ community_update_date + ", board_sort_code=" + board_sort_code + "]";
	}
	
		
	

}
