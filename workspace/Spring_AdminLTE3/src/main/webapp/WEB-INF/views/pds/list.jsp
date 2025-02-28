<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<head>
	<title>자료실 목록</title>
	<style>
		table th,td{
			text-align:center;
		}
		
	
	</style>
</head>	
	
<body>
  <%-- <c:set var="pageMaker" value="${dataMap.pageMaker }" /> --%>	  	
   <div class="content-wrapper" >
    <!-- Content Header (Page header) -->
    <section class="content-header">
    	<div class="container-fluid">
    		<div class="row mb-2">
    			<div class="col-sm-6">
	      			<h1>자료실</h1>
	      		</div>	      		
	    	
	       		
	       		<div class="col-sm-6">
			      <ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item"><a href="list.do"><i class="fa fa-dashboard"></i>자료실</a></li>
			        <li class="breadcrumb-item active">리스트</li>		        
			      </ol>
		      	</div>
	     	</div>	     	
      	</div>
    </section>

    <!-- Main content -->
    <section class="content">
		<div class="card">
			<div class="card-header with-border">
				<button type="button" class="btn btn-primary" id="registBtn" onclick="OpenWindow('registForm.do','자료등록',600,400)">자료등록</button>
				<div id="keyword" class="card-tools" style="width:350px;">	
					<div class="input-group row">
					
						<select class="form-control" name="searchType" id="searchType">
							<option ${pageMaker.cri.searchType eq 'tcw' ? 'selected':'' } value="tcw">전 체</option>
							<option ${pageMaker.cri.searchType eq 't' ? 'selected':'' } value="t">제 목</option>
							<option ${pageMaker.cri.searchType eq 'w' ? 'selected':'' } value="w">작성자</option>
							<option ${pageMaker.cri.searchType eq 'c' ? 'selected':'' } value="c">내 용</option>
							<option ${pageMaker.cri.searchType eq 'tc' ? 'selected':'' } value="tc">제목+내용</option>
							<option ${pageMaker.cri.searchType eq 'cw' ? 'selected':'' } value="cw">작성자+내용</option>
						</select>
						
						<input  class="form-control" type="text" name="keyword" placeholder="검색어를 입력하세요." value="${pageMaker.cri.keyword }"/>
						<span class="input-group-append">
							<button class="btn btn-primary" type="button" id="searchBtn" data-card-widget="search">
								<i class="fa fa-fw fa-search"></i>
							</button>
						</span>
					</div>						
				</div>			
			</div>
			<div class="card-body">
				<table class="table table-bordered text-center">
					<%-- 컬럼길이  : 고정시키지않으면 안에들어있는 길이에따라 변해서 페이지 넘길때마다 컬럼길이가 달라진다. --%>
					<tr style="font-size:0.95em;">
					<th style="width:10%;">번호</th>
					<th style="width:50%;">제목</th>
					<th style="width:15%;">작성자</th>
					<th>등록일</th>
					<th style="width:10%;">조회수</th>
					</tr>
					
					<c:if test="${empty pdsList }">
						<tr>
							<td colspan="5">
								<strong>해당 내용이 없습니다.</strong>
							</td>
						</tr>
					</c:if>
					
					<%--반복문을 돌립니다.(pdsList) --%>
					<c:forEach items="${pdsList }" var="pds">
						<tr>
							<td>${pds.pno}</td>
							<td id="pdsTitle" style="text-align:left;max-width:100%;overflow: hidden; white-space:nowrap; text-overflow:ellipsis;">
								<a href="javascript:OpenWindow('detail.do${pageMaker.makeQuery()}&pno=${pds.pno }&check=list','상세보기',800,800);">
									<span class="col-sm-12">${pds.title }</span>
								</a>
							</td>
							<td>${pds.writer }</td>
							<td>
								<fmt:formatDate value="${pds.regDate }" pattern="yyyy-MM-dd"/>
							</td>
							<td><span class="badge bg-red">${pds.viewcnt}</span></td>
						</tr>
					</c:forEach>
					
				</table>
			</div>
			<div class="card-footer">
				<nav aria-label="pds list Navigation">
					<ul class="pagination justify-content-center m-0">
						<%-- 변수공유해야하니까 inlclude 해야합니다. --%>
						<%@ include file="/WEB-INF/views/pagination/pagination.jsp" %>
					</ul>
				</nav>
			</div>
		</div>
	</section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
	<form id="jobForm">
		  <input type='hidden' name="page" value="${pageMaker.cri.page}" />
		  <input type='hidden' name="perPageNum" 
		  		 value="${pageMaker.cri.perPageNum}"/>
		  <input type='hidden' name="searchType" 
		         value="${pageMaker.cri.searchType }" />
		  <input type='hidden' name="keyword" 
		         value="${pageMaker.cri.keyword }" />
	</form>
 
 <script>
 
	$('#searchBtn').on('click',function(e){
		var jobForm=$('#jobForm');
		jobForm.find("[name='page']").val(1); // 3번페이지보다가 검색하면 1페이지로 이동.
		jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
		jobForm.find("[name='keyword']").val($('input[name="keyword"]').val());
		
		/* alert(jobForm.serialize()); */ // input태그로만든게 파라미터로 날라간다.(=serialize)
		
		jobForm.attr("action","list.do").attr("method","get");
		jobForm.submit();
	});
	
</script>
 
 
 
 
 
</body>





  