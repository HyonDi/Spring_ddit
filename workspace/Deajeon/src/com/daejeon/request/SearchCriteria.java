package com.daejeon.request;

/**
 * 페이지유지해주는 인자들을 모아놓았다. 
 * @author PC-16
 *
 */
public class SearchCriteria {
	private int page; 
	private int perPageNum;
	private String searchType;
	private String keyword;
	
	public SearchCriteria() {
		this.page = 1;
		this.perPageNum = 10;
		this.searchType="";
		this.keyword="";
	}

	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public int getPageStartRowNum() { 
		return (this.page-1)*perPageNum;
	}
}
