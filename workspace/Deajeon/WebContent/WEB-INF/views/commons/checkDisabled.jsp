<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>

	alert("정지된 회원은 접근이 불가능합니다.");
	
    if(window.opener){
		window.close();
	}else{
		history.go(-1);
	}
	 
</script>