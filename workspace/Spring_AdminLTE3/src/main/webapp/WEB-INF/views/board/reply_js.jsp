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
	/* var jsonData = [
	    {
	        "rno": 0,
	        "bno": 243,
	        "replytext": "방가방가",
	        "replyer": "mimi",
	        "regdate": 1587456848000,
	        "updatedate": 1587456848000
	      },
	      {
	        "rno": 1,
	        "bno": 243,
	        "replytext": "방가방가",
	        "replyer": "mimi",
	        "regdate": 1587456976000,
	        "updatedate": 1587456976000
	      }
		
	]; */ // ajax로 받을거야.

	
	// 핸들바에 레지스터헬퍼?
	// timeValue= gettimes한 값.
	// 월은 0~11까지여서 +1한것.
	// 일은 1부터시작함.
	// prettifydate 는 property고 value가 timeValue.....
	// 우리는 Jsone데이터를받는다.
	// 핸들바내에 prettifydate라는 함수가 생성이되고
	// 호출이가능해진다....??????
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
	
<%-- var printData=function(replyArr, target, templateObject){ // 여러번사용할것이기때문에 function으로 만들어둔다.
		//var templateObject = $('#reply-list-template'); // 스크립트 객체화??
		var template=Handlebars.compile(templateObject.html()); // jason객체컴파일하는거래.
		var html = template(replyArr);
		target.after(html); 
		console.log(html);
		alert(html);
	// detailboard.jsp 에있는 repliesDiv에 html(댓글들) 을 병렬로 놓는다.
	} --%>
	
	var printData=function(replyArr,target,templateObject){
		var template=Handlebars.compile(templateObject.html());
		var html = template(replyArr);
		$('.replyLi').remove(); // 앞내용지우고 붙이는것!
		target.after(html);
	}
	
	
	<%-- function getPage(pageInfo){
		alert("<%=request.getContextPath()%>/replies/list.do?bno=${param.bno}&page="+replyPage);
		$.getJSON(pageInfo, function(data){
			printData(data.reply, $('#repliesDiv'), $('#reply-list-template'));
			console.log(data);
		});
	} --%>
	
	function getPage(pageInfo){
		
		$.ajax({
			url : pageInfo,
			type : "get",
			success : function(dataMap){
				printData(dataMap.replyList,$('#repliesDiv'),$('#reply-list-template'));
				printPaging(dataMap.pageMaker, $('.pagination'));
			},
			error:function(error){
				alert("서버 장애로 댓글 목록을 불러올 수 없습니다.");
			}
			
		});
<%-- 		$.getJSON(pageInfo,function(data){	
			printData(data.replyList,$('#repliesDiv'),$('#reply-list-template'));
			printPaging(data.pageMaker, $('.pagination'));
			
			댓글처음등록할때에 -1이 나올수도 있어!방지위한 조치.
			if(data.pageMaker.realEndPage>0){
				realEndPage=data.pageMaker.realEndPage;
			}
		}); --%>
		
	}
	
	
	//reply pagination
	// pageMaker : json데이터야. 
	// tarket : 어디에 뿌릴건지!
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
			//============위까지가 요청
			
			// =============아래는 요청결과를 처리된결과를 받는거
			<%-- success:function(data){
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
			} --%>
			success:function(data){
				var result=data.split(',');
				//alert(result + ": result");
				alert('댓글이 등록되었습니다.');
				getPage("<%=request.getContextPath()%>/replies/list.do?bno=${board.bno}&page="+data);
				$('#newReplyText').val("");
			},
			error :function(error){
				alert('댓글등록이 취소되었습니다.')
				window.location.reload(true);
			}
		});
		
	});
	
	//reply modify
	$('div.timeline').on('click','#modifyReplyBtn',function(event){
		// alert("modify reply click");
		var replyer=$(event.target).attr("data-replyer");
	// 로그인사용자확인
	//String으로 비교할거니가 큰따옴표 꼭 써줘야한다. 안쓰면 변수로 mimi를 찾는다. String mimi를 찾아야하는데!
		/* if(replyer!="${loginUser.id}"){
			alert("수정 권한이 없습니다.");
			$(this).attr("data-toggle","");
		} */
		
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
			contentType:"application/json",
			success:function(result){
				alert("수정되었습니다.");
				getPage("<%=request.getContextPath()%>/replies/list.do?bno=${board.bno}&page=" +replyPage);
			},
			error:function(error){
				alert("수정에 실패했습니다.");
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
				/* contentType:"application/json", */
				success:function(data){
					alert("삭제되었습니다.");
					getPage("<%=request.getContextPath()%>/replies/list.do?bno=${board.bno}&page="+data);
					
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