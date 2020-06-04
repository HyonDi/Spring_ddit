package com.bms.service.schedule;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dao.menu.MenuDao;
import com.bms.dao.schedule.ScheduleDao;
import com.bms.dto.schedule.ScheduleSortCodeVO;
import com.bms.dto.schedule.ScheduleVO;
import com.bms.request.schedule.SearchSchedule;

public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleDao scheduleDao;
	public void setScheduleDao(ScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
	}
	
	@Override
	public List<ScheduleVO> myAllSchedule(String member_code) throws SQLException {
		List<ScheduleVO> scheduleList = scheduleDao.myAllSchedule(member_code);
		return scheduleList;
	}

	@Override
	public List<ScheduleVO> mySortSchedule(ScheduleSortCodeVO scheduleSortCodeVO) throws SQLException {
		List<ScheduleVO> scheduleList = scheduleDao.mySortSchedule(scheduleSortCodeVO);
		return scheduleList;
	}

	@Override
	public List<ScheduleSortCodeVO> myScheduleSortCode(String member_code) throws SQLException {
		List<ScheduleSortCodeVO> scheduleSortCodeList = scheduleDao.myScheduleSortCode(member_code);
		return scheduleSortCodeList;
	}

	@Override
	public List<ScheduleVO> myAllToDoList(String member_code) throws SQLException {
		List<ScheduleVO> scheduleList = scheduleDao.myAllToDoList(member_code);
		return scheduleList;
	}

	@Override
	public List<ScheduleVO> mySortToDoList(ScheduleSortCodeVO scheduleSortCodeVO) throws SQLException {
		List<ScheduleVO> scheduleList = scheduleDao.mySortToDoList(scheduleSortCodeVO);
		return scheduleList;
	}

	@Override
	public List<ScheduleVO> SuperintendentSchedule() throws SQLException {
		List<ScheduleVO> scheduleList = scheduleDao.SuperintendentSchedule();
		return scheduleList;
	}

	@Override
	public ScheduleVO selectOneSchedule(String schedule_code) throws SQLException {
		ScheduleVO scheduleVO = scheduleDao.selectOneSchedule(schedule_code);
		return scheduleVO;
	}

	@Override
	public ScheduleSortCodeVO selectOneScheduleSortCode(String schedule_sort_code) throws SQLException {
		ScheduleSortCodeVO scheduleSortCodeVO = scheduleDao.selectOneScheduleSortCode(schedule_sort_code);
		return scheduleSortCodeVO;
	}

	/*@Override
	public int selectScheduleSeqNext() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectScheduleSortCodeSeqNext() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}*/

	@Override
	public List<ScheduleVO> searchSchedule(SearchSchedule searchSchedule) throws SQLException {
		List<ScheduleVO> scheduleList = scheduleDao.searchSchedule(searchSchedule);
		return scheduleList;
	}

	@Override
	public void insertSchedule(ScheduleVO scheduleVO) throws SQLException {
		int scheduleSeq = scheduleDao.selectScheduleSeqNext();
		
		String scheduleCode = "sccod" + scheduleSeq; 
		scheduleVO.setSchedule_code(scheduleCode);
		
		scheduleDao.insertSchedule(scheduleVO);
				

	}

	@Override
	public void updateSchedule(ScheduleVO scheduleVO) throws SQLException {
		scheduleDao.updateSchedule(scheduleVO);

	}

	@Override
	public void deleteSchedule(String schedule_code) throws SQLException {
		scheduleDao.deleteSchedule(schedule_code);

	}

	@Override
	public void insertScheduleSortCode(ScheduleSortCodeVO scheduleSortCodeVO) throws SQLException {
		int scheduleSortCodeSeq = scheduleDao.selectScheduleSortCodeSeqNext();
		
		String scheduleSortCode = "scscod" +scheduleSortCodeSeq;
		scheduleSortCodeVO.setSchedule_sort_code(scheduleSortCode);
		
		scheduleDao.insertScheduleSortCode(scheduleSortCodeVO);
		
		

	}

	@Override
	public void updateScheduleSortCode(ScheduleSortCodeVO scheduleSortCodeVO) throws SQLException {
		scheduleDao.updateScheduleSortCode(scheduleSortCodeVO);

	}

	@Override
	public void deleteScheduleSortCode(String schedule_sort_code) throws SQLException {
		scheduleDao.deleteScheduleSortCode(schedule_sort_code);

	}

}
