<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body text="000000" bgcolor="ffffff" style="margin:1px;">

<table border="0" style="font-size:9pt; width:100%;" cellspacing=0 cellpadding=0>
	<tr>
		<td valign="middle" align=center width=110>
			<tr><td background="<%=request.getContextPath()%>/resources/images/etc_infor_vline.gif" height=1></td></tr>
			<tr height=22>
				<c:set var="phone" value="${company.company_charge_phone}" />
				<td>&nbsp;<img src="<%=request.getContextPath()%>/resources/images/etc_infor_dot.gif" border=0>&nbsp;휴대폰 : <a style="color:black;" href="tel:${company.company_charge_phone }"> ${fn:substring(phone, 0, 3)} - ${fn:substring(phone, 3, 7)} - ${fn:substring(phone, 7, 11)}</a></td>
			</tr>
			<tr><td background="<%=request.getContextPath()%>/resources/images/etc_infor_vline.gif" height=1></td></tr>
			<tr height=22>
				<td>&nbsp;<img src="<%=request.getContextPath()%>/resources/images/etc_infor_dot.gif" border=0>&nbsp;이메일 : <a style="color:black;" href="mailto:${company.company_charge_email}">${company.company_charge_email}</a></td>
			</tr>
			<tr><td background="<%=request.getContextPath()%>/resources/images/etc_infor_vline.gif" height=1></td></tr>
			<tr height=22>
				<td>&nbsp;<img src="<%=request.getContextPath()%>/resources/images/etc_infor_dot.gif" border=0>&nbsp;회사주소 : ${company.company_address}</td>
			</tr>
			
		</td>
	</tr>
</table>
</body>
</html>