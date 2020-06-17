package com.bms.service.item;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.bms.dto.item.ItemVO;
import com.bms.request.paging.SearchCriteria;

public interface ItemService {

	List<ItemVO> selectStockList() throws SQLException;

	Map<String,Object> getStockList(SearchCriteria cri)throws SQLException;
	
	Map<String, Object> getItemList(SearchCriteria cri)throws SQLException;

	void insertStock(ItemVO stock) throws SQLException;

	ItemVO getStockByItemCode(String item_code) throws SQLException;

	// 재고수정
	void modifyStock(ItemVO stock) throws SQLException;

	// 재고삭제
	void deleteStock(String item_code) throws SQLException;
}
