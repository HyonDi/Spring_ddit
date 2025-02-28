<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  
    <div class="sidebar-content">
      <div class="sidebar-brand">
        <a href="#"><img alt="" src="<%=request.getContextPath()%>/resources/bootstrap/tiles/image/footerLogo.png" width="150px" height="150px"></a><br>
        <span class="user-name">시설물 관리 시스템</span>
        
      </div>
      <div class="sidebar-header">
        
        <div class="user-info">
          <span class="user-name">${loginUser.member_name}님 환영합니다        
          </span>
          <span class="user-role">${loginUser.member_authority}</span>
        </div>
      </div>
      <!-- sidebar-header  -->
   
      <!-- sidebar-search  -->
      <div class="sidebar-menu">
        <ul>
          <li class="sidebar-dropdown">
            <a href="#">
              
              <span>마이페이지 </span>
              
            </a>
            <div class="sidebar-submenu">
              <ul>
               <c:forEach items="${menuList5}" var="menuList">
               		<li>
               		<a onclick="reURL(this)" href="javascript:reURL('${menuList.menu_url}')">${menuList.menu_name}</a>
               		</li>
               </c:forEach>
              </ul>
            </div>
          </li>
          <li class="sidebar-dropdown">
            <a href="#">
             
              <span>인사관리</span>
             
            </a>
            <div class="sidebar-submenu">
              <ul>
               <c:forEach items="${menuList6}" var="menuList">
               		<li>
               		<a onclick="reURL(this)" href="javascript:reURL('${menuList.menu_url}')">${menuList.menu_name}</a>
               		</li>
               </c:forEach>
              </ul>
            </div>
          </li>
          <li class="sidebar-dropdown">
            <a href="#">
              <span>시설 & 재고관리</span>
              
            </a>
            <div class="sidebar-submenu">
              <ul>
                <c:forEach items="${menuList7}" var="menuList">
               		<li>
               		<a onclick="reURL(this)" href="javascript:reURL('${menuList.menu_url}')">${menuList.menu_name}</a>
               		</li>
               </c:forEach>
              </ul>
            </div>
          </li>
          <li class="sidebar-dropdown">
            <a href="#">
              <span>커뮤니티</span>
              
            </a>
            <div class="sidebar-submenu">
              <ul>
                <c:forEach items="${menuList8}" var="menuList">
               		<li>
               		<a onclick="reURL(this)" href="javascript:reURL('${menuList.menu_url}')">${menuList.menu_name}</a>
               		</li>
               </c:forEach>
              </ul>
            </div>
          </li>
        </ul>
      </div>
      <!-- sidebar-menu  -->
    </div>
    <!-- sidebar-content  -->

<!-- page-wrapper -->