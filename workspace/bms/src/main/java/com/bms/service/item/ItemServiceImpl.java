package com.bms.service.item;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dao.item.ItemDao;
import com.bms.dto.item.ItemVO;
import com.bms.request.paging.PageMaker;
import com.bms.request.paging.SearchCriteria;

public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDao itemDao;
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
	@Override
	public List<ItemVO> selectStockList() throws SQLException {
		List<ItemVO> stockList = itemDao.selectStockList();
		return stockList;
	}

	@Override
	public void insertStock(ItemVO stock) throws SQLException {
		int itemCodeSequence = itemDao.selectHoldingItemCodeSequence();
		
		String item_code = "item" + itemCodeSequence;
		stock.setItem_code(item_code);
		
		itemDao.insertStock(stock);
	}

	@Override
	public ItemVO getStockByItemCode(String item_code) throws SQLException {
		ItemVO stock = itemDao.getStockByItemCode(item_code);
		return stock;
	}

	@Override
	public void modifyStock(ItemVO stock) throws SQLException {
		itemDao.modifyStock(stock);
	}

	@Override
	public void deleteStock(String item_code) throws SQLException {
		itemDao.deleteStock(item_code);
	}

	@Override
	public Map<String, Object> getStockList(SearchCriteria cri) throws SQLException {
		Map<String,Object> dataMap=new HashMap<String,Object>();
		
		//현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
		List<ItemVO> stockList=itemDao.selectStockListCriteria(cri);
		
		//전체 board 개수
		int totalCount=itemDao.selectStockListCriteriaCount(cri);
		
		//PageMaker 생성.
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("stockList", stockList);
		dataMap.put("pageMaker",pageMaker);
		
		
		return dataMap;
	}

	@Override
	public Map<String, Object> getItemList(SearchCriteria cri) throws SQLException {
		Map<String,Object> dataMap=new HashMap<String,Object>();
		
		//현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
		List<ItemVO> itemList=itemDao.selectItemListCriteria(cri);
		
		//전체 board 개수
		int totalCount=itemDao.selectItemListCriteriaCount(cri);
		
		//PageMaker 생성.
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("itemList", itemList);
		dataMap.put("pageMaker",pageMaker);
		
		return dataMap;
	}	
}
