<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메일성공</title>
</head>
<body>
	<ul>
		<li>받는 사람 : ${param.receiver }</li>
		<li>보내는 사람 : ${param.sender }</li>
		<li>제목 : ${param.title }</li>
		<li>내용 : ${param.content }</li>
		<li>첨부파일 : ${param.uploadPath }</li>
	</ul>
</body>
<script>
	if('${msg}') alert('${msg}');
</script>
</html>