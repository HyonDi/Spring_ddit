package com.spring.interceptor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.dto.MemberVO;

public class RegistMemberLogInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		Map<String,Object> model = modelAndView.getModel();
		MemberVO registMember = (MemberVO) model.get("registMember");
		
		if(registMember==null) return;
		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		// 누가 누구를 등록했는지 로그 남긴다.loginUser:등록 한사람/ loginUser:등록된사람
		// 첫줄에 라벨을만들 수도 있다.(알아보기쉽게)
		String logStr="[User:regist]," + loginUser.getId() + "," + registMember.getId() + "," 
						+registMember.getPhone() + "," + registMember.getEmail() + "," 
						+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	
		// 경로 잡는다.
		String savePath="d:\\log";
		//File file=new File(savePath);
		if(!new File(savePath).exists()) {
			new File(savePath).mkdirs();
		}
		
		String logFilePath = savePath + File.separator+"regist_user_log.csv";
		// * true:이어쓰기. flase:새로쓰기.
		BufferedWriter out = new BufferedWriter(new FileWriter(logFilePath, true));
		
		// 이미지, 설치파일같은 bynury종류는 input/ outputStream 써야한다.
		// file reader, writer 는 이어쓰기가 없음.
		
		// 로그를 기록
		out.write(logStr);
		out.newLine();
		out.close();
	}

	
}
