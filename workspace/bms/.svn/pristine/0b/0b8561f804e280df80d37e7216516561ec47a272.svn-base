package com.bms.service.constract;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dao.constract.ConstractDao;
import com.bms.dto.constract.ConstractReqVO;
import com.bms.request.paging.PageMaker;
import com.bms.request.paging.SearchCriteria;

public class ConstractServiceImpl implements ConstractService{
	
	@Autowired
	private ConstractDao constractDao;
	public void setConstractDao(ConstractDao constractDao) {
		this.constractDao = constractDao;
	}

	@Override
	public Map<String, Object> getConstractAll(SearchCriteria cri) throws SQLException {
		Map<String,Object> dataMap=new HashMap<String,Object>();
		
		//현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
		List<ConstractReqVO> constractList=constractDao.selectConstractAll(cri);
		
		//전체 board 개수
		int totalCount=constractDao.selectConstractCriteriaTotalCount(cri);
		
		//PageMaker 생성.
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("constractList", constractList);
		dataMap.put("pageMaker",pageMaker);
		
		return dataMap;
	}

	@Override
	public ConstractReqVO mobileConstractDetail(String constract_code) throws SQLException {
		ConstractReqVO constract = constractDao.mobileConstractDetail(constract_code);
		return constract;
	}

}
