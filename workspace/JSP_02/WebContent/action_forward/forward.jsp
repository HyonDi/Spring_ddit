<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%-- <script>
	alert("target.jsp 페이지로 이동합니다.");
</script> --%>
<!-- 아래 forward 때문에 위 스크립트태그 부분이 버퍼에 쌓이다가 무시되고 바로 아래만 실행된다. -->
<!-- 하지만 request는 살아있음!!!! -->
	<!-- param 태그쓴게 정식임. -->
	
<!-- jsp: 하고 쓰이는것들이 전부 action태그임. 얘 주소는 url경로여서 파라미터를 심을 수 있다. 야매래! 그래서 한글인코딩안됨.
										(아까 include할때엔 파일경로였음.) -->

<jsp:forward page="/action_forward/target.jsp">
	<jsp:param value='<%=URLEncoder.encode("홍길동","utf-8")%>' name="name"/>
	<jsp:param value="12" name="age"/>
</jsp:forward>