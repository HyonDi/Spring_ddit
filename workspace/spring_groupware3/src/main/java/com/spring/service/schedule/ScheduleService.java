package com.spring.service.schedule;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.ScheduleVO;

public interface ScheduleService {
	
	public List<ScheduleVO> getScheduleList(String id)throws SQLException;
	public ScheduleVO getSchedule(String id, int sche_no)throws SQLException;
	public int getScheduleSeq()throws SQLException;
	
	public void regist(ScheduleVO sche)throws SQLException;
	public void modify(ScheduleVO sche)throws SQLException;
	public void remove(int sche_no)throws SQLException;
	
}
