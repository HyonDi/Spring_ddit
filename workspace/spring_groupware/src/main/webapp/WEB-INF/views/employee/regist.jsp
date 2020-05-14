<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<head>
<title>임직원 등록</title>
<style type="text/css" id="fontFamilyStyleSheet">
body { 
	font-family: 'Malgun Gothic', sans-serif !important; 
}
.fileDrop{
	width:90%;
	height:100px;
	border:1px dotted gray;
	margin:auto;
}
select:disabled {
	background: lightgray;
  	border:1px solid gray; 
}
  	
div#picturePreView{
	height:140px;
	width:100%;
	margin:3px auto;	  		
	border : 1px solid lightgray;  		
}
</style>
</head>
<body >
	<!-- Page Path Begins -->
	<div class="breadcrumbs" id="breadcrumbs">
		<ul class="breadcrumb">
			<li>
				<i class="ace-icon fa fa-comments-o home-icon bigger-150"></i>
					임직원관리
			</li>
			<li class="active">
					임직원등록
			</li>
		</ul>		
	</div>
	<!-- Page Path Ends -->
	
	<!-- Page Content Begins -->
	<div class="page-content" style="padding-bottoms:8px;min-width:400px;">
	
		<!-- 상단 우측버튼 -->
		<div class="row">
			<div class="wizard-actions">
				<button type="button" class="btn btn-sm btn-white btn-bold" onclick="goSubmit('post');">
					<i class="red ace-icon fa fa-check bigger-120"></i><b>등록</b>
				</button>
				<button type="button" class="btn btn-sm btn-white btn-bold" onclick="javascript:goSubmit('close');">
					<i class="grey ace-icon fa fa-times bigger-120"></i><b>닫기</b>
				</button>
			</div>
		</div>
		<!-- 상단 우측버튼 -->
		
	<!-- <body style="margin:1px;"> -->
	
		<form role="form" id="registForm" class="form-horizontal" action="regist" method="post" enctype="multipart/form-data">
			<div class="hr_line">&nbsp;</div><br/><br/>
			<div class="col-xs-12 text-center" style="background:gray;color:white;" >개인 인적 사항</div>	
			<br/><br/>
			<div class="wrapper">
				<div class="col-xs-4 col-sm-2 control-label bolder g_label form-group">
					<div  role="picture">
						<div id="picturePreView"></div>
						<label for="picture"  class="btn btn-xs btn-info" style="width:110px;margin-bottom:2px;">사진등록</label>
						<input type="file" id="picture" name="picture" style="display:none;"/> 
					</div>
				</div>
				<div class="col-xs-8 col-sm-10" style="padding-left:0;">
					<div class="form-group">
						<label for="writer" class="col-xs-4 col-sm-2 control-label bolder g_label required">
						등록자</label>
						<div class="col-xs-8 col-sm-10 g_value">	
							<div class="checkbox" style="inline;">				
								<span class="label">사원번호 : ${loginUser.eno } | 이름 : ${loginUser.name }</span>				
							</div>
							<input id="regist" name="register" type="hidden" value="${loginUser.id }" />			
						</div>		
					</div>
					<div class="form-group">
						<label for="phone_p" class="col-xs-4 col-sm-2 control-label bolder g_label required">아이디</label>
						<div class="col-xs-8 col-sm-4 g_value">				
							<input class="col-sm-7" id="id" name="id" type="text" maxlength="20" 
									 onkeyup="this.value=this.value.replace(/[ㄱ-ㅎㅏ-ㅣ가-힣  ~!@#$%^&*()_+|<>?:{}\- ]/g, '');" 
									 placeholder="중복확인  필수" value="" />
							<input type="hidden" name="checkID" value="" />
							<button type="button" class="col-sm-4 btn btn-xs btn-info" style="margin-left:2px;" onclick="CheckID();">중복확인</button>			
						</div>		
						<label for="pwd" class="col-xs-4 col-sm-2 control-label bolder g_label required">패스워드</label>
						<div class="col-xs-8 col-sm-4 g_value">													
								<input class="col-sm-12" id="pwd" name="pwd" type="password" maxlength="20"							    
									   placeholder="암호를 입력하시오" value=""/>
														
						</div>
					</div>	
					<div class="form-group">
						<label for="name" class="col-xs-4 col-sm-2 control-label bolder g_label required">이&nbsp;&nbsp;름</label>
						<div class="col-xs-8 col-sm-4 g_value">				
							<input class="col-sm-12" id="name" name="name" type="text" value="" />			
						</div>		
						<label for="ssn1" class="col-xs-4 col-sm-2 control-label bolder g_label required">주민번호</label>
						<div class="col-xs-8 col-sm-4 g_value">													
								<input class="col-xs-5" id="ssn1" name="ssn" type="text" placeholder="앞 6자리" maxlength="6"
								       onkeyup="this.value=this.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣 a-z A-Z]/g, '');"/>
								<span class="col-xs-2">-</span>
								<input class="col-xs-5" id="ssn2" name="ssn" type="text" placeholder="뒤 7자리" maxlength="7"
									   onkeyup="this.value=this.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣 a-z A-Z]/g, '');"/>								
						</div>
					</div>
					<div class="form-group">
						<label for="phone_p" class="col-xs-4 col-sm-2 control-label bolder g_label required">휴대전화</label>
						<div class="col-xs-8 col-sm-4 g_value">				
							<input class="col-sm-12" id="phone_p" name="phone_p" type="text" maxlength="11" 
									 onkeyup="this.value=this.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣 a-z A-Z ~!@#$%^&*()_+|<>?:{}\- ]/g, '');" 
									 placeholder="' - ' 없이 입력하시오" value="" />			
						</div>		
						<label for="phone_c" class="col-xs-4 col-sm-2 control-label bolder g_label">집전화</label>
						<div class="col-xs-8 col-sm-4 g_value">													
								<input class="col-sm-12" id="phone_c" name="phone_c" type="text" maxlength="9"  
									   onkeyup="this.value=this.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣 a-z A-Z ~!#$%^&*()_+|<>?:{}\- ]/g, '');" 
									   placeholder="' - ' 없이 입력하시오" value=""/>
														
						</div>
					</div>	
					<div class="form-group">
						<label for="email" class="col-xs-4 col-sm-2 control-label bolder g_label required">이메일</label>
						<div class="col-xs-8 col-sm-10 g_value">				
							<input class="col-sm-4" id="email" name="email" type="text"  
									 onkeyup="this.value=this.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣  ~!#$@%^&*()_+|<>?:{}\- ]/g, '');" 
									 placeholder="아이디를 입력하시오" value="" />&nbsp;&nbsp;@&nbsp;&nbsp;
							<select name="email" >
								<option value="">-- 계정선택 --</option>
								<option value="gmail.com">gamil.com</option>
								<option value="naver.com">naver.com</option>
								<option value="hanmail.net">hanmail.net</option>
								<option value="daum.net">daum.net</option>		
								<option value="yahoo.com">yahoo.com</option>				
								
							</select>		
							&nbsp;&nbsp;<input type="checkbox" id="directInput"><label for="directInput">직접입력</label>
						</div>				
					</div>			
				</div>
			</div>	
			<div class="wrapper row">		
				<div class="col-sm-12">
					<div class="form-group" >
						<label for="address" class="col-xs-4 col-sm-2 control-label bolder g_label" style="height:102px;line-height:92px;">							
							주&nbsp;&nbsp;&nbsp;소							
						</label>
						<div class="form-group col-xs-8 col-sm-10 g_value">
							<div class="col-sm-12 no-padding " style="margin-bottom:3px;">
								<input id="postCode" class="text-center" name="postCode" type="text" readonly placeholder="우편번호" />
								<input type="button" class="btn btn-xs btn-info" id="searchAddr" onclick="SearchAddress();" value="주소검색" /><br/>
							</div>
							<div class="col-sm-12 no-padding" style="margin-bottom:3px;">
								<input id="address[0]" type="text" name="address1" readonly onclick="$('#searchAddr').click();" style="width:100%;"/>								
							</div>
							<div class="col-sm-12 no-padding" style="margin-bottom:3px;">
								<div class="col-sm-2 no-padding" style="line-height:16px;">								
									<label class="label" style="width:100%;margin-top:5px;">나머지주소</label>
								</div>																					
								<div class="col-sm-7 no-padding" >
									&nbsp;<input id="address[1]" type="text" name="address2" style="width:95%;"/>
								</div>
							</div>
							
						</div>											
					</div>						
					<br/>
					<div class="col-xs-12 text-center" style="background:gray;color:white;" >회사 소속 사항</div>
					<br/><br/>
					<!-- 회사 내역 -->		
					<div class="form-group">				
						<label for="dept" class="col-xs-4 col-sm-2 control-label bolder g_label required">
							부&nbsp;&nbsp;&nbsp;서</label>
						<div class="col-xs-8 col-sm-4 g_value">			
							<select name="dept_no" style="width:100%;center;text-align-last: center;" required >
								<option value=""  > --- 선 택 --- </option>
								<c:forEach var="dept" items="${deptList }">	
								<option value="${dept.dept_no }" >${dept.dept_name }</option>
								</c:forEach>				
							</select>
						</div>
						<label for="position" class="col-xs-4 col-sm-2 control-label bolder g_label required">
							직&nbsp;&nbsp;&nbsp;위</label>
						<div class="col-xs-8 col-sm-4 g_value">			
							<select name="posi_no" style="width:100%;text-align-last: center;" required >
								<option value="" > --- 선 택 --- </option>
								<c:forEach var="position" items="${positionList }">	
								<option value="${position.posi_no }" >${position.posi_name }</option>
								</c:forEach>				
							</select>
						</div>		
						
					</div>	
					<div class="form-group" >
						<label for="eno" class="col-xs-4 col-sm-2 control-label bolder g_label required">사원번호</label> 
						<div class="col-xs-8 col-sm-4 g_value">
							<input type="text" id="eno" name="eno" placeholder="클릭 후 자동완성" style="text-align:center;width:100%;"/>
						</div>
						<label for="regDate" class="col-xs-4 col-sm-2 control-label bolder g_label required">입사날짜</label> 
						<div class="col-xs-8 col-sm-4 g_value">
							<input type="text" id="regDate" name="regDate" readonly placeholder="" style="text-align:center;width:100%;"/>
						</div>
					</div>
					
					<div class="form-group">											
						<label class="col-xs-4 col-sm-2 control-label bolder g_label" style="height:79px;">
							경력사항
							<button type="button" class="btn btn-xs btn-info" style="width:100%;" onclick="RegistCareer();">추가</button>
						</label>						
						<div class="col-xs-8 col-sm-10 g_value row">							
							<div class="col-sm-2" id="coName" style="padding:2px 1px;">
								<label class="label" style="width:100%;">회사명</label>													
							</div>
							<div class="col-sm-4" id="job" style="padding:2px 1px;" >
								<label class="label" style="width:100%;">주요업무</label><br/>
							</div>
							<div class="col-sm-1" id="dept" style="padding:2px 1px;" >
								<label class="label" style="width:100%;">부서</label><br/>								
							</div>  
							<div class="col-sm-1" id="position" style="padding:2px 1px;" >
								<label class="label" style="width:100%;">직위</label><br/>								
							</div> 
							<div class="col-sm-3" id="year" style="padding:2px 1px;" >
								<label class="label" style="width:100%;">업무기간</label>								
							</div>
							<div class="col-sm-1 text-center" id="remove" style="padding:2px 1px;" >
								<label class="label" style="width:100%;">삭제</label><br/>								
							</div>
							<div class="career"></div>							
						</div>
					</div>
					<div class="form-group"></div>	
					<div class="form-group uploadFile ">						
						<label class="col-xs-4 col-sm-2 control-label bolder g_label">
							<i class="ace-icon fa fa-folder-open" style="font-size:16px;"></i>
							<span>첨부서류</span>							
						</label>
						<div class="col-sm-10 g_value" data-role="attach">
							<div class="col-sm-4" style="padding:2px 1px;">								
								<label for="licenseDoc" class="label" style="width:100%;">주민등록등본</label>	
								<div class="input-group">							
									<input class="col-sm-12 no-padding" type="file" id="licenseDoc" name="licenseDoc"/>
									<span class='input-group-btn'>
										<button class="btn btn-xs btn-danger" type='button' data-role="licenseDoc"  ><b>X</b></button>
									</span>
								</div>
							</div>
							<div class="col-sm-4" style="padding:2px 1px;">								
								<label for="graduDoc" class="label" style="width:100%;">졸업증명서</label>	
								<div class="input-group">							
									<input class="col-sm-12 no-padding" type="file" id="graduDoc" name="graduDoc" />
									<span class='input-group-btn'>
										<button class="btn btn-xs btn-danger" type='button' data-role="graduDoc" ><b>X</b></button>
									</span>
								</div>
							</div>
							<div class="col-sm-4" style="padding:2px 1px;">								
								<label for="scoreDoc" class="label" style="width:100%;">성적증명서</label>	
								<div class="input-group">							
									<input class="col-sm-12 no-padding" type="file" id="scoreDoc" name="scoreDoc" />
									<span class='input-group-btn'>
										<button class="btn btn-xs btn-danger" type='button' data-role="scoreDoc" ><b>X</b></button>
									</span>
								</div>
							</div>
										
						</div>
					</div>					
					<div class="form-group">
						<label for="title" class="col-xs-4 col-sm-2 control-label bolder g_label" style="height:103px;line-height:80px;">비&nbsp;&nbsp;&nbsp;고</label>
						<div class="col-xs-8 col-sm-10 g_value">
							<textArea id="remark" name="remark" onkeydown="CheckTextCount(this, 200);" style="width:103%;height:90px;"></textArea>
						</div>
						<br/>
					</div>  
					
				</div>					
			</div>	
		</form>
	</div>
