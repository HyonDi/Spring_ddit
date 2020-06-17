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
  
  <!-- alert -->
  <link href="<%=request.getContextPath()%>/resources/mobile/css/jquery.modal.css" type="text/css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/resources/mobile/css/jquery.modal.theme-xenon.css" type="text/css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/resources/mobile/css/jquery.modal.theme-atlant.css" type="text/css" rel="stylesheet">

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

	<body id="page-top">
	
	  <!-- Navigation -->
	  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
	    <div class="container">
	    	<a class="navbar-brand js-scroll-trigger" style="color:black; display:inline;" href="javascript:location.href='<%=request.getContextPath()%>/community/mobileList';"><ion-icon name="arrow-round-back" style="font-size: 30px; padding-right:20px" /></a>
	    	<span style="font-weight: bold; font-size:20px;">입주자 소통 상세</span>
	    	<c:set var="loginUser" value="${loginUser.member_code}" />
	    	<c:if test="${loginUser eq community.member_code}">
		    	<button id="btns" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
		        <i class="fas fa-bars"></i>
		      	</button>
	      	</c:if>
	      	<c:if test="${loginUser ne community.member_code}">
		    	<button onclick="ale()" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
		        <i class="fas fa-bars"></i>
		      	</button>
	      	</c:if>
	      	<div class="collapse navbar-collapse" id="navbarResponsive">
    	     <div class="d-flex justify-content-center h-100">
		        <div class="searchbar">
		        
		        <c:if test="${loginUser eq  community.member_code }">
		         <ul class="navbar-nav ml-auto">
		          <li class="nav-item">
		            <a onclick="community_mod()" class="nav-link js-scroll-trigger" style="font-size:14px;" href="#download">
		            <ion-icon name="cut"></ion-icon>
		            	 소통글 수정하기
		            </a>
		          </li>
		          <li class="nav-item">
		            <a onclick="goDel()" class="nav-link js-scroll-trigger" style="font-size:14px;" href="#download">
		            <ion-icon name="trash"></ion-icon>
		            	 소통글 삭제하기
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
							    <input id="title" type="text" class="form-control" value="${community.community_title}" style="background-color:white;" readonly>
							  </div>
							  <div class="form-group" id="writer">
							    <label for="exampleFormControlInput1">작성자</label>
							    <input type="text" class="form-control" value="${member_name }" style="background-color:white;" readonly>
							  </div>
							  <div class="form-group" id="addate">
							    <label for="exampleFormControlInput1">글작성일</label>
							    <input type="date" class="form-control" value="<fmt:formatDate value="${community.community_reg_date}" pattern="yyyy-MM-dd"/>" style="background-color:white;" readonly>
							  </div>
							  <div class="form-group" id="viewcnt">
							    <label for="exampleFormControlInput1">조회수</label>
							    <input type="text" class="form-control" value="${community.community_view_cnt }" style="background-color:white;" readonly>
							  </div>
							  <div class="form-group">
							    <label for="exampleFormControlTextarea1">내용</label>
							    <textarea id="content" class="form-control" id="exampleFormControlTextarea1" rows="8" style="background-color:white; padding-top:0px;" readonly>${community.community_contents }</textarea>
							  </div>
							  
							  <input type="hidden" id="board_code" value="${community.community_code}" />
							  <input type="hidden" id="board_sort_code" value="${community.board_sort_code}" />
							  
							  <div class="form-group" id="commits">
							    <input type="button" onclick="goMod();" class="btn btn-primary" class="form-control" value="수정하기" style="width:130px; margin-left:15px;" />
							  </div>
							  <div class="form-group" id="exits">
							    <input type="button" onclick="goExit();" class="btn btn-secondary"class="form-control" value="취소하기" style="width:130px;" />
							  </div>
							  
							</form>
			            </div>
			        </div>
			    </div>
			 </div>
			</div>
		    <div class="overlay"></div>
		  </section>
		  
	  <footer id="nextReply" class="bg-dark">
	  		    <div id="commentArea">
					<!-- 의견 쓰기 -->
					<form id="bbsCommentWebForm" class="form-horizontal" action="/bbs/read.htm?docId=2018042316273647&amp;bbsId=bbs00000000000004&amp;workType=1&amp;moduleId=00000000000000&amp;categoryId=&amp;searchRange=0&amp;listType=L&amp;searchKey=subject&amp;searchValue=" method="post">
						<div class="panel panel-info" style="margin:5px 0px;">
					      <div class="panel-heading">
					        <h4 class="panel-title" style="font-size:14px; font-family: inherit;" id="panel-title">
					        	<i class="ace-icon fa fa-quote-left smaller-80"></i>
					        	댓글	- <span id="cmtnum" style="color:#FF6600;">${replyCnt }</span> 개의 댓글이 있습니다.
					        </h4>
					      </div>
					      <div class="panel-body" style="padding: 5px;">			
							<div class="col-xs-12  col-sm-10 g_value" style="border: 0px; padding-top: 8px;">
								<textArea style="display:inline;width: 294px;height:60px;line-height:120%;margin-right: -5;margin-bottom: -26" id="newReplyText" name="replytext" onkeyup="javascript:TextCount(this);"></textarea>
								<button class="btn btn-success" onclick="replyRegist()" type="button" style="display:inline; width:30px; height:62px; border-radius:0px; padding-left:5px;padding-top: 4px; border:1px solid black;">작성</button>
							<br>
							<font color="#656565">현재 <span id="tmptext">0</span>/최대 1000byte(한글 500자, 영문 1000자)</font>
							</div>
					      </div>
					      
						<!-- 	게시판 이미지 max-width 설정 2018-01-15 -->
						
						<div id="comment-tab___" class="tab-pane___ active___" style="    margin: 5px 10px;">
							<div class="comments___ ace-scroll___" style="position: relative;">
							<div class="scroll-track___ scroll-active___" style="display: block; sheight: 300px;">
							<div class="scroll-bar___" style="sheight: 232px; top: 0px;"></div>
							</div>
							<div id="repliesDiv" class="scroll-content___" style="smax-height: 300px;">				
							</div>
							<div class='text-center'>
								<ul id="pagination" class="pagination pagination-sm no-margin ">
									
								</ul>
							</div>									
						</div>		
					</div>		      
				</div>
				     
				</form>
				<!-- 간단한 의견 목록 끝 -->
				
				<c:forEach items="${reply}" var="reply">
				<div class="itemdiv dialogdiv replyLi">
				
					<div class="user" style="border:1px solid black;">
						<div style="font-weight:bold;">
							<img src="<%=request.getContextPath()%>/community/picture/${reply.member_code}" onerror="this.src='<%=request.getContextPath() %>/resources/images/photo_user_default.png'" style="width:30px; height:30px; align:top">
							<a class="maninfo" data-hasqtip="2">${reply.member_name}</a>
							<span class="blue"><fmt:formatDate value="${reply.reply_reg_date}" pattern="yyyy-MM-dd"/></span>
							
							<c:if test="${loginUser eq reply.member_code}">
								<input type="hidden" value="${reply.reply_code}" id="recod" />
								<input type="hidden" value="${reply.member_name}" id="renam" />
								<input type="hidden" value="${reply.reply_contents}" id="recon"/>
								<a onclick="replyMod(this)" data-toggle="modal" href="#replyModi" class="btn btn-primary" style="font-size:12px; color:white; width:54px; height:20px; padding-top:1px;">수정</a>
								<a onclick="replyDel(this)" class="btn btn-danger" style="color:white; width:54px; height: 20px; padding-top:2px; font-size:12px;" >삭제</a>
								<a onclick="replyRes(this)" class="btn btn-secondary" data-toggle="modal" href="#replyRes" style="font-size:12px; color:white; width:54px; height:20px; padding-top:1px;">답장</a>
							</c:if>
							
							<c:if test="${loginUser ne reply.member_code }">
								<input type="hidden" value="${reply.reply_code}" id="recod" />
								<input type="hidden" value="${reply.member_name}" id="renam" />
								<input type="hidden" value="${reply.reply_contents}" id="recon"/>
								<a onclick="replyRes(this)" data-toggle="modal" href="#replyRes" class="btn btn-secondary" style="font-size:12px; width:54px; height:20px; padding-top:1px;">답장</a>
							</c:if>
						</div>
						
						<div style="display:inline; color:white;">
							<i class="ace-icon fa fa-quote-left" style="color:#555;"></i>
							<span style="white-space:pre-wrap;line-height:130%; align:bottom;">${reply.reply_contents}</span>
							<i class="ace-icon fa fa-quote-right" style="color:#555;"></i>
						</div>
						
					</div>
					
					<br/>

					
					<div id="ref" class="body" style="margin-top: -20; margin-bottom: 20px;">
					<c:forEach items="${replyUp}" var="reup">
						<c:if test="${reup.reply_up_code eq reply.reply_code}">
							<ion-icon name="return-right"></ion-icon>
							<p style="display:inline;">작성자 : ${reup.member_name} &</p>
							<p style="display:inline;">작성일 : <fmt:formatDate value="${reup.reply_reg_date}" pattern="yyyy-MM-dd"/></p>
							
							<c:if test="${loginUser eq reup.member_code }">
								<input type="hidden" id="reshiddenCode" value="${reup.reply_code}" />
								<button onclick="resDels(this);" type="button" class="btn btn-danger" style="font-size: 7px; width:50px; height:15px; padding-top:0px;">삭제</button>
							</c:if>
							
							<br/>
							
							<i style="display:inline-block;" class="ace-icon fa fa-quote-left" style="color:#555;"></i>
								<span style="display:inline;">${reup.reply_contents}</span>
							<i style="display:inline-block;" class="ace-icon fa fa-quote-right" style="color:#555;"></i>
							<br/>
						</c:if>
					</c:forEach>
					</div>
				</div>	
				</c:forEach>
				
			</div>
	  </footer>
	  </header>
	  
	  <!-- 댓글수정 -->
	  <div class="modal fade" id="replyModi" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h3>댓글수정</h3>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <form>
		          <div class="form-group">
		            <label for="recipient-name" class="col-form-label">작성자:</label>
		            <input type="text" class="form-control" name="member_name" id="recipient-name" readonly style="background:white;">
		          </div>
		          <div class="form-group">
		            <label for="message-text" class="col-form-label">내용:</label>
		            <textarea class="form-control" name="reply_contents" rows="5" id="message-text"></textarea>
		          </div>
		        </form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
		        <button type="button" class="btn btn-primary" onclick="reply_mod_submit();">수정</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<!-- 답글작성 -->
		  <div class="modal fade" id="replyRes" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h3>답글작성</h3>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <form>
		          <div class="form-group">
		            <label for="message-text" class="col-form-label">내용:</label>
		            <textarea class="form-control" name="reply_contents2" rows="5" id="message-text2"></textarea>
		          </div>
		        </form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
		        <button type="button" class="btn btn-primary" onclick="reply_res_submit();">작성</button>
		      </div>
		    </div>
		  </div>
		</div>
	
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
		$('#commits').css('display','none');
		$('#exits').css('display','none');
		
		 if (window.location.hash) { 
		        //bind to scroll function
		        $(document).scroll( function() {
		            var hash = window.location.hash
		            var hashName = hash.substring(1, hash.length);
		            var element;

		            //if element has this id then scroll to it
		            if ($(hash).length != 0) {
		                element = $(hash);
		            }
		            //catch cases of links that use anchor name
		            else if ($('a[name="' + hashName + '"]').length != 0)
		            {
		                //just use the first one in case there are multiples
		                element = $('a[name="' + hashName + '"]:first');
		            }

		            //if we have a target then go to it
		            if (element != undefined) {
		                window.scrollTo(0, element.position().top);
		            }
		            //unbind the scroll event
		            $(document).unbind("scroll");
		        });
		    }
  		
  	});
	
	var reply_code;
	
	function replyRes(btn){
		reply_code = $(btn).siblings("input[id='recod']").val();
	}
	
	function reply_res_submit(){
		var reply_contents = $("textarea[name='reply_contents2']").val();
		var reply_up_code = reply_code;
		var board_code = $('#board_code').val();
		var board_sort_code = $('#board_sort_code').val();
		
		modal({
  			type: 'confirm',
  			title : '답장 작성',
  			text : '답장을 작성 하시겠습니까?',
  			callback : function(result){
  				
  				if(result){
  					$.ajax({
						url : '<%=request.getContextPath()%>/community/replyResRegist',
						type : 'get',
						data : {
							'reply_up_code' : reply_up_code,
							'reply_contents' : reply_contents,
							'board_code' : board_code,
							'board_sort_code' : board_sort_code
						},
						dataType : 'text',
						success : function(){
							modal({
					  			type: 'alert',
					  			title : '답장 완료',
					  			text : '해당 댓글에 답장이 완료 되었습니다.',
							});
							setTimeout(function(){
								history.go(0);
								replyGo();
							},1000);
						},
						error : function(){
							modal({
					  			type: 'alert',
					  			title : '서버 오류 발생',
					  			text : '서버오류로 인해 해당 답장에 실패 하였습니다.',
							});
						}
					});
  					
  				}
  			}
						
  		});
		
	}
	
	function resDels(btn){
		var reply_code = $(btn).siblings("input[id='reshiddenCode']").val();
		
		modal({
  			type: 'confirm',
  			title : '답글 삭제',
  			text : '답글을 정말 삭제 하시겠습니까?',
  			callback : function(result){
  				
  				if(result){
  					$.ajax({
						url : '<%=request.getContextPath()%>/community/replyDel',
						type : 'get',
						data : {
							'reply_code' : reply_code
						},
						dataType : 'text',
						success : function(){
							modal({
					  			type: 'alert',
					  			title : '답글 삭제 완료',
					  			text : '해당 답글이 삭제 되었습니다.',
							});
							setTimeout(function(){
								history.go(0);
								replyGo();
							},1000);
						},
						error : function(){
							modal({
					  			type: 'alert',
					  			title : '서버 오류 발생',
					  			text : '서버오류로 인해 해당 댓글 삭제에 실패 하였습니다.',
							});
						}
					});
  					
  				}
  			}
						
  		});
		
	}
	
	function replyDel(btn){
		var reply_code = $(btn).siblings("input[id='recod']").val();

 		modal({
  			type: 'confirm',
  			title : '댓글 삭제',
  			text : '댓글을 정말 삭제 하시겠습니까?',
  			callback : function(result){
  				
  				if(result){
  					$.ajax({
						url : '<%=request.getContextPath()%>/community/replyDel',
						type : 'get',
						data : {
							'reply_code' : reply_code
						},
						dataType : 'text',
						success : function(){
							modal({
					  			type: 'alert',
					  			title : '댓글 삭제 완료',
					  			text : '해당 댓글이 삭제 되었습니다.',
							});
							setTimeout(function(){
								history.go(0);
								replyGo();
							},1000);
						},
						error : function(){
							modal({
					  			type: 'alert',
					  			title : '서버 오류 발생',
					  			text : '서버오류로 인해 해당 댓글 삭제에 실패 하였습니다.',
							});
						}
					});
  					
  				}
  			}
						
  		});
	}
	
	function replyMod(btn){
		var reply_code = $(btn).siblings("input[id='recod']").val();
		var member_name = $(btn).siblings("input[id='renam']").val();
		var reply_contents = $(btn).siblings("input[id='recon']").val();
		$('#recipient-name').val(member_name);
		$('#message-text').val(reply_contents);
	}
	
	function reply_mod_submit(){
		var reply_code = $("input[id='recod']").val();
		var reply_contents = $("textarea[name='reply_contents']").val();
		
 		modal({
  			type: 'confirm',
  			title : '댓글 수정',
  			text : '댓글을 수정 하시겠습니까?',
  			callback : function(result){
  				
  				if(result){
  					$.ajax({
						url : '<%=request.getContextPath()%>/community/replyMod',
						type : 'get',
						data : {
							'reply_code' : reply_code,
							'reply_contents' : reply_contents
						},
						dataType : 'text',
						success : function(){
							modal({
					  			type: 'alert',
					  			title : '댓글 수정 완료',
					  			text : '해당 댓글이 수정 되었습니다.',
							});
							setTimeout(function(){
								history.go(0);	
							},1000);
						},
						error : function(){
							modal({
					  			type: 'alert',
					  			title : '서버 오류 발생',
					  			text : '서버오류로 인해 해당 댓글 수정에 실패 하였습니다.',
							});
						}
					});
  					
  				}
  			}
						
  		});
	}
	
	function ale(){
		modal({
			type: 'primary',
			title: '해당 게시판 권한',
			text : "해당 게시판에 권한이 없습니다!"
		});
	}
	
	function replyRegist(){
		var reply_contents = $('#newReplyText').val();
		var board_code = $('#board_code').val();
		var board_sort_code = $('#board_sort_code').val();
		
		if(reply_contents.length == 0){
			modal({
	  			type: 'alert',
	  			title : '댓글확인',
	  			text : '댓글을 입력하여 주세요.',
			});
			return false;
		}
		
		modal({
  			type: 'confirm',
  			title : '댓글 작성',
  			text : '댓글을 작성 하시겠습니까?',
  			callback : function(result){
  				
  				if(result){
				$.ajax({
					url : '<%=request.getContextPath()%>/community/replyRegist',
					data : {
						'reply_contents' : reply_contents,
						'board_code' : board_code,
						'board_sort_code' : board_sort_code
					},
					type : 'get',
					dataType : 'text',
					success : function(){
						modal({
				  			type: 'alert',
				  			title : '댓글 작성 완료',
				  			text : '댓글 작성이 완료되었습니다.',
						});
						setTimeout(function(){
							history.go(0);
							replyGo();	
						},1000);
						
					},
					error : function(){
						modal({
				  			type: 'alert',
				  			title : '서버오류 발생',
				  			text : '댓글 작성이 취소되었습니다.',
						});
					}
				});
  				}
  			}
  		});
	}
	
	function replyGo(){
		var location = document.querySelector('#nextReply').offsetTop;
  		window.scrollTo({top:location, behavior:'smooth'});				
	}
	
	function TextCount(obj){
		var strsubject = obj.value;
		strlength = 0;
		document.getElementById("tmptext").innerHTML = strsubject.length;
		for (cntchar = 0; cntchar < strsubject.length; cntchar++) {
			if (strsubject.charCodeAt(cntchar) > 255){
				strlength += 2;
			}else{
				strlength++;
			}
			if (strlength >= 1000){
				alert("입력 문자는 최대 1000byte이므로 더이상 입력 할 수 없습니다");
				obj.value = obj.value.substring(0, cntchar);
				break;
			}
		}
	}
	
	function goDel(){
  	  	
  	  	modal({
  			type: 'confirm',
  			title : '게시판 삭제',
  			text : '해당 게시판을 정말 삭제 하시겠습니까?',
  			callback : function(result){
  				if(result){
  					community_del();
  				}
  			}
  			
  		});	
		   
 	}
	
	function community_del(){
		var community_code = $('#board_code').val();
		
		$.ajax({
			url : '<%=request.getContextPath()%>/community/community_del',
			data : {'community_code' : community_code},
			type : 'get',
			dataType : 'text',
			success : function(){
		  	  	modal({
		  			type: 'alert',
		  			title : '삭제 완료',
		  			text : '해당 게시판 삭제가 완료 되었습니다..'
		  		});
		  	  	setTimeout(function(){
		  	  		location.href="<%=request.getContextPath()%>/community/mobileList";						
				}, 1300);
			},
			error : function(){
				modal({
		  			type: 'alert',
		  			title : '삭제 실패',
		  			text : '해당 게시판 삭제가 실패 하였습니다.'
		  		});
			}
			
		});
	}
	
	function goMod(){
		
		var community_code = $('#board_code').val();
		var community_title = $('#title').val();
		var community_contents = $('#content').val();
  	  	
  	  	modal({
  			type: 'confirm',
  			title : '게시판 수정',
  			text : '해당 게시판을 정말 수정 하시겠습니까?',
  			callback : function(result){
  				if(result){
  					$.ajax({
  						url : '<%=request.getContextPath()%>/community/community_mod',
  						data : {
  							'community_code' : community_code,
  							'community_title' : community_title,
  							'community_contents' : community_contents
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
		$('#nextReply').css('display', '');
	}
	
	function community_mod(){
		
		$('#btns').click();
		
		$('#writer').css('display', 'none');
		$('#addate').css('display', 'none');
		$('#viewcnt').css('display', 'none');
		$('#content').attr('rows', 15).css('margin-bottom','50');
		
		$('#commits').css('display','inline');
		$('#exits').css('display','inline');
		
		$('#title').prop('readonly', false);
		$('#content').prop('readonly', false);
		
		$('#nextReply').css('display', 'none');
		
	}
	</script>
</html>
