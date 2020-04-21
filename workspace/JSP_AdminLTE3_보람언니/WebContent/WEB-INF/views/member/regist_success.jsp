<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	<%-- 등록 창 닫기 --%>
	alert("${param.id}님 회원 등록이 정상적으로 완료되었습니다.");
	window.close();
	
	<%-- 기존 창 새로고침 --%>
	window.opener.location.reload(true);
</script>