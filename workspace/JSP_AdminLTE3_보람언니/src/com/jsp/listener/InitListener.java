package com.jsp.listener;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.dao.BoardDAO;
import com.jsp.dao.MemberDAO;
import com.jsp.service.BoardServiceImpl;
import com.jsp.service.MemberServiceImpl;

@WebListener
public class InitListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent ctxEvent)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent ctxEvent)  { 
    	/*String sqlSessionFactoryType = ctxEvent.getServletContext().getInitParameter("sqlSessionFactory");

    	List<String> DAOType = new ArrayList<String>();
    	DAOType.add(ctxEvent.getServletContext().getInitParameter("memberDAO"));
    	DAOType.add(ctxEvent.getServletContext().getInitParameter("boardDAO"));
    	DAOType.add(ctxEvent.getServletContext().getInitParameter("replyDAO"));
    	String memberDAOType = ctxEvent.getServletContext().getInitParameter("memberDAO");
    	String boardDAOType = ctxEvent.getServletContext().getInitParameter("boardDAO");
    	String replyDAOType = ctxEvent.getServletContext().getInitParameter("replyDAO");

    	try {
    		SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) Class.forName(sqlSessionFactoryType).newInstance();
    		
    		//dao에 어떤 타입의 메소드, 클래스 Impl이 올지 몰라서 와일드카드 사용
    		Class<?> cls = Class.forName(memberDAOType);
    		Class<?> cls2 = Class.forName(boardDAOType);
    		
    		//"setSessionFactory" : 원래 set메소드를 for문으로 돌려서 확인해야한다
    		//getMethod(메소드명, 메소드의 파라미터타입들(가변배열)->지금은 하나) -> 일단 있는지 확인
    		Method setSqlSessionFactory = cls.getMethod("setSessionFactory", SqlSessionFactory.class);
    		
    		Object obj = cls.newInstance();
    		Object obj2 = cls2.newInstance();
    		//invoke(obj, sqlSessionFactory) : 있으니 확인해봤으면 알아서해라...
    		//"setSqlSessionFactory"야, 너 obj에 있으니까 어떻게 실행하는지 가서 확인해봐
    		//갈때 sqlSessionFactory 이거 챙겨가
    		setSqlSessionFactory.invoke(obj, sqlSessionFactory);
    		
    		MemberDAO memberDAO = (MemberDAO) obj;
    		MemberServiceImpl.getInstance().setMemberDAO(memberDAO);

    		BoardDAO boardDAO = (BoardDAO) obj2;
    		BoardServiceImpl.getInstance().setBoardDAO(boardDAO);
    		
		} catch (Exception e) {
			e.printStackTrace();
		}*/
    	
    	
    }
	
}
