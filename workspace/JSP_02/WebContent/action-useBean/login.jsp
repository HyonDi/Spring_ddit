<%@page import="com.jsp.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%!
/* class LoginRequest{
	private String id;
	private String pwd;
	
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return this.id;
	}
	public void setPwd(String pwd){
		this.pwd=pwd;
	}
	public String getPwd(){
		return this.pwd;
	}
} */
%>
<%-- 
	LoginRequest loginReq = new LoginRequest(); => jsp:useBean
	
	loginReq.setId(request.getParameter("id"); => jsp:setProperty
	loginReq.setPwd(request.getParameter("pwd"); => jsp:setProperty
 --%>

<jsp:useBean id="loginReq" class="com.jsp.request.LoginRequest">
</jsp:useBean>
<%-- 유즈빈은 객체생성하는거. --%>
<%-- <jsp:setProperty name="loginReq" property="id" value='<%=request.getParameter("id") %>'/>
<jsp:setProperty name="loginReq" property="pwd" value='<%=request.getParameter("pwd") %>'/>
 
 --%>
 <jsp:setProperty property="*" name="loginReq"/>
 <%-- 얘는 리퀘스트에있는 파라미터값 set하는거. --%>
 <%-- 위 주석 안의 메서드(set으로된)들 한번에 받아오는것. 액션태그가 리플렉션에의해서
  set메서드 속에 들어있는 파라미터들(프로퍼티들) 받아와서 set지우고 get파라미터한 후 다시 set메서드로 집어넣음 --%>
 
 <%
 	MemberVO member = loginReq.toMemberVO(); // 현재 아이디랑 비밀번호만 들어있음. 밑에서 더 넣는듯.
 	
 	member.setName("홍길동");
 	member.setPhone("010-1234-1234");
 	member.setAddress("대전혁신도시 중구 대흥동");
 	
 	session.setAttribute("loginUser", member);
 	// String, vo타입 들어가나보다.
 	
 	session.setMaxInactiveInterval(10);
 	// '초(sec)'가 기준이다.
 	
 	String id = session.getId();
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	아이디 : <%= loginReq.getId() %><br/>
	패스워드 : <%= loginReq.getPwd() %><br/>
	<button type="button" onclick="location.href='main.jsp';">메인가기</button>
	test : <%=id%>
</body>
</html>