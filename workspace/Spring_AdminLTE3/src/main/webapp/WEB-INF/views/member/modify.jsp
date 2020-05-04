<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <%@ include file="/WEB-INF/views/include/open_header.jsp" %> --%>

<body>
  <div class="content-wrapper">
	<!-- Content Header (Page header) -->
	  <section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>회원상세</h1>
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
				        <li class="breadcrumb-item">
				        	<a href="lis">
					        	<i class="fa fa-dashboard"></i> 회원관리
					        </a>
				        </li>
				        <li class="breadcrumb-item active">
				        	상세보기
				        </li>		        
   	  				</ol>
 				</div>
 			</div>
		</div>
	</section>
  
    <section class="content register-page" style="height: 586.391px;">       
		<div class="register-box" style="min-width:450px;">
	    	<form role="form" class="form-horizontal" action="modifySubmit.do" method="post">
				<input type="hidden" name="picture" value="${member.picture}"/>
	        	<div class="register-card-body" >
	        	<div class="card-header">
	              	<div class="row">
	              		<button type="button" id="modifyBtn" class="btn btn-warning col-sm-4 text-center" onclick="SubmitMember('form');">수정하기</button>
	              		<div class="col-sm-4"></div>
	              		<button type="button" id="cacelBtn" class="btn btn-default pull-right col-sm-4 text-center">취 소</button>
			          		
		          	</div> 
		          	</div>
	        		<div class="row">		
									<%-- 기존데이터 유지를 위해 value값 넣어놓음. 이미지를 안바꿨을 때를 대비함. success 시에 picture_js에서 name=picture 를 가져올것임.???--%>
						
						<div class="input-group col-md-12">
							<div class="col-md-12" style="text-align: center;">
							<br/>
								<div class="" id="pictureView" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto; margin-bottom:5px;"></div>														
								<div class="input-group input-group-sm">
									<label for="inputFile" class=" btn btn-warning btn-sm btn-flat input-group-addon">파일선택</label>
									<input id="inputFileName" class="form-control" type="text"/>
									<span class="input-group-append-sm">											
										<button type="button" class="btn btn-info btn-sm btn-append" onclick="upload_go();">업로드</button>											
									</span>
								</div>						
							</div>												
						 </div>
					</div>	
					<br />
	                <div class="form-group row" >
	                  <label for="inputEmail3" class="col-sm-3 control-label text-right">아이디</label>
	                  <div class="col-sm-9">
	                    <input name="id" type="text" readonly class="form-control" id="inputEmail3" value="${member.id }">
	                  </div>
	                </div>
	
	                <div class="form-group row">
	                  <label for="inputPassword3" class="col-sm-3 control-label text-right">패스워드</label>
	                  <div class="col-sm-9">
	                    <input name="pwd" type="password" class="form-control" id="inputPassword3" value="${member.pwd }">
	                  </div>
	                </div>
	                <div class="form-group row">
	                  <label for="inputPassword3" class="col-sm-3 control-label text-right">이&nbsp;&nbsp;름</label>
	                  <div class="col-sm-9">
	                    <input name="name" type="text" class="form-control" id="inputPassword3" value="${member.name }">
	                  </div>
	               </div>
	                <div class="form-group row">
	                  <label for="inputPassword3" class="col-sm-3 control-label text-right">이메일</label>
	                  <div class="col-sm-9">
	                    <input name="email" type="email" class="form-control" id="inputPassword3" value="${member.email }">
	                  </div>
	                </div>
	                <%-- <div class="form-group row">
	                  <label for="inputPassword3" class="col-sm-3 control-label text-right">전화번호</label>
	                  <div class="col-sm-9">   
	                  	<input name="phone" type="text" class="form-control" id="inputPassword3" value="${member.phone.substring(0,3) }-${member.phone.substring(3,7)}-${member.phone.substring(7) }">	                
	                  </div>                  
	                </div>  --%>  
	                <!-- // 안되면 삭제하기 -->
	                
	                <div class="form-group row">
							<label for="phone" class="col-sm-3 control-label text-right">전화번호</label>
							<div class="col-sm-9">	
								<div class="input-group-sm">
									<select style="width:93px;" name="phone" id="phone" class="form-control float-left">
										<option value="${member.phone.substring(0,3) }">${member.phone.substring(0,3) }</option>
										<option value="010">010</option>
										<option value="011">011</option>
										<option value="017">017</option>
										<option value="018">018</option>
									</select>							
									<label class="float-left" style="padding: 0; text-align: center;">&nbsp;-&nbsp;</label>										
									<input style="width:93px;" name="phone" type="text" class="form-control float-left" value="${member.phone.substring(3,7)}"/>
									<label class="float-left" style="padding: 0; text-align: center;">&nbsp;-&nbsp;</label>
									<input style="width:93px;" name="phone" type="text" class="form-control float-left" value="${member.phone.substring(7)}" />						
								</div>
							</div>
						</div>
	                
	                <!-- // -->            
	              </div> <!-- card body -->
	              <%-- <div class="card-footer">
	              	<div class="row">
	              		<button type="button" id="modifyBtn" class="btn btn-warning col-sm-4 text-center" onclick="SubmitMember('form');">수정하기</button>
	              		<div class="col-sm-4"></div>
	              		<button type="button" id="cacelBtn" class="btn btn-default pull-right col-sm-4 text-center">취 소</button>
			          		
		          	</div>  	
	              </div> --%> 		          	     
	      	  </form>
      	  </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

<form role="imageForm" action="upload/picture.do" method="post" enctype="multipart/form-data">
	<input id="inputFile" name="pictureFile" type="file" class="form-control" style="display:none;">
	<input type="hidden" id="oldFile" name="oldPicture" value="${member.picture}"/> <%-- value 미리넣어야함. --%>
	<input type="hidden" name="checkUpload" value="${empty member.picture ? '0':'1'}"/>
	
<%-- 	<input type="hidden" name="checkUpload" value="
	
		<c:choose> --> if else 에 해당하는 것. tomcat이 먼저 여기를 읽고 실행하기때문에 checkUpload 의 vaue에 값이 들어간다. 위랑 동일.
			<c:when test="${empty member.picture}">
				0
			</c:when>
			<c:otherwise>
				1
			</c:otherwise>
		</c:choose>

	"/>  --%>

</form>


<%-- <%@ include file="/WEB-INF/views/include/open_footer.jsp" %> --%>
<%@ include file="picture_js.jsp" %>
<script>
	var imageURL="picture/get.do?picture=${member.picture}";
	$('div#pictureView').css({'background-image':'url('+imageURL+')',
							  'background-position':'center',
							  'background-size':'cover',
							  'background-repeat':'no-repeat'
	});
	
	
/* 	$('#modifyBtn').on('click', function(e){
		//alert("${param.id}님 정보 수정이 정상적으로 완료되었습니다.");
		location.href="detail?id=${member.id}";
		
	}); */
	
	$('#cacelBtn').on('click', function(e){
		//location.href="stop?id=${member.id}";
		history.go(-1);
	});
</script>

</body>




  
  