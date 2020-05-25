package com.spring.scheduler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.spring.dto.MemberLoginLogVO;
import com.spring.service.LoginLogService;

//@Component("taskScheduler")
public class MemberLoginLogTaskScheduler {
	// 방법 : 어노테이션으로, 빈등록으로
	
	//@Autowired
	private LoginLogService logService;
	public void setLogService(LoginLogService logService) {
		this.logService = logService;
	}
	
	
	// '10초에 1번씩 이 메서드를 실행하겠다.' 라는 어노테이션 / fixedRate(정기적)/ 주기적(1시간에한번씩, 2일에 ㅎ한 번씩.
											// 3분마다 한 번 씩 박수쳐라(주기적. 3일에 한번 끽
	//@Scheduled(fixedRate=1000*10)// 10초마다
	//@Scheduled(cron="0 0 2 * * *")// 매년 매월 매일 새벽 2시마다.
	public void testScheduler() {
		// 해당로그파일 읽어서 ListVO 만들고..
		// spring이 읽게하려면 public void에 파라미터가 없어야함.
		BufferedReader in = null;
		
		try {
			String filePath="d:\\log\\login_user_log.csv";
			FileReader reader = new FileReader(filePath); //글자씩읽는다.
			
			in = new BufferedReader(reader); // 줄단위로 읽는다.
			
			String textLine= null;
			
			List<MemberLoginLogVO> logList = new ArrayList<MemberLoginLogVO>();
			
			while((textLine=in.readLine())!=null) {
				String[] logData = textLine.split(",");
				
				MemberLoginLogVO logVO = new MemberLoginLogVO();
				logVO.setId(logData[1]);
				logVO.setPhone(logData[2]);
				logVO.setEmail(logData[3]);
				logVO.setIpAddress(logData[4]);
				try {
					logVO.setIndate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(logData[5]));
				}catch(ParseException e) {
					e.printStackTrace();
				}
				logList.add(logVO);
			}
			
			
			// 서비스 요청
			logService.write(logList);
			System.out.println("schedule run!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(in!=null) in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
