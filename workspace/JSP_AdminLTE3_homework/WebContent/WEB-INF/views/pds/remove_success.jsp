<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script>
	alert("${loginUser.id}님 글 삭제 완료되었습니다.");
	
	window.opener.location.reload(true);
	window.close();
		
</script>