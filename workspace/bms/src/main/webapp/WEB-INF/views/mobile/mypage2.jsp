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
	    	<span style="font-weight: bold; font-size:20px;">개인정보 수정</span>
	    </div>
	  </nav>
	
	  <header style="padding-bottom: 100px; padding-top: 60px; height: 678px;">
	    <div class="container h-70">
	      <div class="row h-70">
	        <div class="col-lg-7 my-auto">
	          <div class="header-content mx-auto">
	          <section class="contact bg-light" id="contact" style="padding-top: 30px; padding-bottom: 30px;">
					<form  class="needs-validation" id="modifyForm" method="post">              
			              <div class="form-inline form-group" style="height: 60px;">
			                <label class="col-sm-3" for="member_name" style="font-size:1.2em;display:inline;width: 180px;">이름 :</label>
			                <input type="text" class="form-control" id="member_name" name="member_name" value="${member.member_name }" style="width: 176px;" readonly>
			              </div>            
			
			            <div class="form-inline form-group" style="height: 60px; margin-bottom:0px;">
			              <label class="col-sm-3" for="member_id" style="font-size:1.2em;display:inline;width: 180px;">아이디 :</label>
			                <input type="text" class="form-control" id="member_id" name="member_id" value="${member.member_id }" style="width: 176px;" oninput="checkNick();" autofocus>
			                <input type="hidden" id="checkID" name="${member.member_id}" />
			                <small id="idInput" class="text-muted" style="padding-left: 30px;">
							      * 아이디는 8 ~ 15 영문자 또는 영문,숫자로 입력해주세요.
							</small>
			            </div>            
			            
			         	<div class="form-inline form-group" style="height: 60px;">
			                <label class="col-sm-3" for="member_ssn" style="font-size:1.2em;display:inline;width: 180px;">주민등록번호 :</label>
			                <input type="text" class="form-control" id="member_ssn" name="member_ssn" value="${member.member_ssn }" style="width: 176px;" readonly>
			             </div>
			
			            <div class="form-inline form-group" style="height: 60px; margin-bottom:0px;">
			                <label class="col-sm-3" for="member_email" style="font-size:1.2em;display:inline;width: 180px;">이메일 :</label>
			                <input type="text" class="form-control" id="member_email" name="member_email" value="${member.member_email }" style="width: 176px;">
			                <small id="passwordHelpInline" class="text-muted" style="padding-left: 50px;">
							      * 이메일 형식으로 맞추어 주세요.
							</small>
			             </div>
			
			           	<div class="form-inline form-group" style="height: 60px;">
			                <label class="col-sm-3" for="member_address" style="font-size:1.2em;display:inline;width: 180px;">임차 장소 :</label>
			                <input type="text" class="form-control" id="member_address" name="member_address" value="${member.member_address }" style="width: 176px;" readonly>
			             </div>
			            
			             <div class="form-inline form-group" style="height: 60px;">
			                <label class="col-sm-3" for="member_phone" style="font-size:1.2em;display:inline;width: 180px;">휴대폰 번호 :</label>
			                <input type="text" class="form-control" id="member_phone" name="member_phone" value="${member.member_phone }" style="width: 176px;">
			             </div>
			             
						<input type="hidden" class="pw" id="member_pwd" name="member_pwd" value="${member.member_pwd }">
			            
			            <small id="passwordHelpInline" class="text-muted" style="">
						      ※ 수정이 불가한 사항은 변경 요청 부탁 드립니다.
						</small>
						
			            <button type="button" class="btn btn-primary" style="width: 176px;height: 44px;font-size:large;margin-top: 20px;" onclick="goSubmit();">저장</button>    
			               
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
  
	function goSubmit(){
  	  	
  	  	modal({
  			type: 'confirm',
  			title : '개인정보 변경',
  			text : '정말 정보를 변경 하시겠습니까?',
  			callback : function(result){
  				if(result){
  					goModifySave();
  				}
  			}
  			
  		});	
		   
 	}
  
  function goModifySave(){
		var form = $("form[id='modifyForm']").serialize();
		
		$.ajax({
			url:"<%=request.getContextPath()%>/mypage/personal_information_modification/resident/test",
			type:'post',
			dataType:"text",
			data : $('form').serialize(),
			success:function(data){
				if(data == "SUCCESS"){
					modal({
			  			type: 'alert',
			  			title : '개인정보 수정',
			  			text : '개인정보 수정이 완료 되었습니다.',
			  		});	
				}else{
					modal({
			  			type: 'alert',
			  			title : '개인정보 수정',
			  			text : '개인정보 수정이 취소 되었습니다.',
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
		
	};

	function checkNick() {
		var id = $('input[name="member_id"]');
		var ids = $('input[name="member_id"]').val();
		var chk = $("input[id='checkID']").attr('name');
		
		if(!id.val()){
			alert("아이디를 입력하세요.");
			id.focus();
			return;
		}

		if(ids ==chk){
			$('#idInput').text("* 아이디는 8 ~ 15 영문자 또는 영문,숫자로 입력해주세요.").css('padding-left','30px');
		}else{
			$.ajax({
				url:"<%=request.getContextPath()%>/mypage/personal_information_modification/checkId",
				type:"get",
				data:{"id":id.val()},
				dataType:"json",
				success:function(data){
					if(data.result){
						$('input[name="checkID"]').attr("value", id.val());
						$('#idInput').text("사용 가능한 아이디 입니다.").css('padding-left','190px');
						return;
					}else{
						$('#idInput').text("중복된 아이디 입니다.").css('padding-left','190px');
					}
				},
				error:function(data){
					alert("서버오류로 인해 확인이 불가능 합니다.");
				}
			});
		}
		
		
	}
  </script>
</html>
