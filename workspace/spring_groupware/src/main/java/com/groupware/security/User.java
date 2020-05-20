package com.groupware.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.groupware.dto.EmployeeVO;

public class User implements UserDetails{
	// employee를 기생시키게 만든다.
	// UserDetails 는 껍데기고 알맹이는 employee이다.
	
	private EmployeeVO member;
	
	public User() {};
	
	// 생성자
	public User(EmployeeVO member) {
		//super(); // 이건 안붙여도 compiler가알아서넣어준다.
		this.member = member;
	}

	// 이 메서드들을 employee화 시켜야함.
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		return member.getPwd();
	}

	@Override
	public String getUsername() {
		return member.getId();
	}

	@Override
	public boolean isAccountNonExpired() {
		// 기간제 계정의 경우 기간만료 여부 - 우리는 기간제사용을하지않아서 무조건 true준다.
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// 사용제제(잠겨있지않은 계정인가?) - 휴직에관해서 lock 구현할것임.(휴직:enabled = 2) 
		boolean result = true;
		if(member.getEnabled()>1) result = false;
		
		return result;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// 인증정보만료여부(패스워드만료)-사용안함.=true
		return true;
	}

	@Override
	public boolean isEnabled() {
		// 휴면계정 여부 : 퇴사상태면 사용불가.
		boolean result = true;
		if(member.getEnabled()==0) result = false;
		return result;
	}
	
	// 꺼내쓰기위한용도.
	public EmployeeVO getMemberVO() {
		return this.member;
	}
	
}
