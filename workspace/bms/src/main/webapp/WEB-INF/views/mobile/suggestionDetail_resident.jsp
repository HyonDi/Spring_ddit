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
  
  <!-- alert -->
  <link href="<%=request.getContextPath()%>/resources/mobile/css/jquery.modal.css" type="text/css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/resources/mobile/css/jquery.modal.theme-xenon.css" type="text/css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/resources/mobile/css/jquery.modal.theme-atlant.css" type="text/css" rel="stylesheet">

  <!-- Plugin CSS -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/mobile/device-mockups/device-mockups.min.css">

  <!-- Custom styles for this template -->
  <link href="<%=request.getContextPath()%>/resources/mobile/css/new-age.min.css" rel="stylesheet">

</head>

	<body id="page-top">
	
	  <!-- Navigation -->
	  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
	    <div class="container">
	    	<a class="navbar-brand js-scroll-trigger" style="color:black; display:inline;" href="javascript:location.href='<%=request.getContextPath()%>/suggestion/mobileList?chk=mem';"><ion-icon name="arrow-round-back" style="font-size: 30px; padding-right:20px" /></a>
	    	<span style="font-weight: bold; font-size:20px;">건의사항</span>
		    <c:set var="loginUser" value="${loginUser.member_code}" />
	      	<c:if test="${null ne reply or loginUser eq suggestion.member_code}">
		    	<button id="btns" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
		        <i class="fas fa-bars"></i>
		      	</button>
	      	</c:if>
	      	<c:if test="${null eq reply and loginUser ne suggestion.member_code}">
		    	<button onclick="ale()" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
		        <i class="fas fa-bars"></i>
		      	</button>
	      	</c:if>
	      	<div class="collapse navbar-collapse" id="navbarResponsive">
    	     <div class="d-flex justify-content-center h-100">
		        <div class="searchbar">
		        <ul class="navbar-nav ml-auto">
				
		         <c:if test="${loginUser eq  suggestion.member_code }">
		          <li class="nav-item">
		            <a onclick="suggestion_mod()" class="nav-link js-scroll-trigger" style="font-size:14px;" href="#">
		            <ion-icon name="cut"></ion-icon>
		            	 건의사항 수정하기
		            </a>
		          </li>
		          
		          <li class="nav-item">
		            <a onclick="goDel()" class="nav-link js-scroll-trigger" style="font-size:14px;" href="#">
		            <ion-icon name="trash"><ㄴ/ion-icon>
		            	 건의사항 삭제하기
		            </a>
		          </li>
		         </c:if>
		         
		         <c:if test="${null ne reply}">
		          <li class="nav-item">
		            <a onclick="replyGo()" class="nav-link js-scroll-trigger" style="font-size:14px;" href="#">
		            <ion-icon name="today"></ion-icon>
		            	 건의사항 답변 보기
		            </a>
		          </li>
		          
		        </ul>
		        </c:if>
		        
		        </div>
		      </div>
	      </div>
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
							    <label for="exampleFormControlInput1">제목</label>
							    <input id="title" type="text" class="form-control" value="${suggestion.suggestion_title}" style="background-color:white;" readonly>
							  </div>
							  <div class="form-group" id="writer">
							    <label for="exampleFormControlInput1">작성자</label>
							    <input type="text" class="form-control" value="${member_name }" style="background-color:white;" readonly>
							  </div>
							  <div class="form-group" id="addate">
							    <label for="exampleFormControlInput1">글작성일</label>
							    <input type="date" class="form-control" value="<fmt:formatDate value="${suggestion.suggestion_reg_date}" pattern="yyyy-MM-dd"/>" style="background-color:white;" readonly>
							  </div>
							  <div class="form-group" id="viewcnt">
							    <label for="exampleFormControlInput1">조회수</label>
							    <input type="text" class="form-control" value="${suggestion.suggestion_view_cnt }" style="background-color:white;" readonly>
							  </div>
							  <div class="form-group">
							    <label for="exampleFormControlTextarea1">내용</label>
							    <textarea id="content" class="form-control" id="exampleFormControlTextarea1" rows="8" style="background-color:white; padding-top:0px;" readonly>${suggestion.suggestion_contents }</textarea>
							  </div>
							  <div class="form-group" id="commits">
							    <input type="button" onclick="goMod();" class="btn btn-primary" class="form-control" value="수정하기" style="width:130px; margin-left:15px;" />
							  </div>
							  <div class="form-group" id="exits">
							    <input type="button" onclick="goExit();" class="btn btn-secondary"class="form-control" value="취소하기" style="width:130px;" />
							  </div>
							  
							  <input type="hidden" id="sug_code" value="${suggestion.suggestion_code}" />
							</form>
			            </div>
			        </div>
			    </div>
			 </div>
			</div>
		    <div class="overlay"></div>
		  </section>
	  <c:set var="reply" value="${reply}" />
	  <c:if test="${not empty reply}">
	  <footer id="nextReply">
	  		<div class="form-group" id="nextReply">
			<label for="exampleFormControlTextarea1" style="padding-bottom:10px; font-size: 20px; font-weight: bold; color:white;">답변</label>
			    <textarea class="form-control" name="replys" id="replys" rows="8" style="background-color:white; padding-top:0px;">
			    	${reply.reply_contents}
			    </textarea>
				<button type="button" id="replysBtn" class="btn btn-secondary" style="margin-top: 10px; margin-bottom: -30; width: 226px;" onclick="replySub();">전송하기</button>
				<button type="button" id="modifyBtn" class="btn btn-secondary" style="margin-top: 10px; margin-bottom: -30; width: 226px;" onclick="replySubModify();">수정하기</button>
			</div>
	  </footer>
	  </c:if>
		  
	  </header>
	
	</body>
	
	  <!-- Bootstrap core JavaScript -->
  <script src="<%=request.getContextPath()%>/resources/mobile/vendor/jquery/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/resources/mobile/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="<%=request.getContextPath()%>/resources/mobile/vendor/jquery-easing/jquery.easing.min.js"></script>
  
  <!-- alert -->
  <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/mobile/js/jquery.modal.js"></script>

  <!-- Custom scripts for this template -->
  <script src="<%=request.getContextPath()%>/resources/mobile/js/new-age.min.js"></script>
  
  <script src="https://unpkg.com/ionicons@4.5.10-0/dist/ionicons.js"></script>
  
  <script>
	$(document).ready(function(){
  		var chks = $('#chk').val();

  		if(chks == ''){
  			$('footer').remove();
  		}else{
  			$("#replys").prop('readonly',true);
  			$('#replysBtn').css('display','none');
  			$('#modifyBtn').css('display','none');
  			$('#commits').css('display','none');
  			$('#exits').css('display','none');
  		}
  		
  	});
	
	function replyGo(){
  		var location = document.querySelector('#nextReply').offsetTop;
  		window.scrollTo({top:location, behavior:'smooth'});
	}
	
	function ale(){
		modal({
			type: 'primary',
			title: '건의사항 권한',
			text : "해당 건의사항에 권한이 없습니다!"
		});
	}
	
	function goMod(){
		
		var suggestion_code = $('#sug_code').val();
		var suggestion_title = $('#title').val();
		var suggestion_contents = $('#content').val();
  	  	
  	  	modal({
  			type: 'confirm',
  			title : '건의사항 수정',
  			text : '건의사항을 정말 수정 하시겠습니까?',
  			callback : function(result){
  				if(result){
  					$.ajax({
  						url : '<%=request.getContextPath()%>/suggestion/suggestion_mod',
  						data : {
  							'suggestion_code' : suggestion_code,
  							'suggestion_title' : suggestion_title,
  							'suggestion_contents' : suggestion_contents
  						},
  						type : 'get',
  						dataType : 'text',
  						success : function(){
  							modal({
  					  			type: 'alert',
  					  			title : '건의사항 수정',
  					  			text : '해당 건의사항 수정이 완료 되었습니다.'
  					  		});
  							goExit();
  						},
  						error : function(){
  							modal({
  					  			type: 'alert',
  					  			title : '서버 오류 발생',
  					  			text : '해당 건의사항 수정이 취소 되었습니다.'
  					  		});
  						}
  					});
  				}
  			}
  			
  		});	
		   
 	}
	
	function goExit(){
		$('#writer').css('display', '');
		$('#addate').css('display', '');
		$('#viewcnt').css('display', '');
		$('#title').prop('readonly', true);
		$('#content').prop('readonly', true);
		$('#content').attr('rows', 8).css('margin-bottom','');
		$('#commits').css('display','none');
		$('#exits').css('display','none');
	}
	
	function goDel(){
  	  	
  	  	modal({
  			type: 'confirm',
  			title : '건의사항 삭제',
  			text : '건의사항을 정말 삭제 하시겠습니까?',
  			callback : function(result){
  				if(result){
  					suggestion_del();
  				}
  			}
  			
  		});	
		   
 	}
	
	function suggestion_del(){
		var suggestion_code = $('#sug_code').val();
		
		$.ajax({
			url : '<%=request.getContextPath()%>/suggestion/suggestion_del',
			data : {'suggestion_code' : suggestion_code},
			type : 'get',
			dataType : 'text',
			success : function(){
		  	  	modal({
		  			type: 'alert',
		  			title : '삭제 완료',
		  			text : '해당 건의사항 삭제가 완료 되었습니다.'
		  		});
		  	  	setTimeout(function(){
		  	  		location.href="<%=request.getContextPath()%>/suggestion/mobileList?chk=mem";						
				}, 1300);
			},
			error : function(){
				modal({
		  			type: 'alert',
		  			title : '삭제 실패',
		  			text : '해당 건의사항 삭제가 실패 하였습니다.'
		  		});
			}
			
		});
	}
	
	function suggestion_mod(){
		
		$('#btns').click();
		
		$('#writer').css('display', 'none');
		$('#addate').css('display', 'none');
		$('#viewcnt').css('display', 'none');
		$('#content').attr('rows', 15).css('margin-bottom','50');
		
		$('#commits').css('display','inline');
		$('#exits').css('display','inline');
		
		$('#title').prop('readonly', false);
		$('#content').prop('readonly', false);
		
		
	}
  </script>
	
</html>
