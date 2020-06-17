
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery-3.5.1.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>



</style>
<html>
<body>
	<div class="col-md-8 order-md-1">
          <h1 class="mb-3">개인 정보 수정</h1>         
          <form  class="needs-validation" id="modifyForm" method="post">              
              <div class="form-inline form-group ">
                <label class="col-sm-3" for="member_name" style="font-size:1.5em;">입주자 이름 :</label>
                <input type="text" class="form-control" id="member_name" name="member_name" value="${member.member_name }">
              </div>            

            <div class="form-inline form-group ">
              <label class="col-sm-3" for="member_id" style="font-size:1.5em;">입주자 아이디 :</label>
                <input type="text" class="form-control" id="member_id" name="member_id" value="${member.member_id }">
                <button type="button" class="btn btn-primary" onclick="CheckID();">중복 확인</button>
                <input type="hidden" id="checkID" name="checkID" />
            </div>            

             <div class="form-inline form-group ">
                <label class="col-sm-3" for="member_pwd" style="font-size:1.5em;">비밀번호 :</label>
                <input type="password" class="pw" id="member_pwd" name="member_pwd" value="${member.member_pwd }">
                <span>비밀번호를 입력해주세요</span>
             </div>  
              
             <div class="form-inline form-group ">
                <label class="col-sm-3" for="member_pwdCheck" style="font-size:1.5em;">비밀번호 확인 :</label>
                 <input type="password" class="pw" id="member_pwdCheck" name="member_pwdCheck" value="">
                 <span id="alert-success" style="display: none;">비밀번호가 일치 합니다.</span>
                 <span id="alert-danger" style="display: none; color: #d92742; font-weight: bold;">비밀번호가 일치하지 않습니다.</span>
             </div>

            
         	<div class="form-inline form-group ">
                <label class="col-sm-3" for="member_ssn" style="font-size:1.5em;">주민등록번호 :</label>
                <input type="text" class="form-control" id="member_ssn" name="member_ssn" value="${member.member_ssn }">
             </div>



            <div class="form-inline form-group ">
                <label class="col-sm-3" for="member_email" style="font-size:1.5em;">Email :</label>
                <input type="text" class="form-control" id="member_email" name="member_email" value="${member.member_email }">
             </div>

           <div class="form-inline form-group ">
                <label class="col-sm-3" for="member_address" style="font-size:1.5em; width:">주 소  :</label>
                <input type="text" style="width: 600px;" class="form-control" id="member_address" name="member_address" value="${member.member_address }">
                <input id="addressBtn" type="button" class="btn btn-outline btn-success" onclick="DaumPostcode()" value="우편번호찾기"/>
             </div>
            
            
             <div class="form-inline form-group ">
                <label class="col-sm-3" for="member_phone" style="font-size:1.5em;">휴대폰 번호 :</label>
                <input type="text" class="form-control" id="member_phone" name="member_phone" value="${member.member_phone }">
             </div>
            
            <hr>
            
            <button type="button" class="btn btn-success" onclick="goModifySave();">저장</button>  
            <button type="button" class="btn btn-danger" onclick="goRemove();">회원 탈퇴</button>  
               
          </form>
        </div>

</body>



<script>


	$('.pw').focusout(function(){

	var pwd1 = $("#member_pwd").val();
	var pwd2 = $("#member_pwdCheck").val();
	
	if(pwd1!="" &&pwd2== ""){
		null;
	}else if (pwd1!=""||pwd2!="") {
		if(pwd1 == pwd2){
			$("#alert-success").css('display','inline-block');
			$("alert-danger").css('display', 'none');
		}else{
			alert("비밀번호가 일치하지 않습니다 재확인해주세요");
			$("#alert-success").css('display', 'none');
			$("alert-danger").css('display', 'inline-block');
		}
	}
}); 



//주소찾기
function DaumPostcode() {	
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
//             document.getElementById('member_address').value = data.zonecode;
            document.getElementById("member_address").value = roadAddr

            
            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
            if(roadAddr !== ''){
                document.getElementById("extraAddress").value = extraRoadAddr;
            } else {
                document.getElementById("extraAddress").value = '';
            }
            
        }
    
    }).open({
    	autoClose: true
    });
            
}


 	function goRemove() {
 		if(confirm("정말 탈퇴하시겠습니까?") == true){
 			var userInput = prompt("비밀번호를 입력해 주세요");
 			var pwd = $("#member_pwd").val();
 			if(userInput == pwd){
	$.ajax({
		url:"<%=request.getContextPath()%>/mypage/personal_information_remove/resident/test",
		type:'post',
		dataType:"text",
		data : $('form').serialize(),
		success:function(data){
			if(data == "SUCCESS"){
				alert("탈퇴에 성공했습니다.");
				top.location.href = "<%=request.getContextPath()%>/commons/login"
			}else{
				alert("예상치 못한 오류로 탈퇴하지 못하였습니다.");
			}
		},
		error:function(){
			alert("일시적 서버오류가 발생했습니다.");
			}
		
		}); 
 			}else{
 				alert("비밀번호가 다릅니다. 다시 시도해주세요");
 				return false;
 			}
	
 		}else{
 			return false;
 		}
 	}
		
 	
	function goModifySave(){
		var form = $("form[id='modifyForm']").serialize();
		if(confirm("정말 수정하시겠습니까?") == true){		
		$.ajax({
			url:"<%=request.getContextPath()%>/mypage/personal_information_modification/resident/test",
			type:'post',
			dataType:" ",
			data : $('form').serialize(),
			success:function(data){
				if(data == "SUCCESS"){
					alert("수정에 성공했습니다.");
				}else{
					alert("예상치 못한 오류로 수정하지 못하였습니다.");
				}
			},
			error:function(){
				alert("일시적 서버오류가 발생했습니다.");
			}
			
		});
		
		}else{
			return false;
		}
		
	};

	function CheckID() {
		var id = $('input[name="member_id"]');
		if(!id.val()){
			alert("아이디를 입력하세요.");
			id.focus();
			return;
		}
		
		$.ajax({
			url:"<%=request.getContextPath()%>/mypage/personal_information_modification/checkId",
			type:"get",
			data:{"id":id.val()},
			dataType:"json",
			success:function(data){
				if(data.result){
					$('input[name="checkID"]').attr("value", id.val());
					alert("사용가능 합니다.");
					return;
				}else{
					alert("중복입니다.");
				}
			},
			error:function(data){
				alert("서버오류로 인해 확인이 불가능 합니다.");
			}
		});
	}

</script>

