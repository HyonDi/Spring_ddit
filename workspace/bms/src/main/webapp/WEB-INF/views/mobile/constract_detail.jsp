<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html lang="en">

<head>

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

  <!-- Plugin CSS -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/mobile/device-mockups/device-mockups.min.css">

  <!-- Custom styles for this template -->
  <link href="<%=request.getContextPath()%>/resources/mobile/css/new-age.min.css" rel="stylesheet">

</head>

	<body id="page-top">
	
	  <!-- Navigation -->
	  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
	    <div class="container">
	    	<a class="navbar-brand js-scroll-trigger" style="color:black; display:inline;" href="javascript:location.href='<%=request.getContextPath()%>/constract/mobileList';"><ion-icon name="arrow-round-back" style="font-size: 30px; padding-right:20px" /></a>
	    	<span style="font-weight: bold; font-size:20px;">계약내역 상세</span>
	    </div>
	  </nav>
	
	  <header class="contact" style="height: 708px;">
		  <section class="cta" style="padding-bottom: 0px; padding-top: 0px;">
		    <div class="cta-content">
		     <div class="container h-120">
			    <div class="row align-items-center h-120">
			        <div class="col-6 mx-auto">
			            <div class="jumbotron" style="height: 652px;margin-top: 90px;width: 332px;margin-left: -80;">
							<form>
							 <div class="form-group">
							    <label for="exampleFormControlInput1">계약자</label>
							    <input type="text" class="form-control" value="${constract.member_name }" style="background-color:white;" readonly>
							  </div>
							  <div class="form-group">
							    <label for="exampleFormControlInput1">계약기간</label>
							    <input type="text" class="form-control" value="<fmt:formatDate value="${constract.constract_start_date}" pattern="yyyy-MM-dd"/>   ~   <fmt:formatDate value="${constract.constract_last_date}" pattern="yyyy-MM-dd" />" style="background-color:white;" readonly />
							  </div>
							  <div class="form-group">
							    <label for="exampleFormControlTextarea1">계약 유형</label>
							    <input type="text" class="form-control" value="${constract.constract_kind}" style="background-color:white;" readonly>
							  </div>
							</form>
							<input type="hidden" id="member_code" value="${constract.member_code}" />
							<input type="hidden" id="board_code" value="${constract.constract_code}" />
							<input type="hidden" id="board_sort_code" value="${constract.board_sort_code}" />
			            </div>
			        </div>
			    </div>
			 </div>
			</div>
		    <div class="overlay"></div>
		  </section>
	  </header>

	</body>
	
	  <!-- Bootstrap core JavaScript -->
  <script src="<%=request.getContextPath()%>/resources/mobile/vendor/jquery/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/resources/mobile/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="<%=request.getContextPath()%>/resources/mobile/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="<%=request.getContextPath()%>/resources/mobile/js/new-age.min.js"></script>
  
  <script src="https://unpkg.com/ionicons@4.5.10-0/dist/ionicons.js"></script>
  
  <script>
  	$(document).ready(function(){
  		var member_code = $("input[id='member_code']").val();
  		var board_code = $("input[id='board_code']").val();
  		var board_sort_code = $("input[id='board_sort_code']").val();
  		
  		$.ajax({
  			url : '<%=%>',
  			type : 'get',
  			data : {},
  			dataType : 'text',
  			
  			
  		});
  		
  	});
  </script>
	
</html>
