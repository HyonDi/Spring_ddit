package com.jsp.utils;

import java.util.UUID;

/**
 * UUID 로 사진 이름 고유하게 만들것이다.
 * @author PC-16
 *
 */
public class MakeFileName {
	
	public static String toUUIDFileName(String fileName, String delimiter) {
		
		// 지구상에 딱 하나인!!
		// 회원등록 원래이미지 파일명을 유지시키지 않을거가 delimiter는 "" 빈문자 줄것임.
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid + delimiter + fileName;
	}
	
	
}
