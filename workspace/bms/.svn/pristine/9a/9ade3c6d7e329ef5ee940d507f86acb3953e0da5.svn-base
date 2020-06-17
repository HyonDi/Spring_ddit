package com.bms.dao.task;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dto.facility.FacilityVO;
import com.bms.dto.facility.ResponsibilityFacilityVO;
import com.bms.dto.task.ResponsibilityTaskVO;
import com.bms.dto.task.TaskVO;

public class TaskDaoImpl implements TaskDao{
	@Autowired
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 보유 시설 리스트
	@Override
	public List<TaskVO> selectNecessaryTask(String member_code) throws SQLException {
		List<TaskVO> HoldingFacilityList = sqlSession.selectList("Task-Mapper.selectNecessaryTask",member_code);
		return HoldingFacilityList;
	}

	// 보유 시설 테이블에 등록
	@Override
	public void insertResponsibilityTask(ResponsibilityTaskVO responsibilitytask) throws SQLException {
		sqlSession.update("Task-Mapper.insertResponsibilityTask",responsibilitytask);
		
	}
	
	// 보유 시설 테이블에서 삭제
	@Override
	public void deleteResponsibilityTask(String task_code) throws SQLException {
		sqlSession.update("Task-Mapper.deleteResponsibilityTask",task_code);		
	}

}