<%-- <%@ include file="regist_js.jsp" %> --%>
<!-- 이거(regist_js.jsp) 만들어오기! -->

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	/* <자잘한것 */
	$('#directInput').on("click",function(){
		//alert($("#directInput").prop("checked"));
		if($("#directInput").prop("checked")){
			// 체크돼있으면 selectbox를 input type=text로 바꿔야하는거아냐?
			// 아니면 아예 안보이게 골뱅이도없애던가
			// $("select[name=email]").prop('disabled',true);
			var input = $('<input>').attr({"type":"text","name":"email","class":"newInput"}).css("width","100px").css("margin-right","12px");
			$("select[name='email']").hide();
			$(this).before(input);
			
		}else{
			// $("select[name=email]").prop('disabled',false);
			$("select[name='email']").show();
			$("input[class='newInput']").remove();
		}
		
	});
	
	function RegistCareer(){
		/* if($('input[name="uploadFile"]').length >=5){
			alert("파일추가는 5개까지만 가능합니다.");
			return;
		} */
		//alert("RegistCareer()");
		
		var input=$('<input>').attr({"type":"text","name":"coName"}).css("display","inline").addClass("col-sm-2");
		var input2=$('<input>').attr({"type":"text","name":"job"}).css("display","inline").addClass("col-sm-4");
		var input3=$('<input>').attr({"type":"text","name":"dept"}).css("display","inline").addClass("col-sm-1");
		var input4=$('<input>').attr({"type":"text","name":"position"}).css("display","inline").addClass("col-sm-1");
		var input5=$('<input>').attr({"type":"text","name":"year"}).css("display","inline").addClass("col-sm-3");
		 
		var div=$('<div>').addClass("inputRow");
		div.append(input);
		div.append(input2);
		div.append(input3);
		div.append(input4);
		div.append(input5).append("<button style='border:0;outline:0;' id='careerDel' class='btn btn-xs btn-danger col-sm-1' type='button'>X</button");
		div.appendTo('.career');
	}
	
	$('#careerDel').on('click',)
	
	$(document).on("click",'#careerDel', function(){
		// inputrow 를 삭제해야함.
		$(this).parent().remove();
	})
	
	/* 자잘한것> */
	
	/* <전송 */
	function goSubmit(type){
		
	}
	/* 전송> */
	
	//시작-종료일 비활성화
	/* function blarDate(id){
		$('#regDate').datepicker( "option", "minDate", $("#sDate").val() );
		 
		if (id == "regDate"){
		 	$('#regDate').datepicker( "option", "minDate", $("#sDate").val() );
		 }else if (id == "eDate"){
		  	$('#sDate').datepicker( "option", "maxDate", $("#eDate").val() );
		 }
	}
	 */
	
	
	
	$('input#picture').on('change', function(event){
		// alert("file select !");
		
		
		// alert($('input[name="checkUpload"]').val());
		
		// this = input#inputFile
		var fileFormat = this.value.substr(this.value.lastIndexOf(".") + 1).toUpperCase();
		// 이미지 확장자 jpg확인
		if(fileFormat != "JPG"){
			alert("이미지는 jpg 형식만 가능합니다.");
			return;
		};
		
		// 이미지 파일 용량 체크
			// 파일정보는 files[] 에 경로와 다른것들이 들어있는데,
			// files[0] 에 실제파일이 들어있다.
		// 얘는 file객체가아니고 input태그(input#inputFile) 에 들어있는 file을 얘기함.
		if(this.files[0].size>1024*1024*1){
			alert("사진 용량은 1MB 이하만 가능합니다.");
			return;
		};
		
	
		// 자바스크립트의 if문은 boolean이아니라 있는지/없는지 임.
		// 값이 없을 때(NaN, null , 1/0, false, undefined) false. 있을 때 true
		// 따라서 아래 if문 조건식은 this.files 가 있고, this.files[0] 이 있니? 하고 있는 것.
		if(this.files && this.files[0]) {
			
			
			// new fileReader : java의 흔적. 봄(돔,봄 javacript에있었음.)안에 있대.
			var reader = new FileReader();
			
			reader.onload = function(e) {
				// 이미지 미리보기
					// 백그라운드로 넣은이유? 이미지태그로넣으면 안좋아요. 크기와 비율이 다른 이미지를 늘리고 쪼그라트림.
					// 그리고 다운로드가 가능함.(이미지태그 넣으면. 백그라운드에넣으면 스크롤안에도 못넣으니 보안성^)
					// background-size 에서 cover는 짧은쪽을먼저 맞추고, 나머진 잘라버린다.
					// 'background-position' : 'center'  이미지를 가운데로.
					// 'background-repeat' : 'no-repeat' : 여백부분에 이미지가 반복됨. ( cover 하면 상관없음. )
				$('div#picturePreView').css({'background-image' : 'url(' + e.target.result + ')',
											'background-position' : 'center',
											'background-size' : 'cover',
											'background-repeat' : 'no-repeat'
				});
			}
			reader.readAsDataURL(this.files[0]);
		}
		
		
	});
	
	//주소검색
	$("#searchAddr").on('click', function(){
		
		new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
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
	            document.getElementById('postCode').value = data.zonecode;
	            document.getElementById("address[0]").value = roadAddr+"("+data.jibunAddress+")";
	            //document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
	            
	            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
	            /* if(roadAddr !== ''){
	                document.getElementById("sample4_extraAddress").value = extraRoadAddr;
	            } else {
	                document.getElementById("sample4_extraAddress").value = '';
	            } */
	
	            //var guideTextBox = document.getElementById("guide");
	            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
	            /* if(data.autoRoadAddress) {
	                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
	                guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
	                guideTextBox.style.display = 'block';
	
	            } else if(data.autoJibunAddress) {
	                var expJibunAddr = data.autoJibunAddress;
	                guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
	                guideTextBox.style.display = 'block';
	            } else {
	                guideTextBox.innerHTML = '';
	                guideTextBox.style.display = 'none';
	            } */
	        }
	    }).open();
	
	})
	
	// 입사날짜
	$("#regDate").on('click', function(){
		$(this).datepicker();
	})
	
	// 사원번호자동입력
	var cnt = 0;// 등록끝나면 +1 시킬거임.
	if(cnt < 10){
		cnt="0"+cnt;
	}
	
	$('#eno').on('click', function(){
		$('#eno').val("");
		
		var eno = ""+$("#regDate").val().split("-")[0]+
					 $("#regDate").val().split("-")[1]+
					 $("#regDate").val().split("-")[2]+
					 $("select[name=dept_no] option:selected").val()+
					 cnt;

		$(this).val(eno);
		
		cnt++; // 나중에 등록 이후로 바꿔야함.
	})
	
	
	// 이력추가
	$('#addFileBtn').on('click',function(event){
	
	if($('input[name="uploadFile"]').length >=5){
		alert("파일추가는 5개까지만 가능합니다.");
		return;
	}
	
	var input=$('<input>').attr({"type":"file","name":"uploadFile"})
	  .css("display","inline"); 
	var div=$('<div>').addClass("inputRow");
	div.append(input).append("<button style='border:0;outline:0;' class='badge bg-red' type='button'>X</button");
	div.appendTo('.fileInput');
	});


	$('div.fileInput').on('click','div.inputRow > button',function(event){
		$(this).parent('div.inputRow').remove();
	});
	
	$('.fileInput').on('change','input[type="file"]',function(event){
		if(this.files[0].size>1024*1024*40){
			alert("파일 용량이 40MB를 초과하였습니다.");
			this.value="";
			$(this).focus();
			return false;
		} 
	});
</script>
</body>



