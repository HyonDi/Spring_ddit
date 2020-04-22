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
    		<i class="fa fa-clock"></i>{{regdate}}
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

var replyPage=1;
var realEndPage=1; 
	
	
getPage("<%=request.getContextPath()%>/replies/list.do?bno=${param.bno}&page="+replyPage);
	
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
		$.getJSON(pageInfo,function(data){	
			printData(data.replyList,$('#repliesDiv'),$('#reply-list-template'));
		});
	}
</script>