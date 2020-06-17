package com.bms.service.resident;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dao.resident.ResidentDao;
import com.bms.dto.member.ResidentVO;
import com.bms.request.paging.PageMaker;
import com.bms.request.paging.SearchCriteria;

public class ResidentServiceImpl implements ResidentService{
	
	@Autowired
	private ResidentDao residentDao;
	public void setResidentDao(ResidentDao residentDao) {
		this.residentDao = residentDao;
	}

	@Override
	public Map<String, Object> getResidentAll(SearchCriteria cri) throws SQLException {
		Map<String,Object> dataMap=new HashMap<String,Object>();
		
		//현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
		List<ResidentVO> residentList= residentDao.selectResidentAll(cri);
		
		//전체 board 개수
		int totalCount=residentDao.selectResidentCriteriaTotalCount(cri);
		
		//PageMaker 생성.
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("residentList", residentList);
		dataMap.put("pageMaker",pageMaker);
		
		return dataMap;
	}

	@Override
	public ResidentVO getResidentByCode(String member_code) throws SQLException {
		ResidentVO resident = residentDao.selectResidentByCode(member_code);
		return resident;
	}

}
