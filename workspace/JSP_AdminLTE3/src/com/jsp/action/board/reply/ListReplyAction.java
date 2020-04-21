package com.jsp.action.board.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.service.ReplyService;
import com.jsp.service.ReplyServiceImpl;

public class ListReplyAction implements Action{

	private ReplyService ReplyService = ReplyServiceImpl.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;
		
		
		
		return url;
	}

}
