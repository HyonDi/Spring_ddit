package com.jsp.action.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dao.ReplyDAO;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

public class DetailAction implements Action{

	private MemberService memberService;// = MemberServiceImpl.getInstance();
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		// 1. 화면결정
		String url="member/detail";
		
		// 2. 파라미터 처리 // 이건 어디서난거지? 어디서 setparam을 한거?? 
		// => 주소줄로!! list.jsp의 javascript:OpenWindow('detail?id=${member.id}' 에서  첫번째 id!!
		String id = request.getParameter("id");
		
		// 3. 서비스요청 => 결과받음
		MemberVO member = null;
		try {
			member = memberService.getMember(id);
			
			// 이게 뭘하는거죠?? attribute가 뭘 넣는거죠ㅠㅠ jsp에 보낼거라면
			// 무조건 앞에 내가정한이름 넣고 뒤에 넣을 값 들어있는 변수이름 적으면되는거에요??
			// 필요없는부분???
			
			// 꺼낼때 왼쪽이름사용해서 get해야한다.(el문으로)
			request.setAttribute("member", member);
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			// 4. 결과에따른 화면분할
			url = "error/500_error";
			request.setAttribute("exception", e);
		}
		// 5. 화면요청
		//ViewResolver.view(request, response, url);
		return url;
	}

}
