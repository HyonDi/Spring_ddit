<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>건축물 시설 관리 시스템</title>

	<!-- header -->
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<link rel="stylesheet" href="https://d19m59y37dris4.cloudfront.net/universal/2-0-1/vendor/font-awesome/css/font-awesome.min.css">
	<link href="<%=request.getContextPath()%>/resources/bootstrap/tiles/header.css" rel="stylesheet">

    <!-- footer -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
	<!-- Bootstrap core CSS -->
	<link href="<%=request.getContextPath()%>/resources/bootstrap/tiles/css/bootstrap.min.css" rel="stylesheet">
	<!-- Material Design Bootstrap -->
	<link href="<%=request.getContextPath()%>/resources/bootstrap/tiles/css/mdb.min.css" rel="stylesheet">
	<!-- Your custom styles (optional) -->
	<link href="<%=request.getContextPath()%>/resources/bootstrap/tiles/css/style.css" rel="stylesheet">
    
	<!-- main -->
	<link href="<%=request.getContextPath()%>/resources/bootstrap/tiles/css/main/main.css" rel="stylesheet">
<style type="text/css">

	  #header{            
            width:auto;
            height:50px;
            
            
      }
        
      #main{
          float:left;
          width: 100%;
          padding-top : 210px;
          min-height: 758px;
      }
      
      #footer{
          width: auto;
          height: auto;            
          text-align: center;
          
          clear:both;
      }
      
</style>

</head>

<body>
	<div style="width:100%; height:100%;">
		<div id="header"><tiles:insertAttribute name="header" /></div>
	    <div id="main"><tiles:insertAttribute name="body" /></div>    
	    <div id="footer"><tiles:insertAttribute name="footer" /></div>
    </div>
</body>

	<!-- header -->
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <!-- footer -->
     <script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap/tiles/js/jquery-3.4.1.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap/tiles/js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap/tiles/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap/tiles/js/mdb.min.js"></script>
	<!-- main -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap/tiles/js/main/main.js"></script>
	<script type="text/javascript">
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
 	             history.pushState(test, null, tt);
 	             document.form.target="mainframe";
 	           	 document.form.action=tt+"/test";
 	             document.form.submit()
 	        /*  $('#iframe').attr('src',$(this).attr(tt));
 	           
 	         }) */

 	         }
 	     } else {
 	         location.hash = "#"+ tt;
 	     }
 	 }
	</script>
</html>




