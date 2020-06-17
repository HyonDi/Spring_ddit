package com.bms.dao.facility;

import java.sql.SQLException;
import java.util.List;

import com.bms.dto.facility.CheckListVO;
import com.bms.dto.facility.FacilityManageVO;
import com.bms.request.paging.FacilitySearchCriteria;
import com.bms.request.paging.SearchCriteria;

public interface FacilityManageDao {
	//1.시설
	//시설 리스트
	List<FacilityManageVO> selectSearchAllFacilityList(FacilitySearchCriteria cri)throws Exception;
	//시설 리스트카운트
	int selectSearchAllFacilityListCount(FacilitySearchCriteria cri)throws SQLException;
	//시설등록
	void insertFacility(FacilityManageVO facility)throws SQLException;
	//
	String selectByFacilityCode() throws SQLException;
	//해당 시설정보가져오기
	FacilityManageVO selectFacilityByFacilityCode(String facility_code)throws SQLException;
	//시설정보 수정
	void modifyFacility(FacilityManageVO facility)throws SQLException;
	//시설정보 삭제
	void deleteFacility(String facility_code)throws SQLException;
//-------------------------------------------------------------------------------------------------------------
	//2.시설 점검사항
	//시설점검사항리스트
	List<CheckListVO> selelctCheckListByFacilityCode(String facility_code)throws SQLException;
	//시설코드 가져오기
	String selectFacilityCode()throws SQLException;
	
	//체크리스트 작성
	void insertFacilityCheckList(CheckListVO check)throws SQLException;
	//체크리스트 수정
	void modifyCheckList(CheckListVO checkList)throws SQLException;
	//체크리스트 삭제
	void deleteCheckList(String check_point_facility_code)throws SQLException;
	//체크리스트 하나꺼내오기
	CheckListVO selectCheckListByCheckListCode(String check_point_facility_code)throws SQLException; 
}
