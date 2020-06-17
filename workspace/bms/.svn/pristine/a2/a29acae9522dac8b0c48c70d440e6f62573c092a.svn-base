<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title></title>
</head>
<body>
<section class="content register-page" style="height: 586.391px; ">	<!-- form start -->
	<div class="register-box" style="width:600px;">
	<div class="card" style="width: 600px;margin-left:120px;margin-top:20px">
		<div class="register-card-body">
		<button type="button" id="registBtn" style="margin-bottom:30px;background:crimson;color:white;width:100px;float:right;margin:10px 10px 0px 10px;" class="btn btn-lg btn-crimson" onclick="closeWindow();">	
					<b>취소</b>
		</button>
		<button type="button" id="deleteBtn" style="margin-bottom:30px;background:crimson;color:white;width:100px;float:right;margin:10px 10px 0px 10px" class="btn btn-lg btn-crimson">	
					<b>삭제</b>
		</button>
		<button type="button" id="modifyBtn" style="margin-bottom:30px;background:crimson;color:white;width:100px;float:right;margin:10px 10px 0px 10px" class="btn btn-lg btn-crimson">	
					<b>수정</b>
		</button>
			<form role="form" class="form-horizontal" action="<%=request.getContextPath()%>/facility_stock/stock_management/regist" method="post" style="padding-top: 10px">
				<input type="hidden" name="picture">
				<div class="input-group mb-3">
					<div class="mailbox-attachments clearfix" style="text-align: center;">
						<div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 3px double pink; height: 180px; width: 300px; margin: 10px 0px 0px 140px;"></div>
						<div class="mailbox-attachment-info" style="margin-left:125px">
							
						</div>
					</div>
					<br>
				</div>

				<div class="wrap-input100 p-r-10 ">
					<input readonly="readonly" class="input100 has-val" id="email" type="text" name="item_name" value="${stock.item_name}">
					<span class="focus-input100"></span> <span class="label-input100">이름</span>
				</div>

				<div class="wrap-input100">
					<input readonly="readonly" class="input100 has-val" id="name" type="text" name="item_price" value="${stock.item_price}">
					<span class="focus-input100"></span> <span class="label-input100">가격</span>
				</div>

				<div class="wrap-input100">
					<input readonly="readonly" class="input100 has-val" id="phone" type="text" name="item_cnt" value="${stock.item_cnt}">
					<span class="focus-input100"></span> <span class="label-input100">수량</span>
				</div>

			</form>
		</div>
	</div>	
		<!-- register-card-body -->
	</div>
</section>
	<form name="postForm">
	<input type="hidden" name="item_code" value="${stock.item_code}" />
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
	<script>
	function closeWindow() {
		if (window.opener) {
			self.close();
		} else {
			var elem = window.frameElement.parentElement.parentElement;
			var className = elem.getAttribute("class") || elem.className || '';
			if (className.toLowerCase().indexOf("dhtmlwindow") > -1) {
				elem.outerHTML = "";
			}
		}
	}
	
	var imageURL = "<%=request.getContextPath()%>/facility_stock/stock_management/getPicture?picture=${stock.item_picture}";
	$('div#pictureView').css({'background-image':'url('+imageURL+')',
							  'background-position':'center',
							  'background-size':'cover',
							  'background-repeat':'no-repeat'
							});
	$('input').css("border","none").prop("readonly",true);
	
	$('#deleteBtn').on('click',function(e){
		var answer = confirm("이 상품을 삭제하시겠습니까?");
		if(answer){
			var form=$('form[name="postForm"]');
			form.attr({
				"action":"<%=request.getContextPath()%>/facility_stock/stock_management/delete",
				"method":"post"
			});
			form.submit();
		}
	});
	var form=$('form[name="postForm"]');
	$('#modifyBtn').on('click',function(e){
		form.attr({
			"action":"<%=request.getContextPath()%>/facility_stock/stock_management/modifyForm",
			"method":"post"
		});
		form.submit();
	});
	</script>
</body>
</html>