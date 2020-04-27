<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%//현재창 닫고 부모창 새로고침! %>


<script>
	alert("${loginUser.id}님 글 수정이 완료되었습니다.");
// 	alert("${board.title}로 글제목을 변경하셨습니다.");
	
	window.opener.location.reload(true);
	window.location.href = 'detail.do?pno=${param.pno}&check=modyfied';
	
</script>