<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>건축물 시설 관리 시스템</title>
	<!-- header -->
	<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
	 <link rel="stylesheet" href="https://d19m59y37dris4.cloudfront.net/universal/2-0-1/vendor/font-awesome/css/font-awesome.min.css">
	<link href="<%=request.getContextPath()%>/resources/bootstrap/tiles/header.css" rel="stylesheet">
	<!-- sidebar -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/bootstrap/tiles/sidebar.css" rel="stylesheet">
    <!-- footer -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
	<!-- Bootstrap core CSS -->
	<link href="<%=request.getContextPath()%>/resources/bootstrap/tiles/css/bootstrap.min.css" rel="stylesheet">
	<!-- Material Design Bootstrap -->
	<link href="<%=request.getContextPath()%>/resources/bootstrap/tiles/css/mdb.min.css" rel="stylesheet">
	<!-- Your custom styles (optional) -->
	<link href="<%=request.getContextPath()%>/resources/bootstrap/tiles/css/style.css" rel="stylesheet">
	

<!-- JS, Popper.js, and jQuery -->

<style type="text/css">
	  #header{            
            width:100%;
            height:auto;
            text-align: center;
            
        }
        #sidebar{
            float:left;
             width:14.9%;
            
        }
        #main{
            float:left;
             width:86%;
             height:auto;
            
        }
        #footer{
            width: 100%;
            height: auto;            
            text-align: center;
            
            clear:both;
        }
         #left, #main{ 
              
                
         } 
          
</style>

</head>

<body>
	<div class="page-wrapper chiller-theme toggled">
	
		<nav id="sidebar" class="sidebar-wrapper"><tiles:insertAttribute name="left" /></nav>
		<main class="page-content">
		<div class="container-fluid">
		   	<div id="header" class="top-bar"><tiles:insertAttribute name="header" /></div>
		   	
		   	<div id="main" style="width:100%">
			   		<iframe id="mainframe" name="mainframe" src="" style="top: 0px; left: 0px; bottom: 0px; height: 662px; width: 100%; border: 0px;">
			   			<tiles:insertAttribute name="body" />
			   		</iframe>	
		   	</div>
   
		   	<footer id="footer" class="text-center"><tiles:insertAttribute name="footer" /></footer>
		</div>
		</main>
    </div>
    
</body>

	<!-- header -->
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<!-- sidebar -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="<%=request.getContextPath()%>/resources/bootstrap/tiles/sidebar.js"></script>
    <!-- footer -->
     <!-- footer -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap/tiles/js/jquery-3.4.1.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap/tiles/js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap/tiles/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap/tiles/js/mdb.min.js"></script>
	

  	<script>
  	document.onkeydown = trapRefresh;
  	function trapRefresh(){
  		if(event.keyCode == 116){
  			event.keyCode = 0;
  			event.cancelBubble = true;
  			event.returnValue = false;
  			document.mainframe.location.reload;
  		}
  	}
  	
  	function reURL(mCode) {
  	     // HTML5 지원브라우저에서 사용 가능
  	     if (typeof(history.pushState) == 'function') {
  	         //현재 주소를 가져온다.
  	         var renewURL = location.href;
  	         
  	         //현재 URL
  	         idx = renewURL.indexOf("/");
  	         test = renewURL.substring(idx+11);
  	         
  	         //변경할 URL
  	         tt = mCode.getAttribute('href');
  	         idx1 = tt.indexOf("'");
  	         idx2 = tt.lastIndexOf("'");
  	         
  	         tt = tt.substring(idx1+1, idx2);
  	         
  	         
  	         /* alert(renewURL); */
  	         /* alert(test + "," + tt); */
  	         
  	         //현재 주소 중 .htm 뒤 부분이 있다면 날려버린다.
  	         //renewURL = renewURL.substring(0, renewURL.indexOf(".htm")+4);
  	          
  	         /* if (mCode != 'MENU00') {
  	             renewURL += "?mCode="+mCode;
  	         } */
  	         //mCode 값을 가져와서 비교한다.
  	         //var qCode = getQueryString("mCode") || "MENU00";
  	         if (tt != test) {
  	             //페이지를 리로드하지 않고 페이지 주소만 변경할 때 사용
  	             window.history.pushState(tt, null, test);
  	           
  	          /*  	 window.parent.location.href= tt;
  	           	 window.parent.location.reload(); */
  	             $('#mainframe').attr('src', tt+"/test");
  	            /*  document.form.target="mainframe";
  	           	 document.form.action=tt+"/test";
  	             document.form.submit(); */
  	        /*  $('#iframe').attr('src',$(this).attr(tt));
  	           
  	         }) */

  	         }else{
  	        	$('#mainframe').attr('src', tt+"/test");
  	         }
  	     } else {
  	    	$('#mainframe').attr('src', tt+"/test");
  	     }
  	 }
  	</script>
</html>




