package com.bms.controller.notice;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bms.dto.notice.NoticeVO;
import com.bms.request.paging.SearchCriteria;
import com.bms.service.member.MemberService;
import com.bms.service.notice.NoticeService;

@Controller
@RequestMapping("/notice/")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("mobileList")
	public ModelAndView MobilenoticeList(SearchCriteria cri, ModelAndView mnv, String chk) throws SQLException {
		
		String url = "mobile/noticeList_resident";
		
		System.out.println(chk);
		
		if(chk.equals("admin")) {
			url = "mobile/noticeList_superintendent";
		}else {
			url = "mobile/noticeList_resident";
		}
		
		Map<String, Object> dataMap = noticeService.getNoticeAll(cri);
		
		
		mnv.setViewName(url);
		mnv.addAllObjects(dataMap);
		
		return mnv;
	}
	
	@RequestMapping(value="mobileDetail",method=RequestMethod.GET)
	public ModelAndView MobilenoticeDetail(ModelAndView mnv, String notice_code, String chk, String chk2) throws SQLException {
		String url = "mobile/noticeDetail_resident";
		
		if(chk.equals("dt") && chk2.equals("mem")) {
			url = "mobile/noticeDetail_resident2";
		}else if(chk.equals("dt") && chk2.equals("admin")) {
			url = "mobile/noticeDetail_superintendent2";
		}else if(chk.equals("dc") && chk2.equals("admin")) {
			url = "mobile/noticeDetail_superintendent";
		}else if(chk.equals("dc") && chk2.equals("mem")){
			url = "mobile/noticeDetail_resident";
		}
		
		
		NoticeVO notice = noticeService.getnoticeByNno(notice_code);
		
		String member_code = notice.getMember_code();
		
		String member_name = memberService.getMemberNameByCode(member_code);
		
		mnv.setViewName(url);
		mnv.addObject("notice", notice);
		mnv.addObject("member_name", member_name);
		
		return mnv;
	}

}
