<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body class="no-skin">
	<div class="main-content">
		<div class="main-content-inner">	
			<div class="page-content main-content" style="padding:0;">
				<div class="no-skin listBody" style="overflow:auto;">
					<div class="breadcrumbs" id="breadcrumbs" style="">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon bigger-150"></i>
								커뮤니티 Home
							</li>
						</ul>
					</div>
					
					<div class="page-content" style="padding-top:0px; padding-bottom:0px;">			
						<div id="main-widget-container">
							
							<div class="row" style="/*background-color:#f8f8f8;*/">
								
								<div class="center">
									<span class="btn btn-app btn-sm btn-light no-hover" style="margin: 15px 10px; width: 130px;" data-rel="tooltip" 
									      data-placement="bottom" title="최근 1주일내 등록된 공지사항" data-original-title="Bottm Info">
										<span class="line-height-1 bigger-170 blue"> <span>0</span></span><br>
										<span class="line-height-1 smaller-90"> 중요공지사항 </span>
									</span>
			
									<span class="btn btn-app btn-sm btn-yellow no-hover" style="margin: 15px 10px; width: 130px;" data-rel="tooltip" 
										  data-placement="bottom" title="최신 1주일내 등록된 자유게시글" data-original-title="Bottm Info">
										<span class="line-height-1 bigger-170"> <span>4</span> </span><br>
										<span class="line-height-1 smaller-90"> 최신자유게시글 </span>
									</span>
			
									<span class="btn btn-app btn-sm btn-pink no-hover" style="margin:15px 10px; width: 130px;" data-rel="tooltip" 
										  data-placement="bottom" title="최근 1주일내 등록된 자료 수" data-original-title="Bottm Info">
										<span class="line-height-1 bigger-170"> <span>0</span> </span><br>
										<span class="line-height-1 smaller-90"> 완료된문서 </span>
									</span>
			
									<span class="btn btn-app btn-sm btn-grey no-hover" style="margin: 15px 10px; width: 130px;" data-rel="tooltip" data-placement="bottom" title="임시보관함에 저장된 문서의 수" data-original-title="Bottm Info" onclick="parent.reURL('MENU020102');parent.onSubMenu('MENU020102');">
										<span class="line-height-1 bigger-170"> <span id="appr_idx4">2</span> </span><br>
										<span class="line-height-1 smaller-90"> 임시보관함 </span>
									</span>			
								
								</div>
														
								<!-- 우측 count -->
							</div>
						</div>		
					</div>
				</div>
			</div>
		</div>
	</div>	
</body>