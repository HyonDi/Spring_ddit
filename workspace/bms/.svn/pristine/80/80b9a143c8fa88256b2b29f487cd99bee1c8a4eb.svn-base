package com.bms.service.task;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dao.facility.FacilityDao;
import com.bms.dao.member.MemberDao;
import com.bms.dao.task.TaskDao;
import com.bms.dto.facility.FacilityVO;
import com.bms.dto.facility.ResponsibilityFacilityVO;
import com.bms.dto.task.ResponsibilityTaskVO;
import com.bms.dto.task.TaskVO;

public class TaskServiceImpl implements TaskService{
	@Autowired
	private TaskDao taskDao;
	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}
	
	// 필요 업무 리스트
	@Override
	public List<TaskVO> selectNecessaryTask(String member_code) throws SQLException {
		List<TaskVO> necessaryTaskList = taskDao.selectNecessaryTask(member_code);
		return necessaryTaskList;
	}

	// 담당 업무 등록
	@Override
	public void insertResponsibilityTask(ResponsibilityTaskVO responsibilityTask) throws SQLException {
		taskDao.insertResponsibilityTask(responsibilityTask);
	}

	// 담당 업무 삭제
	@Override
	public void deleteResponsibilityTask(String facility_code) throws SQLException {
		taskDao.deleteResponsibilityTask(facility_code);
		
	}

}
