package com.spring.controller.schedule;

import java.net.URI;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.spring.dto.EmployeeVO;
import com.spring.dto.ScheduleVO;
import com.spring.dto.holiday.HolidayItem;
import com.spring.dto.holiday.HolidayResponseVO;
import com.spring.request.ScheduleRequest;
import com.spring.service.schedule.ScheduleService;

@Controller
@RequestMapping("/schedule")
public class SchedulerController {
	
	@Autowired
	private ScheduleService service;
	
	
	@ModelAttribute("subMenuList")
	public List<String[]> subMenuModel(HttpServletRequest request){
		List<String[]> subMenuList=new ArrayList<String[]>();
		
		String rootPath=request.getContextPath()+"/schedule";
		
		subMenuList.add(new String[]{"캘린더",rootPath+"/calendar","SUB10001"});
		subMenuList.add(new String[]{"일정목록",rootPath+"/list","SUB10002"});
		
		
		
		return subMenuList;
	}
	
	@RequestMapping("/calendar")
	public void scheduleCalendar(Model model)throws Exception{
		int sche_no=service.getScheduleSeq();
		model.addAttribute("sche_no",sche_no);		
	}
	
	@RequestMapping("/list")
	public void scheduleList(HttpSession session,Model model)throws Exception{
		EmployeeVO loginUser=(EmployeeVO)session.getAttribute("loginUser");
		String id=loginUser.getId();
		
		List<ScheduleVO> scheduleList=service.getScheduleList(id);
		model.addAttribute("scheduleList",scheduleList);
	}
	
	@RequestMapping("/regist")
	public void scheduleRegistGET(@ModelAttribute("scheduleReq")ScheduleRequest scheduleReq, Model model)throws Exception{
		
	}
	
	@RequestMapping("/holiday_json")
	@ResponseBody
	public ResponseEntity<List<HolidayToJson>> holiday_json(String startDate, String endDate)throws Exception{
		
		
		RestTemplate restTemplate = new RestTemplate();
		String serviceKey ="KK5AuEALIxx6RrtZ%2BbEX6YxDbWjblN6Nx85zIhwW0LcmExcZUzwDVd227eLapB31eqc5kt%2BjsL4n06OCwNQGoQ%3D%3D";
		String holidayURL = "http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getHoliDeInfo";
		String requestURL=null;
		
		String[] splitDate = endDate.split("-"); 
		splitDate[1]=new DecimalFormat("00").format((Integer.parseInt(splitDate[1])-1));
		
		URI requestURI = new URI(holidayURL+"?ServiceKey="+serviceKey+"&solYear="+splitDate[0]+"&solMonth="+(splitDate[1]));
		
		
		HolidayResponseVO holidayResp=restTemplate.getForObject(requestURI, HolidayResponseVO.class);
		
		List<HolidayToJson> holidayList = new ArrayList<HolidayToJson>();
		for(HolidayItem item : holidayResp.getBody().getItems()) {
			HolidayToJson holidayJson = new HolidayToJson();
			
			
			String year=item.getLocdate().substring(0,4);
			String month=item.getLocdate().substring(4,6);
			String date=item.getLocdate().substring(6);
			String descript = "<style>#trip {border-collapse:collapse; }#trip tr {height:25px;}#trip td {padding:3px; font-size:10pt; color:#000; font-family:Dotum; word-break:break-all; border:1px solid #b7cbd9;}.title {font-weight:bold; color:#000; text-align:center; background-color:#f2f7ff;}</style><table id='trip' width=100% height=100% border=0 cellspacing=0 cellpadding=0 style='border-collapse:collapse;'><tr><td width='100' class='title'>기념일 이름</td><td width=* bgcolor='#ffffff'>"+item.getDateName()+"</td></tr><tr><td class='title'>공휴일 여부</td><td bgcolor='#ffffff'>공휴일</td></tr></table>";
			
			holidayJson.setTitle(item.getDateName());			
			holidayJson.setStart(year+"-"+month+"-"+date);
			holidayJson.setDescript(descript);
			holidayList.add(holidayJson);

		}
		
		System.out.println(holidayList);
		return new ResponseEntity(holidayList,HttpStatus.OK);
	}
}










