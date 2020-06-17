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
	    	<a class="navbar-brand js-scroll-trigger" style="color:black; display:inline;" href="javascript:location.href='<%=request.getContextPath()%>/mobile/main_superintendent';"><ion-icon name="arrow-round-back" style="font-size: 30px; padding-right:20px" /></a>
	    	<span style="font-weight: bold; font-size:20px;">건의사항</span>
	    	<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	        <i class="fas fa-bars"></i>
	      	</button>
	      	<div class="collapse navbar-collapse" id="navbarResponsive">
    	     <div class="d-flex justify-content-center h-100">
		        <div class="searchbar" >
		         <ul class="navbar-nav ml-auto" id="navAppend">
		          <li class="nav-item" id="write">
		            <a class="nav-link js-scroll-trigger" id="chkReply" style="font-size:14px;" href="#" onclick="reply();">
		            <ion-icon name="hand"></ion-icon>
		            	 건의사항 답변작성
		            </a>
		          </li>
		        </ul>
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
							    <input type="text" class="form-control" value="${suggestion.suggestion_title}" style="background-color:white;" readonly>
							  </div>
							  <div class="form-group">
							    <label for="exampleFormControlInput1">작성자</label>
							    <input type="text" class="form-control" value="${member_name }" style="background-color:white;" readonly>
							  </div>
							  <div class="form-group">
							    <label for="exampleFormControlInput1">글작성일</label>
							    <input type="date" class="form-control" value="<fmt:formatDate value="${suggestion.suggestion_reg_date}" pattern="yyyy-MM-dd"/>" style="background-color:white;" readonly>
							  </div>
							  <div class="form-group">
							    <label for="exampleFormControlInput1">조회수</label>
							    <input type="text" class="form-control" value="${suggestion.suggestion_view_cnt }" style="background-color:white;" readonly>
							  </div>
							  <div class="form-group">
							    <label for="exampleFormControlTextarea1">내용</label>
							    <textarea class="form-control" id="exampleFormControlTextarea1" rows="8" style="background-color:white; padding-top:0px;" readonly>${suggestion.suggestion_contents }</textarea>
							  </div>
							</form>
							<input type="hidden" id="codes" value="${suggestion.suggestion_code}" />
							<input type="hidden" id="sorts" value="${suggestion.board_sort_code}" />
							<input type="hidden" id="chk" value="${reply.reply_code}" />
			            </div>
			        </div>
			    </div>
			 </div>
			</div>
		    <div class="overlay"></div>
		  </section>
		  
	  <footer id="nextReply">
	  	<c:set var="reply" value="${reply}" />
	  	<c:if test="${not empty reply}">
	  		<div class="form-group" id="nextReply">
			<label for="exampleFormControlTextarea1" style="padding-bottom:10px; font-size: 20px; font-weight: bold; color:white;">답변</label>
			    <textarea class="form-control" name="replys" id="replys" rows="8" style="background-color:white; padding-top:0px;">
			    	${reply.reply_contents}
			    </textarea>
				<button type="button" id="replysBtn" class="btn btn-secondary" style="margin-top: 10px; margin-bottom: -30; width: 226px;" onclick="replySub();">전송하기</button>
				<button type="button" id="modifyBtn" class="btn btn-secondary" style="margin-top: 10px; margin-bottom: -30; width: 226px;" onclick="replySubModify();">수정하기</button>
			</div>
	  	</c:if>
	  </footer>
	  
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
  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.3/handlebars.min.js" ></script>
  <script id="reply-template" type="text/x-handlebars-template">
	<div class="form-group" id="nextReply">
			<label for="exampleFormControlTextarea1" style="padding-bottom:10px; font-size: 20px; font-weight: bold; color:white;">답변</label>
	    		<textarea class="form-control" id="replys" name="replys" id="exampleFormControlTextarea1" rows="8" style="background-color:white; padding-top:0px;">
	    		</textarea>
				<button type="button" id="replysBtn" class="btn btn-secondary" style="margin-top: 10px; margin-bottom: -30; width: 226px;" onclick="replySub();">작성하기</button>
				<button type="button" id="modifyBtn" class="btn btn-secondary" style="margin-top: 10px; margin-bottom: -30; width: 226px;" onclick="replySubModify();">수정하기</button>
	</div>
  </script>
  
  <script id="reply_nav" type="text/x-handlebars-template">
  	<ul class="navbar-nav ml-auto">
	      <li id="deletes" class="nav-item">
		       <a onclick="replyModify();" class="nav-link js-scroll-trigger" style="font-size:14px;" href="#">
		        <ion-icon name="cut"></ion-icon>
		          	 건의사항 답변 수정하기
	           </a>
	      </li>

		  <li id="modifys" class="nav-item">
		      <a onclick="replyDelete();" class="nav-link js-scroll-trigger" style="font-size:14px;" href="#">
		  	   <ion-icon name="trash"></ion-icon>
		         	 건의사항 답변 삭제하기
		      </a>
		  </li>
	</ul>
  </script>
  
  <script>
  
  	$(document).ready(function(){
  		var chks = $('#chk').val();

  		if(chks == ''){
  			$('#nextReply').css('display','none');
  		}else{
  			$('#chkReply').attr('onclick', 'alerts();');
  			$("#replys").prop('readonly',true);
  			$('#replysBtn').css('display','none');
  			$('#modifyBtn').css('display','none');
  			replyWriteCheckControll();
  		}
  		
  	});
  
  	function reply(){
  		$('#nextReply').css('display', '');
  		
  		var rep = Handlebars.compile($('#reply-template').html());
  		$('footer#nextReply').append(rep);
  		var location = document.querySelector('#nextReply').offsetTop;
  		window.scrollTo({top:location, behavior:'smooth'});
  		$('#chkReply').attr('onclick', 'scrolls();');
  		
  		$('#modifyBtn').css('display','none');
  	}
  	
  	function scrolls(){
  		var location = document.querySelector('#nextReply').offsetTop;
  		window.scrollTo({top:location, behavior:'smooth'});
  	}
  	
  	function replySub(){
  		var replyText = $("textarea[name='replys']").val();
  		var suggestion_code = $('#codes').val();
  		var board_sort_code = $('#sorts').val();
  		
  		$.ajax({
  			url : '<%=request.getContextPath()%>/suggestion/reply',
  			type : 'get',
  			data : {
  				"replyText" : replyText,
  				"suggestion_code" : suggestion_code,
  				"board_sort_code" : board_sort_code
  			},
  			dataType : 'text',
  			success : function(result){
  					modal({
						type: 'primary',
						title: '건의사항 답변 작성',
						text : "답변 작성이 완료 되었습니다!"
					});
  					$('#chk').attr('value', result);
  					$('#replysBtn').css('display','none');
  					replyWriteCheckControll();
  			},
  			error : function(){
  				modal({
					type: 'primary',
					title: '서버 오류 발생',
					text : "서버 오류로 인해 건의사항 답변 작성에 실패 하였습니다!"
				});
  			}
  		});
  	}
  	
  	function replyWriteCheckControll(){
  		$('#write').css('display', 'none');
  		$('#chkReply').attr('onclick', 'reply();');
  		
  		var navs = Handlebars.compile($('#reply_nav').html());
  		
  		$('#navAppend').append(navs);
  	}
  	
  	function replyDeleteCheckControll(){
  		$('#deletes').css('display','none');
  		$('#modifys').css('display','none');
  		
  		$('#nextReply').css('display','none');
  		$('#write').css('display', '');
  		
  	}
  	
  	function alerts(){
			modal({
				type: 'primary',
				title: '건의사항 답변 작성',
				text : "답변이 이미 작성 되어 있습니다!"
			});
  		scrolls();
  	}
  	
  	function replyDelete(){
	var reply_code = $('#chk').val();
  		
   		$.ajax({
  			url : '<%=request.getContextPath()%>/suggestion/replyDel',
  			type : 'get',
  			data : {
  				"reply_code" : reply_code
  			},
  			dataType : 'text',
  			success : function(){
  					modal({
						type: 'primary',
						title: '건의사항 답변 삭제',
						text : "답변 삭제가 완료 되었습니다!"
					});
  					replyDeleteCheckControll();
  			},
  			error : function(){
  				modal({
					type: 'primary',
					title: '서버 오류 발생',
					text : "서버 오류로 인해 건의사항 답변 삭제에 실패 하였습니다!"
				});
  			}
  		});
  	}
  	
  	function replyModify(){
  		scrolls();
  		$('#modifyBtn').css('display','');
  		$("#replys").prop('readonly',false);
  	}
  	
  	function replySubModify(){
  		var reply_code = $('#chk').val();
  		var replyText = $("textarea[name='replys']").val();
  		var suggestion_code = $('#codes').val();
  		var board_sort_code = $('#sorts').val();
  		
  		$.ajax({
  			url : '<%=request.getContextPath()%>/suggestion/replyModify',
  			type : 'get',
  			data : {
  				"replyText" : replyText,
  				"suggestion_code" : suggestion_code,
  				"board_sort_code" : board_sort_code,
  				"reply_code" : reply_code
  			},
  			dataType : 'text',
  			success : function(result){
  					modal({
						type: 'primary',
						title: '건의사항 답변 수정',
						text : "답변 수정이 완료 되었습니다!"
					});
  					$('#modifyBtn').css('display','none');
  					$("#replys").prop('readonly',true);
  			},
  			error : function(){
  				modal({
					type: 'primary',
					title: '서버 오류 발생',
					text : "서버 오류로 인해 건의사항 답변 수정에 실패 하였습니다!"
				});
  			}
  		});
  	}
  	
  </script>
	
</html>
