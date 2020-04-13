<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	Date today = new Date();
	String todayStr = new SimpleDateFormat("yyyy-MM-dd").format(today);
	out.println(todayStr);
%>

<%-- <fmt:formatDate var="today" value="<%=today %>" pattern="yyyy-MM-dd"/> --%>
<!-- 이거는 pageScope 에 저장하겠다는 뜻임. 꺼내려면 ${today} 를 작성해서 꺼낼 수 있다. -->

<fmt:formatDate value="<%=today %>" pattern="yyyy-MM-dd"/>
<!-- 이건 저장안하고 화면에 찍겠다는 뜻인가보다. -->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

</body>
</html>