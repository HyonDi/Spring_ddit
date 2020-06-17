package com.bms.service.manager;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dao.manager.ManagerDao;
import com.bms.dto.manager.ManagerVO;
import com.bms.request.paging.PageMaker;
import com.bms.request.paging.SearchCriteria;

public class ManagerServiceImpl implements ManagerService{

	@Autowired
	private ManagerDao managerDao;
	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}
	
	@Override
	public Map<String, Object> getManagerAll(SearchCriteria cri) throws SQLException {
		Map<String,Object> dataMap=new HashMap<String,Object>();
		
		//현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
		List<ManagerVO> managerList=managerDao.selectManagerAll(cri);
		
		//전체 board 개수
		int totalCount=managerDao.selectManagerCriteriaTotalCount(cri);
		
		//PageMaker 생성.
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("managerList", managerList);
		dataMap.put("pageMaker",pageMaker);
		
		return dataMap;
	}

	@Override
	public ManagerVO getManagerByCode(String member_code) throws SQLException {
		ManagerVO manager = managerDao.selectManagerByCode(member_code);
		return manager;
	}
	
}
