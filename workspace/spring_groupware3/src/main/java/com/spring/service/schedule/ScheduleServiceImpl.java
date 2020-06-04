package com.spring.service.schedule;

import java.sql.SQLException;
import java.util.List;

import com.spring.dao.schedule.ScheduleDAO;
import com.spring.dto.ScheduleVO;

public class ScheduleServiceImpl implements ScheduleService {
	
	private ScheduleDAO scheduleDAO;
	public void setScheduleDAO(ScheduleDAO scheduleDAO) {
		this.scheduleDAO= scheduleDAO;		
	}

	@Override
	public List<ScheduleVO> getScheduleList(String id) throws SQLException {
		List<ScheduleVO> scheduleList=scheduleDAO.selectScheduleList(id);
		return scheduleList;
	}

	@Override
	public ScheduleVO getSchedule(String id, int sche_no) throws SQLException {
		ScheduleVO schedule=scheduleDAO.selectScheduleByno(id, sche_no);
		return schedule;
	}

	@Override
	public void regist(ScheduleVO sche) throws SQLException {
		scheduleDAO.insertSchedule(sche);
		
	}

	@Override
	public void modify(ScheduleVO sche) throws SQLException {
		scheduleDAO.updateSchedule(sche);
	}

	@Override
	public void remove(int sche_no) throws SQLException {
		scheduleDAO.deleteSchedule(sche_no);
	}

	@Override
	public int getScheduleSeq() throws SQLException {
		int sche_no=scheduleDAO.selectScheduleSeq();
		return sche_no;
	}
	
	
	
}
