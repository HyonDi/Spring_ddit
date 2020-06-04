package com.spring.dao.schedule;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.ScheduleVO;

public interface ScheduleDAO {
	
	public List<ScheduleVO> selectScheduleList(String id)throws SQLException;
	public ScheduleVO selectScheduleByno(String id, int sche_no)throws SQLException;
	public int selectScheduleSeq()throws SQLException;
	
	public void insertSchedule(ScheduleVO sche)throws SQLException;
	public void updateSchedule(ScheduleVO shce)throws SQLException;
	public void deleteSchedule(int sche_no)throws SQLException;
	
}
