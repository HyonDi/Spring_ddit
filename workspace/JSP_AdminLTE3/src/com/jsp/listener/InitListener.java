package com.jsp.listener;

import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.jsp.action.ApplicationContext;


@WebListener
public class InitListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent ctxEvent)  {}

    public void contextInitialized(ServletContextEvent ctxEvent)  { 
   
    	Map<String, Object> applicationContext = ApplicationContext.getApplicationContext();

		ServletContext ctx = ctxEvent.getServletContext();

		//1. 인스턴스 생성(조립에필요한 인스턴스-web.xml에 인스턴스들을 나열해놓음.(param-name으로))
		// 이름들을꺼내면 파라미터-네임들이 쭉 나온다.
		// 파라미터네임리턴타입이 enumeration이야. 이터레이터밖에못꺼냄.?
		Enumeration<String> paramNames = ctx.getInitParameterNames();

		// 이터레이터 - 다음거있니?
		while (paramNames.hasMoreElements()) {
											// next(있어 . 대답. 순서없음.)
			String paramName = paramNames.nextElement();
			
			// param-value를 가져온다.
			String classType = ctx.getInitParameter(paramName);
			try {// 로드
				Class<?> cls = Class.forName(classType);

				// 인스턴스생성
				Object targetObj = cls.newInstance();
				
				// 컨테이너에 넣는다. param-name , 그 인스턴스
				applicationContext.put(paramName, targetObj);

				// 이제 조립하면된다.(아래에있음)
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		// 2. 인스턴스 의존성 확인 및 조립.
		// Enumeration iterator 에 올리려면 다시올리려면 재할당해야한다.
		// 의존성확인위해서. 확인하려면 클래스타입의 매서드를확인해야한다.(set메서드가있는지.)
		// 클래스타입보려면 param-value가 필요.
		paramNames = ctx.getInitParameterNames();
		
		while (paramNames.hasMoreElements()) {
			// 이제 인스턴스를생성하기위함이아니라 메서드를확인하기위함이다.
			String paramName = paramNames.nextElement();
			String classType = ctx.getInitParameter(paramName);
			
			try {
				// 클래스로딩
				Class<?> cls = Class.forName(classType);

				// 메서드를 쭉 꺼내본다. - proxy 필요.(interface) - reflection?
				Method[] methods = cls.getMethods();

				for (Method method : methods) {
					// set이있는지없는지 확인한다.
					if (method.getName().contains("set")) {
						
						System.out.println(method.getName());
						
						// 										set을지움.					첫번째글자를 소문자로바꿈.
						String setInstanceName = ((method.getName().replace("set", "")).charAt(0) + "").toLowerCase()
								+ method.getName().substring(4);
						
						// boardService 의 setboardDao() 로 예를든다.
						// 컨테이너에있는 boardService에서 setboardDao()를 실행하고				boardDao를 줘.
						method.invoke(applicationContext.get(paramName), applicationContext.get(setInstanceName));
						// invoke : 	해당메서드를 어떤인스턴스(boardServiceImpl)로			어떤파라미터(boardDao)를넣어서 실행할것인지.
						
						// 그래서 클래스만들고, web.xml에 넣으면 listener가 조립해준다. 우리는 의존주입이필요한것의 set메서드를 만들어놓으면된다.
						
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		System.out.println(applicationContext);
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
