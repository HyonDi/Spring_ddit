package com.bms.controller.schedule;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bms.dto.schedule.ScheduleJsonDTO;
import com.bms.dto.schedule.ScheduleSortCodeVO;
import com.bms.dto.schedule.ScheduleVO;
import com.bms.service.schedule.ScheduleService;



@Controller
@RequestMapping("/schedule")
public class ScheduleContoller {
	
	@Autowired
	private ScheduleService scheduleService;

	@RequestMapping(value="/schedule", method=RequestMethod.GET)
	public ModelAndView getCalendar(ModelAndView mnv) throws Exception {
		String url = "schedule/schedule";
		
		List<ScheduleVO> allSchedule = scheduleService.myAllSchedule("222222");
		mnv.addObject("allSchedule", allSchedule);
		
		return mnv;
		
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
	@RequestMapping(value="/toJson", method=RequestMethod.GET)//메서드안에 get,post설정만해줘도 충분
	@ResponseBody// 이새끼있으면 이 컨트롤러는 '응답전용이다'라는뜻
	public List<ScheduleJsonDTO> getCalendarJson() throws Exception {
		
		List<ScheduleVO> allScheduleVo = scheduleService.myAllSchedule("222222");
		
		List<ScheduleJsonDTO> allSchedule =  new ArrayList<ScheduleJsonDTO>();
		
		
		ScheduleJsonDTO dto = new ScheduleJsonDTO();
		
		for(int i =0; i <allScheduleVo.size(); i ++) {
			
			ScheduleJsonDTO d = dto.scheduleVOToDto(allScheduleVo.get(i));// 여기서 name 찍음
			System.out.println(allScheduleVo.get(i));
			
			System.out.println("dto >> " + dto);
			allSchedule.add(d);
		}
		System.out.println("allSchedule.toArray() : " + allSchedule.toString());
		return allSchedule;
		
	}
	
	
	
	
	/*@RequestMapping(value="/addSchedule", method=RequestMethod.GET)
	public ModelAndView getAddSchedule(ModelAndView mnv) throws Exception {
		String url = "schedule/addSchedule";
		
		
		List<ScheduleSortCodeVO> scheduleSortcodeList = scheduleService.myScheduleSortCode("333333");
		mnv.addObject("scheduleSortcodeList", scheduleSortcodeList);
		mnv.setViewName(url);
		
		return mnv;
	//얘자나 지금 데이터채워주는애 ㅇㅇㅇ	헐 들어와있음/. ㅇㅇㅇ저거한줄임헐헐헐아니
	 * 잠깐만 그 jsp에서는 요청한 페이지가/addSchedule 이거자나 ㅇㅇ근데 얘가 뭘알고 jsp를꺼내주냔말이지 
	}*/
	
	@RequestMapping(value="/addSchedule", method=RequestMethod.GET)
	public void getAddSchedule(Model model) throws Exception {
		
		model.addAttribute("scheduleSortcodeList",scheduleService.myScheduleSortCode("333333"));
	}
	
	
	
	
	
	
	
	@RequestMapping(value="/addSchedule", method=RequestMethod.POST)
	public String addSchedule(ScheduleVO schedule, Model model) throws Exception {
		String url = "schedule/addSchedule_ok";
		
		
		System.out.println("schedule.getSchedule_isallday() : " + schedule.getSchedule_isallday());
		scheduleService.insertSchedule(schedule);
		
		model.addAttribute("schedule", schedule);
		System.out.println("schedule.getSchedule_name() : " + schedule.getSchedule_name());
		return url;
		// 이거는 지금 model로 한것이란말이지.ㅇㅇ Post고.ㅇㅇ...그게왜음.... 여긴심지어 모델엔뷰를 안쓰고잇자나머저,
		// 저게 파라미터로있는이유는 내가지우는것을 깜빡했기때문이야.
		// 내가 모델앤뷰를 써야한다고생각했던이유는 get으로 페이지 받아올때 input태그가 있다고 치자. 그 태그 안에
		// 글씨를 써놓은상태로 세팅하고싶기때문이었어.
		//모델어트류비티라고 아시나
		//그니까 페이지 처음 로딩하면 데이터가 이미 들어가있게 하고싣판거아냥ㅇㅇㅇㅇ
		//모델엔뷰랑 상관없이 모델어트류비티가 지금도 걍 해주고잇자나
		// 여기서말구
	}
	
	
	@RequestMapping(value="/addToDoList", method=RequestMethod.GET)
	public String getAddToDoList(ModelAndView mnv) throws Exception {
		String url = "schedule/addToDoList";
		return url;
		
	}
}
