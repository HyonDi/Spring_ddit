<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	if(window.opener){ //window.opener : 부모창 있음? = 요청한 페이지가 새 창임?
		alert("세션이 만료되었습니다.\n로그인 화면으로 이동합니다.");
		window.close();
		window.opener.location.href = "<%= request.getContextPath() %>/commons/loginForm.do";
	}else{
		alert("세션이 만료되었습니다.\n로그인 화면으로 이동합니다.");
		location.href = "<%= request.getContextPath() %>/commons/loginForm.do";
	}
</script>