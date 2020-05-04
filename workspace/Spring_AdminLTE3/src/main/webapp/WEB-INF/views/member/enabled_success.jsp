<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script>
	alert("${param.id}님 활성화 완료되었습니다.");
	/* window.close(); */
	
	window.opener.location.reload(true);
	window.location.href = 'detail?id=${param.id}';
		
</script>