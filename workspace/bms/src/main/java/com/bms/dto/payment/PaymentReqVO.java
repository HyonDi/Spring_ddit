package com.bms.dto.payment;

import java.util.Date;

public class PaymentReqVO {
	
	private String payment_code;
	private String member_code;
	private Date payment_date;
	private int payment_amount;
	private String payment_plan;
	private String board_sort_code;
	private String payment_type;
	private String member_name;
	public String getPayment_code() {
		return payment_code;
	}
	public void setPayment_code(String payment_code) {
		this.payment_code = payment_code;
	}
	public String getMember_code() {
		return member_code;
	}
	public void setMember_code(String member_code) {
		this.member_code = member_code;
	}
	public Date getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	public int getPayment_amount() {
		return payment_amount;
	}
	public void setPayment_amount(int payment_amount) {
		this.payment_amount = payment_amount;
	}
	public String getPayment_plan() {
		return payment_plan;
	}
	public void setPayment_plan(String payment_plan) {
		this.payment_plan = payment_plan;
	}
	public String getBoard_sort_code() {
		return board_sort_code;
	}
	public void setBoard_sort_code(String board_sort_code) {
		this.board_sort_code = board_sort_code;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	@Override
	public String toString() {
		return "PaymentReqVO [payment_code=" + payment_code + ", member_code=" + member_code + ", payment_date="
				+ payment_date + ", payment_amount=" + payment_amount + ", payment_plan=" + payment_plan
				+ ", board_sort_code=" + board_sort_code + ", payment_type=" + payment_type + ", member_name="
				+ member_name + "]";
	}

	

	
}