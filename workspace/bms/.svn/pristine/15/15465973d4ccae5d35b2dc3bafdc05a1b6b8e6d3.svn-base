package com.bms.controller.constract;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bms.dto.constract.ConstractReqVO;
import com.bms.dto.member.MemberVO;
import com.bms.request.paging.SearchCriteria;
import com.bms.service.constract.ConstractService;

@Controller
@RequestMapping("/constract")
public class ConstractController {
	
	@Autowired
	private ConstractService constractService;
	
	@Autowired
	private String constractPicturePath;
	
	@RequestMapping("mobileList")
	public ModelAndView mobilePaymentList(SearchCriteria cri, ModelAndView mnv, HttpSession session) throws Exception{
		
		String url = "mobile/constract_resident";
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		Map<String, Object> dataMap = constractService.getConstractAll(cri);
		
		mnv.setViewName(url);
		mnv.addAllObjects(dataMap);
		mnv.addObject("loginUser", loginUser);
		
		return mnv;
	}
	
	@RequestMapping("mobileDetail")
	public ModelAndView mobilePaymentDetail(ModelAndView mnv, String constract_code) throws Exception{
		
		System.out.println("페이코드 : " + constract_code);
		
		String url = "mobile/constract_detail";
		
		ConstractReqVO constract = null;
		
		try {
			
			constract = constractService.mobileConstractDetail(constract_code);
			System.out.println("페이 : " + constract.toString());
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		mnv.setViewName(url);
		mnv.addObject("constract", constract);
		
		return mnv;
	}

}
