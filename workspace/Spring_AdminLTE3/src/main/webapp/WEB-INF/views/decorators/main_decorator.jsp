<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%-- <%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %> --%>

<%@ include file="/WEB-INF/views/include/header.jsp"%>


<%-- <decorator:body/> --%>
<!-- jsp에 '바디태그있으면 바디태그내용 여기에 붙이고, 없으면 싹가져와서 가져다붙여라.' 는뜻. 
script는 바디태그안에넣어야해. 바디만 가져와서 스크립트빠져부림. 바디태그없으면 어디에써도상관없지만 가져오면 어쨋든 바디태그안으로 들어오게됨.
왜냐면 인클루드한 헤더, 푸터에서 바디태그 열고닫기때문임. -->







<%@ include file="/WEB-INF/views/include/footer.jsp"%>