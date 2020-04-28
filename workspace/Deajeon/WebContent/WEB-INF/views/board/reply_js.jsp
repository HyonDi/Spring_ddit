<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.6/handlebars.js"></script>
<script type="text/x-handlebars-template" id="reply-list-template">
	{{#each .}}
<div class="replyLi" data-rno={{rno}}>
	<i class="fas fa-comments bg-yellow"></i>
 	<div class="timeline-item" >
  		<span class="time">
    		<i class="fa fa-clock"></i>{{prettifyDate regdate}}
	 		<a class="btn btn-primary btn-xs" id="modifyReplyBtn"
	    		data-replyer={{replyer}} data-toggle="modal" data-target="#modifyModal">Modify</a>
  		</span>
	
  		<h3 class="timeline-header"><strong style="display:none;">{{rno}}</strong>{{replyer}}</h3>
  		<div class="timeline-body">{{replytext}} </div>
	</div>
</div>
{{/each}}
</script>

<script>
	
	Handlebars.registerHelper("prettifyDate",function(timeValue){
		var dateObj = new Date(timeValue);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth()+1;
		var date = dateObj.getDate();
		return year + "/" + month + "/" + date;
	})
	
			
			
			
			
			
	
var replyPage=1;
<%-- var realEndPage=1;  --%>
	
	
getPage("<%=request.getContextPath()%>/replies/list.do?bno=${board.bno}&page="+replyPage);
	
	
	var printData=function(replyArr,target,templateObject){
		var template=Handlebars.compile(templateObject.html());
		var html = template(replyArr);
		$('.replyLi').remove(); 
		target.after(html);
	}

	
	function getPage(pageInfo){	
		$.getJSON(pageInfo,function(data){	
			printData(data.replyList,$('#repliesDiv'),$('#reply-list-template'));
			printPaging(data.pageMaker, $('.pagination'));

		});
	}
	

	var printPaging = function(pageMaker,target){
		
		var str="";
		
		// prev 버튼을 만든다.
		if(pageMaker.prev){
			str +="<li class='page-item'><a class='page-link' href='"+(pageMaker.startPage-1) +"'> <i class='fas fa-angle-left'/> </a></li>";
		}

		// 해당페이지에 색넣기! active로
		for(var i=pageMaker.startPage; i <= pageMaker.endPage; i++){
			var strClass= pageMaker.cri.page == i ? 'active' : '';
			str +="<li class='page-item " + strClass + "'><a class='page-link' href='"+i+"'>" + i +"</a></li>";
		}
		
		// next 버튼
		if(pageMaker.next){
			str +="<li class='page-item'><a class='page-link' href='"+(pageMaker.endPage+1) +"'> <i class='fas fa-angle-right'/> </a></li>";
		}
		
		
		target.html(str);
	}
	
	$('.pagination').on('click','li a', function(event){
		//alert("reply page click");
		
		event.preventDefault();// 페이지네이션의 1,2,3,4,5... 번호 클릭 시 페이지이동 막는다. 
		//(a태그에 href에 숫자넣어놔서 원래는 이동되어야하는데 우리는 ajax?로 비동기처리 하기때문에 이동시키지않을것임.) 
		replyPage = $(this).attr("href");// 누른 페이지번호(a태그의 href속성값)를 받아온다.
		
		// 절대주소계속 주는 이유 : url은 boardDetail로 되어있기때문에 상대주소를 줄 수 없다.(댓글관련된거니까)
		getPage("<%=request.getContextPath()%>/replies/list.do?bno=${board.bno}&page="+replyPage);
		// 누른페이지번호 가져와서 그쪽으로 페이지 이동시킨다.
	});
	
	
	
	<%--detailBoard에 이벤트줍니다.(등록)--%>
	$('#replyAddBtn').on('click', function(e){
		//alert('add reply btn');
		var replyer=$('#newReplyWriter').val();
		var replytext=$('#newReplyText').val();
		
		// 최소한의 유효성으로!
		if(replytext==""){
			alert('댓글내용을 입력해주세요.');
			$('#newReplyText').focus().css("boarder-color","red").attr("placeholder","내용은 필수입니다.");
			return;
		}
	
		
		// 제이슨데이터. 보낼때 stringify ..?
		//
		var data={
			"bno":"${board.bno}",
			"replyer":replyer,
			"replytext":replytext
		}
		
		<%--보낼 때
			restful방식! 화면을보내는게아니라 데이터를 받아서 내보내는형식?--%>
		$.ajax({
			url:"<%=request.getContextPath()%>/replies/regist.do",
			type:"post",
			data:JSON.stringify(data),
			contentType:"application/json", <%--보내는 data 형식 지정--%>
			dataType:"text", <%-- 받는 ㅇata 형식 지정--%>
			
			success:function(data){
				var result=data.split(',');
				//alert(result + ": result");
				if(result[0]=="SUCCESS"){
					alert('댓글이 등록되었습니다.');
					getPage("<%=request.getContextPath()%>/replies/list.do?bno=${board.bno}&page="+result[1]);
					
					$('#newReplyText').val("");
				}else{
					window.location.reload(true);
					// alert('댓글등록이 취소되었습니다.')
					return;
				}
			}
		});
		
	})
	
	//reply modify
	$('div.timeline').on('click','#modifyReplyBtn',function(event){
		// alert("modify reply click");
		var replyer=$(event.target).attr("data-replyer");
	// 로그인사용자확인
	//String으로 비교할거니가 큰따옴표 꼭 써줘야한다. 안쓰면 변수로 mimi를 찾는다. String mimi를 찾아야하는데!
		if(replyer!="${loginUser.id}"){
			alert("수정 권한이 없습니다.");
			$(this).attr("data-toggle","");
		}
		
	});
	
	// 수정창에 data 표시
	$('div.timeline').on('click', '.replyLi',function(event){
		var reply=$(this);
		$('#replytext').val(reply.find('.timeline-body').text());
	// DATA-TOGGLE 주는이유 : MODAL 때문.
		$('.modal-title').html(reply.attr('data-rno'));
	});
	
	
	
	
	
	$('#replyModBtn').on('click', function(event){
		// alert("modify action btn");
		var rno=$('.modal-title').text();
		var replytext=$('#replytext').val();
		
		
		var sendData={
				"rno":rno,
				"replytext":replytext
		}
		
		$.ajax({
			url:"<%=request.getContextPath()%>/replies/modify.do",
			type:"post",
			data:JSON.stringify(sendData),
			success:function(result){
				if(result=="SUCCESS"){
					alert("수정되었습니다.");
					getPage("<%=request.getContextPath()%>/replies/list.do?bno=${board.bno}&page=" +replyPage);
				}else{
					alert("수정이 실패했습니다.");
				}
			},
			error:function(error){
				alert("삭제에 실패했습니다.");
			},
			complete:function(){
				$('#modifyModal').modal('hide');
			}
		});
	});
		
		$('#replyDelBtn').on('click', function(event){
			// alert("delete action btn");
			var rno=$('.modal-title').text();
			
			var sendData={
					"bno":"${board.bno}",
					"rno":rno,
					"page":replyPage
			};
			
			$.ajax({
				url:"<%=request.getContextPath()%>/replies/remove.do",
				type:"post",
				data:JSON.stringify(sendData),
				success:function(data){
					var result = data.split(',');
					if(result[0]=="SUCCESS"){
						alert("삭제되었습니다.");
						getPage("<%=request.getContextPath()%>/replies/list.do?bno=${board.bno}&page="+result[1]);
					}
				},
				error:function(error){
					alert("삭제에 실패했습니다.");
				},
				complete:function(){
					$('#modifyModal').modal('hide');
				}
			})
		});
	
</script>