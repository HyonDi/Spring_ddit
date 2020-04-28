package com.daejeon.action.board.reply;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daejeon.action.Action;
import com.daejeon.dto.ReplyVO;
import com.daejeon.request.ModifyReplyRequest;
import com.daejeon.service.ReplyService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ModifyReplyAction implements Action {

	private ReplyService replyService;
	public void setReplyService(ReplyService replyService) {
		this.replyService= replyService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url=null;
		
		ObjectMapper mapper=new ObjectMapper();
		ModifyReplyRequest replyReq = mapper.readValue(request.getReader(), ModifyReplyRequest.class);
		ReplyVO reply = replyReq.toReplyVO();
		
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			replyService.modifyReply(reply);
			out.print("SUCCESS");
		} catch (SQLException e) {
			e.printStackTrace();
			out.print("FAIL");
		} finally {
			if(out!=null) out.close();
		}
		
		
		return url;
	}

}
