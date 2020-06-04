<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


<script>
	function detail_pds_go(pno){
		var detail_target=$('a[data-target="'+pno+'"]');
		var id = '${loginUser.id}'; 
		var dept_no = '${loginUser.dept_no}';
		
		var shareData=detail_target.attr("share-data");		
		if(shareData.indexOf(id) > 0 || shareData.indexOf(dept_no) > 0){
			OpenWindow("detail?pno="+pno,"","800","600");
			return;
		}
		
		alert("공유대상자가 아닙니다.");
	}

</script>