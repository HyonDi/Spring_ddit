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


    public void contextDestroyed(ServletContextEvent sce)  { 
    }


    public void contextInitialized(ServletContextEvent sce)  { 
    /*	
    	String sqlSessionFactoryType = sce.getServletContext().getInitParameter("sqlSessionFactory");
    	
    	List<String> DAOType = new ArrayList<String>();
    	
    	DAOType.add(sce.getServletContext().getInitParameter("memberDAO"));
    	DAOType.add(sce.getServletContext().getInitParameter("replyDAODAO"));
    	DAOType.add(sce.getServletContext().getInitParameter("boardDAO"));
    	
    	String memberDAOType = sce.getServletContext().getInitParameter("memberDAO");
    	String boardDAOType = sce.getServletContext().getInitParameter("boardDAO");
    	String replyDAO = sce.getServletContext().getInitParameter("replyDAO");
    	// 위에것들 String이라 class loading 해야대.
    	
    	//MemberDAOImpl memberDaoImpl = null;
    	SqlSessionFactory sqlSessionFactory = null;
    	
    	try {
    		sqlSessionFactory = (SqlSessionFactory)Class.forName(sqlSessionFactoryType).newInstance();
    		
    		Class<?> cls = Class.forName(memberDAOType);
    		Class<?> cls2 = Class.forName(boardDAOType);
    		// dao는 daoimple이 여러개고, dao에는 set메서드가 없엉.그래서 dao를임플한 누가 올지모르니 <?>로, 와일드카드로해놓음.
    		// 암튼 개를 로딩함.
    		
    		Method setSqlSessionFactory = cls.getMethod("setSqlSessionFactory", SqlSessionFactory.class);
    															// 메서드이름, 파라미터종류와 타입.
    		Method setSqlSessionFactory2 = cls2.getMethod("setSqlSessionFactory", SqlSessionFactory.class);
    		
    		Object obj = cls.newInstance(); // 인스턴스를 생성.
    		Object obj2 = cls2.newInstance();
    		
    		setSqlSessionFactory.invoke(obj, sqlSessionFactory);
    		setSqlSessionFactory2.invoke(obj2, sqlSessionFactory);
    		// invoke : setSqlSessionFactory(메서드이름)에게 sqlSessionFactory를 들고 obj에 가서 실행하라는 의미
    		// obj는 실행할 곳. 멤버다오를 임플한 멤버다오임플중 하나일것임.
    		// 이게 멤버다오임플에다가 sqlsession 주는 부분임.
    		
    		MemberDAO memberDAO = (MemberDAO)obj;// 실행된 결과를 멤버다오임플을 멤버다오로 변환해서 넣음
    		BoardDAO boardDAO = (BoardDAO)obj2;
    		
    		
    		MemberServiceImpl.getInstance().setMemberDAO(memberDAO);
    		// 서비스임플에 (멤버다오)멤버다오임플 를 세팅해줌.
    		BoardServiceImpl.getInstance().setBoardDAO(boardDAO);		
    		
    		
			//memberDaoImpl = (MemberDAOImpl)Class.forName(memberDAOType).newInstance();
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
    	// MemberServiceImpl.getInstance().setMemberDAO(memberDaoImpl);
    	//memberDaoImpl.setSessionFactory(sqlSessionFactory);
    }
	
}
