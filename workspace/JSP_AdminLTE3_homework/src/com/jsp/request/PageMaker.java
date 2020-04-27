package com.jsp.request;

public class PageMaker {
	private int totalCount; // 전체 board 개수
	private int startPage=1; // 시작 페이지 번호
	private int endPage=1; //마지막 페이지 번호
	private int realEndPage; //끝페이지 번호-마지막페이지 10개 다 안차면 있는거만보여주기위해서 필요
	private boolean prev; // 이전페이지 버튼 유무
	private boolean next; // 다음 페이지 버튼 유무
	
	private int displayPageNum = 10; // 한 페이지에 보여줄 페이지 번호 개수
	
	private SearchCriteria cri; // 현재 페이지 정보
	
	
	// startPage, endPage, prev, next 설정. by totalCount
	private void calcData() {
		endPage = (int)(Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
		startPage = (endPage - displayPageNum) + 1;
		
		realEndPage = (int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
		
		if(startPage < 0) {
			startPage = 1;
		}
		
		if(endPage > realEndPage) {
			endPage = realEndPage;
		}
		
		prev = startPage == 1? false : true;
		next = endPage * cri.getPerPageNum() >= totalCount ? false: true;
		// totalCount 에 db조회 값이 제대로들어오는 시기? : 아래 게터세터의 setTotalCount 될 때. 
	}

	public String makeQuery(int page) {
		String query="?page=" + page
					+"&perPageNum="+cri.getPerPageNum()
					+"&searchType="+cri.getSearchType()
					+"&keyword="+cri.getKeyword();
		return query;
	}
	
	
	
	// 게터세터
	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData(); // totalCount에 값이 들어갈 때, 이 메서드를 실행해야한다.
	}


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public int getRealEndPage() {
		return realEndPage;
	}


	public void setRealEndPage(int realEndPage) {
		this.realEndPage = realEndPage;
	}


	public boolean isPrev() {
		return prev;
	}


	public void setPrev(boolean prev) {
		this.prev = prev;
	}


	public boolean isNext() {
		return next;
	}


	public void setNext(boolean next) {
		this.next = next;
	}


	public int getDisplayPageNum() {
		return displayPageNum;
	}


	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}


	public SearchCriteria getCri() {
		return cri;
	}


	public void setCri(SearchCriteria cri) {
		this.cri = cri;
	}
	
	
	
}
