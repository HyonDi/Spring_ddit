<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
<base target="_self" />
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
<style type="text/css">

/* @media screen and (min-width: 768px) { 
        .modal:before {
                display: inline-block;
                vertical-align: middle;
                content: " ";
                height: 100%;
        }
}

	.modal-dialog.modal-center {
	  display: inline-block;
	  text-align: left;
	  vertical-align: middle; 
  
} */

</style>
</head>
<body style="background-color: #666666;">
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form" action="<%=request.getContextPath()%>/commons/loginPost" method="post">
					<div class="flex-sb-m w-full p-b-43 p-t-30">
						<img alt="" src="<%=request.getContextPath()%>/resources/login/images/로고.JPEG" style="width : 150px;height:150px;display:block;margin:auto;">
					</div>
					<span class="login100-form-title p-b-43">쾌적한시설	</span>
					<span class="login100-form-title p-b-43"><span style="color : crimson;">B.M.S</span>가 만들어드립니다.</span>
					
					
					<div class="wrap-input100 validate-input" data-validate = "아이디는 8~15 영문자 또는 영문,숫자로 입력해주세요">
						<input class="input100" type="text" name="id">
						<span class="focus-input100"></span>
						<span class="label-input100">아이디
						<img alt="" src="<%=request.getContextPath()%>/resources/login/images/아이디아이콘.png" width="15px" height="15px" style="float:right;">
						</span>
						
					</div>
					
					
					<div class="wrap-input100 validate-input" data-validate="패스워드는 8~15대소문자,숫자,특수문자혼합입니다.">
						<input class="input100" type="password" name="pwd">
						<span class="focus-input100"></span>
						<span class="label-input100">비밀번호
						<img alt="" src="<%=request.getContextPath()%>/resources/login/images/비밀번호.png" width="15px" height="15px" style="float:right;">
						</span>
					</div>

					<div class="flex-sb-m w-full p-t-3 p-b-32">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
							<label class="label-checkbox100" for="ckb1">
								아이디 저장
							</label>
						</div>
						
						<!-- <div class="contact100-form-checkbox">
							<label class="label-checkbox100">
								아이디 찾기
							</label>
						</div>
						
						<div class="contact100-form-checkbox">
							<label class="label-checkbox100">
								비밀번호 찾기
							</label>
						</div> -->
						
						<div>
							<a data-toggle="modal" href="#findId" class="txt2 p-l-140">
								아이디 찾기
							</a>
						</div>
						<div>
							<a data-toggle="modal" href="#findPassword" class="txt2">
								비밀번호찾기
							</a>
						</div>
					</div>
			

					<div class="container-login100-form-btn">
						<button type="submit" class="login100-form-btn">
							로그인
						</button>
					</div>
					
					
				</form>

				<div class="login100-more" style="background-image: url('<%=request.getContextPath()%>/resources/login/images/건물.png');">
				</div>
			</div>
		</div>
	</div>
	
		<!-- 아이디찾기 - 모달 -->
	 <div class="modal modal-center fade" id="findId" role="dialog">
    <div class="modal-dialog modal-lg modal-center" style="margin-top:30px;">
    
      <!-- Modal content-->
      <div class="modal-content" style="padding-left:20px;padding-right:20px; margin-top:150px">
        <div class="modal-header" style="padding-bottom:30px">
          <button type="button" class="close" data-dismiss="modal">×</button>
          <h4 class="modal-title">아이디 찾기</h4>
        </div>
        
			<form id="findChkId" action="<%=request.getContextPath()%>/commons/findId" method="post">	
		        <div class="wrap-input100 p-r-10 ">
					<input class="input100" id="email" type="text" name="member_email" >
					<span class="focus-input100"></span>
					<span class="label-input100">이메일</span>
				</div>
							
				<div class="wrap-input100">
					<input class="input100" id="name" type="text" name="member_name">
					<span class="focus-input100"></span>
					<span class="label-input100">이름	</span>
				</div>
				
				<div class="wrap-input100">
					<input class="input100" id="phone" type="text" name="member_phone">
					<span class="focus-input100"></span>
					<span class="label-input100">휴대폰 번호</span>
				</div>
				
		        <div class="modal-footer" style="padding-top:20px">
		          <button type="button" onclick="form.submit();" class="login100-form-btn" data-dismiss="modal">전송</button>
		          <button type="button" class="login100-form-btn" data-dismiss="modal">닫기</button>
		        </div>
			</form>
			
      </div>
    </div>
  </div>
  <!-- 비밀번호찾기 - 모달 -->
  <div class="modal modal-center fade" id="findPassword" role="dialog">
    <div class="modal-dialog modal-lg modal-center" style="margin-top:30px;">
    
      <!-- Modal content-->
  <form action="<%=request.getContextPath()%>/commons/findPassword" method="post">
      <div class="modal-content" style="padding-left:20px;padding-right:20px; margin-top:150px">
        <div class="modal-header" style="padding-bottom:30px">
          <button type="button" class="close" data-dismiss="modal">×</button>
          <h4 class="modal-title">비밀번호찾기</h4>
        </div>
        <div class="wrap-input100">
			<input class="input100" id="id" type="text" name="member_id">
			<span class="focus-input100"></span>
			<span class="label-input100">아이디
			
			</span>
						
		</div>
					
					
		<div class="wrap-input100">
			<input class="input100" id="name" type="text" name="member_name">
			<span class="focus-input100"></span>
			<span class="label-input100">이름
			
			</span>
		</div>
		
		<div class="wrap-input100">
			<input class="input100" id="email" type="text" name="member_email">
			<span class="focus-input100"></span>
			<span class="label-input100">이메일
			
			</span>
		</div>
		
        <div class="modal-footer" style="padding-top:20px">
          <button type="button" onclick="form.submit();" class="login100-form-btn" data-dismiss="modal">전송</button>
          <button type="button" class="login100-form-btn" data-dismiss="modal">닫기</button>
        </div>
      </div>
</form>	
      
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

</script>
</body>
</html>