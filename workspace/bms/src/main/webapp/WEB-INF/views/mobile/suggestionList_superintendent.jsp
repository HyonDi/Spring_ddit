<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

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

	<body id="page-top" style="height: 700px;width: 405px;">
	
	  <!-- Navigation -->
	  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
	    <div class="container">
	    	<a class="navbar-brand js-scroll-trigger" style="color:black; display:inline;" href="javascript:location.href='<%=request.getContextPath()%>/mobile/main_superintendent';"><ion-icon name="arrow-round-back" style="font-size: 30px; padding-right:20px" /></a>
	    	<span style="font-weight: bold; font-size:20px;">건의사항</span>
	    	<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	        <i class="fas fa-bars"></i>
	      	</button>
	      	<div class="collapse navbar-collapse" id="navbarResponsive">
    	     <div class="d-flex justify-content-center h-100">
		        <div class="searchbar">
		          <input type="hidden" name="searchType" value="tcw"/>
		          <input class="search_input" type="text" name="keyword" placeholder="Search...">
		          <a href="javascript:searchList_go(1);" class="search_icon"><i class="fas fa-search"></i></a>
		         <ul class="navbar-nav ml-auto">
		        </ul>
		        </div>
		      </div>
	      </div>
       </div>
	  </nav>
	  
	  <header class="contact">
		<section class="contact" id="contact2" style="padding-top:56px; padding-bottom:0px;">
			<div class="container">
				<div style="display:block;">
					<ul class="list-group" style="width:405px; margin-left:-12px;">
					  <c:forEach items="${suggestionList}" var="suggestion">
					  		<li class="list-group-item" style="padding:18.9px;"><a href="<%=request.getContextPath()%>/suggestion/mobileDetail?suggestion_code=${suggestion.suggestion_code}&chk=dt&chk2=admin" style="color:black;">${suggestion.suggestion_title}</a></li>
					  </c:forEach>
					</ul>
				</div>
				<nav aria-label="member list Navigation">
					<ul class="pagination justify-content-center m-0">
						<li class="page-item">
							<a class="page-link" style="padding-top:15.9px; padding-bottom:15.9px;" href="javascript:searchList_go(1);"><ion-icon name="skip-backward"></ion-icon></a>
						</li>
						<li class="page-item">
							<a class="page-link" href="javascript:searchList_go(${pageMaker.prev ? pageMaker.startPage-1 : 1});"><ion-icon size="large" name="arrow-dropleft"></ion-icon></a>
						</li>
						<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">
						<li class="page-item <c:out value="${pageMaker.cri.page == pageNum?'active':''}"/>">
							<a class="page-link" style="padding-top: 13.2;padding-bottom: 13.2;" href="javascript:searchList_go(${pageNum});" >${pageNum}</a>
						</li>
						</c:forEach>
						<li class="page-item">
							<a class="page-link" href="javascript:searchList_go(${pageMaker.next ? pageMaker.endPage+1 : pageMaker.cri.page});"><ion-icon size="large" name="arrow-dropright"></ion-icon></a>
						</li>
						<li class="page-item">
							<a class="page-link" style="padding-top:15.9px; padding-bottom:15.9px;" href="javascript:searchList_go(${pageMaker.realEndPage} );"><ion-icon name="skip-forward"></ion-icon></a>
						</li>	
					</ul>
				</nav>
					<form id="jobForm">
						<input type="hidden" name="page" value="1">
						<input type="hidden" name="perPageNum" value="10">
						<input type="hidden" name="searchType" value="">
						<input type="hidden" name="keyword" value="">
					</form>	
			</div>
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
function searchList_go(page,url){
	
	var jobForm=$('#jobForm');
	jobForm.find("[name='page']").val(page);
	jobForm.find("[name='searchType']").val($('input[name="searchType"]').val());
	jobForm.find("[name='keyword']").val($('input[name="keyword"]').val());	
	jobForm.attr("method","post");

	if(url){
		jobForm.attr("action",url);
	}else{
		jobForm.attr("action","mobileList?chk=admin");		
	}
	
	jobForm.submit();
	
}
</script>
  
</html>
