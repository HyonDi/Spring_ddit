<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 


	<!-- Page Path Begins -->
	<div class="breadcrumbs" id="breadcrumbs">
		<ul class="breadcrumb">
			<li>게시판</li>
			<li class="active">자유게시판</li>
		</ul>
		<%-- <%@ include file="/WEB-INF/views/commons/user_label.jsp" %> --%>
	</div>
	<!-- Page Path Ends -->
	<!-- Page Content Begins -->	
	<div class="page-content" style="padding-bottoms:8px;">

	<!-- 상단 우측버튼 -->
	<div class="row">
		<div class="wizard-actions">
			<div style="float:left;">
			<!-- 문서 편집 이력 && 익명사용 -->
			</div>
			
			<div>
				<%-- <c:if test="${loginUser.id eq board.writer}">	--%>				
				<button type="button" class="btn btn-sm btn-white btn-bold"  onclick="modify_go('free');">
					<i class="red ace-icon fa fa-pencil bigger-120"></i><b>편집</b>
				</button>		
				<button type="button" class="btn btn-sm btn-white btn-bold" onclick="remove_go('free');" >
					<i class="red ace-icon fa fa-trash bigger-120"></i><b>삭제</b>
				</button>		
				<%-- </c:if>  --%>
				<button type="button" class="btn btn-sm btn-white btn-bold" onclick="javascript:docPrint('document');">
					<i class="grey ace-icon fa fa-print bigger-120"></i><b>인쇄</b>
				</button>
				<button type="button" class="btn btn-sm btn-white btn-bold" onclick="closeDoc();">
					<i class="grey ace-icon fa fa-times bigger-120"></i><b>닫기</b>
				</button>
			</div>
		</div>
		
	</div>
	<!-- 상단 우측버튼 -->
	
	<form id="search" class="form-horizontal" action="/bbs/read.htm?docId=2018042316273647&amp;bbsId=bbs00000000000004&amp;workType=1&amp;moduleId=00000000000000&amp;categoryId=&amp;searchRange=0&amp;listType=L&amp;searchKey=subject&amp;searchValue=" method="post">
	
		<div class="hr_line">&nbsp;</div> 
		<div class="form-group"><!-- label의 for명은 input 개체명과 연관을 가지도록 기술 -->
			<label for="" class="col-xs-4  col-sm-2 control-label no-padding-right bolder g_label">제목</label>
			<div class="col-xs-8  col-sm-10 g_value" style="padding-top: 8px;">${board.title }</div>
		</div>
	
		<!--  본문 영역 -->
		<div class="form-group">
		<div class="col-xs-12  g_value" style="min-height: 250px; padding: 8px 3px 3px; margin: 0px; overflow: auto;">
	  		<p>${board.content}<br></p>
		</div>
		</div>
		
		<table id="btntbl">
			<tr>
				<td class="tblspace09"></td>
			</tr>
		</table>

		<input type="hidden" name="attachobj" value="">
	<!-- 조회시 파일 첨부 컨트롤 삽입 -->
	</form>

	<div id="ajaxIndicator" style="display:none"><span>Loading</span></div>

	<div id="commentArea">
	
	<!-- 의견 쓰기 -->
	<form id="bbsCommentWebForm" class="form-horizontal" action="/bbs/read.htm?docId=2018042316273647&amp;bbsId=bbs00000000000004&amp;workType=1&amp;moduleId=00000000000000&amp;categoryId=&amp;searchRange=0&amp;listType=L&amp;searchKey=subject&amp;searchValue=" method="post">
		<div class="panel panel-info" style="margin:5px 0px;">
	      <div class="panel-heading">
	        <h4 class="panel-title" style="font-size:14px; font-family: inherit;" id="panel-title">
	        	<i class="ace-icon fa fa-quote-left smaller-80"></i>
	        	댓글	- <span id="cmtnum" style="color:#FF6600;">${board.replycnt }</span> 개의 의견이 있습니다.
			 
	        </h4>
	      </div>
	      <div class="panel-body" style="padding: 5px;">			
			<div class="col-xs-12  col-sm-10 g_value" style="border: 0px; padding-top: 8px;">
			<textArea style="width:100%; height:60px; line-height:120%;" id="newReplyText" name="replytext" onkeyup="javascript:TextCount(this);"></textarea>
			<br>
			<a id="editButton" style="display:none;" href="javascript:goCommentSubmit('edit','')">편집</a>		
			<font color="#656565">현재 <span id="tmptext">0</span>/최대 1000byte(한글 500자, 영문 1000자)</font>
			</div>
			<div id="commentSave" style="margin:8px;">
				
				<button type="button" class="btn btn-white btn-xs radius-4" onclick="reply_regist_go();" title="save">
					<i class="red ace-icon fa fa-pencil-square-o bigger-160"></i>
				</button>
			</div>			
	      </div>
	      
		<!-- 	게시판 이미지 max-width 설정 2018-01-15 -->
		<style>
			img{max-width: 820px;}
		</style>
		
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
</div>
</div>

<!-- Modal -->
<div id="modifyModal" class="modal fade in" >
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title"></h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>        
      </div>
      <div class="modal-body" data-rno>
        <p><input type="text" id="replytext" class="form-control"></p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-info" id="replyModBtn">Modify</button>
        <button type="button" class="btn btn-danger" id="replyDelBtn">DELETE</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>            




<%@ include file="/WEB-INF/views/board/free/free_detail_js.jsp" %>
<%@ include file="/WEB-INF/views/board/free/reply.jsp" %>

</body>





