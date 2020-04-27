package com.jsp.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class MakeLogForException {
	
	public static void makeLog(HttpServletRequest request, Exception e) throws IOException{

		// 오늘날짜를 포맷해서 담음
		String today = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String uri = request.getRequestURI(); // uri주소를 빼온다.
		String errorMessage = e.getMessage(); // 익셉션에서 메세지 가져온다.
		
		String log = today+","+uri+","+errorMessage; // 합침!
		
		String savePath = GetUploadPath.getUploadPath("error.log").replace("/", File.separator);
		// uploadPath.properties에 저장해놓은 error.log 주소에 / 을 file.separator 로 바꿔넣음.
		
		File file = new File(savePath);
		if(!file.exists()) { // 파일이 존재하면 
			file.mkdirs(); // 디렉토리폴더를 만든다.
		}
		
		String fileName = today.split(" ")[0] + "-log.csv"; // " " 기준으로자름.yyyy-MM-dd HH:mm:ss 이거에서 yyyy-MM-dd 부분!
		
		String logFilePath = savePath + fileName;
		
		// 파일 쓰기
		// bufferedWriter : 줄단위로 작성함.
		// fileWriter(logFilePath, true) : true 하면 이어쓰기함. false하면 지우고 새로쓰기함.
		// 날짜가같으면 같은파일명일것이다. 거기에 이어쓰기!
		BufferedWriter out = null;
		try {
			out=new BufferedWriter(new FileWriter(logFilePath, true));
			
			// 로그를 기록
			out.write(log);
			out.newLine();
		} finally {
			// bufferedWriter만들다가 터지면 out이 안생겨서 finally에서 out을 못잡으니 터진다.
			// 따라서 if걸어줘야함.
			if(out!=null)out.close();
			//만들다 터지면 닫는다.
		}
		
		
	}
}
