<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/login/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/login/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/login/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/login/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/login/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/login/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/login/css/util.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/login/css/main.css">
<!--===============================================================================================-->
<title></title>
<style type="text/css">
	.displaynone{
		display : none;
	}
	
	.displayblock{
		display : block;
	}
</style>
</head>
<body>

<input id="pwdchk1or2" type="hidden" value="${member_pwdupdatechk}">
<div id="enabled">
	<form id="changePassword" action="<%=request.getContextPath()%>/commons/passwordChange" method="post" 
	style="width:50%;margin:auto;padding-top:200px;">	
	<img alt="" src="<%=request.getContextPath()%>/resources/login/images/로고2.jpg" style="width : 150px;height:150px;display:block;margin:auto;">
	<h1 style="text-align:center;padding-bottom:30px;">B.M.S 비밀번호변경</h1>
		        <div class="wrap-input100 p-r-10 ">
					<span class="focus-input100"></span>
					<input type="hidden" name="id" value="${id}"/>
					<input type="hidden" name="member_pwdupdatechk" value="${member_pwdupdatechk}"> 
					<span class="label-input100" style="color:black;width:100%;"><span style="color:red;">${id}</span>님의 비밀번호를 변경해주세요</span>
				</div>
							
				<div class="wrap-input100">
					<input class="input100" id="pwd" type="password" name="member_pwd" value="">
					<span class="focus-input100"></span>
					<span class="label-input100">새로운 비밀번호</span>
				</div>
				
				<div class="wrap-input100">
					<input class="input100" id="pwd2" type="password" name="member_pwdchk" value="">
					<span class="focus-input100"></span>
					<span class="label-input100">비밀번호확인</span>
				</div>
				
		        <div class="modal-footer" style="padding-top:20px">
		          <button type="submit" class="login100-form-btn" data-dismiss="modal">전송</button>
		          <button type="button" class="login100-form-btn" data-dismiss="modal">닫기</button>
		        </div>
			</form>
		</div>		

<div id="disabled">
<h1>이미 비밀번호가 변경되었습니다.</h1>
</div>

<script>
$(function(){
	
	if($('#pwdchk1or2')==1){
		$('#enabled').addClass('displayblock');
		$('#enabled').removeClass('displaynone');
		$('#diabled').removeClass('displayblock');
		$('#diabled').addClass('displayblock');
	}else{
		$('#enabled').removeClass('displayblock');
		$('#enabled').addClass('displaynone');
		$('#diabled').addClass('displayblock');
		$('#diabled').removeClass('displayblock');
		
	}
})
</script>	
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/resources/login/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/resources/login/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/resources/login/vendor/bootstrap/js/popper.js"></script>
	<script src="<%=request.getContextPath()%>/resources/login/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/resources/login/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/resources/login/vendor/daterangepicker/moment.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/login/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/resources/login/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/resources/login/js/main.js"></script>			
	<script>
		
	</script>
</body>
</html>