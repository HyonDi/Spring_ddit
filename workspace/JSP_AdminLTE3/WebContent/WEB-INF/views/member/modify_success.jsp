<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%//현재창 닫고 부모창 새로고침! %>

<script>
	alert("${param.id}님 정보 수정이 정상적으로 완료되었습니다.");
	/* window.close(); */
	
	window.opener.location.reload(true);
	window.location.href = 'detail.do?id=${param.id}';
		
</script>