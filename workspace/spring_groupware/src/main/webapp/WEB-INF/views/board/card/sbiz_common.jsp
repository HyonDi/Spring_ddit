<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script>
/*
 * 화면너비 체크
 */
function wCatch() {

	var
		status
	,	wc	= $('.w_catch')
	,	wcP = wc.find('.wc_p').css('display')
	,	wcT = wc.find('.wc_t').css('display')
	,	wcM = wc.find('.wc_m').css('display')
	;

	return "block" === wcP ? status = "p" : "block" === wcT ? status = "t" : "block" === wcM ? status = "m" : void 0

}


</script>