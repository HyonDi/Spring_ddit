<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	int price= 100000000;

	DecimalFormat df = new DecimalFormat("#,###");// #은 있을때만?
	out.println(df.format(price)+"<br/>");
%>
<span style="color:red;font-weight:bold;font-size:32px;">
<fmt:formatNumber value="<%=price %>" pattern="#,###"/>￦
</span>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

</body>
</html>