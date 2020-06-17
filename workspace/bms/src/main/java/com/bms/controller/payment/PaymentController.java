package com.bms.controller.payment;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bms.dto.member.MemberVO;
import com.bms.dto.payment.PaymentReqVO;
import com.bms.request.paging.SearchCriteria;
import com.bms.service.payment.PaymentService;

@Controller
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping("mobileList")
	public ModelAndView mobilePaymentList(SearchCriteria cri, ModelAndView mnv, HttpSession session) throws Exception{
		
		String url = "mobile/payment_resident";
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		Map<String, Object> dataMap = paymentService.getPaymentAll(cri);
		
		mnv.setViewName(url);
		mnv.addAllObjects(dataMap);
		mnv.addObject("loginUser", loginUser);
		
		return mnv;
	}
	
	@RequestMapping("mobileDetail")
	public ModelAndView mobilePaymentDetail(ModelAndView mnv, String payment_code) throws Exception{
		
		System.out.println("페이코드 : " + payment_code);
		
		String url = "mobile/payment_detail";
		
		PaymentReqVO payment = null;
		
		try {
			
			payment = paymentService.mobilePaymentDetail(payment_code);
			System.out.println("페이 : " + payment.toString());
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		mnv.setViewName(url);
		mnv.addObject("payment",payment);
		
		return mnv;
	}

}
