<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<link href="<%=request.getContextPath() %>/resources/css/schedule/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/schedule/css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/schedule/css/animate.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/schedule/css/style.css" rel="stylesheet">


<style>
.titleDiv{
		background : #e74c3c;
		color : white;
	}
	
#title{
		margin-left : 20px;
	}	
	
.subt{
	font-size : 14px;
	font-weight : bold;
}
#buttonDiv{
		text-align : right;
	}

.form-group{
	font-weight : bold;
	font-size : 15px;
}

.form-text{
	font-weight : normal;
	font-size : 13px;
	color : #83808C;
}

.idchkBtn{
	width : 40px;
}

.chkImg{
	width : 20px;
	height : 20px;
	float : right;
	margin : 10px;
}

.address{
	display : inline;
	width : 200px;
	margin : 10px;
}

#addressBtn{
	height : 30px;
}

#roadAddress{
	margin-left : 150px;
}

#inputFileName{
	height : 30px;
}
</style>
</head>
<body>
	<div class="titleDiv">
		<br/>
		<h1 id="title"> <b>입주자 등록</b> </h1>
		<br/>
	</div>
	<div class="ibox-content">
	<input type="hidden" value="0" id="formChk">
  <form role="form" action="<%=request.getContextPath()%>/member/addResident" method="post">
  	  <span class="subt">필수 입력 사항</span>
  	  <hr/>
      <div class="form-group  row"><label class="col-sm-2 col-form-label">아이디</label>
          <div class="col-sm-8"><input name="member_id" id="idInput" required="required" type="text" class="form-control inputHelp">
          <span class="form-text m-b-none" hidden="true">영문자로 시작하며 숫자를 포함해 9~15글자로 입력해주세요.</span></div>
          	<button id="idchkBtn" type="button" class="btn btn-danger btn-xs" onclick="CheckID();">중복확인</button>
          	<input type="hidden" id="checkID" name="checkID" />
          <img class="chkImg" id="idImg" alt="" src="" >
      </div>
      
      <div class="form-group  row"><label class="col-sm-2 col-form-label">이름</label>
          <div class="col-sm-8"><input name="member_name" id="nameInput" required="required" type="text" class="form-control inputHelp">
          <span class="form-text m-b-none" hidden="true">한글이름은 2~5글자, 영문이름은 5~20글자로 입력해주세요.</span></div>
          <img class="chkImg" id="nameImg" alt="" src="" >
      </div>
      
      
      <div class="form-group  row"><label class="col-sm-2 col-form-label">비밀번호</label>
          <div class="col-sm-9"><input name="member_pwd" id="pwdInput" required="required" type="password" class="form-control inputHelp">
          <span class="form-text m-b-none" hidden="true">비밀번호는 영문 소문자와 대문자, 숫자, 특수문자를 포함하는 9~15글자로 입력해주세요.</span></div>
          <img class="chkImg" alt="" src="" id="pwdImg">
      </div>
      <div class="form-group  row"><label class="col-sm-2 col-form-label">비밀번호 확인</label>
          <div class="col-sm-9"><input id="pwdchkInput" type="password" required="required" class="form-control inputHelp">
          <span class="form-text m-b-none" hidden="true">비밀번호와 일치하게 작성해주세요.</span></div>
          <img class="chkImg" alt="" src="" id="pwdchkImg">
      </div>
      <div class="form-group  row"><label class="col-sm-2 col-form-label">주민번호</label>
          <div class="col-sm-4"><input id="ssnA" required="required" type="text" class="form-control ssn"></div>-
          <div class="col-sm-4"><input id="ssnB" required="required" type="password" class="form-control ssn"></div>
          <img class="chkImg" alt="" src="" id="ssnImg">
          <input type="hidden" id="member_ssn" name="member_ssn">
      </div>
      <div class="form-group  row"><label class="col-sm-2 col-form-label">휴대폰번호</label>
          <div class="col-sm-3"><input id="phoneA" required="required" type="text" class="form-control phone"></div>-
          <div class="col-sm-3"><input id="phoneB" required="required" type="text" class="form-control phone"></div>-
          <div class="col-sm-3"><input id="phoneC" required="required" type="text" class="form-control phone"></div>
          <img class="chkImg" alt="" src="" id="phoneImg">
          <input type="hidden" id="member_phone" name="member_phone">
      </div>
      <div class="form-group  row"><label class="col-sm-2 col-form-label">특이사항</label>
          <div class="col-sm-8"><input name="member_significant" id="significantInput" type="text" class="form-control inputHelp">
          </div>
      </div>
      <div class="form-group  row"><label class="col-sm-2 col-form-label">활성화</label>
         <%--  <div class="col-sm-8"><input name="member_enabled" id="enabledInput" type="text" class="form-control inputHelp">
          </div> --%>
          <div class="switch">
              <div class="onoffswitch">
                  <input type="checkbox" name="enabledStr" checked class="onoffswitch-checkbox" id="example1">
                  <label class="onoffswitch-label" for="example1">
                      <span class="onoffswitch-inner"></span>
                      <span class="onoffswitch-switch"></span>
                  </label>
              </div>
          </div>
          
      </div>
      
      <br/><br/>
      
      <span class="subt">사용자 입력 사항</span>
      <hr/>
      <div id="addressstart" class="form-group  row"><label class="col-sm-2 col-form-label">주소</label>
      	<div>
            <input class="form-control address" name="member_address" type="text" id="postcode" placeholder=" ex) 101호 ">
		</div>
		 
      </div>
      <div class="form-group  row"><label class="col-sm-2 col-form-label">이메일</label>
          <div class="col-sm-9"><input name="member_email" id="emailInput" type="email" class="form-control"></div>
          <img class="chkImg" alt="" src="" id="emailImg">
      </div>
      <!-- <파일업로드........사진............... -->
      <div class="form-group  row"><label class="col-sm-2 col-form-label">사진</label>
      <input type="hidden" name="picture">
		<%-- <div class="input-group mb-3"> --%>
			
			<div class="mailbox-attachments clearfix" style="text-align: center;">
				<div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 1px solid gray; height: 250px; width: 200px; margin: 10px 0px 0px 10px;"></div>
				<div class="mailbox-attachment-info" style="margin-left:-60px">
					<div class="input-group input-group-sm" style="padding-top: 10px">
						<label for="inputFile" class=" btn btn-warning btn-sm btn-flat input-group-addon">파일선택</label>
						<input id="inputFileName" class="form-control" type="text" name="picture"> <span class="input-group-append-sm">
							<button type="button" class="btn btn-warning btn-sm btn-flat input-group-addon" onclick="upload_go();">업로드</button>
						</span>
					</div>
				</div>
			</div>
			<br>
		<%-- </div> --%>
		</div>
      <!-- 파일업로드> -->
      
      
      <input type="hidden" id="member_authority" name="member_authority" value="manager">
      <input type="hidden" id="member_up_code" name="member_up_code" value="${owner.member_code}">
      
     <div id="buttonDiv" >
	<br/>
		<button id="registBtn" type="button" class="btn btn-outline btn-success">등&emsp;록</button>
		<button type="button" class="btn btn-outline btn-default" onclick="closeDoc();">취&emsp;소</button>
	</div>  
    </form>
