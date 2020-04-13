<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
	String source = "010-1234-5678";

	StringTokenizer stn = new StringTokenizer(source,"-");
	// 한번에 다 잘라주지않고 가래떡썰듯 달라고 할 때 마다 조금씩 잘라서 준다.
	
	while(stn.hasMoreTokens()){ //  다음에 자를게 있는지 물어보고 있으면 잘라준다.
		out.println(stn.nextToken() + "<br/>");
	}
%>

<%-- str 이름으로 source에있는것 잘라서 pageContext에 넣어준다. pageContext에 str이랑 status가 공존하게됨. --%>
<c:forTokens var="str" items="<%=source %>" delims="-" varStatus="status">
	${status.count } : ${str } <br/>
</c:forTokens>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

</body>
</html>