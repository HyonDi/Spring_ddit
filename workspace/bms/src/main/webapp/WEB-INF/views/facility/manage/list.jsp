<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>관리인 관리</title>

<link href="<%=request.getContextPath() %>/resources/css/schedule/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/schedule/css/animate.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/schedule/css/style.css" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/board/css/util.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/board/css/itemboard.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fontawesome-free/css/all.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/board/vendor/bootstrap/css/bootstrap.css">	
	

<style>
	#addSuperintendentBtn{
		display : inline;
		margin-bottom : 20px;
		margin-right : 20px;
	}
	
	#searchType{
		display : inline;
		width : 120px;
		margin-right : 10px;
/* 		float : right; */
	}
	#keword{
		display : inline;
		width : 300px;
		margin-right : 10px;
/* 		float : right; */
	}
	#searchBtn{
/* 		float : right; */
	margin-right : 20px;
	}
	
	#searchWrapper{
		float : right;
	}
	
	#imgprofile{
		width : 100%;
		height : 100%;
	}
	.product-imitation{
		padding:0px;
	}
	#pictureView{
		width:377.5px;
		height:211.22px;
	}
</style>
</head>
<body>
	<div class="wrapper wrapper-content animated fadeInRight">
		<button id="addSuperintendentBtn" type="button"	class="btn btn-w-m btn-danger" onclick="OpenWindow('<%=request.getContextPath()%>/facility_stock/facility_management/regist','','850','620');">시설등록</button>

		<div id=searchWrapper>
			<select class="form-control" id="searchType" name="searchType">
				<option value="w" ${pageMaker.cri.searchType eq 'w' ? 'selected': '' }>전체</option>
				<option value="n" ${pageMaker.cri.searchType eq 'n' ? 'selected': '' }>이름</option>
			</select> 
			<input id="keword" type="text" class="form-control form-control-sm" value="${param.keyword}" name="keyword" placeholder="검색어를 입력하세요." style="height: 2.6em;">
			<button id="searchBtn" type="submit" class="btn btn-m btn-primary" style="height: 2.3em;background: #c82333;border: 1px solid #c82333;font-weight: bold;">검색</button>
		</div>
		<div class="row">

			<c:forEach items="${facilityList}" var="facilityList">
				<div class="col-md-3">
					<div class="ibox">
						<div class="ibox-content product-box">
						<input type="hidden" name="picture" value="${stock.item_picture}">
							<div class="product-imitation" id="pictureView">
							<IMG id="imgprofile" alt="image" src="<%=request.getContextPath()%>/facility_stock/facility_management/getPicture?picture=${facilityList.facility_picture}" />
							</div>
                            <input type="hidden" name="pictureCodeInput" value="${facilityList.facility_code }"/>
							<div class="product-desc">

								<a onclick="OpenWindow('<%=request.getContextPath()%>/facility_stock/facility_management/detail?facility_code=${facilityList.facility_code}','','850','620');" class="product-name">${facilityList.facility_name}</a>

								<div class="m-t text-righ">

									<a href="#" onclick="OpenWindow('<%=request.getContextPath()%>/facility_stock/facility_management/detail?facility_code=${facilityList.facility_code}','','850','620');" class="btn btn-xs btn-outline btn-primary" style="background-color: #c82333;color:white;font-weight:bold;border: 1px solid crimson;font-size: 0.8em;">상세정보
										<i class="fa fa-long-arrow-right"></i>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				
			</c:forEach>
		</div>
			<div class="card-footer">
				<%@ include file="/WEB-INF/views/pagination/pagination.jsp"%>
			</div>
	</div>

	<form id="jobForm">
		<input type='hidden' name="page" value="${pageMaker.cri.page}" /> 
		<input type='hidden' name="perPageNum" value="${pageMaker.cri.perPageNum}" />
		<input type='hidden' name="searchType" value="${pageMaker.cri.searchType }" /> <input type='hidden'	name="keyword" value="${pageMaker.cri.keyword }" />
	</form>
	<!-- Mainly scripts -->
	<script
		src="<%=request.getContextPath() %>/resources/js/schedule/js/jquery-3.1.1.min.js"></script>
	<script
		src="<%=request.getContextPath() %>/resources/js/schedule/js/popper.min.js"></script>
	<script
		src="<%=request.getContextPath() %>/resources/js/schedule/js/bootstrap.js"></script>
	<script
		src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script
		src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<!-- Custom and plugin javascript -->
	<script
		src="<%=request.getContextPath() %>/resources/js/schedule/js/inspinia.js"></script>
	<script
		src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/pace/pace.min.js"></script>
	<script>
	

	
	
	$(document).ready(function(){
		/* $('div.pictureView').next('input').val(); */	
		
	
	})
	
	function OpenWindow(UrlStr, WinTitle, WinWidth, WinHeight) {
		winleft = (screen.width - WinWidth) / 2;
		wintop = (screen.height - WinHeight) / 2;
		var win = window.open(UrlStr , WinTitle , "scrollbars=yes,width="+ WinWidth +", height="+ WinHeight +", top="+ wintop +", left=" + winleft + ", resizable=yes, status=yes"  );
	    win.focus() ; 
	}	
	
<%-- 	var imageURL = "<%=request.getContextPath()%>/facility_stock/facility_management/getPicture?picture=${facilityList.facility_picture}";
	$('div#pictureView').css({'background-image':'url('+imageURL+')',
							  'background-position':'center',
							  'background-size':'cover',
							  'background-repeat':'no-repeat'
	}); --%>
	
	$('#searchBtn').on('click',function(e){
		
		var jobForm=$('#jobForm');
		jobForm.find("[name='page']").val(1);
		jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
		jobForm.find("[name='keyword']").val($('input[name="keyword"]').val());
		
		jobForm.attr("action","<%=request.getContextPath()%>/facility_stock/facility_management/owner/test").attr("method","get");
		jobForm.submit();
	});
	
	function searchList_go(page){
		
		var jobForm=$('#jobForm');
		jobForm.find("[name='page']").val(page);
		jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
		jobForm.find("[name='keyword']").val($('div.input-group>input[name="keyword"]').val());	
		jobForm.attr("action","<%=request.getContextPath()%>/facility_stock/facility_management/owner/test").attr("method","post");
		jobForm.submit();
	}

	</script>
</body>
</html>