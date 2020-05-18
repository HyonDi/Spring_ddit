package com.groupware.controller.baord;

public class ColName {
	private String colName;
	private String Width;
	

	public ColName(String colName, String width) {
		super();
		this.colName = colName;
		Width = width;
	}

	public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

	public String getWidth() {
		return Width;
	}

	public void setWidth(String width) {
		Width = width;
	}
	
	
}
