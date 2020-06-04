package com.spring.controller;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionAdvice {

	@ExceptionHandler(SQLException.class)
	public ModelAndView sqlExceptionPage(Exception e) {
		e.printStackTrace();
		
		ModelAndView modelnView=new ModelAndView();
		
		modelnView.setViewName("/error/db_error");
		modelnView.addObject("exception",e);
		
		return modelnView;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView ExceptionPage(Exception e) {
		e.printStackTrace();
		
		ModelAndView modelnView=new ModelAndView();
		
		modelnView.setViewName("/error/500_error");
		modelnView.addObject("exception",e);
		
		return modelnView;
	}
}
