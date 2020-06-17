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
	    	<span style="font-weight: bold; font-size:20px;">설정</span>
	    </div>
	  </nav>
	
	  <header style="padding-bottom: 100px; padding-top: 60px; height: 678px;">
	    <div class="container h-70">
	      <div class="row h-70">
	        <div class="col-lg-7 my-auto">
	          <div class="header-content mx-auto">
	          <section class="contact bg-light" id="contact" style="padding-top: 30px; padding-bottom: 30px;">
			    <div class="container">
			    <h4><ion-icon name="key"></ion-icon>개인정보 수정</h4>
			      <ul class="list-inline list-social">
			        <li class="list-inline-item social-twitter">
			          <a href="<%=request.getContextPath()%>/mypage/personal_information_modification/mobile/mypage_resident2">
			            <ion-icon name="contact"></ion-icon>
			            	<p>개인정보</p>
			          </a>
			        </li>
			        <li class="list-inline-item social-facebook">
			          <a href="<%=request.getContextPath()%>/mypage/personal_information_modification/mobile/mypage_resident3">
			            <ion-icon name="lock"></ion-icon>
			            	<p>비밀번호</p>
			          </a>
			        </li>
			      </ul>
			      <h4 style="padding-top: 50px;" ><ion-icon name="business"></ion-icon>건물위치 찾기</h4>
			      <ul class="list-inline list-social">
					<div id="map" style="width:350px;height:300px;"></div>
					<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ce33224ed9c72f079f74535ef28f9984"></script>
			      </ul>
			    </div>
			    </section>
	          </div>
	        </div>
	      </div>
	    </div>
	  </header>
	  
	  <footer>
	    <div class="container">
	      <p style="color:white;">주소 : 대전광역시 중구 대흥동 500 영민빌딩</p>
	      <a style="color:white;" href='tel:042-243-2025'>연락처 : 042-243-2025</a>
	    </div>
	  </footer>
	  
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
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(36.3248075,127.419786),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
		
		// 마커가 표시될 위치입니다 
		var markerPosition  = new kakao.maps.LatLng(36.3248075,127.419786); 

		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
		    position: markerPosition
		});

		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);
		
	</script>
	
</html>
