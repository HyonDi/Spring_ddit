package com.groupware.security;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.groupware.dao.employee.EmployeeDAO;
import com.groupware.dto.EmployeeVO;

public class CustomAuthentication implements AuthenticationProvider{
	// 얘는 필터야.
	// LoginSuccessHandler, LoginFailureHandler처럼 만들고 빈등록한다.
	// securiti-context
	// provider??

	private EmployeeDAO employeeDAO;
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		// 여기서 인증처리를 한다. authentication-manager : 가 인증된 authentication을받고 
		// LoginSuccessHandler, LoginFailureHandler 중 누구부를지 결정함.
		
		// 사용자가입력한 값(로그인 시도한 id, password) 가져오기
		String login_id = (String) auth.getPrincipal();// id
		String login_pwd = (String) auth.getCredentials();// pwd
		
		EmployeeVO employee = null;
		try {
			employee=employeeDAO.selectEmployeeById(login_id);
		}catch(SQLException e) {
			// 'BadCredentialsException'를 provider가 manager에게보내면 manager가 trycatch함. : failuer호출한다.
			// throws하지않으면 successHandler호출.
			// (다른 exception의경우에는 manager도 던진다.)
			
			// 로그인실패시 던지는것. 메세지(파라미터)는 failureHandler쪽에 인가된다.
			throw new BadCredentialsException("Internal server error!");
		}
		
		// usesr 객체를 employee의? authentication에담아야한대.
		if(employee != null && login_pwd.equals(employee.getPwd())) {
			User loginUser = new User(employee);
			
			if(!loginUser.isEnabled()) { // 사용제제(퇴사자)
				throw new DisabledException("퇴사한 상태입니다. 관리자에게문의바랍니다.");
				// 매니저에게 throw하면 매니저가 catch한다.
			}else {
				// 휴직중 혹은 재직중인상태. // 휴직인사람은 User(일반사원)의권한으로 떨어뜨린다.
				
				// 권한을 주는 객체 : grantedAuthority // 권한이 여러개일 수 있어서 roles는 List이다.
				List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
				
				// 사용자에게 권한부여
				if(loginUser.isAccountNonLocked()) {
					// lock 아닌상태.(재직중)
					// role 에 grantedAuthority를넣는다.
					roles.add(new SimpleGrantedAuthority(employee.getAuthority()));
				}else {
					// lock인상태.(휴직중)
					roles.add(new SimpleGrantedAuthority("ROLE_USER"));
				}
				
				// 스프링 시큐리티 내부 클래스로 인증 토큰 생성한다.
				// token단위로 user id, user pwd, user authentication을 생성한다. => security내부에서  작동되기시작한다.
				UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(employee.getId(), employee.getPwd(), roles);
				
				// 전달한 내용을 설정한 후
				result.setDetails(loginUser);
				
				return result;
			}
		}else {
			// 패스워드가 틀린경우 예외처리
			throw new BadCredentialsException("아이디 혹은 패스워드가 일치하지 않습니다.");
		}
		
		// return null; // method에서 throw(exception) 도 반환하는것이어서 return지워도된다.
	}

	@Override
	public boolean supports(Class<?> arg) {
		/* UsernamePasswordAuthenticationToken 리턴할 때,
		      파라미터와 같은 레퍼런스인지 비교를 하고 리턴을 한다.
		   defaule-target-url 로 전송된다.  */
		
		// 매니저에게 너한텐 이게들어갈거야. 하고 알려주는거래. 타입비교!!
		// 매니저가 provider의 authenticate를 호출해서 Authentication을 받을것인데 제대로왔는지 확인하기위해 supprot에 넣어보는 것.
		// 너가내보내는 authentication이 너가 하고자했던 타입과 일치하는가?
		// 매니저가 알아서 실행하나봐.
		
		// UsernamePasswordAuthenticationToken 타입.
		return arg.equals(UsernamePasswordAuthenticationToken.class);
		
	}
	
	
	
}
