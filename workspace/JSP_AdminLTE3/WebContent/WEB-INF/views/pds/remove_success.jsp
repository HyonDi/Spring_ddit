<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	alert("${loginUser.id}님 글 삭제 완료되었습니다.");
	
	window.close();
	/* window.opener.location.reload(true); */
	
	/* window.opener.location.href="list.do${pageMaker.makeQuery()}"; // 주소줄 정리 위해서 아래로 바꿈.pageination에있는 searchList_go 메서드*/
	/* form 태그만들어서 post로 submit하면 주소줄을 정리 가능하다. */
	opener.parent.searchList_go(${pageMaker.cri.page},"<%=request.getContextPath()%>/pds/list.do");
	
</script>

