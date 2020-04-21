package com.jsp.utils;

import java.util.UUID;

public class MakeFileName {
	
	public static String toUUIDFileName(String fileName, String delimiter) {
		//UUID : MathRandom과 같은 기능(시리얼 코드 체계)
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid + delimiter + fileName;
	}
	
}
