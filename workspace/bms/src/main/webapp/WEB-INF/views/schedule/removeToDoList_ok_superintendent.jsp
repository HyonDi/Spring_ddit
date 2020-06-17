<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


<script>
	var message = "ToDoList를 정상적으로 삭제하였습니다.\n";
	/* message+="임직원 명단으로 이동합니다.\n 아무키나 누르세요."; */
	alert(message);
	
	window.location.href="<%=request.getContextPath()%>/mypage/schedule_management/superintendent/test?member_code='${member.member_code}'";
	
</script>