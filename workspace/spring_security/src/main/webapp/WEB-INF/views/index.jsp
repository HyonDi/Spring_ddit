<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<ul>
		<li><a href="<%=request.getContextPath() %>/home/main">/home/main</a></li>
		<li><a href="<%=request.getContextPath() %>/admin/main">/admin/main</a></li>
		<li><a href="<%=request.getContextPath() %>/manager/main">/manager/main</a></li>
		<li><a href="<%=request.getContextPath() %>/member/main">/member/main</a></li>
	</ul>
	
	<!-- 디폴트 로그인/로그아웃 정해져있음. security-context에서 default사용하기로했음.-->
	<a href="/spring_security_login">로그인</a>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="/j_spring_security_logout">로그아웃</a>
	
</body>
</html>