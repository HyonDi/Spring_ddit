package com.spring.dao.schedule;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.spring.dto.ScheduleVO;

public class ScheduleDAOImpl implements ScheduleDAO{

	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session=session;
	}
	
	@Override
	public List<ScheduleVO> selectScheduleList(String id) throws SQLException {
		List<ScheduleVO> scheduleList = session.selectList("Schedule-Mapper.selectScheduleList",id);
		return scheduleList;
	}

	@Override
	public ScheduleVO selectScheduleByno(String id, int sche_no) throws SQLException {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("id", id);
		paramMap.put("sche_no", sche_no);
		ScheduleVO schedule=session.selectOne("Schedule-Mapper.selectScheduleByNo",paramMap);
						
		return schedule;
	}

	@Override
	public void insertSchedule(ScheduleVO sche) throws SQLException {
		session.update("Schedule-Mapper.insertSchedule",sche);
		
	}

	@Override
	public void updateSchedule(ScheduleVO sche) throws SQLException {
		session.update("Schedule-Mapper.updateSchedule",sche);
	}

	@Override
	public void deleteSchedule(int sche_no) throws SQLException {
		session.update("Schedule-Mapper.deleteSchedule",sche_no);
	}

	@Override
	public int selectScheduleSeq() throws SQLException {
		int result=session.selectOne("Schedule-Mapper.selectScheduleSeq");
		return result;
	}

}
