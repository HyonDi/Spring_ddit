package com.jsp.dispatcher;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import com.jsp.action.Action;

public class HandlerMapper {

	//인스턴스를 만들지 못하도록
	private HandlerMapper() {}
	
	private static Map<String, Action> commandMap = new HashMap<String, Action>();
	
	static {
		//url.properties 라고 쓰지 않는 이유 : ResourceBundle은 properties 읽는 용도라서 알아서 읽는다
		String path = "com/jsp/properties/url";
		
		ResourceBundle rbHome = ResourceBundle.getBundle(path);
		
		//키 중복을 방지하기 위해 Set 사용
		//keySet() : 키를 담고 있는 바구니
		Set<String> actionSetHome = rbHome.keySet();
		
		Iterator<String> it = actionSetHome.iterator();
		
		while (it.hasNext()) {
			String command = it.next();
			
			//getString() : Value 값 꺼내기
			String actionClassName = rbHome.getString(command);
			
			System.out.println(actionClassName);
			
			try {
				Class actionClass = Class.forName(actionClassName);
				Action commandAction = (Action) actionClass.newInstance();
				commandMap.put(command, commandAction);
				
				System.out.println(command + " : " + commandAction + "가 준비되었습니다.");
				
			} catch (ClassNotFoundException e) {
				System.out.println(actionClassName + "이 존재하지 않습니다.");
			} catch (InstantiationException e) {
				System.out.println(actionClassName + "인스턴스를 생성할 수 없습니다.");
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Action getAction(String command) {
		Action action = commandMap.get(command);
		return action;
	}
}
