package com.bms.dao.task;

import java.sql.SQLException;
import java.util.List;

import com.bms.dto.facility.FacilityVO;
import com.bms.dto.facility.ResponsibilityFacilityVO;
import com.bms.dto.task.ResponsibilityTaskVO;
import com.bms.dto.task.TaskVO;

public interface TaskDao {
	// 필요 업무 리스트
	List<TaskVO> selectNecessaryTask(String member_code) throws SQLException;
	// 담당 업무 테이블에 등록
	void insertResponsibilityTask(ResponsibilityTaskVO responsibilityTaskVO) throws SQLException;
	// 담당 업무 테이블에서 삭제
	void deleteResponsibilityTask(String task_code) throws SQLException;
}
