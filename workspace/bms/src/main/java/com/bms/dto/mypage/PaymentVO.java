 package com.bms.dto.mypage;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class PaymentVO {
	private String payment_code; //납부통지 글코드
	private String member_code; //예금주
	private String member_name; //예금주
	private Date payment_date; //날짜
	private int payment_amount; //납부한 금액
	private String payment_plan; //카드, 무통장 입금
	private String board_sort_code; //영수증 첨부 파일
	private String payment_type; //납부 유형
	
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
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
	@DateTimeFormat(pattern="yyyy-MM-dd")
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
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	@Override
	public String toString() {
		return "PaymentVO [payment_code=" + payment_code + ", member_code=" + member_code + ", member_name="
				+ member_name + ", payment_date=" + payment_date + ", payment_amount=" + payment_amount
				+ ", payment_plan=" + payment_plan + ", board_sort_code=" + board_sort_code + ", payment_type="
				+ payment_type + "]";
	}
	
	
	
	
}
