package com.jsp.action.board.reply;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsp.action.Action;
import com.jsp.request.PageMaker;
import com.jsp.request.RegistReplyRequest;
import com.jsp.request.SearchCriteria;
import com.jsp.service.ReplyService;

public class RegistReplyAction implements Action {

	private ReplyService replyService;
	public void setReplyServcie(ReplyService replyService) {
		this.replyService=replyService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url=null;
		
		ObjectMapper mapper = new ObjectMapper();
		
														// 데이터. 			// 저장그릇
		RegistReplyRequest replyReq = mapper.readValue(request.getReader(), RegistReplyRequest.class);
		
		response.setContentType("text/plainlcharset=utf-8");
		PrintWriter out=response.getWriter();
		try {
			replyService.registReply(replyReq.toReplyVO());
			
			// 제일최근에작성한글 앞으로 끌어오는방법.
			// 서치크리테리아다시생성
			SearchCriteria cri = new SearchCriteria();
			
			Map<String,Object> dataMap = replyService.getReplyList(replyReq.getBno(), cri);
			PageMaker pageMaker = (PageMaker)dataMap.get("pageMaker");
			int realEndPage = pageMaker.getRealEndPage();
			out.print("SUCCESS," + realEndPage);
			
		} catch (SQLException e) {
			e.printStackTrace();
			out.print("FAIL,1");
		} finally {
			if(out!=null)out.close();
		}
		
		return url;
	}

}
