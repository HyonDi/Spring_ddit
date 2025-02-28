<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>B.M.S(Building Management System)</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="<%=request.getContextPath()%>/resources/login/images/icons/로고.JPEG"/>
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

</head>
<body style="background-color: #666666;">
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form" action="<%=request.getContextPath()%>/commons/loginPost" method="post">
					<div class="flex-sb-m w-full p-b-43 p-t-30">
						<img alt="" src="<%=request.getContextPath()%>/resources/login/images/로고.JPEG" style="width : 150px;height:150px;display:block;margin:auto;">
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "아이디는 6~13 영문자,숫자로입력해주세요">
						<input class="input100" type="text" name="id">
						<span class="focus-input100"></span>
						<span class="label-input100">아이디
						<img alt="" src="<%=request.getContextPath()%>/resources/login/images/아이디아이콘.png" width="15px" height="15px" style="float:right;">
						</span>
						
					</div>
					
					
					<div class="wrap-input100 validate-input" data-validate="패스워드는 8~15대소문자,숫자,특수문자혼합입니다.">
						<input class="input100" type="password" name="pass">
						<span class="focus-input100"></span>
						<span class="label-input100">비밀번호
						<img alt="" src="<%=request.getContextPath()%>/resources/login/images/비밀번호.png" width="15px" height="15px" style="float:right;">
						</span>
					</div>

					<div class="btn btn-success btn-block">
						<button type="submit" class="btn btn-success btn-block">
							로그인
						</button>
					</div>
					<div class="btn btn-primary btn-block">
						<a data-toggle="modal" href="#findPassword" class="btn btn-primary btn-block">
							아이디 / 패스워드 찾기
						</a>
					</div>
				</form>
				<div class="login100-more" style="background-image: url('<%=request.getContextPath()%>/resources/login/images/건물.png');">
				</div>
			</div>
		</div>
	</div>
	
	<!-- 비밀번호찾기 - 모달 -->
  <div class="modal modal-center fade" id="findPassword" role="dialog">
    <div class="modal-dialog modal-lg modal-center" style="margin-top:30px;">
    
      <!-- Modal content-->
      <div class="modal-content" style="padding-left:20px;padding-right:20px; margin-top:150px">
        <div class="modal-header" style="padding-bottom:20px; margin-bottom:10px">
          <button class="modal-title btn btn-primary" onclick="idcommons()" style="width:155px;">아이디 찾기</button>
          <button class="modal-title btn btn-primary" onclick="pwdcommons()" style="width:155px;">패스워드 찾기</button>
        </div>
        <form id="findChk" action="<%=request.getContextPath()%>/commons/findId" method="post">
	        <div class="wrap-input100" id="idchk" style="display:none;">
				<input class="input100" type="text" name="member_id">
				<span class="focus-input100"></span>
				<span class="label-input100">아이디</span>
			</div>
			
			<div class="wrap-input100 p-r-10 ">
				<input class="input100" type="text" name="member_email">
				<span class="focus-input100"></span>
				<span class="label-input100">이메일</span>
			</div>
			
			<div class="wrap-input100">
				<input class="input100" type="text" name="member_name">
				<span class="focus-input100"></span>
				<span class="label-input100">이름</span>
			</div>
			
			<div class="wrap-input100">
				<input class="input100" type="text" name="member_phone">
				<span class="focus-input100"></span>
				<span class="label-input100">휴대폰 번호</span>
			</div>
			
	        <div class="modal-footer" style="padding-top:20px">
	          <button type="submit" onclick="form.submit();" class="login100-form-btn" data-dismiss="modal">전송</button>
	          <button type="button" class="login100-form-btn" data-dismiss="modal">닫기</button>
	        </div>
	     </form>
      </div>
      </div>
      </div>
	
	
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
	function getCall(phone){

		var member_phone = "0" + phone;

		$.ajax({
			type : 'get',
			url : "<%=request.getContextPath()%>/commons/fingerLogin",
			data : {'member_phone':member_phone},
			dataType:'json',
			success : function(member){
				var id = member.member_id;
				var pwd = member.member_pwd;
				
				location.href="<%=request.getContextPath()%>/commons/mobileLogin?id=" + id + "&pwd=" + pwd;
			},
			error : function(errror){
				alert("에러발생");
			}
			
		});
		
	}
	
	function idcommons(){
		$("div[id='idchk']").css('display','none');
		$("form[id='findChk']").attr('action', '<%=request.getContextPath()%>/commons/findId');
	}
	
	function pwdcommons(){
		$("div[id='idchk']").css('display','inline-block');
		$("form[id='findChk']").attr('action', '<%=request.getContextPath()%>/commons/findPassword');
	}
</script>
</body>
</html>