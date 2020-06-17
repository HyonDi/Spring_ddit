package com.bms.controller.SuperintendentSchedule;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bms.dto.member.MemberVO;
import com.bms.dto.menu.MenuVO;
import com.bms.dto.schedule.ScheduleJsonDTO;
import com.bms.dto.schedule.ScheduleSortCodeVO;
import com.bms.dto.schedule.ScheduleVO;
import com.bms.request.paging.SearchCriteria;
import com.bms.service.menu.MenuService;
import com.bms.service.schedule.ScheduleService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/community/")
public class SuperintendentScheduleController {
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private ScheduleService scheduleService;

	///community/management_schedule_check/resident
	///community/management_schedule_check/owner
	
	// 건물주가 보는 관리인 스케쥴리스트 
	@RequestMapping(value="management_schedule_check/owner", method=RequestMethod.GET)
	public ModelAndView SuperintendentScheduleList_owner(ModelAndView mnv, HttpServletResponse response)throws Exception{
		String url = "schedule/superintendentScheduleList.owner";
		
		List<MenuVO> menuList1 = null;
		List<MenuVO> menuList2 = null;
		List<MenuVO> menuList3 = null;
		List<MenuVO> menuList4 = null;
		try {
			menuList1 = menuService.selectUnderMenu("MENU01");
			menuList2 = menuService.selectUnderMenu("MENU02");
			menuList3 = menuService.selectUnderMenu("MENU03");
			menuList4 = menuService.selectUnderMenu("MENU04");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		mnv.addObject("menuList1", menuList1);
		mnv.addObject("menuList2", menuList2);
		mnv.addObject("menuList3", menuList3);
		mnv.addObject("menuList4", menuList4);
		mnv.setViewName(url);
		return mnv;
	}
	
	// 입주자가 보는 관리인 스케쥴 리스트 
	@RequestMapping(value="management_schedule_check/resident", method=RequestMethod.GET)
	public ModelAndView SuperintendentScheduleList_resident(ModelAndView mnv, HttpServletResponse response)throws Exception{
		String url = "schedule/superintendentScheduleList.resident";
		
		List<MenuVO> menuList9 = null;
		List<MenuVO> menuList10 = null;
		List<MenuVO> menuList11 = null;
		try {
			
			menuList9 = menuService.selectUnderMenu("MENU09");
			menuList10 = menuService.selectUnderMenu("MENU10");
			menuList11 = menuService.selectUnderMenu("MENU11");
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		mnv.addObject("menuList9", menuList9);
		mnv.addObject("menuList10", menuList10);
		mnv.addObject("menuList11", menuList11);
		mnv.setViewName(url);
		return mnv;
	}
	
	@RequestMapping(value="management_schedule_check/owner/test")
	public String getSuperintendentScheduleList_owner(Model model, String sortCode, HttpSession session, ModelAndView mnv)throws Exception{
		// 여기에 관리인 스케쥴 리스트-건물주
		String url = "schedule/superintendentScheduleList";
		
		List<ScheduleVO> scheduleList = new ArrayList<>();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		mnv.addObject("loginUser", loginUser);
		
		// 관리인리스트 담는곳
		scheduleList = scheduleService.SuperintendentSchedule(loginUser.getMember_code());
		List<ScheduleJsonDTO> jsonList = new ArrayList<ScheduleJsonDTO>();
		ScheduleSortCodeVO ssc = new ScheduleSortCodeVO();
		
		for (ScheduleVO sv : scheduleList) {
			boolean isallday;
			
			if(sv.getSchedule_isallday() == 1) {
				isallday = true;
			}else {
				isallday = false;
			}
			
			if (sv.getSchedule_end_date() != null && sv.getSchedule_start_date() != null & sv.getSchedule_name() != null) {
				ssc = scheduleService.selectOneScheduleSortCode(sv.getSchedule_sort_code());
				ScheduleJsonDTO sd = new ScheduleJsonDTO(sv.getSchedule_name(), sv.getSchedule_start_date(), 
						sv.getSchedule_end_date(),isallday,sv.getSchedule_code(),ssc.getSchedule_sort_color(),
						sv.getSchedule_sort_code(), sv.getSchedule_contents(), sv.getSchedule_start_time(),
						sv.getSchedule_end_time(), Integer.toString(sv.getSchedule_istodolist()));
				jsonList.add(sd);
			}
		}
		
		model.addAttribute("jsonList", JSONArray.fromObject(jsonList));
		//mnv.setViewName(url);
		return url;
	}
	
	
	@RequestMapping(value="management_schedule_check/resident/test")
	public String getSuperintendentScheduleList_resident(Model model, String sortCode, HttpSession session, ModelAndView mnv)throws Exception{
		// 여기에 관리인 스케쥴 리스트-입주자
		String url = "schedule/superintendentScheduleList";
		
		List<ScheduleVO> scheduleList = new ArrayList<>();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		mnv.addObject("loginUser", loginUser);
		
		// 관리인리스트 담는곳
		scheduleList = scheduleService.SuperintendentSchedule(loginUser.getMember_up_code());
		List<ScheduleJsonDTO> jsonList = new ArrayList<ScheduleJsonDTO>();
		ScheduleSortCodeVO ssc = new ScheduleSortCodeVO();
		
		for (ScheduleVO sv : scheduleList) {
			boolean isallday;
			
			if(sv.getSchedule_isallday() == 1) {
				isallday = true;
			}else {
				isallday = false;
			}
			
			if (sv.getSchedule_end_date() != null && sv.getSchedule_start_date() != null & sv.getSchedule_name() != null) {
				ssc = scheduleService.selectOneScheduleSortCode(sv.getSchedule_sort_code());
				ScheduleJsonDTO sd = new ScheduleJsonDTO(sv.getSchedule_name(), sv.getSchedule_start_date(), 
						sv.getSchedule_end_date(),isallday,sv.getSchedule_code(),ssc.getSchedule_sort_color(),
						sv.getSchedule_sort_code(), sv.getSchedule_contents(), sv.getSchedule_start_time(),
						sv.getSchedule_end_time(), Integer.toString(sv.getSchedule_istodolist()));
				jsonList.add(sd);
			}
		}
		
		model.addAttribute("jsonList", JSONArray.fromObject(jsonList));
		//mnv.setViewName(url);
		return url;
	}
}