</div>
<form role="imageForm" action="<%=request.getContextPath()%>/member/picture" method="post"
		enctype="multipart/form-data">
		<input id="inputFile" name="pictureFile" type="file" class="form-control" style="display: none;"> 
		<input id="oldFile" type="hidden" name="oldPicture" value="" /> 
		<input type="hidden" name="checkUpload" value="0" />
</form>


<%-- 
<form role="imageAnimalForm" action="<%=request.getContextPath()%>/member/picture" method="post"
		enctype="multipart/form-data">
		<input id="inputFile" name="pictureFile" type="file" class="form-control" style="display: none;"> 
		<input id="oldFile" type="hidden" name="oldPicture" value="" /> 
		<input type="hidden" name="checkUpload" value="0" />
</form>
 --%>


<%-- <script src="<%=request.getContextPath()%>/resources/login/vendor/select2/select2.min.js"></script> --%>
<%-- <script src="<%=request.getContextPath()%>/resources/login/js/main.js"></script> --%>
<%-- <script src="<%=request.getContextPath()%>/resources/login/vendor/bootstrap/js/bootstrap.min.js"></script> --%>
<!-- Mainly scripts -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/jquery-3.1.1.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/popper.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/bootstrap.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/inspinia.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/pace/pace.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script>

function CheckID() {
	var id = $('input[name="member_id"]');
	if(!id.val()){
		alert("아이디를 입력하세요.");
		id.focus();
		return;
	}
	
	var idreg = RegExp(/^[a-zA-Z][0-9a-zA-Z]{8,14}$/);
	if(!idreg.test($("#idInput").val())){
		alert("아이디는 영문자로 시작하며 숫자를 포함해 9~15글자로 입력해주세요.");
		id.focus();
		return;
	}
	
	$.ajax({
		url:"<%=request.getContextPath()%>/member/checkId",
		type:"get",
		data:{"id":id.val()},
		dataType:"json",
		success:function(data){
			if(data.result){
				$('input[name="checkID"]').attr("value", id.val());
				alert("사용가능 합니다.");
				$('#idImg').attr('src','<%=request.getContextPath()%>/resources/images/member/확인.png');
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


function upload_go(){
	//form 태그 양식을 객체화	
	var form = new FormData($('form[role="imageForm"]')[0]);
	
	if($('input[name="pictureFile"]').val()==""){
		alert("사진을 선택하세요.");
		$('input[name="pictureFile"]').click();
		return;
	};	

	$.ajax({
		url:"<%=request.getContextPath()%>/member/picture",
		data:form,
		type:'post',
		processData:false,
		contentType:false,
		success:function(data){
			$('input#oldFile').val(data);
			$('form[role="form"] > input[name="picture"]').val(data);
			$('input[name="checkUpload"]').val(1);
			alert("사진을 업로드 했습니다.");
		}
	});
	
}
$('#registBtn').on('click', function(e) {
	$('#member_ssn').attr('value',$('#ssnA').val()+$('#ssnB').val());
	$('#member_phone').attr('value',$('#phoneA').val()+'-'+$('#phoneB').val()+'-'+$('#phoneC').val());
	$('#member_address').attr('value',$('#roadAddress').val()+'/'+$('#jibunAddress').val()+'/'+$('#detailAddress').val());
	
	
	var uploadCheck = $('input[name="checkUpload"]').val();
	if(!(uploadCheck>0)){
 		//alert("사진을 업로드 해주세요");	
		// 랜덤이미지소스 넘기기
		if (!confirm("사진 없이 등록하시겠습니까?")) return false;
		
		// ----------------------------------------------------------------
		
	<%-- 	var form = new FormData($('form[role=""imageAnimalForm""]')[0]);
		
 		$.ajax({
		url:"<%=request.getContextPath()%>/member/picture",
		data:form,
		type:'post',
		processData:false,
		contentType:false,
		success:function(data){
			$('input#oldFile').val(data);
			$('form[role="form"] > input[name="picture"]').val(data);
			$('input[name="checkUpload"]').val(1);
			//alert("사진을 업로드 했습니다.");
		} 
	});
	--%>
		// ----------------------------------------------------------------
		
	}
/* 	
	var uploadCheck = $('input[name="checkUpload"]').val();
	if(!(uploadCheck>0)){
		alert("사진을 업로드 해주세요");	
		//$('input[name="pictureFile"]').click();
		return;
	} */
	
	/* if($('input[name="item_name"]').val()==""){
		alert("이름을 입력해주세요");
		return;
	} 
		
	if($('input[name="item_price"]').val()==""){
		alert("가격을 입력해주세요");
		return;
	}	
	
	
	if($('input[name="item_cnt"]').val()==""){
		alert("가격을 입력해주세요");
		return;
	}*/
	
	// null 체크를 해야하는데 어떻게할까 
	
	var form = $('form[role="form"]'); 
	form.submit();
	//goSubmit('post','');
});

$('input#inputFile').on('change',function(event){
	$('input[name="checkUpload"]').val(0);
	
	var fileFormat=
		this.value.substr(this.value.lastIndexOf(".")+1).toUpperCase();
	//이미지 확장자 jpg 확인
	if(fileFormat!="JPG"){
		alert("이미지는 jpg 형식만 가능합니다.");
		return;
	} 
	//이미지 파일 용량 체크
	if(this.files[0].size>1024*1024*1){
		alert("사진 용량은 1MB 이하만 가능합니다.");
		return;
	};
	
	
	document.getElementById('inputFileName').value=this.files[0].name;
	
	if (this.files && this.files[0]) {
		
        var reader = new FileReader();
        
        reader.onload = function (e) {
        	//이미지 미리보기	        	
        	$('div#pictureView')
        	.css({'background-image':'url('+e.target.result+')',
				  'background-position':'center',
				  'background-size':'cover',
				  'background-repeat':'no-repeat'
        		});
        }
        
        reader.readAsDataURL(this.files[0]);
	}
});

$(document).ready(function(){
	
	 $('.inputHelp').focusin(function(){
		$(this).next('span').attr("hidden",false);
	})
	
	$('.inputHelp').focusout(function(){
		$(this).next('span').attr("hidden",true);
	}) 
	
	// 아이디정규식>
	idreg = RegExp(/^[a-zA-Z][0-9a-zA-Z]{8,14}$/);
	/* pwdreg = RegExp(/^[a-zA-Z][0-9a-zA-Z]{8,14}$/);*/ 
	pwdreg = RegExp(/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&]).{8,15}$/);
	phoneAreg = RegExp(/^\d{3}$/);
	phoneBreg = RegExp(/^\d{4}$/);
	phoneCreg = RegExp(/^\d{4}$/);
	mailreg= RegExp(/^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.[a-zA-Z0-9]+){1,2}$/);
	ssnAreg = RegExp(/^\d{6}$/);
	ssnBreg = RegExp(/^\d{7}$/);
	namereg = RegExp(/^[가-힣]+|^[a-zA-Z]+/);//한글또는 영문으로 시작했는가?
	rkor = RegExp(/^[가-힣]{2,5}$/); 
	reng = RegExp(/^[a-zA-Z]{5,20}$/); 
	
	 // 아이디유효성
	$("#idInput").on("propertychange change keyup paste input", function() {
	   /* 중복확인 한 다음 바뀌었는지 안바뀌었는지 써야하는 내용. 
	   var currentVal = $(this).val();
	    if(currentVal == oldVal) {
	        return;
	    }
	 
	    oldVal = currentVal;
	    alert("changed!"); */
		if(!idreg.test($("#idInput").val())){ 
			//alert("형식에 맞게 입력해주세요"); 
			 $('#idImg').attr('src','<%=request.getContextPath()%>/resources/images/member/X.png');
			//$("#idInput").focus(); 
			//return false; 
		}else{
			$('#idImg').attr('src','<%=request.getContextPath()%>/resources/images/member/회색확인.png');
		}
	});
	 
	// 이름 유효성
	$("#nameInput").on("propertychange change keyup paste input", function() {
		if(!namereg.test($("#nameInput").val())){ 
			 $('#nameImg').attr('src','<%=request.getContextPath()%>/resources/images/member/X.png');
		}else{
			if(rkor.test($("#nameInput").val())){// 한글일때 길이
				$('#nameImg').attr('src','<%=request.getContextPath()%>/resources/images/member/확인.png');
			}else if(reng.test($("#nameInput").val())){ // 영문일때 길이
				$('#nameImg').attr('src','<%=request.getContextPath()%>/resources/images/member/확인.png');
			}else{
				$('#nameImg').attr('src','<%=request.getContextPath()%>/resources/images/member/X.png');
			}
		}
	});
	
	 // 비밀번호 유효성
	$("#pwdInput").on("propertychange change keyup paste input", function() {
		if(!pwdreg.test($("#pwdInput").val())){ 
			//alert("형식에 맞게 입력해주세요"); 
			 $('#pwdImg').attr('src','<%=request.getContextPath()%>/resources/images/member/X.png');
			//$("#idInput").focus(); 
			//return false; 
		}else{
			$('#pwdImg').attr('src','<%=request.getContextPath()%>/resources/images/member/확인.png');
		}
	});
	 
	// 비밀번호 체크
	$("#pwdchkInput").on("propertychange change keyup paste input", function() {
		if($("#pwdInput").val()!=$("#pwdchkInput").val()){ 
			//alert("형식에 맞게 입력해주세요"); 
			 $('#pwdchkImg').attr('src','<%=request.getContextPath()%>/resources/images/member/X.png');
			//$("#idInput").focus(); 
			//return false; 
		}else{
			$('#pwdchkImg').attr('src','<%=request.getContextPath()%>/resources/images/member/확인.png');
		}
	});
	
	//휴대폰번호 유효성
	$(".phone").on("propertychange change keyup paste input", function() {
		if(!phoneAreg.test($("#phoneA").val())||!phoneBreg.test($("#phoneB").val())||!phoneCreg.test($("#phoneC").val())){ 
			//alert("형식에 맞게 입력해주세요"); 
			 $('#phoneImg').attr('src','<%=request.getContextPath()%>/resources/images/member/X.png');
			//$("#idInput").focus(); 
			//return false; 
		}else{
			$('#phoneImg').attr('src','<%=request.getContextPath()%>/resources/images/member/확인.png');
		}
	});
	
	 // 이메일 유효성
	$("#emailInput").on("propertychange change keyup paste input", function() {
		if(!mailreg.test($("#emailInput").val())){ 
			//alert("형식에 맞게 입력해주세요"); 
			 $('#emailImg').attr('src','<%=request.getContextPath()%>/resources/images/member/X.png');
			//$("#idInput").focus(); 
			//return false; 
		}else{
			$('#emailImg').attr('src','<%=request.getContextPath()%>/resources/images/member/확인.png');
		}
	});
	 
	//주민번호 유효성
	$(".ssn").on("propertychange change keyup paste input", function() {
		if(!ssnAreg.test($("#ssnA").val())||!ssnBreg.test($("#ssnB").val())){ 
			//alert("형식에 맞게 입력해주세요"); 
			 $('#ssnImg').attr('src','<%=request.getContextPath()%>/resources/images/member/X.png');
			//$("#idInput").focus(); 
			//return false; 
		}else{
			$('#ssnImg').attr('src','<%=request.getContextPath()%>/resources/images/member/확인.png');
		}
	});
})
	
	
// 주소찾기
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
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById("roadAddress").value = roadAddr;
            document.getElementById("jibunAddress").value = data.jibunAddress;
            
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

function closeDoc() {
	//$(window).unbind("beforeunload");
	
	if ( window.opener ) {
		window.close();
	} else {
		try {
	 		var ifrm = $(window.frameElement).parent();
	 		var mdiv = ifrm.parent();
	 		mdiv.remove();
		} catch(e) {
			//alert( ifrm );
		}
	}
}
	

</script>
</body>
</html>