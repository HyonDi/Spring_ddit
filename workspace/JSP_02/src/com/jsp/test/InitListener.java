package com.jsp.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class InitListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
 
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	String childType = sce.getServletContext().getInitParameter("child"); 
    	
    	Child child = null;
    	
    	// 클래스 로딩하는 아이.
    	try {
			child = (Child)Class.forName(childType).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 껍데기는 object임.
    	
    	Parent.getInstance().setChild(child);
    }
	
}
