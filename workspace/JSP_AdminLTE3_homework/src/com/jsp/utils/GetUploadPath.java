package com.jsp.utils;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.io.Resources;

/**
 * 요청하는 곳의 uploadPath를 'uploadPath.properties'에서 찾아서 리턴해준다. 
 * @author PC-16
 *
 */
public class GetUploadPath {
	
	
	private static Properties properties = new Properties();
	
	static {
		String resource = "com/jsp/properties/uploadPath.properties";
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			properties.load(reader);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getUploadPath(String key) {
		String uploadPath = null;
		uploadPath = properties.getProperty(key); // key값을 넣은 것.
		
		// / 슬래시로 돼있는걸 \ 역슬래시(File.separator)로 바꾼다.
		uploadPath = uploadPath.replace("/", File.separator);
		return uploadPath;
	}
}
