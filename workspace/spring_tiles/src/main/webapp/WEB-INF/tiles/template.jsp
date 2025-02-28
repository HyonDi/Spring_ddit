<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<style>
	#header{
		width : 100%;
		height : 50%;
		text-align : center;
		background-color : aqua;
	}
	
	#left{
		float : left;
		width : 15%;
		background-color : gray;
	}
	
	#main{
		float : left;
		width : 85%;
		background-color : lime;
	}
	
	#footer{
		width:100%;
		height : 50%;
		text-align : center;
		background-color : orange;
		clear : both;
	}
	
	#left, #main{
		min-height : 600px;
	}
</style>
</head>

<body>
	<div style="width:100%; height:100%;">
		<!-- name에 들어가는건 tiles.xml에서 지정한 name과 똑같이 입력한다 -->
		<div id="header"><tiles:insertAttribute name="header" /></div>
		<div id="left"><tiles:insertAttribute name="left" /></div>
		<div id="main"><tiles:insertAttribute name="body" /></div>
		<div id="footer"><tiles:insertAttribute name="footer" /></div>
	</div>

</body>
</html>