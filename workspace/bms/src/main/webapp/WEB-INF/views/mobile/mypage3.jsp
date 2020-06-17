<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<html lang="en">

<head>
  <meta name="format-detection" content="telephone=no">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- Bootstrap core CSS -->
  <link href="<%=request.getContextPath()%>/resources/mobile/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="<%=request.getContextPath()%>/resources/mobile/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/mobile/vendor/simple-line-icons/css/simple-line-icons.css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Muli" rel="stylesheet">
  
  <!-- alert -->
  <link href="<%=request.getContextPath()%>/resources/mobile/css/jquery.modal.css" type="text/css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/resources/mobile/css/jquery.modal.theme-xenon.css" type="text/css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/resources/mobile/css/jquery.modal.theme-atlant.css" type="text/css" rel="stylesheet">

  <!-- Plugin CSS -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/mobile/device-mockups/device-mockups.min.css">

  <!-- Custom styles for this template -->
  <link href="<%=request.getContextPath()%>/resources/mobile/css/new-age.min.css" rel="stylesheet">

</head>

	<body id="page-top">
	
	  <!-- Navigation -->
	  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
	    <div class="container">
	    	<a class="navbar-brand js-scroll-trigger" style="color:black; display:inline;" href="javascript:history.go(-1);"><ion-icon name="arrow-round-back" style="font-size: 30px; padding-right:20px" /></a>
	    	<span style="font-weight: bold; font-size:20px;">패스워드 변경</span>
	    </div>
	  </nav>
	
	  <header style="padding-bottom: 100px; padding-top: 60px; height: 678px;">
	    <div class="container h-70">
	      <div class="row h-70">
	        <div class="col-lg-7 my-auto">
	          <div class="header-content mx-auto">
	          <section class="contact bg-light" id="contact" style="padding-top: 30px; padding-bottom: 30px;">
		          <form class="form-inline" style="padding-left: 70px;">
					  <div class="form-group">
					    <label for="member_pwd" style="display:block; margin-left:-5;">새로운 비밀번호</label>
					    <input type="password" id="member_pwd" name="member_pwd" class="form-control mx-sm-3" aria-describedby="passwordHelpInline" style="width: 250px; display:inline;" oninput="checkPwd()">
					    <img id="img1" src="<%=request.getContextPath()%>/resources/mobile/img/check.png" style="width:30px;height:30px; display:none;" />
					  </div>
					  
					  <div class="form-group">
					    <label for="member_pwdCheck" style="display:block; style="display:block;margin-left: -25;"">새로운 비밀번호 확인</label>
					    <input type="password" id="member_pwdCheck" class="form-control mx-sm-3" aria-describedby="passwordHelpInline" style="width: 250px; display:inline;" oninput="checkPwd()">
					    <img id="img2" src="<%=request.getContextPath()%>/resources/mobile/img/check.png" style="width:30px;height:30px; display:none;" />
					  </div>
					  
					  
					   <small id="passwordHelpInline" class="text-muted" style="margin-right: 95px; padding-left: 30px;">
						 * 패스워드는 8 ~ 15 대소문자, 숫자, 특수문자 혼합 입니다.
						</small>
						
						<input id="chpwd" type="hidden" value="" />
						<input type="hidden" name="member_name" value="${member.member_name }">
						<input type="hidden" name="member_id" value="${member.member_id }">
						<input type="hidden" name="member_ssn" value="${member.member_ssn }">
						<input type="hidden" name="member_email" value="${member.member_email }">
						<input type="hidden" name="member_address" value="${member.member_address }">
						<input type="hidden" name="member_phone" value="${member.member_phone }">
						
			            <button type="button" class="btn btn-primary" style="width: 176px;height: 44px;font-size:large;margin-top: 20px; margin-left: 40px;" onclick="goSubmit()">저장</button>
				  </form>
				  
			    </section>
	          </div>
	        </div>
	      </div>
	    </div>
	  </header>
	  
	</body>
	
	  <!-- Bootstrap core JavaScript -->
  <script src="<%=request.getContextPath()%>/resources/mobile/vendor/jquery/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/resources/mobile/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="<%=request.getContextPath()%>/resources/mobile/vendor/jquery-easing/jquery.easing.min.js"></script>
  
  <!-- alert -->
  <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/mobile/js/jquery.modal.js"></script>

  <!-- Custom scripts for this template -->
  <script src="<%=request.getContextPath()%>/resources/mobile/js/new-age.min.js"></script>
  
  <script src="https://unpkg.com/ionicons@4.5.10-0/dist/ionicons.js"></script>
  
  <script>
  
  	function checkPwd(){
  		
  		var pwd1 = $('#member_pwd').val();
  	  	var pwd2 =  $('#member_pwdCheck').val();
  		
  		if(pwd1.length < 8 || pwd1.length > 15 || pwd2.length < 8 || pwd2.length > 15){
  			$('#img1').css('display', 'inline').attr('src', '<%=request.getContextPath()%>/resources/mobile/img/nocheck.png');
  			$('#img2').css('display', 'inline').attr('src', '<%=request.getContextPath()%>/resources/mobile/img/nocheck.png');
  		}else{
  			$('#img1').css('display', 'inline').attr('src', '<%=request.getContextPath()%>/resources/mobile/img/check.png');
  			$('#img2').css('display', 'inline').attr('src', '<%=request.getContextPath()%>/resources/mobile/img/check.png');
  		}
  		
  		if(pwd1 == pwd2){
  			$('#img1').css('display', 'inline').attr('src', '<%=request.getContextPath()%>/resources/mobile/img/check.png');
  			$('#img2').css('display', 'inline').attr('src', '<%=request.getContextPath()%>/resources/mobile/img/check.png');
  			$('#chpwd').attr('value','ok');
  		}else{
  			$('#img1').css('display', 'inline').attr('src', '<%=request.getContextPath()%>/resources/mobile/img/nocheck.png');
  			$('#img2').css('display', 'inline').attr('src', '<%=request.getContextPath()%>/resources/mobile/img/nocheck.png');
  			$('#chpwd').attr('value','no');
  		}
    		
  		var regex = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/.test(pwd1);
  		var regex2 = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/.test(pwd2);
  		
  		if(!(regex || regex2)){
  			$('#img1').css('display', 'inline').attr('src', '<%=request.getContextPath()%>/resources/mobile/img/nocheck.png');
  			$('#img2').css('display', 'inline').attr('src', '<%=request.getContextPath()%>/resources/mobile/img/nocheck.png');
  		}

  		
  	}
  	
  	function goSubmit(){
  	  	
	  	  	modal({
	  			type: 'confirm',
	  			title : '패스워드 변경 확인',
	  			text : '정말 패스워드를 변경 하시겠습니까?',
	  			callback : function(result){
	  				if(result){
	  					goModifySave();
	  				}
	  			}
	  			
	  		});	
  		   
	 }
   	
   	function goModifySave(){
		var form = $("form[id='modifyForm']").serialize();
		var comple = $('#chpwd').val();
		
		if(comple == 'ok'){
			
			$.ajax({
				url:"<%=request.getContextPath()%>/mypage/personal_information_modification/resident/test",
				type:'post',
				dataType:"text",
				data : $('form').serialize(),
				success:function(data){
					if(data == "SUCCESS"){
						modal({
							type: 'primary',
							title: '패스워드 변경',
							text : "패스워드 변경이 완료 되었습니다! 다시 로그인 하세요."
						});
						setTimeout(function(){
							location.href="<%=request.getContextPath()%>/commons/logout";						
						}, 1300);
					}else{
						modal({
							type: 'alert',
							title: '패스워드 변경',
							text : "패스워드 변경이 실패 하였습니다!"
						});
					}
				},
				error:function(){
					modal({
						type: 'alert',
						title: '서버 오류',
						text : "일시적인 서버 오류로 인한 변경이 취소 되었습니다!"
					});
				}
				
			});
		}else{
			modal({
				type: 'alert',
				title: '패스워드를 확인하세요',
				text : "패스워드가 형식에 맞지 않거나 일치하지 않습니다."
			});
		}
	};
   	</script>
	
</html>
