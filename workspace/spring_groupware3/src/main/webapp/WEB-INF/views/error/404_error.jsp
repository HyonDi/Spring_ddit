<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<meta name="robots" content="noindex,nofollow">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<title>잘못된 요청 페이지</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/css/font-awesome.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/css/garam-fonts.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/css/garam.min.css" class="ace-main-stylesheet" id="main-ace-style" />


<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/common/libs/jquery-cookie/jquery.cookie.js"></script>

<style>
div.logo{
	background-image:url('<%=request.getContextPath()%>/resources/images/logo_black.png');
	background-position:center;
	background-size:contain;
	background-repeat:no-repeat;
	
}
</style>
</head>

<body class="login-layout light-login">

<div class="main-container" style="margin-top:23px;">
	<div class="main-content">
		<div class="row">
			<div class="col-sm-10 col-sm-offset-1">
				<div class="login-container">
					<div class="center">
		
						<!-- Main content -->
				   		<section class="content">				
					      	<div class="error-page">					      	
					      						      		
						        <h2 class="headline blue">페이지를 찾을 수 없습니다.</h2>
						        <br/>
						
						        <div class="error-content">
						          <h4><i class="fa fa-warning red"></i>허용되지 않는 주소를 요청하셨습니다.</h4>
								  <br/>
						          <p>요청된 주소가 잘못되었거나 아직 제공되지 않는 기능입니다. <br/>문의사항은  
						             <a href="mailto:admin@khmsys.co.kr">관리자에게 메일</a>로 송부바랍니다.
						          </p>
								  <br/><br/>	
							       <form class="search-form">						            
						                <button type="button" name="submit" class="btn btn-sm btn-warning btn-flat"
						                		onclick="history.go(-1);">
						                	뒤로가기
						           	  	</button>
						            <!-- /.input-group -->
						          </form>
					        	</div>
					      	</div>
				    		<!-- /.error-page -->
				    	</section>
				    	<!-- /.content -->
				    	<br/><br/><br/>
				    	<div class="logo" style="width:200px;height:70px;margin:0 auto;"></div>
				    </div>
				 </div>
			</div>
		</div>
    </div>
</div>
  

</body>
</html>
