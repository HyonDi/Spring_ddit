package com.bms.controller.schedule;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bms.dto.member.MemberVO;
import com.bms.dto.menu.MenuVO;
import com.bms.dto.schedule.ScheduleJsonDTO;
import com.bms.dto.schedule.ScheduleSortCodeVO;
import com.bms.dto.schedule.ScheduleVO;
import com.bms.service.menu.MenuService;
import com.bms.service.schedule.ScheduleService;

import net.sf.json.JSONArray;



@Controller
@RequestMapping("/mypage/schedule_management/")
public class ScheduleContoller {
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value="superintendent", method=RequestMethod.GET)
	public ModelAndView getMain_sueprintendent(ModelAndView mnv) throws Exception {
		
		String url = "schedule/schedule.manager";
		List<MenuVO> menuList5 = menuService.selectUnderMenu("MENU05");
		List<MenuVO> menuList6 = menuService.selectUnderMenu("MENU06");
		List<MenuVO> menuList7 = menuService.selectUnderMenu("MENU07");
		List<MenuVO> menuList8 = menuService.selectUnderMenu("MENU08");

		mnv.addObject("menuList5", menuList5);
		mnv.addObject("menuList6", menuList6);
		mnv.addObject("menuList7", menuList7);
		mnv.addObject("menuList8", menuList8);
		mnv.setViewName(url);
		
		return mnv;

	}
	
	@RequestMapping(value="resident", method=RequestMethod.GET)
	public ModelAndView getMain_resident(ModelAndView mnv) throws Exception {
		String url = "schedule/schedule.resident";
		List<MenuVO> menuList9 = menuService.selectUnderMenu("MENU09");
		List<MenuVO> menuList10 = menuService.selectUnderMenu("MENU10");
		List<MenuVO> menuList11 = menuService.selectUnderMenu("MENU11");

		mnv.addObject("menuList9", menuList9);
		mnv.addObject("menuList10", menuList10);
		mnv.addObject("menuList11", menuList11);
		mnv.setViewName(url);
		
		return mnv;

	}
	
	@Autowired
	private ScheduleService scheduleService;

	@RequestMapping(value="superintendent/test"/*, method=RequestMethod.GET*/)
	public String getCalendar(Model model,String sortCode, HttpSession session) throws Exception {
		String url = "schedule/schedule";
		System.out.println("Controller uperintendent/test");
		System.out.println(sortCode);
		// 여기!! 캘린더에 일정 출력하는 내용
		List<ScheduleVO> scheduleList = new ArrayList<>();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		
		/*if(sortCode==null || sortCode.equals("all")) {*/
			System.out.println("전체출력");
			scheduleList = scheduleService.myAllSchedule(member.getMember_code()); // 수정
			// 딜리트하고 다시올 때 멤버코드가 없나봐
			
		/*}else {
			System.out.println("분류별 출력");
			MemberVO member = (MemberVO) session.getAttribute("loginUser");
			String member_code = member.getMember_code();
			System.out.println("맴버코드 : " + member_code);
			ScheduleSortCodeVO scheduleVO = new ScheduleSortCodeVO();
			scheduleVO.setMember_code(member_code);
			System.out.println("맴버코드 : " + member_code);
			scheduleVO.setSchedule_sort_code(sortCode);
			
			
			scheduleList = scheduleService.mySortSchedule(scheduleVO);
			System.out.println("sortSchedule : >>>>>>>" + scheduleList.toString() );
			
		}*/
		
			List<ScheduleJsonDTO> jsonList = new ArrayList<ScheduleJsonDTO>();
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			ScheduleSortCodeVO ssc = new ScheduleSortCodeVO();
			
			for (ScheduleVO sv : scheduleList) {
				boolean isallday;
				if(sv.getSchedule_isallday() == 1) {
					isallday = true;
				}else {
					isallday = false;
				}
				
				if (sv.getSchedule_end_date() != null && sv.getSchedule_start_date() != null & sv.getSchedule_name() != null) {
					//ScheduleJsonDTO sd = new ScheduleJsonDTO(sv.getSchedule_name(), sdf.format(sv.getSchedule_start_date()), sdf.format(sv.getSchedule_end_date()),isallday,sv.getSchedule_code());
					
					ssc = scheduleService.selectOneScheduleSortCode(sv.getSchedule_sort_code());
					
					ScheduleJsonDTO sd = new ScheduleJsonDTO(sv.getSchedule_name(), sv.getSchedule_start_date(), 
							sv.getSchedule_end_date(),isallday,sv.getSchedule_code(),ssc.getSchedule_sort_color(),
							sv.getSchedule_sort_code(), sv.getSchedule_contents(), sv.getSchedule_start_time(),
							sv.getSchedule_end_time(), Integer.toString(sv.getSchedule_istodolist()));
					
					
					jsonList.add(sd);
				}
			}
			
			// todoList출력하는 내용 
			List<ScheduleVO> allToDoList = scheduleService.myAllToDoList(member.getMember_code());
			
			
			model.addAttribute("jsonList", JSONArray.fromObject(jsonList));
			model.addAttribute("scheduleSortcodeList",scheduleService.myScheduleSortCode(member.getMember_code()));
			model.addAttribute("allToDoList", allToDoList);
			
			return url;
		
	}
	
	/*@RequestMapping(value="superintendent/test", method=RequestMethod.POST)
	@ResponseBody
	public String getSortCalendar(Model model,String sortCode, HttpSession session) throws Exception{
		// 분류에따른 일정리스트 출력하기
		String url = "schedule/schedule";
		
		System.out.println("Controller superintendent/test");
		System.out.println("sortCode : >>>>>>>>>>>>>" + sortCode);
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		String member_code = member.getMember_code();
		
		ScheduleSortCodeVO scheduleVO = new ScheduleSortCodeVO();
		scheduleVO.setMember_code(member_code);
		scheduleVO.setSchedule_sort_code(sortCode);
		
		
		List<ScheduleVO> sortSchedule = scheduleService.mySortSchedule(scheduleVO);
		System.out.println("sortSchedule : >>>>>>>" + sortSchedule.toString() );
		
		List<ScheduleJsonDTO> jsonList = new ArrayList<ScheduleJsonDTO>();
		ScheduleSortCodeVO ssc = new ScheduleSortCodeVO();
		
		for (ScheduleVO sv : sortSchedule) {
			boolean isallday;
			if(sv.getSchedule_isallday() == 1) {
				isallday = true;
			}else {
				isallday = false;
			}
			
			if (sv.getSchedule_end_date() != null && sv.getSchedule_start_date() != null & sv.getSchedule_name() != null) {
				//ScheduleJsonDTO sd = new ScheduleJsonDTO(sv.getSchedule_name(), sdf.format(sv.getSchedule_start_date()), sdf.format(sv.getSchedule_end_date()),isallday,sv.getSchedule_code());
				
				ssc = scheduleService.selectOneScheduleSortCode(sv.getSchedule_sort_code());
				
				//System.out.println("sv.getSchedule_sort_code() : " + sv.getSchedule_sort_code() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>");
				System.out.println(ssc.getSchedule_sort_code());
				System.out.println(ssc.getSchedule_sort_color());
				System.out.println(ssc.toString());
				
				ScheduleJsonDTO sd = new ScheduleJsonDTO(sv.getSchedule_name(), sv.getSchedule_start_date(), 
						sv.getSchedule_end_date(),isallday,sv.getSchedule_code(),ssc.getSchedule_sort_color(),
						sv.getSchedule_sort_code(), sv.getSchedule_contents(), sv.getSchedule_start_time(),
						sv.getSchedule_end_time(), Integer.toString(sv.getSchedule_istodolist()));
				System.out.println(sd.toString());
				//System.out.println("sv.getSchedule_code() 테스트 >>>>>>>>>>>>>>>>>" + sv.getSchedule_code());
				//System.out.println(sd.toString());
				
				//System.out.println("sortCode : >>>>>>>>>>>>" + sortCode);
				jsonList.add(sd);
			}
			}
		//return url;
		List<ScheduleVO> allToDoList = scheduleService.myAllToDoList("333333");
		
		
		model.addAttribute("jsonList", JSONArray.fromObject(jsonList));
		model.addAttribute("scheduleSortcodeList",scheduleService.myScheduleSortCode("333333"));
		model.addAttribute("allToDoList", allToDoList);
		
		return url;
	}
	*/
	
	@RequestMapping(value="resident/test", method=RequestMethod.GET)
	public String getCalendar2(Model model,String sortCode, HttpSession session) throws Exception {
		String url = "schedule/schedule";
		System.out.println("Controller uperintendent/test");
		System.out.println(sortCode);
		// 여기!! 캘린더에 일정 출력하는 내용
		List<ScheduleVO> scheduleList = new ArrayList<>();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		
			System.out.println("전체출력");
			scheduleList = scheduleService.myAllSchedule(member.getMember_code()); // 수정
		
		
			List<ScheduleJsonDTO> jsonList = new ArrayList<ScheduleJsonDTO>();
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			ScheduleSortCodeVO ssc = new ScheduleSortCodeVO();
			
			for (ScheduleVO sv : scheduleList) {
				boolean isallday;
				if(sv.getSchedule_isallday() == 1) {
					isallday = true;
				}else {
					isallday = false;
				}
				
				if (sv.getSchedule_end_date() != null && sv.getSchedule_start_date() != null & sv.getSchedule_name() != null) {
					//ScheduleJsonDTO sd = new ScheduleJsonDTO(sv.getSchedule_name(), sdf.format(sv.getSchedule_start_date()), sdf.format(sv.getSchedule_end_date()),isallday,sv.getSchedule_code());
					
					ssc = scheduleService.selectOneScheduleSortCode(sv.getSchedule_sort_code());
					
					ScheduleJsonDTO sd = new ScheduleJsonDTO(sv.getSchedule_name(), sv.getSchedule_start_date(), 
							sv.getSchedule_end_date(),isallday,sv.getSchedule_code(),ssc.getSchedule_sort_color(),
							sv.getSchedule_sort_code(), sv.getSchedule_contents(), sv.getSchedule_start_time(),
							sv.getSchedule_end_time(), Integer.toString(sv.getSchedule_istodolist()));
					
					
					jsonList.add(sd);
				}
			}
			
			// todoList출력하는 내용 
			List<ScheduleVO> allToDoList = scheduleService.myAllToDoList(member.getMember_code());
			
			
			model.addAttribute("jsonList", JSONArray.fromObject(jsonList));
			model.addAttribute("scheduleSortcodeList",scheduleService.myScheduleSortCode(member.getMember_code()));
			model.addAttribute("allToDoList", allToDoList);
			
			return url;
		
	}
	//없네
	
	//리턴 = 데이터 그렇다는것은 화면을 불러올수없는거네
	//ㅇㅇ 데이터만 넘겨줄때 쓰는거임 ajaxㅇㅋ 존나편리하게도 리턴에 데이터만 넣어줘도 되는건 데이터바인드라는 라이브러리를 사용하고있기때문임
	//다른데가서 똑같이해도 안된다 = 라이브러리점검
	
	//나머지는알아서공부할수잇을듯 충분히ㅎㅎ 그리고 모델엔뷰 안쓴다고 들음
	//쓸이유가 없기때문
	//걍 보이드쓰믄 대자나
	//model 쓰고 나는 Post로 요청할때 mode쓰고 void하고 GEt으로 요청할때엔 modelandview쓴다고생각했음.
	//걍 강단하게 getMapping PostMapping이라는 어노테이션도 있꼬 (여기엔라이브러리추가안대잇음)
	//모델엔뷰 쓸이유전혀없음 코드만졸라길어짐 그럼
	// @ResponseBody// 이새끼있으면 이 컨트롤러는 '응답전용이다'라는뜻
	
	
	
	
	@RequestMapping(value="/dragUpdate", method=RequestMethod.POST)
	@ResponseBody
	public Object getCalendarJson(@RequestBody ScheduleVO schedule) throws Exception {
		System.out.println("Cotroller dargUpdate");
		HashMap<String, Object> scheduleMap = new HashMap<String, Object>();
		
		
		scheduleMap.put("schedule", schedule);
		
		//System.out.println("schedule.toString() : " + scheduleMap.toString());
		//System.out.println("code : " + schedule.getSchedule_code());
		//System.out.println("color : " + color);
		
		String sd = schedule.getSchedule_start_date();
		String ed = schedule.getSchedule_end_date();
		
		
		sd = sd.substring(0,10);
		
		if(ed==null) {
			ed = sd;
		}
		ed = ed.substring(0,10);
		
		schedule.setSchedule_start_date(sd);
		schedule.setSchedule_end_date(ed);
		
		//System.out.println("sdf.parse(ed).toString() : >>>" + sdf.parse(ed).toString());
		try {
			scheduleService.updateSchedule(schedule);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return scheduleMap;
	}
	
	@RequestMapping(value="/todoDragUpdate", method=RequestMethod.POST)
	@ResponseBody
	public ScheduleVO todoDragUpdate(ScheduleVO schedule, String date,boolean removechk) {
		
		System.out.println("Cotroller todoDragUpdate");
//		HashMap<String, Object> scheduleMap = new HashMap<String, Object>();
		
//		scheduleMap.put("schedule", schedule);

		String deltodo = schedule.getSchedule_code();
//		System.out.println("schedule.toString() : " + scheduleMap.toString());
		System.out.println("code >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>: " + schedule.getSchedule_code());
//		System.out.println("name >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>: " + schedule.getSchedule_name());
//		System.out.println("date >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>: " + schedule.getSchedule_start_date());
//		System.out.println("date >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>: " + schedule.getSchedule_sort_code());
//		System.out.println("ndate >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>: " + date);
		// 달력 어느날짜에 내려놨는지 알아야함!!!!!!!!!!!!!!!!---------------------<<수정해야함>>
		System.out.println("removechk >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>: " + removechk);
		/*String sd = schedule.getSchedule_start_date();
		String ed = schedule.getSchedule_end_date();
		
		
		sd = sd.substring(0,10);
		ed = ed.substring(0,10);*/
		
		schedule.setSchedule_start_date(date);
		schedule.setSchedule_end_date(date);
		schedule.setSchedule_istodolist(0);
		
		try {
			scheduleService.insertSchedule(schedule);
			// remove 체크돼있으면 삭제한다.
			if(removechk==true) {
				System.out.println("deltodo : >>>>>>>>>>>>>>>>>>" + deltodo);
				scheduleService.deleteSchedule(deltodo);	
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return schedule;
	}
	
	@RequestMapping(value="/removeSchedule",method=RequestMethod.GET)
	public String removeSchedule(String schedule_code) throws Exception{
		String url = "schedule/removeSchedule_ok";
		System.out.println("Controller removeSchedule");
		System.out.println("schedule_code : >>>>>>>>>" + schedule_code);
		
		
		scheduleService.deleteSchedule(schedule_code);
		
		
		/*PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('삭제되었습니다.');");
		out.println("window.opener.location.reload();window.close();");
		out.println("</script>");
		*/
		return url;
		
	}
	@RequestMapping(value="/removeToDoList",method=RequestMethod.GET)
	public String removeToDoList(String schedule_code,Model model,HttpSession session) throws Exception{
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		String url="";
		
		if(member.getMember_authority().equals("resident")) {
			url = "schedule/removeToDoList_ok";
		}else {
			url = "schedule/removeToDoList_ok_superintendent";
		}
		
		System.out.println("Controller removeToDoList");
		System.out.println("schedule_code : >>>>>>>>>" + schedule_code);
		//String member_code = member.getMember_code();
		
		model.addAttribute("member",member);
		scheduleService.deleteSchedule(schedule_code);
		
		
		/*PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('삭제되었습니다.');");
		out.println("window.opener.location.reload();window.close();");
		out.println("</script>");
		*/
		return url;
		
	}
	
	/*@RequestMapping(value="/addSchedule", method=RequestMethod.GET)
	public ModelAndView getAddSchedule(ModelAndView mnv) throws Exception {
		String url = "schedule/addSchedule";
		
		
		List<ScheduleSortCodeVO> scheduleSortcodeList = scheduleService.myScheduleSortCode("333333");
		mnv.addObject("scheduleSortcodeList", scheduleSortcodeList);
		mnv.setViewName(url);
		
		return mnv;
	
	}*/
	
	@RequestMapping(value="/addSchedule", method=RequestMethod.GET)
	public ModelAndView getAddSchedule(ModelAndView mnv, HttpSession session) throws Exception {
		String url = "/schedule/addSchedule";
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		mnv.addObject("scheduleSortcodeList",scheduleService.myScheduleSortCode(member.getMember_code()));
		mnv.setViewName(url);
		return mnv;
	}
	
	@RequestMapping(value="/addSchedule", method=RequestMethod.POST)
	public String addSchedule(HttpSession session,ScheduleVO schedule, Model model, @RequestParam("makeNewCode") int makeNewCode,ScheduleSortCodeVO sortcodeVo) throws Exception {
		String url = "schedule/addSchedule_ok";
		//System.out.println("makeNewCode : >>>>>>>>>>>>>>>>" + makeNewCode);
		//System.out.println("sortcodeVo의 색 >>>>>>>>>>:" + sortcodeVo.getSchedule_sort_color()+"/"+"작성자 : " +sortcodeVo.getMember_code());
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		if(makeNewCode==1) {
			// 코드새로만들기를 하면 
			sortcodeVo.setMember_code(member.getMember_code());
			scheduleService.insertScheduleSortCode(sortcodeVo);
			System.out.println("새로운 분류 만들기 성공");
			schedule.setSchedule_sort_code(sortcodeVo.getSchedule_sort_code());
		}else {
			System.out.println("makeNewCode 가 1이 아님!! : "+makeNewCode+" : <<<<<<<<<<<<<<<makeNewCode");
		}
		
		scheduleService.insertSchedule(schedule);
		
		//scheduleService.insertSchedule(schedule);
		//System.out.println("schedule.getSchedule_isallday() : " + schedule.getSchedule_isallday());
		
		model.addAttribute("schedule", schedule);
		//System.out.println("schedule.getSchedule_name() : " + schedule.getSchedule_name());
		return url;
		
	}
	
	@RequestMapping(value="/addToDoList", method=RequestMethod.GET)
	public ModelAndView getAddToDoList(HttpSession session,ModelAndView mnv) throws Exception {
		String url = "/schedule/addToDoList";
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		mnv.addObject("scheduleSortcodeList",scheduleService.myScheduleSortCode(member.getMember_code()));
		mnv.setViewName(url);
		return mnv;
	}
	
	@RequestMapping(value="/addToDoList", method=RequestMethod.POST)
	public String addToDoList(HttpSession session,ScheduleVO schedule, Model model, @RequestParam("makeNewCode") int makeNewCode,ScheduleSortCodeVO sortcodeVo) throws Exception {
		String url = "schedule/addToDoList_ok";
		
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		if(makeNewCode==1) {
			// 코드새로만들기를 하면 
			sortcodeVo.setMember_code(member.getMember_code());
			scheduleService.insertScheduleSortCode(sortcodeVo);
			System.out.println("새로운 분류 만들기 성공");
			schedule.setSchedule_sort_code(sortcodeVo.getSchedule_sort_code());
		}else {
			System.out.println("makeNewCode 가 1이 아님!! : "+makeNewCode+" : <<<<<<<<<<<<<<<makeNewCode");
		}
		
		scheduleService.insertSchedule(schedule);
		
		model.addAttribute("schedule", schedule);
	
		
		return url;
		
		
	}
	
	@RequestMapping(value="/updateSchedule", method=RequestMethod.GET)
	public String getUpdateSchedule(HttpSession session, Model model, String schedule_code) throws Exception {
		String url = "/schedule/updateSchedule";
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		// test
		//System.out.println("schedule_code >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>: " + schedule_code); // null임.
		
		ScheduleVO schedule = scheduleService.selectOneSchedule(schedule_code);
		//System.out.println(schedule.getSchedule_end_date()+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		/*model.addAttribute("oneSchedule",schedule);*/
		
		// 데이트형식 바꿈 
		//SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		schedule.setSchedule_start_date(schedule.getSchedule_start_date().substring(0,10));
		schedule.setSchedule_end_date(schedule.getSchedule_end_date().substring(0,10));
		
		
		model.addAttribute("oneSchedule",schedule);
		model.addAttribute("scheduleSortcodeList",scheduleService.myScheduleSortCode(member.getMember_code()));
		
		return url;
	}
	
	@RequestMapping(value="/detailSchedule", method=RequestMethod.GET)
	public String getDetailSchedule(HttpSession session, Model model, String schedule_code) throws Exception {
		String url = "/schedule/detailSchedule";
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		// test
		//System.out.println("schedule_code >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>: " + schedule_code); // null임.
		
		ScheduleVO schedule = scheduleService.selectOneSchedule(schedule_code);
		//System.out.println(schedule.getSchedule_end_date()+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		/*model.addAttribute("oneSchedule",schedule);*/
		
		// 데이트형식 바꿈 
		//SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		schedule.setSchedule_start_date(schedule.getSchedule_start_date().substring(0,10));
		schedule.setSchedule_end_date(schedule.getSchedule_end_date().substring(0,10));
		
		
		model.addAttribute("oneSchedule",schedule);
		model.addAttribute("scheduleSortcodeList",scheduleService.myScheduleSortCode(member.getMember_code()));
		
		return url;
	}
	
	@RequestMapping(value="/detailSchedule_owner_resident", method=RequestMethod.GET)
	public String getDetailSchedule_owner_resident(HttpSession session, Model model, String schedule_code) throws Exception {
		String url = "/schedule/detailSchedule_owner_resident";
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		// test
		//System.out.println("schedule_code >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>: " + schedule_code); // null임.
		
		ScheduleVO schedule = scheduleService.selectOneSchedule(schedule_code);
		//System.out.println(schedule.getSchedule_end_date()+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		/*model.addAttribute("oneSchedule",schedule);*/
		
		// 데이트형식 바꿈 
		//SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		schedule.setSchedule_start_date(schedule.getSchedule_start_date().substring(0,10));
		schedule.setSchedule_end_date(schedule.getSchedule_end_date().substring(0,10));
		
		
		model.addAttribute("oneSchedule",schedule);
		model.addAttribute("scheduleSortcodeList",scheduleService.myScheduleSortCode(member.getMember_code()));
		
		return url;
	}
	
	
	
	
	
	
	
	@RequestMapping(value="/updateSchedule", method=RequestMethod.POST)
	public String updateSchedule(ScheduleVO schedule, Model model) throws Exception {
		String url = "schedule/updateSchedule_ok";
		
		//System.out.println("schedule.getSchedule_isallday() : " + schedule.getSchedule_isallday());
		//scheduleService.insertSchedule(schedule);
		scheduleService.updateSchedule(schedule);
		model.addAttribute("schedule", schedule);
		//System.out.println("schedule.getSchedule_name() : " + schedule.getSchedule_name());
		return url;
		
	}
	
}
