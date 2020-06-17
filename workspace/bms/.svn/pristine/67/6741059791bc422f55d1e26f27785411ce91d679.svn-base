<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>stock management</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/board/vendor/bootstrap/css/bootstrap.min.css">

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/board/fonts/font-awesome-4.7.0/css/font-awesome.min.css">

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/board/vendor/animate/animate.css">

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/board/vendor/select2/select2.min.css">

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/board/vendor/perfect-scrollbar/perfect-scrollbar.css">

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/board/css/util.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/board/css/stockboard.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fontawesome-free/css/all.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/board/vendor/bootstrap/css/bootstrap.css">
<style type="text/css">
	
</style>
</head>
<body>
	
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100">
				<div class="input-group row" style="margin:0px 20px 20px 0px;">						
						<select class="form-control col-md-2" name="searchType" id="searchType">
							<option value="w"  ${pageMaker.cri.searchType eq 'w' ? 'selected': '' }>전 체</option>
							<option value="n" ${pageMaker.cri.searchType eq 'n' ? 'selected': '' }>이 름</option>							
						</select>
						<div style="border:1px solid gray;margin-left:250px;width:500px; height:">					
							<input class="form-control" type="text" name="keyword" placeholder="검색어를 입력하세요." value="${param.keyword}" style="width:100%"/>
						</div>
						
							<button class="btn btn-lg btn-crimson" style="background:crimson;color:white;" type="button" id="searchBtn" onclick="searchList_go(1);" data-card-widget="search">
							<b>검색하기</b>
							</button>
							<button type="button" style="margin-left:20px;background:crimson;color:white;" class="btn btn-lg btn-crimson" onclick="OpenWindow('<%=request.getContextPath()%>/facility_stock/stock_management/regist','','850','620');">	
							<b>재고등록</b>
							</button>
					
					</div>
					<table>
						<thead>
							<tr class="table100-head">
								<th class="column1">번호</th>
								<th class="column2">시설물이름</th>
								<th class="column3">단가</th>
								<th class="column4">수량</th>
								<th class="column6">등록날짜</th>
							</tr>
						</thead>
						<tbody>
						<c:if test="${empty stockList }" >
						<tr>
							<td colspan="5">
								<strong>해당 내용이 없습니다.</strong>
							</td>
						</tr>
						</c:if>		
						<c:forEach items="${stockList}" var="stockList">
								<tr>
									<td class="column1"><a onclick="OpenWindow('<%=request.getContextPath()%>/facility_stock/stock_management/detail?item_code=${stockList.item_code}','','850','620');">${stockList.item_code}</a></td>
									<td class="column2">${stockList.item_name}</td>
									<td class="column3">${stockList.item_price}</td>
									<td class="column4">${stockList.item_cnt}</td>
									<td class="column5"><fmt:formatDate value="${stockList.regdate}" pattern="yyyy-MM-dd" /></td>
								</tr>
						</c:forEach>		
						</tbody>
					</table>
					<div class="card-footer">
					<%@ include file="/WEB-INF/views/pagination/pagination.jsp" %>				
					</div>
					
				</div>
			</div>
		</div>
	</div>

	<form id="jobForm">
		  <input type='hidden' name="page" value="${pageMaker.cri.page}" />
		  <input type='hidden' name="perPageNum" 
		  		 value="${pageMaker.cri.perPageNum}"/>
		  <input type='hidden' name="searchType" 
		         value="${pageMaker.cri.searchType }" />
		  <input type='hidden' name="keyword" 
		         value="${pageMaker.cri.keyword }" />
	</form>
	

<!--===============================================================================================-->	
	<script src="<%=request.getContextPath()%>/resources/board/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/resources/board/vendor/bootstrap/js/popper.js"></script>
	<script src="<%=request.getContextPath()%>/resources/board/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/resources/board/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/resources/board/js/stock.js"></script>
	<SCRIPT type="text/javascript">
	$('#searchBtn').on('click',function(e){
		
		var jobForm=$('#jobForm');
		jobForm.find("[name='page']").val(1);
		jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
		jobForm.find("[name='keyword']").val($('input[name="keyword"]').val());
		
		jobForm.attr("action","<%=request.getContextPath()%>/facility_stock/stock_management/owner/test").attr("method","get");
		jobForm.submit();
	});
	
	function searchList_go(page){
		
		var jobForm=$('#jobForm');
		jobForm.find("[name='page']").val(page);
		jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
		jobForm.find("[name='keyword']").val($('div.input-group>input[name="keyword"]').val());	
		jobForm.attr("action","<%=request.getContextPath()%>/facility_stock/stock_management/owner/test").attr("method","post");
		jobForm.submit();
	}
	</SCRIPT>
</body>
</html>