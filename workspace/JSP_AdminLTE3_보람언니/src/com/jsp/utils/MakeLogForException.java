package com.jsp.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class MakeLogForException {

	public static void makeLog(HttpServletRequest request, Exception e) throws IOException {
		
		String today = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String uri = request.getRequestURI();
		String errorMessage = e.getMessage(); //UploadPictureServlet에서 받은 Exception 메시지
		
		String log = today + "," + uri + "," + errorMessage;
		
		String savePath = GetUploadPath.getUploadPath("error.log").replace("/", File.separator);
		
		File file = new File(savePath);
		if(!file.exists()) { //지정한 경로의 이름으로 된 폴더가 없으면...
			file.mkdirs();
		}
		
		//log 파일명
		//today.split(" ")[0] : 공백을 기준으로 자른 문자열들을 String 배열의 0번째에 둔다
		String fileName = today.split(" ")[0] + "-log.csv"; //csv파일로 저장하면 엑셀이 ','를 구분자로 인식해 나눠 저장한다
		
		String logFilePath = savePath + fileName;
		
		//파일 쓰기
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(logFilePath, true)); //true:내용을모두쓴다(한줄한줄 이어쓰기)/false:마지막내용만남는다(한줄 쓰고 그 줄에 덮어쓰기)
			
			//로그를 기록
			out.write(log);
			out.newLine();
		}finally {
			if(out!=null) out.close();
		}
		
	}
}
