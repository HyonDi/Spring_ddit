<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


<script>
	var message = "${schedule.schedule_code}:${schedule.schedule_name} 을\n";
	message+="정상적으로 수정하였습니다.\n";
	/* message+="임직원 명단으로 이동합니다.\n 아무키나 누르세요."; */
	alert(message);
	window.opener.location.reload();
	<%-- window.opener.location.href="<%=request.getContextPath()%>/employee/list"; --%>
	window.close();
</script>