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
		<h1 id="title"> <b>납부 등록</b> </h1>
		<br/>
	</div>
	<div class="ibox-content">
	<input type="hidden" value="0" id="formChk">
  <form role="form" action="<%=request.getContextPath()%>/contract_payment/payment_management_regist" method="post">
  	  <hr/>
      <div class="form-group  row"><label class="col-sm-2 col-form-label">납부 날짜</label>
          <div class="col-sm-8"><input name="payment_date" id="payment_date" type="date" class="form-control inputHelp">
          </div>
          <img class="chkImg" id="idImg" alt="" src="" >
      </div>
      
      <div class="form-group  row"><label class="col-sm-2 col-form-label">납부 금액</label>
          <div class="col-sm-8"><input name=payment_amount id="payment_amount" type="text" class="form-control inputHelp">
          </div>
          <img class="chkImg" id="nameImg" alt="" src="" >
      </div>
      
      
      <div class="form-group  row"><label class="col-sm-2 col-form-label">납부 방법</label>
          <div class="col-sm-9"><input name="payment_plan" id="payment_plan" type="text" class="form-control inputHelp">
          </div>
          <img class="chkImg" alt="" src="" id="pwdImg">
      </div>

      <div class="form-group  row"><label class="col-sm-2 col-form-label">납부 유형</label>
          <div class="col-sm-8"><input name="payment_type" id="payment_type" type="text" class="form-control inputHelp">
          </div>
      </div>
      <br/><br/>
      <div class="form-group  row"><label class="col-sm-2 col-form-label">납부인 코드</label>
          <div class="col-sm-9">
          		<select name="">
          			
          		</select>	
          </div>
          <img class="chkImg" alt="" src="" id="emailImg">
      </div>
      <!-- <파일업로드........사진............... -->
      <div class="form-group  row"><label class="col-sm-2 col-form-label">사진</label>
		<%-- <div class="input-group mb-3"> --%>
			
			<div class="mailbox-attachments clearfix" style="text-align: center;">
				<div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 1px solid gray; height: 250px; width: 200px; margin: 10px 0px 0px 10px;"></div>
				<div class="mailbox-attachment-info" style="margin-left:-60px">
					<div class="input-group input-group-sm" style="padding-top: 10px">
						<label for="inputFile" class=" btn btn-warning btn-sm btn-flat input-group-addon">파일선택</label>
						<input id="inputFileName" class="form-control" type="text" name="board_sort_code"> <span class="input-group-append-sm">
							<button type="button" class="btn btn-warning btn-sm btn-flat input-group-addon" onclick="upload_go();">업로드</button>
						</span>
					</div>
				</div>
			</div>
			<br>
		<%-- </div> --%>
		</div>
      <!-- 파일업로드> -->
     <div id="buttonDiv" >
	<br/>
		<button id="registBtn" type="button" class="btn btn-outline btn-success">등&emsp;록</button>
		<button type="button" class="btn btn-outline btn-default" onclick="closeDoc();">취&emsp;소</button>
	</div>  
    </form>
</div>
<form role="imageForm" action="<%=request.getContextPath()%>/contract_payment/picture" method="post"
		enctype="multipart/form-data">
		<input id="inputFile" name="pictureFile" type="file" class="form-control" style="display: none;"> 
		<input id="oldFile" type="hidden" name="oldPicture" value="" /> 
		<input type="hidden" name="checkUpload" value="0" />
</form>

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

function upload_go(){
	
	alert("test");
	//form 태그 양식을 객체화	
	var form = new FormData($('form[role="imageForm"]')[0]);
	
	if($('input[name="pictureFile"]').val()==""){
		alert("사진을 선택하세요.");
		$('input[name="pictureFile"]').click();
		return;
	};	

	$.ajax({
		url:"<%=request.getContextPath()%>/contract_payment/picture",
		data:form,
		type:'post',
		processData:false,
		contentType:false,
		success:function(data){
			$('input#oldFile').val(data);
			$('form[role="form"] > input[name="board_sort_code"]').val(data);
			$('input[name="checkUpload"]').val(1);
			alert("사진을 업로드 했습니다.");
		}
	});
	
}

$('#registBtn').on('click', function(e) {
	
	alert("test");
	
	var uploadCheck = $('input[name="checkUpload"]').val();
	if(!(uploadCheck>0)){
		alert("사진을 업로드 해주세요");	
		//$('input[name="pictureFile"]').click();
		return;
	}
	
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