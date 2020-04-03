<%@page import="java.net.URLEncoder"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	Date birth = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birth"));
	String[] hobby = request.getParameterValues("hobby");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	이름 : <%=name %><br/>
	나이 : <%=age %><br/>
	생일 : <%=new SimpleDateFormat("yyyy.MM.dd.").format(birth) %><br/>
	취미 : 	
	<%
	// 배열이고, 몇개일지 모르니 for문 돌려야함.
		for(String hobb : hobby){
			out.print(hobb+" ");
		}
	%>
	<br/><br/>
	<button type="button" onclick="regist_go()">등록하기</button>
	
	<form name="frm" action="regist.jsp" method="get">
		<input type="hidden" name="name" value="<%=name %>"/>
		<input type="hidden" name="age" value="<%=age %>"/>
	</form>
	
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script>
		function regist_go(){
			//document.frm.submit();
			$('form[name="frm"]').submit();
		}
	</script>
	<!-- 이렇게하면 때에따라 get, post방식으로 보낼 수 있다. 스크립트에서 하는것보다 손은 많이가지만. -->
	
	<%-- <script>
		var answer = confirm("등록하시겠습니까?");
		if(answer){
			location.href="regist.jsp?name=<%=name%>&age=<%=age%>";
		}else{
			location.href="http://www.ddit.or.kr";
		}
	</script> --%><!-- 자바스크립트로. 무조건 get방식으로 해야함.-->
	
	<%-- <%
		//response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		if(Integer.parseInt(age)>=20){
			response.sendRedirect("regist.jsp?name=" + 
			URLEncoder.encode(name,"utf-8")
			+ "&age=" + age);//브라우저가 읽을 url주소임.
		}else{
			response.sendRedirect("http://www.ddit.or.kr");			
		}
	%> --%><!-- sendredirect로 -->
	
	
	
</body>
</html>