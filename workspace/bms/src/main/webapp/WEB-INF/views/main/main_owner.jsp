<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="<%=request.getContextPath()%>/resources/js/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main/main.css" />
<title></title>

<style></style>

</head>

<body>

	<div class="main-card">
		<div class="card ">
			<div class="card-inner">
				<div class="card-front">
					<div class="top-letter">
						인사 관리
					</div>
					<div class="bottom-image">
						<img src="http://placeimg.com/280/350/people" alt="인사관리 이미지">
					</div>
				</div>
				<div class="card-back">
					<div class="top-letter">
						인사 관리
					</div>
					
					<div class="bottom-menu">
						<ol>
							<c:forEach items="${menuList1}" var="menuList">	
									<li><a href="${menuList.menu_url }">&emsp;&emsp;&emsp;${menuList.menu_name }</a></li>
							</c:forEach>
						</ol>
					</div>
				</div>
			</div>
		</div>
		
		<div class="card ">
			<div class="card-inner">
				<div class="card-front">
					<div class="top-letter">
						계약 & 납부 관리
					</div>
					<div class="bottom-image">
						<img src="http://placeimg.com/280/350/payment" alt="계약 & 납부 관리 이미지">					
					</div>
				</div>
				<div class="card-back">
					<div class="top-letter">
						계약 & 납부 관리
					</div>
					<div class="bottom-menu">
						<ol>
							<c:forEach items="${menuList2}" var="menuList">	
									<li><a href="${menuList.menu_url }">&emsp;&emsp;&emsp;${menuList.menu_name }</a></li>
							</c:forEach>
						</ol>
					</div>
				</div>
			</div>
		</div>
		
		<div class="card ">
			<div class="card-inner">
				<div class="card-front">
					<div class="top-letter">
						시설 & 재고 관리
					</div>
					<div class="bottom-image">
						<img src="http://placeimg.com/280/350/facility" alt="시설 & 재고 관리 이미지">
					</div>
				</div>
				<div class="card-back">
					<div class="top-letter">
						시설 & 재고 관리
					</div>
					<div class="bottom-menu">
						<ol>
							<c:forEach items="${menuList3}" var="menuList">	
									<li><a href="${menuList.menu_url }">&emsp;&emsp;&emsp;${menuList.menu_name }</a></li>
							</c:forEach>
						</ol>
					</div>
				</div>
			</div>
		</div>
		
		<div class="card ">
			<div class="card-inner">
				<div class="card-front">
					<div class="top-letter">
						커뮤니티
					</div>
					<div class="bottom-image">
						  <img src="http://placeimg.com/280/350/community" alt="커뮤니티이미지">
					</div>
				</div>
				<div class="card-back">
					<div class="top-letter">
						커뮤니티
					</div>
					<div class="bottom-menu">
						<ol>
							<c:forEach items="${menuList4}" var="menuList">	
									<li><a href="${menuList.menu_url }">&emsp;&emsp;&emsp;${menuList.menu_name }</a></li>
							</c:forEach>
						</ol>
					</div>
				</div>
			</div>
		</div>
	</div>
<script>

</script>
<script src="<%=request.getContextPath() %>/resources/js/main/main.js"></script>
</body>
</html>