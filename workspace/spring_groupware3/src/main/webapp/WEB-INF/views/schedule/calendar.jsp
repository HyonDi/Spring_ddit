<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    

<%@ include file="./subMenu.jsp" %>

<div class="page-content main-content" style="padding: 0px;">	
	<div id="if_list_div" style="position:relative;sheight:0;padding:0;soverflow:hidden;" class="show">
		<div id="if_list" name="if_list" style="position: absolute; top: 0px; left: 0px; bottom: 0px; height: 796px; width: 100%; border: 0px;" class="no-skin listBody">
			<div class="breadcrumbs" id="breadcrumbs" style="border:none;">
				<ul class="breadcrumb">
					<li>
						<i class="ace-icon fa fa-calendar home-icon bigger-150"></i>
						&nbsp;일정관리
					</li>
					<li class="active">
						캘린더
					</li>
				</ul>
				<div class="nav-search" id="nav-search">
					<div data-toggle="buttons" class="btn-group" id="gubun-search">
						<label class="btn btn-xs btn-grey no-border active">
							<input type="radio" id="guA" name="gubun" value="" checked="checked">
							<i class="menu-icon fa fa-font"></i>
							전체
						</label>
			
						<label class="btn btn-xs btn-light no-border">
							<input type="radio" id="guS" name="gubun" value="S">
							<i class="menu-icon fa fa-user-circle-o"></i>
							공유일정
						</label>
			
						<label class="btn btn-xs btn-light no-border">
							<input type="radio" id="guP" name="gubun" value="P">
							<i class="menu-icon fa fa-user"></i>
							개인일정
						</label>	
						<select name="scid" id="scid" onchange="reloadCal()" style="height: 26px; display: none;"><option value="">전체</option></select>					
					</div>
					
				</div>
			</div>
			
			<div class="page-content main-content" style="padding:0;">
				<!-- Page Content Begins -->
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<div id='calendar'></div>
						</div>
					</div>
				</div>
				<!-- Page Content Ends -->					
			</div>
		</div>
	</div>
</div>

<%@ include file="./calendar_js.jsp" %>


