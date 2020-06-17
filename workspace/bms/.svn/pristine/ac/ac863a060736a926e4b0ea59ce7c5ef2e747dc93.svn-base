package com.bms.service.facility;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dao.facility.FacilityManageDao;
import com.bms.dto.facility.CheckListVO;
import com.bms.dto.facility.FacilityManageVO;
import com.bms.request.paging.FacilityPageMaker;
import com.bms.request.paging.FacilitySearchCriteria;
import com.bms.request.paging.PageMaker;

public class FacilityManageServiceImpl implements FacilityManageService {
	
	@Autowired
	private FacilityManageDao facilityManageDao;
	public void setFacilityManageDao(FacilityManageDao facilityManageDao) {
		this.facilityManageDao = facilityManageDao;
	}
	@Override
	public Map<String, Object> selectSearchAllFacilityList(FacilitySearchCriteria cri) throws SQLException {
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		List<FacilityManageVO> facilityList;
		try {
			facilityList = facilityManageDao.selectSearchAllFacilityList(cri);
			int totalCount = facilityManageDao.selectSearchAllFacilityListCount(cri);
			
			FacilityPageMaker pageMaker = new FacilityPageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(totalCount);
			
			dataMap.put("facilityList", facilityList);
			dataMap.put("pageMaker",pageMaker);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return dataMap;
	}
	@Override
	public void insertFacilityDetail(FacilityManageVO facility, List<CheckListVO> checkList) throws SQLException {

		String url = UUID.randomUUID().toString().replace("-", "");
		facility.setFacility_url(url);
		
		facilityManageDao.insertFacility(facility);
		
		for(CheckListVO check:checkList) {		
			String facility_code = facilityManageDao.selectByFacilityCode();
			check.setFacility_code(facility_code);
			String[] chkCon = check.getCheck_point_facility_contents().split(",");
			for(int i = 0; i < chkCon.length; i++) {
				check.setCheck_point_facility_contents(chkCon[i]);
				facilityManageDao.insertFacilityCheckList(check);	
			}
			
		}
	}
	@Override
	public FacilityManageVO selectFacilityByFacilityCode(String facility_code) throws SQLException {
		FacilityManageVO getFacility = facilityManageDao.selectFacilityByFacilityCode(facility_code);
		return getFacility;
	}
	@Override
	public List<CheckListVO> selelctCheckListByFacilityCode(String facility_code) throws SQLException {
		List<CheckListVO> getCheckList = facilityManageDao.selelctCheckListByFacilityCode(facility_code);
		return getCheckList;
	}
	@Override
	public void insertFacilityCheckList(List<CheckListVO> checkList) throws SQLException {
		
		for(CheckListVO check:checkList) {		
			String facility_code = facilityManageDao.selectFacilityCode();
			check.setFacility_code(facility_code);
			String[] chkCon = check.getCheck_point_facility_contents().split(",");
			for(int i = 0; i < chkCon.length; i++) {
				check.setCheck_point_facility_contents(chkCon[i]);
				facilityManageDao.insertFacilityCheckList(check);	
			}
			
		}
	}
	@Override
	public void modifyFacility(FacilityManageVO facility) throws SQLException {
		facilityManageDao.modifyFacility(facility);
	}
	@Override
	public void deleteFacility(String facility_code) throws SQLException {
		facilityManageDao.deleteFacility(facility_code);
	}
	@Override
	public void modifyCheckList(CheckListVO checkList) throws SQLException {
		facilityManageDao.modifyCheckList(checkList);
	}
	@Override
	public void deleteCheckList(String check_point_facility_code) throws SQLException {
		facilityManageDao.deleteCheckList(check_point_facility_code);
	}
	@Override
	public void insertFacilityCheckListTo(CheckListVO chkList) throws SQLException {
		facilityManageDao.insertFacilityCheckList(chkList);
	}
	@Override
	public CheckListVO selectCheckListByCheckListCode(String check_point_facility_code) throws SQLException {
		CheckListVO chk = facilityManageDao.selectCheckListByCheckListCode(check_point_facility_code);
		return chk;
	}
	

}
