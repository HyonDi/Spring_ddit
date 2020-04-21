<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%-- siteMesh 사용하기 위해 필요한 태그라이브러리 --%>
<%-- include할 jsp 파일에도 넣어줘야함 --%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>

<%@ include file="/WEB-INF/views/include/header.jsp" %>

<%-- 가져올 화면(jsp)의 body태그 안의 내용만 가져온다(script를 body안에 넣어야한다) <body></body>가 구분자 역할 --%>
<decorator:body />


<%@ include file="/WEB-INF/views/include/footer.jsp" %>