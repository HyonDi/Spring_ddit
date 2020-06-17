package com.bms.service.facility;

import java.sql.SQLException;
import java.util.List;

import com.bms.dto.facility.FacilityVO;
import com.bms.dto.facility.ResponsibilityFacilityVO;

public interface FacilityService {
	// 보유 시설 리스트
	List<FacilityVO> selectHoldingFacilityList(String member_code) throws SQLException;
	// 담당 시설 테이블에 등록
	void insertResponsibilityFacility(ResponsibilityFacilityVO responsibilityFacility) throws SQLException;
	// 담당 시설 테이블에서 삭제
	void deleteResponsibilityFacility(String facility_code) throws SQLException;
}
