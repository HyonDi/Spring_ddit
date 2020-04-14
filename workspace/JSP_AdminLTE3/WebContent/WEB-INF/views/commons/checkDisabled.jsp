<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
// 리스너
	alert("정지된 회원은 접근이 불가능합니다.");
	/* history.go(-1); */
	window.location.href = 'detail?id=${param.id}';
	
/*  	if(window.opener){
		//window.opener.location.reload(true); 
		//window.location.href = 'detail?id=${param.id}'; 
		// /commons/login 
		alert("정지된 회원은 접근이 불가능합니다.");
		history.go(-1);
	}else{
		alert("정지된 회원은 접근이 불가능합니다.");
		history.go(-1);
	}  */
	
</script>