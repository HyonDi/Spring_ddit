<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>에러가 났어요...큰일입니다.</h1>
	
	<!-- isErrorPage="true"로 하면 이전페이지에서 난 에러정보를 가져올 수 있다. -->
	<p> <%=exception.getMessage()%></p>
	<hr/>
	<%--<p> <%=exception.printStackTrace()</p>--%>
</body>
</html>