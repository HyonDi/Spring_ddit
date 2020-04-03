<%@page import="com.jsp.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
	
	<h1><% MemberVO loginUser = (MemberVO)session.getAttribute("loginUser"); %></h1>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1><%= loginUser.getId() %> 님 환영합니다.</h1>
	<button id="logoutBtn" type="button" onclick="logout_go();">로그아웃</button>
</body>

<script>
	function logout_go(id){
		location.href="logout.jsp";
	}
</script>

</html>