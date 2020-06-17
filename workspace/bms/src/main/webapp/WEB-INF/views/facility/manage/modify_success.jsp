<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script>
	alert("시설정보가 수정되었습니다");
	location.href="<%=request.getContextPath()%>/facility_stock/facility_management/detail?facility_code=${facility.facility_code}";
	window.opener.location.reload();
</script>