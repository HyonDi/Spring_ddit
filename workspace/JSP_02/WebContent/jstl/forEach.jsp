<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<%
	for(int i =2; i <10 ; i++) {
		
		out.println(i + "단 입니다. <br/>");
		for(int j = 1; j < 10; j ++){
			
		out.println(i +" X " + j + " = " + j*j);
		}
		
		out.println("<br/>");
	}
%>


	<c:forEach var="dan" begin="2" end="9" step="1">
		<c:forEach var="gop" begin="1" end="9" step="1">
			${dan } * ${gop } = ${dan*gop } <br/> 
		</c:forEach>
	<br/>
	</c:forEach>
	
	
<%
	// 아래의 strList 는 지역변수임.
	List<String> strList = new ArrayList<String>();
	strList.add("1");
	strList.add("2");
	strList.add("3");
	strList.add("a");
	strList.add("b");
	strList.add("c");
	
	for(String str : strList) {
		out.println(str+"<br/>");
	}
%>
<%--  --%>

<%-- 여깄는  var 는 pageContext 의 속성명. 
	strList에 있는걸 하나씩 꺼내서 var=str 이름으로 pageContext에집어넣는다.--%>
<c:forEach var="str" items="<%=strList %>">
	<%-- 여기서 strList 는 el문 사용할수없다. 어디에 집어넣었던게 아니여서. 지금 c:foreach 돌리면서 집어넣어짐. --%>
	${str}<br/>	
</c:forEach>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

</body>
</html>