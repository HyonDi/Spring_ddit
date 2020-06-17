package com.bms.dao.item;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dto.item.ItemVO;
import com.bms.request.paging.SearchCriteria;

public class ItemDaoImpl implements ItemDao {

	@Autowired
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<ItemVO> selectStockList() throws SQLException {
		List<ItemVO> stockList = sqlSession.selectList("Item-Mapper.selectStockList");
		return stockList;
	}

	@Override
	public void insertStock(ItemVO stock) throws SQLException {
		sqlSession.update("Item-Mapper.insertItem", stock);
	}

	@Override
	public int selectHoldingItemCodeSequence() throws SQLException {
		int sequence = sqlSession.selectOne("Item-Mapper.selectHoldingItemCodeSequence");
		return sequence;
	}

	@Override
	public ItemVO getStockByItemCode(String item_code) throws SQLException {
		ItemVO stock = sqlSession.selectOne("Item-Mapper.getItemByItemCode", item_code);
		return stock;
	}

	@Override
	public void modifyStock(ItemVO stock) throws SQLException {
		sqlSession.update("Item-Mapper.modifyItem", stock);
	}

	@Override
	public void deleteStock(String item_code) throws SQLException {
		sqlSession.update("Item-Mapper.deleteItem", item_code);
		
	}

	@Override
	public List<ItemVO> selectStockListCriteria(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<ItemVO> stockList = sqlSession.selectList("Item-Mapper.selectSearchStockList", cri, rowBounds);
		return stockList;
	}

	@Override
	public int selectStockListCriteriaCount(SearchCriteria cri) throws SQLException {
		//System.out.println("cri:>>>>>>>>" + cri.toString());
		int count = sqlSession.selectOne("Item-Mapper.selectSearchStockListCount", cri);
		return count;
	}

	@Override
	public List<ItemVO> selectItemListCriteria(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<ItemVO> itemList = sqlSession.selectList("Item-Mapper.selectSearchItemList", cri, rowBounds);
		return itemList;
	}

	@Override
	public int selectItemListCriteriaCount(SearchCriteria cri) throws SQLException {
		int count = sqlSession.selectOne("Item-Mapper.selectSearchItemListCount", cri);
		return count;
	}

}
