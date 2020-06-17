package com.bms.dao.item;

import java.sql.SQLException;
import java.util.List;

import com.bms.dto.item.ItemVO;
import com.bms.request.paging.SearchCriteria;

public interface ItemDao {
	//재고현황 리스트(페이지 아직미적용)
	List<ItemVO> selectStockList() throws SQLException;
	//재고현황리스트 검색적용
	List<ItemVO> selectStockListCriteria(SearchCriteria cri)throws SQLException;
	//시설물리스트(시설물 + 재고)
	List<ItemVO> selectItemListCriteria(SearchCriteria cri)throws SQLException;
	//시설물현황 카운트
	int selectItemListCriteriaCount(SearchCriteria cri)throws SQLException;
	//재고현황리스트 검색적용(카운트)
	int selectStockListCriteriaCount(SearchCriteria cri)throws SQLException;
	//재고등록하기
	void insertStock(ItemVO stock) throws SQLException;
	//item_code시퀀스 값 받아오기
	int selectHoldingItemCodeSequence()throws SQLException;
	//코드에 맞는 재고찾기
	ItemVO getStockByItemCode(String item_code)throws SQLException;
	//재고수정
	void modifyStock(ItemVO stock)throws SQLException;
	//재고삭제
	void deleteStock(String item_code)throws SQLException;
}
