<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


<script>
	
	if(window.opener){
		alert("세션이 만료되었습니다. 다시 로그인해주세요.");
		window.opener.location.href = "<%=request.getContextPath()%>/commons/loginForm.do";
		window.close();
	}else{
		alert("세션이 만료되었습니다. 다시 로그인해주세요.");
		location.href = "<%=request.getContextPath()%>/commons/loginForm.do";
	}
</script>