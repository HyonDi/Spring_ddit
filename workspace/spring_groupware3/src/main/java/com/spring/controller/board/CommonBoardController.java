package com.spring.controller.board;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.service.board.PdsService;

@Controller
@RequestMapping("/board")
public class CommonBoardController{
	
	
	@Autowired
	private PdsService pService;
	
	
	
	
	@RequestMapping(value="/recent",method=RequestMethod.GET)
	public String boardMain() {
		String url="board/recent";				
		return url;
	}
	
	@RequestMapping("/search")
	public void searchBoard()throws Exception{}
	
	
	@RequestMapping("/regist")
	public String registForm(Model model)throws Exception {
		String url="board/regist";
		
		Calendar day = Calendar.getInstance(); // 현재 시간	
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







