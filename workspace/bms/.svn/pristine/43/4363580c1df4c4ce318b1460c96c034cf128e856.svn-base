package com.bms.service.facility;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dao.facility.FacilityDao;
import com.bms.dao.member.MemberDao;
import com.bms.dto.facility.FacilityVO;
import com.bms.dto.facility.ResponsibilityFacilityVO;

public class FacilityServiceImpl implements FacilityService{
	@Autowired
	private FacilityDao facilityDao;
	public void setFacilityDao(FacilityDao facilityDao) {
		this.facilityDao = facilityDao;
	}
	
	// 보유 시설 리스트
	@Override
	public List<FacilityVO> selectHoldingFacilityList(String member_code) throws SQLException {
		List<FacilityVO> HoldingFacilityList = facilityDao.selectHoldingFacilityList(member_code);
		return HoldingFacilityList;
	}

	// 담당 시설 등록
	@Override
	public void insertResponsibilityFacility(ResponsibilityFacilityVO responsibilityFacility) throws SQLException {
		facilityDao.insertResponsibilityFacility(responsibilityFacility);
	}

	// 담당 시설 삭제
	@Override
	public void deleteResponsibilityFacility(String facility_code) throws SQLException {
		facilityDao.deleteResponsibilityFacility(facility_code);
		
	}

}
