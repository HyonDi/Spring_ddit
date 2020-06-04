<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


<!DOCTYPE html>
<!-- saved from url=(0041)http://new.kmsmap.com/common/userinfo.htm -->
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보</title>
<style>
td {font-size:9pt;}
</style>
</head>
<body text="000000" bgcolor="ffffff" style="margin:1px;">
<!-- 전체 div 사이즈 353px 임 -->
<!-- 타이틀 바 사이즈 -->
	<table width="100%" cellspacing="0" cellpadding="0" border="0" style="border:1px solid #ADADAD;">
		<tr height="26">
			<td width="*" background="/resources/common/userinfo_files/etc_infor_ti_bg.gif">
				<font color="#5a7f10" style="font-size:9pt"><b>&nbsp;&nbsp;${member.id}</b></font>
			</td>
			<td width="20" align="center" background="/resources/common/userinfo_files/etc_infor_ti_bg.gif">
			
			</td>
	</tr>
	</table>
	<table border="0" style="font-size:9pt; width:100%;" cellspacing="0" cellpadding="0">
		<tr>
			<td valign="middle" align="center" width="110">
	<!-- 		<img id='userphoto'  SRC="../userdata/photos/20180117182355" BORDER=0 width="100" height="120"  -->
	<!-- 		onerror="this.src='../common/images/photo_user_default.gif';"> -->
			<img id="userphoto" src="/resources/common/userinfo_files/photo_user_default.gif" border="0" width="100" height="120" onerror="this.src=&#39;../common/images/photo_user_default.gif&#39;;">
			</td>
			<td valign="center">
				<table id="Info" width="99%" border="0" cellpadding="0" cellspacing="0">
					<tr height="22">
						<td>&nbsp;<img src="/resources/common/userinfo_files/etc_infor_dot.gif" border="0">&nbsp;부서 : 중앙정보시스템</td>
					</tr>
					<tr><td background="/resources/common/userinfo_files/etc_infor_vline.gif" height="1"></td></tr>
					<tr height="22">
						<td>&nbsp;<img src="/resources/common/userinfo_files/etc_infor_dot.gif" border="0">&nbsp;직급 : 사원</td>
					</tr>
					<tr><td background="/resources/common/userinfo_files/etc_infor_vline.gif" height="1"></td></tr>
					<tr height="22">
						<td>&nbsp;<img src="/resources/common/userinfo_files/etc_infor_dot.gif" border="0">&nbsp;업무 : </td>
					</tr>
					<tr><td background="/resources/common/userinfo_files/etc_infor_vline.gif" height="1"></td></tr>
					<tr height="22">
						<td>&nbsp;<img src="/resources/common/userinfo_files/etc_infor_dot.gif" border="0">&nbsp;전화 : ${member.phone }</td>
					</tr>
					<tr><td background="/resources/common/userinfo_files/etc_infor_vline.gif" height="1"></td></tr>
					<tr height="22">
						<td>&nbsp;<img src="/resources/common/userinfo_files/etc_infor_dot.gif" border="0">&nbsp;휴대폰 : ${member.phone }</td>
					</tr>
					<tr><td background="/resources/common/userinfo_files/etc_infor_vline.gif" height="1"></td></tr>
					<tr height="22">
	
						<td>&nbsp;<img src="/resources/common/userinfo_files/etc_infor_dot.gif" border="0">&nbsp;이메일 : <a href="mailto:test1@">${member.email }@</a></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>