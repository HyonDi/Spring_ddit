package com.jsp.dispatcher;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import com.jsp.action.Action;
import com.jsp.action.ApplicationContext;

public class HandlerMapper {
	// 서블릿똘마니???
	
	// 인스턴스생성 못하게 한다.
	private HandlerMapper() {}

	// static구조 => static초기화해야함. // listener 를통해 만들면 싱글톤패턴으로만들면된다. 하지만 서블릿에 의존주입이안되서 그러지않음.
	private static Map<String,Action> commandMap = new HashMap<String, Action>();
	
	static {
		String path="com/jsp/properties/url";
		
		// resourceBundle. 은 properties만읽는애라 .properties 붙이지않는다.!
		ResourceBundle rbHome = ResourceBundle.getBundle(path);
		
		//set 으로하는이유 : keyset 이 순서를가지고있어서 하나씩호출하기위함.
		Set<String> actionSetHome = rbHome.keySet(); // properties에있는 애들의 keyset 을 꺼낸다.
		
		Iterator<String> it=actionSetHome.iterator();
		
		while(it.hasNext()) {
			String command = it.next();
			
			// getValue -> entry??? Map은 get 이래.
			String actionClassName = rbHome.getString(command);
			
			System.out.println(actionClassName);

			try{
			Class<?> actionClass = Class.forName(actionClassName);
			Action commandAction = (Action) actionClass.newInstance();
			
			// 의존성확인 및 조립 . 주입시키기!
			Method[] methods = actionClass.getMethods();
			
			// 우리 set메서드들 다 파라미터 하나임. 그래서 0번째꺼만가져온다. 그런데 패키명경로들이 쭉 딸려옴.(com.jsp....)
			for(Method method : methods) {
				if(method.getName().contains("set")) {
					String paramType=method.getParameterTypes()[0].getName();
					
					// 그래서 .으로 split해서 잘라서 뒤에거 빼온다.
					paramType=paramType.substring(paramType.lastIndexOf(".")+1);
					
					// 리터럴스트링으로 바꾸는방법 : (char) +"" 시킴.
					paramType=(paramType.charAt(0) + "").toLowerCase()+paramType.substring(1);
					try {
						method.invoke(commandAction, ApplicationContext.getApplicationContext().get(paramType));
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			
			commandMap.put(command, commandAction);
			
			System.out.println(command+" : " + commandAction + " 가 준비되었습니다.");
			
			} catch(ClassNotFoundException e) {
				System.out.println(actionClassName + "이 존재하지 않습니다.");
			} catch(InstantiationException e) {
				System.out.println(actionClassName + " 의 인스턴스를 생성할 수 없습니다.");
			} catch(IllegalAccessException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	// 써야함!!
	public static Action getAction(String command) {
		Action action = commandMap.get(command);
		return action;
	}
}
