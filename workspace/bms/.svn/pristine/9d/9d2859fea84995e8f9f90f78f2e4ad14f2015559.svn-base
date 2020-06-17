package com.bms.dao.facility;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dto.facility.FacilityVO;
import com.bms.dto.facility.ResponsibilityFacilityVO;

public class FacilityDaoImpl implements FacilityDao{
	@Autowired
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 보유 시설 리스트
	@Override
	public List<FacilityVO> selectHoldingFacilityList(String member_code) throws SQLException {
		List<FacilityVO> HoldingFacilityList = sqlSession.selectList("Facility-Mapper.selectHoldingFacilityList",member_code);
		return HoldingFacilityList;
	}

	// 담당 시설 테이블에 등록
	@Override
	public void insertResponsibilityFacility(ResponsibilityFacilityVO responsibilityFacility) throws SQLException {
		sqlSession.update("Facility-Mapper.insertResponsibilityFacility",responsibilityFacility);
		
	}
	
	// 담당 시설 테이블에서 삭제
	@Override
	public void deleteResponsibilityFacility(String facility_code) throws SQLException {
		sqlSession.update("Facility-Mapper.deleteResponsibilityFacility",facility_code);		
	}

}
