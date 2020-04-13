<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script>
	
	/* alert(window.opener()); */
	
	if(window.opener){
		/* window.opener.location.reload(true); */
		/* window.location.href = 'detail?id=${param.id}'; */
		/* /commons/login */
		alert("세션이 만료되었습니다. 다시 로그인해주세요.");
		window.opener.location.href = "<%=request.getContextPath()%>/commons/login";
		window.close();
	}else{
		alert("세션이 만료되었습니다. 다시 로그인해주세요.");
		location.href = "<%=request.getContextPath()%>/commons/login";
	}
</script>