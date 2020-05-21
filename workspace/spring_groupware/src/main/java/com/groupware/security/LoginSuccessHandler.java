package com.groupware.security;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.web.servlet.ModelAndView;

import com.groupware.dto.EmployeeVO;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	
/*	이렇게 하는것 주입안됨.
	EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
*/
	// 따라서 고의적으로 context Loading해야한다.filter가 container를 가져오도록 해야한다.(만들어져있는 container말고)
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		 
		
		/*ApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/groupware/context/root-context.xml");
		
		EmployeeService service = (EmployeeService) ctx.getBean("employeeService");
		
		String id = authentication.getName();
		
		try {
			EmployeeVO loginUser = (EmployeeVO) service.getEmployee(id).get("employee");
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
		} catch(SQLException e) {
			e.printStackTrace();
		}*/

		
		
		/* 새로운 방법!-새 provider / 고의적으로 context Loading 하지않는 방법!*/
		// authentication 갖다준다. 로그인성공한. UserDetail안에 loginUser(getmember로) 뽑음.
		User user = (User)authentication.getDetails();
		EmployeeVO loginUser = user.getMemberVO();
		
		// session에 넣음.
		HttpSession session = request.getSession();
		
		session.setAttribute("loginUser", loginUser);
		// 30분이상은 줘도 소용없다. 30분이후엔 tomcat이 날림.
		session.setMaxInactiveInterval(20*15); //second
		
		// 30분 이상으로 연장시키려면 빈컨트롤러만들어서.. ajax로 시간마다 날리라고??
		
		
		// 록인 로그 작성(빈등록안하고 여기서 로그남기는 방법.(우리는 로그인 컨트롤러가 없기때문에 이렇게해야함.))
		try {
			
			writeLoginLog(request, response, loginUser);
		} catch(Exception e) {
			writeLoginLog(loginUser.getId());
		}
		
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(!user.isAccountNonLocked()) {
			out.println("<script>");
			out.println("alert('휴직상태로 권한이 일반사용자로 제한됩니다.');");
			out.println("location.href='/" + request.getContextPath() + "';");
			out.println("</script>");
		}else {
			super.onAuthenticationSuccess(request, response, authentication);// "하던데로 하렴." 하는것. 
		}
		
	}

	private void writeLoginLog(HttpServletRequest request, HttpServletResponse response, EmployeeVO loginUser)
			throws Exception {// 정상적으로 log생성시(오버로딩)

		if (loginUser == null)
			return;

		// 로그인 정보를 스트링으로 저장.
		String tag = "[login]";
		String log = tag + "," + loginUser.getEno() + "," + loginUser.getId() + "," + loginUser.getPhone_c() + ","
				+ loginUser.getPhone_p() + "," + loginUser.getEmail() + "," + request.getRemoteAddr() + ","
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

		// 로그 파일 생성.
		String savePath = "d:\\log";
		File file = new File(savePath);
		if (!file.exists()) {
			file.mkdirs();
		}

		String logFilePath = savePath + File.separator + "login_employee_log.csv";
		BufferedWriter out = new BufferedWriter(new FileWriter(logFilePath, true));

		// 로그를 기록
		out.write(log);
		out.newLine();

		out.close();
	}
	
	private void writeLoginLog(String id){// exception으로 log생성 실패시 작동될 함수.(오버로딩)
			
		System.out.println("[LoginLog]"+id+" 생성 실패 : " + new Date());
		
			// loginUserLogInterceptor 내용 복사해왔다.(위로 복붙함)
		
			/*MemberVO loginUser= (MemberVO)request.getSession().getAttribute("loginUser");
			if(loginUser==null) return;
			*/
			// 로그인 정보를 스트링으로 저장.
			/*String tag="[login:user]";
			String log = tag+"," + loginUser.getId() + "," + loginUser.getPhone()+"," + loginUser.getEmail() + ","
						+request.getRemoteAddr()+"," + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			
			// 경로 잡는다.
			String savePath="d:\\log";
			File file=new File(savePath);
			if(!file.exists()) {
				file.mkdirs();
			}
			
			String logFilePath = savePath + File.separator+"login_user_log.csv";
			// * true:이어쓰기. flase:새로쓰기.
			BufferedWriter out = new BufferedWriter(new FileWriter(logFilePath, true));
			
			// 이미지, 설치파일같은 bynury종류는 input/ outputStream 써야한다.
			// file reader, writer 는 이어쓰기가 없음.
			
			// 로그를 기록
			out.write(log);
			out.newLine();
			
			out.close();*/
		}
	}
	

