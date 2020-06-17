package com.bms.dao.facility;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dto.facility.CheckListVO;
import com.bms.dto.facility.FacilityManageVO;
import com.bms.request.paging.FacilitySearchCriteria;

public class FacilityManageDaoImpl implements FacilityManageDao{
	
	@Autowired
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<FacilityManageVO> selectSearchAllFacilityList(FacilitySearchCriteria cri) throws Exception {
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<FacilityManageVO> facilityList = sqlSession.selectList("FacilityManage-Mapper.selectSearchAllFacilityList", cri, rowBounds); 
		return facilityList;
	}

	@Override
	public int selectSearchAllFacilityListCount(FacilitySearchCriteria cri) throws SQLException {
		int count = sqlSession.selectOne("FacilityManage-Mapper.selectSearchAllFacilityListCount", cri);
		return count;
	}

	@Override
	public void insertFacility(FacilityManageVO facility) throws SQLException {
		sqlSession.update("FacilityManage-Mapper.insertFacility", facility);
	}

	@Override
	public void insertFacilityCheckList(CheckListVO checkList) throws SQLException {
		sqlSession.update("FacilityManage-Mapper.insertFacilityCheckList",checkList);
	}


	@Override
	public String selectByFacilityCode() throws SQLException {
		String res = sqlSession.selectOne("FacilityManage-Mapper.selectByFacilityCode");
		return res;
	}

	@Override
	public FacilityManageVO selectFacilityByFacilityCode(String facility_code) throws SQLException {
		FacilityManageVO getFacility = sqlSession.selectOne("FacilityManage-Mapper.selectFacilityByFacilityCode", facility_code);
		return getFacility;
	}

	@Override
	public List<CheckListVO> selelctCheckListByFacilityCode(String facility_code) throws SQLException {
		List<CheckListVO> getCheckList = sqlSession.selectList("FacilityManage-Mapper.selelctCheckListByFacilityCode", facility_code);
		return getCheckList;
	}

	@Override
	public String selectFacilityCode() throws SQLException {
		String facility_code = sqlSession.selectOne("FacilityManage-Mapper.selectFacilityCode");
		return facility_code;
	}

	@Override
	public void modifyFacility(FacilityManageVO facility) throws SQLException {
		sqlSession.update("FacilityManage-Mapper.modifyFacility", facility);
		
	}

	@Override
	public void deleteFacility(String facility_code) throws SQLException {
		sqlSession.update("FacilityManage-Mapper.deleteFacility", facility_code);
	}

	@Override
	public void modifyCheckList(CheckListVO checkList) throws SQLException {
		sqlSession.update("FacilityManage-Mapper.modifyCheckList", checkList);
		
	}

	@Override
	public void deleteCheckList(String check_point_facility_code) throws SQLException {
		sqlSession.update("FacilityManage-Mapper.deleteCheckList", check_point_facility_code);
		
	}

	@Override
	public CheckListVO selectCheckListByCheckListCode(String check_point_facility_code) throws SQLException {
		CheckListVO chk = sqlSession.selectOne("FacilityManage-Mapper.selectCheckListByCheckListCode", check_point_facility_code);
		return chk;
	}

	

	
}
