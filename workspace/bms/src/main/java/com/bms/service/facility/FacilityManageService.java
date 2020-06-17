package com.bms.service.facility;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.bms.dto.facility.CheckListVO;
import com.bms.dto.facility.FacilityManageVO;
import com.bms.request.paging.FacilitySearchCriteria;

public interface FacilityManageService {
	// 1.시설
	Map<String, Object> selectSearchAllFacilityList(FacilitySearchCriteria cri) throws SQLException;

	void insertFacilityDetail(FacilityManageVO facility, List<CheckListVO> checkList) throws SQLException;

	FacilityManageVO selectFacilityByFacilityCode(String facility_code) throws SQLException;

	void modifyFacility(FacilityManageVO facility) throws SQLException;

	void deleteFacility(String facility_code) throws SQLException;
	// -----------------------------------------------------------------------------

	// 2.시설점검사항
	List<CheckListVO> selelctCheckListByFacilityCode(String facility_code) throws SQLException;

	void insertFacilityCheckList(List<CheckListVO> checkList) throws SQLException;
	
	//체크리스트 하나꺼내오기
	CheckListVO selectCheckListByCheckListCode(String check_point_facility_code)throws SQLException;
	
	// 체크리스트 수정
	void modifyCheckList(CheckListVO checkList) throws SQLException;

	// 체크리스트 삭제
	void deleteCheckList(String check_point_facility_code) throws SQLException;

	void insertFacilityCheckListTo(CheckListVO chkList) throws SQLException;
}
