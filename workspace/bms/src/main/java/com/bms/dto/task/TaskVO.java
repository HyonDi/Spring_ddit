package com.bms.dto.task;

public class TaskVO {
	private String task_code;
	private String member_code;
	private String task_contents;
	
	
	public TaskVO() {}
	public TaskVO(String task_code, String member_code, String task_contents) {
		super();
		this.task_code = task_code;
		this.member_code = member_code;
		this.task_contents = task_contents;
	}
	public String getTask_code() {
		return task_code;
	}
	public void setTask_code(String task_code) {
		this.task_code = task_code;
	}
	public String getMember_code() {
		return member_code;
	}
	public void setMember_code(String member_code) {
		this.member_code = member_code;
	}
	public String getTask_contents() {
		return task_contents;
	}
	public void setTask_contents(String task_contents) {
		this.task_contents = task_contents;
	}
	@Override
	public String toString() {
		return "TaskVO [task_code=" + task_code + ", member_code=" + member_code + ", task_contents=" + task_contents
				+ "]";
	}
	
}
