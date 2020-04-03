<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<%
	// 여기가 스크립트릿
	String name=request.getParameter("name");
	String age=request.getParameter("age");
%>

<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>이름 : <%=name %></h1>
	<h1>나이 : <%=age %></h1>
</body>
</html>