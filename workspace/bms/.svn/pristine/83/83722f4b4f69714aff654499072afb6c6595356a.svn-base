<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>테스트 진행</title>
</head>
<body>
	
	<table border="1" onmouseup="javascript:alert('그냥 테스트해봄.');" >
	<CAPTION>테스트 테이블</CAPTION>
	<tr>
		<td>코드</td>
		<td>아이디</td>
		<td>패스워드</td>
		<td>이름</td>
		<td></td>
	</tr>
	<c:forEach items="${memberList}" var="member">	
		<td>${member.member_code}</td>
		<td>${member.member_id}</td>
		<td>${member.member_pwd}</td>
		<td>${member.member_name}</td>
	</c:forEach>
	</table>
	
</body>

</html>