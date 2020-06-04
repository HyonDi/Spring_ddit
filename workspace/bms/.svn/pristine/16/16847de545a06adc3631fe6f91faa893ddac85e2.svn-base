package com.bms.dao.schedule;

import java.sql.SQLException;
import java.util.List;

import com.bms.dto.schedule.ScheduleSortCodeVO;
import com.bms.dto.schedule.ScheduleVO;
import com.bms.request.schedule.SearchSchedule;

public interface ScheduleDao {
	
	// 1. 내 전체 스케쥴
	List<ScheduleVO> myAllSchedule(String member_code) throws SQLException;
	
	// 2. 내 분류별 스케쥴 
	List<ScheduleVO> mySortSchedule(ScheduleSortCodeVO scheduleSortCodeVO) throws SQLException;
	
	// 3. 내가 가진 분류 코드
	List<ScheduleSortCodeVO> myScheduleSortCode(String member_code) throws SQLException;
	
	// 4. 내 전체 해야할 일
	List<ScheduleVO> myAllToDoList(String member_code) throws SQLException;
	
	// 5. 분류별 해야할 일
	List<ScheduleVO> mySortToDoList(ScheduleSortCodeVO scheduleSortCodeVO) throws SQLException;
	
	// 6. 모든 관리인의 업무 일정
	List<ScheduleVO> SuperintendentSchedule() throws SQLException;
	
	// 7. 일정하나 뽑기
	ScheduleVO selectOneSchedule(String schedule_code) throws SQLException;
	
	// 8. 분류코드 하나 뽑기 
	ScheduleSortCodeVO selectOneScheduleSortCode(String schedule_sort_code) throws SQLException;
	
	// 9. 스케쥴의 다음시퀀스 뽑기
	int selectScheduleSeqNext() throws SQLException;
	
	// 10. 스케쥴분류코드의 다음시퀀스 뽑기 
	int selectScheduleSortCodeSeqNext() throws SQLException;
	
	// 11. 내 스케쥴 검색 
	List<ScheduleVO> searchSchedule(SearchSchedule searchSchedule) throws SQLException;
	
	// 스케쥴 cud
	void insertSchedule(ScheduleVO scheduleVO) throws SQLException;
	void updateSchedule(ScheduleVO scheduleVO) throws SQLException;
	void deleteSchedule(String schedule_code) throws SQLException;
	
	// 스케쥴 분류코드 cud
	void insertScheduleSortCode(ScheduleSortCodeVO scheduleSortCodeVO) throws SQLException;
	void updateScheduleSortCode(ScheduleSortCodeVO scheduleSortCodeVO) throws SQLException;
	void deleteScheduleSortCode(String schedule_sort_code) throws SQLException;
	
}
