package com.bms.dao.schedule;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dto.schedule.ScheduleSortCodeVO;
import com.bms.dto.schedule.ScheduleVO;
import com.bms.request.schedule.SearchSchedule;
import com.sun.xml.internal.bind.v2.TODO;

public class ScheduleDaoImpl implements ScheduleDao {
	
	@Autowired
	private SqlSession session;
	public void setSqlSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public List<ScheduleVO> myAllSchedule(String member_code) throws SQLException {
		List<ScheduleVO> scheduleList = null;
		
		scheduleList = session.selectList("Schedule-Mapper.myAllSchedule",member_code);
		return scheduleList;
	}

	@Override
	public List<ScheduleVO> mySortSchedule(ScheduleSortCodeVO scheduleSortCodeVO) throws SQLException {
		List<ScheduleVO> scheduleList = null;
		
		scheduleList = session.selectList("Schedule-Mapper.mySortSchedule",scheduleSortCodeVO);
		return scheduleList;
	}

	@Override
	public List<ScheduleSortCodeVO> myScheduleSortCode(String member_code) throws SQLException {
		List<ScheduleSortCodeVO> scheduleSortCodeList = null;
		
		scheduleSortCodeList = session.selectList("Schedule-Mapper.myScheduleSortCode",member_code);
		return scheduleSortCodeList;
	}

	@Override
	public List<ScheduleVO> myAllToDoList(String member_code) throws SQLException {
		List<ScheduleVO> scheduleList = null;
		
		scheduleList = session.selectList("Schedule-Mapper.myAllToDoList",member_code);
		return scheduleList;
	}

	@Override
	public List<ScheduleVO> mySortToDoList(ScheduleSortCodeVO scheduleSortCodeVO) throws SQLException {
		List<ScheduleVO> scheduleList = null;
		
		scheduleList = session.selectList("Schedule-Mapper.mySortToDoList",scheduleSortCodeVO);
		return scheduleList;
	}

	@Override
	public List<ScheduleVO> SuperintendentSchedule(String member_up_code) throws SQLException {
		List<ScheduleVO> scheduleList = null;
		
		scheduleList = session.selectList("Schedule-Mapper.SuperintendentSchedule",member_up_code);
		return scheduleList;
	}

	@Override
	public ScheduleVO selectOneSchedule(String schedule_code) throws SQLException {
		ScheduleVO scheduleVO = null;
		
		scheduleVO = session.selectOne("Schedule-Mapper.selectOneSchedule", schedule_code);
		return scheduleVO;
	}

	@Override
	public ScheduleSortCodeVO selectOneScheduleSortCode(String schedule_sort_code) throws SQLException {
		ScheduleSortCodeVO scheduleSortCodeVO = null;
		
		scheduleSortCodeVO = session.selectOne("Schedule-Mapper.selectOneScheduleSortCode", schedule_sort_code);
		return scheduleSortCodeVO;
	}

	@Override
	public int selectScheduleSeqNext() throws SQLException {
		int scheduleSeqNext = 0;
		scheduleSeqNext = session.selectOne("Schedule-Mapper.selectScheduleSeqNext");
		return scheduleSeqNext;
	}

	@Override
	public int selectScheduleSortCodeSeqNext() throws SQLException {
		int scheduleSortCodeSeqNext = 0;
		scheduleSortCodeSeqNext = session.selectOne("Schedule-Mapper.selectScheduleSortCodeSeqNext");
		return scheduleSortCodeSeqNext;
	}

	@Override
	public List<ScheduleVO> searchSchedule(SearchSchedule searchSchedule) throws SQLException {
		List<ScheduleVO> scheduleList = null;
		scheduleList = session.selectList("Schedule-Mapper.searchSchedule",searchSchedule);
		return scheduleList;
	}

	@Override
	public void insertSchedule(ScheduleVO scheduleVO) throws SQLException {
		session.update("Schedule-Mapper.insertSchedule", scheduleVO);

	}

	@Override
	public void updateSchedule(ScheduleVO scheduleVO) throws SQLException {
		session.update("Schedule-Mapper.updateSchedule", scheduleVO);

	}

	@Override
	public void deleteSchedule(String schedule_code) throws SQLException {
		session.update("Schedule-Mapper.deleteSchedule", schedule_code);

	}

	@Override
	public void insertScheduleSortCode(ScheduleSortCodeVO scheduleSortCodeVO) throws SQLException {
		session.update("Schedule-Mapper.insertScheduleSortCode", scheduleSortCodeVO);

	}

	@Override
	public void updateScheduleSortCode(ScheduleSortCodeVO scheduleSortCodeVO) throws SQLException {
		session.update("Schedule-Mapper.updateScheduleSortCode", scheduleSortCodeVO);

	}

	@Override
	public void deleteScheduleSortCode(String schedule_sort_code) throws SQLException {
		session.update("Schedule-Mapper.deleteScheduleSortCode", schedule_sort_code);

	}

}
