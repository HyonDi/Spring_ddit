<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	//session.invalidate();

	String str = "5교시...졸립겠네요..ㅜㅜ";

	/* 추가 */
	//pageContext.setAttribute("msg", str);
	
	/* 추가 (우선순위 보기위함.) */
	request.setAttribute("msg", "그런다고 졸면 될까요?");
	session.setAttribute("msg", "졸음을 깨는건 의자가 아니라 관심입니다.");
	application.setAttribute("msg", "관심을 가져주세요...제발~!");
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<ul>
		<%-- <li>스크립트릿 : <%out.println(str); %></li> --%>
		<li>스크립트릿 : <%out.println(pageContext.getAttribute("msg")); %></li>
		
		<%-- <li>표현식 : <%=str%></li> --%>
		<li>표현식 : <%=pageContext.getAttribute("msg")%></li>
		
		<li>el문 : ${msg}</li>
		
		<li>el문(session에서 찾기) : ${sessionScope.msg}</li>
	</ul>
</body>
</html>