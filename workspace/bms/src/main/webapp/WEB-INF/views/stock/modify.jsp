<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/board/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/resources/login/images/icons/로고.JPEG" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/login/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/login/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/login/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/login/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/login/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/login/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/login/css/util.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/login/css/stockregist.css">
<!--===============================================================================================-->
</head>
<body>
<section class="content register-page" style="height: 586.391px; ">	<!-- form start -->
	<div class="register-box" style="width:600px;">
	<div class="card" style="width: 600px;margin-left:120px;margin-top:20px">
		<div class="register-card-body">
		<button type="button" style="margin-bottom:30px;background:crimson;color:white;width:100px;float:right;margin:10px 10px 0px 10px;" class="btn btn-lg btn-crimson" onclick="closeWindow();">	
					<b>취소</b>
		</button>
		<button type="submit" id="modifyBtn" style="margin-bottom:30px;background:crimson;color:white;width:100px;float:right;margin:10px 10px 0px 10px" class="btn btn-lg btn-crimson">	
					<b>수정</b>
		</button>
			<form role="form" class="form-horizontal" action="<%=request.getContextPath()%>/facility_stock/stock_management/modify" method="post" style="padding-top: 10px">
				<input type="hidden" name="picture" value="${stock.item_picture}">
				<input type="hidden" name="item_code" value="${stock.item_code}">
				<div class="input-group mb-3">
					<div class="mailbox-attachments clearfix" style="text-align: center;">
						<div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 3px double pink; height: 180px; width: 300px; margin: 10px 0px 0px 140px;"></div>
						<div class="mailbox-attachment-info" style="margin-left:125px">
							<div class="input-group input-group-sm" style="padding-top: 10px">
								<label for="inputFile" class=" btn btn-warning btn-sm btn-flat input-group-addon">파일선택</label>
								<input id="inputFileName" class="form-control" type="text" name="picture"> <span class="input-group-append-sm">
									<button type="button" class="btn-sm btn-append" onclick="upload_go();" style="background:crimson;color:white">업로드</button>
								</span>
							</div>
						</div>
					</div>
					<br>
				</div>

				<div class="wrap-input100 p-r-10 ">
					<input class="input100 has-val" id="name" type="text" name="item_name" value="${stock.item_name}">
					<span class="focus-input100"></span> <span class="label-input100">이름</span>
				</div>

				<div class="wrap-input100">
					<input class="input100 has-val" id="price" type="text" name="item_price" value="${stock.item_price}">
					<span class="focus-input100"></span> <span class="label-input100">가격</span>
				</div>

				<div class="wrap-input100">
					<input class="input100 has-val" id="cnt" type="text" name="item_cnt" value="${stock.item_cnt}">
					<span class="focus-input100"></span> <span class="label-input100">수량</span>
				</div>

			</form>
		</div>
	</div>	
		<!-- register-card-body -->
	</div>
</section>
	<form role="imageForm" action="<%=request.getContextPath()%>/facility_stock/stock_management/picture" method="post"
		enctype="multipart/form-data">
		<input id="inputFile" name="pictureFile" type="file" class="form-control" style="display: none;"> 
		<input id="oldFile" type="hidden" name="oldPicture" value="" /> 
		<input type="hidden" name="checkUpload" value="0" />
	</form>
	
	<script
		src="<%=request.getContextPath()%>/resources/login/vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script
		src="<%=request.getContextPath()%>/resources/login/vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script
		src="<%=request.getContextPath()%>/resources/login/vendor/bootstrap/js/popper.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/login/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script
		src="<%=request.getContextPath()%>/resources/login/vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script
		src="<%=request.getContextPath()%>/resources/login/vendor/daterangepicker/moment.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/login/vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script
		src="<%=request.getContextPath()%>/resources/login/vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/resources/login/js/main.js"></script>
	<script src="<%=request.getContextPath()%>/resources/board/js/stock.js"></script>
	<script type="text/javascript">
	var imageURL = "<%=request.getContextPath()%>/facility_stock/stock_management/getPicture?picture=${stock.item_picture}";
	$('div#pictureView').css({'background-image':'url('+imageURL+')',
							  'background-position':'center',
							  'background-size':'cover',
							  'background-repeat':'no-repeat'
							});
	$('#modifyBtn').on('click',function(e){
		var uploadCheck = $('input[name="checkUpload"]').val();
		if(uploadCheck!=1){			
			alert("사진 업로드는 필수입니다.");	
			return;
		}
		
		var form=$('form[role="form"]');	
		form.submit();
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

	function upload_go(){
		//form 태그 양식을 객체화	
		var form = new FormData($('form[role="imageForm"]')[0]);
		
		if($('input[name="pictureFile"]').val()==""){
			alert("사진을 선택하세요.");
			$('input[name="pictureFile"]').click();
			return;
		};	

		$.ajax({
			url:"<%=request.getContextPath()%>/facility_stock/stock_management/picture",
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
	
	</script>
</body>
</html>