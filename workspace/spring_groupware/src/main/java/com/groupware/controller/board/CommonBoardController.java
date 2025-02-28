package com.groupware.controller.board;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class CommonBoardController {
// 커뮤니티쪽에서 공통적으로 사용되는 컨트롤러.
	
	
	@RequestMapping("/regist")
	public String registForm(Model model) throws Exception{
		String url = "board/regist";
		
		Calendar day = Calendar.getInstance(); // 현재시간
		
		Date startDate = day.getTime();
		String startDateStr = new SimpleDateFormat("yyyy-MM-dd").format(startDate);
		day.add(Calendar.DATE, 30);
		
		Date endDate = day.getTime();
		String endDateStr = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
		
		model.addAttribute("startDate",startDateStr);
		model.addAttribute("endDate",endDateStr);
		
		return url;
				
	}
}
