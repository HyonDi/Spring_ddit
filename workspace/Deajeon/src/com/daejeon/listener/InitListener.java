package com.daejeon.listener;

import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.daejeon.action.ApplicationContext;


@WebListener
public class InitListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent ctxEvent)  {}

    public void contextInitialized(ServletContextEvent ctxEvent)  { 
   
    	Map<String, Object> applicationContext = ApplicationContext.getApplicationContext();

		ServletContext ctx = ctxEvent.getServletContext();

		Enumeration<String> paramNames = ctx.getInitParameterNames();

		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			
			String classType = ctx.getInitParameter(paramName);
			try {
				Class<?> cls = Class.forName(classType);

				Object targetObj = cls.newInstance();
				
				applicationContext.put(paramName, targetObj);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		paramNames = ctx.getInitParameterNames();
		
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			String classType = ctx.getInitParameter(paramName);
			
			try {
				Class<?> cls = Class.forName(classType);

				Method[] methods = cls.getMethods();

				for (Method method : methods) {
					if (method.getName().contains("set")) {
						
						System.out.println(method.getName());
						
						String setInstanceName = ((method.getName().replace("set", "")).charAt(0) + "").toLowerCase()
								+ method.getName().substring(4);
						

						method.invoke(applicationContext.get(paramName), applicationContext.get(setInstanceName));
						
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		System.out.println(applicationContext);
	
    }
	
}
