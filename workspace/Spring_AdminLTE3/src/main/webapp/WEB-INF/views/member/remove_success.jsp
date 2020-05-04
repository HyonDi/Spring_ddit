<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script>
	alert("${param.id}님 삭제 완료되었습니다.");
	
	window.opener.location.reload(true);
	window.close();
		
</script>