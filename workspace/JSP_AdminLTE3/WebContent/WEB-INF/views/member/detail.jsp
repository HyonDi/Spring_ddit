<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/include/open_header.jsp" %>


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
	    	<form role="form" class="form-horizontal" action="regist.do" method="post"><%--여기 왜 regist.do 일까? --%>
	    	
	        	<div class="register-card-body" >
	        		<div class="card-header">
	        			<div class="row">
			          		<div class="col-sm-3 text-center">
			          		
			          		<%-- 이 페이지에서는 이벤트구현할것입니다. --%>
			          			<button type="button" id="modifyBtn" class="btn btn-warning ">수 정</button>
			          		</div>
			          		<div class="col-sm-3text-center">
				          		<button type="button" id="deleteBtn" class="btn btn-danger" >삭 제</button>
			          		</div>
			          		<div class="col-sm-3 text-center">
			          			<button type="button" id="stopBtn" class="btn btn-info" >정 지</button>
			          		</div>
			          		<div class="col-sm-3 text-center">
			            		<button type="button" id="listBtn" onclick="CloseWindow();" class="btn btn-primary pull-right">닫 기</button>
			            	</div>
		          	    </div>  	
	        		</div>
	        		<br/>
	            	<div class="row"  style="height:200px;">
						<div class="mailbox-attachments clearfix col-md-12" style="text-align: center;">							
							<div id="pictureView" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;"></div>														
						</div>
					</div>
					<br />
	                <div class="form-group row" >
	                  <label for="inputEmail3" class="col-sm-3 control-label text-right">아이디</label>
	                  <div class="col-sm-9">
	                    <input name="id" type="text" class="form-control" readonly id="inputEmail3" value="${member.id }">
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
	                    <input name="name" type="text" class="form-control" id="inputName3" value="${member.name }">
	                  </div>
	               </div>
	                <div class="form-group row">
	                  <label for="inputPassword3" class="col-sm-3 control-label text-right">이메일</label>
	                  <div class="col-sm-9">
	                    <input name="email" type="email" class="form-control" id="inputPassword3" value="${member.email }">
	                  </div>
	                </div>
	                <div class="form-group row">
	                  <label for="inputPassword3" class="col-sm-3 control-label text-right">전화번호</label>
	                  <div class="col-sm-9">   
	                  	<input name="phone" type="text" class="form-control" id="inputPassword3" value="${member.phone.substring(0,3) }-${member.phone.substring(3,7)}-${member.phone.substring(7) }">	                
	                  </div>                  
	                </div> 
	              </div>  		          	     
	      	  </form>
      	  </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

<!-- post parameter -->
<form name="postForm">
	<input type="hidden" name="id" value="${member.id }" />
</form>


<%@ include file="/WEB-INF/views/include/open_footer.jsp" %>

<script>
<%-- 	$.ajax({
		url : "picture/get?picture=abcdefg.jpg",
		type: "get",
		success:function(data){
			alert(data);
		}
	}); 
--%>
	var imageURL="picture/get?picture=${member.picture}"; // var imageURL="picture/get?picture=3e810dd179ef43a8ab88267bd9167d84.jpg";
	
	$('div#pictureView').css({'background-image' : 'url('+imageURL+')',
								'background-position' : 'center',
								'background-size' : 'cover',
								'background-repeat' : 'no-reapeat'
	});
	<%-- ajax를 이용하지않고 background image를 url로 직접 넣었다. --%>
	
	
	$('#modifyBtn').on('click', function(e){
		//alert("modify btn click!") -test
		// 현재화면에서 수정버튼누르면 저장, 취소버튼 나오게하고 readonly 해놨던거 풀고 해도되지만 servlet이용하는게 더 안전하다.
		location.href="modify?id=${member.id}";
		
	});
	
	$('#stopBtn').on('click', function(e){
		location.href="stop?id=${member.id}";
	});
	
	$('#deleteBtn').on('click', function(e){
		<%-- 비밀번호를 입력받을 것이다. 확인취소버튼누르게하는것보다 타이핑을시켜야함. --%>
		var pwd = prompt("암호를 입력하세요.","password","여긴 안나옴!!");
		
		/* if(pwd=="${loginUser.pwd}"){
			location.href="remove?id=${member.id}";
			// 저 member.id가 세션이종료되어도 나온다. 막는방법 -> ajax. jlpt 로. c:if를 써야하는데 script랑 혼용못해서 ajax를 사용해야한다.
			// tomcat이 먼저 c:if를 해석함. 사용자가 입력한부분은 그 후야. 
			<c:if test=""></c:if>
		}else{
			alert("패스워드가 일치하지 않습니다.");
			return;
		} */
		
		
		// ajax 방식
			$.ajax({
				url:"checkPassword?pwd="+pwd,
				type:"get",
				success:function(data){
					// alert(data);
					if(data=="SUCCESS"){
						location.href="remove?id=${member.id}";
					}else{
						alert("패스워드가 일치하지 않습니다.");
					}
				}
		}); 
		
		
/* 		// getjosn 은 타입을 json으로 제한시켜서 여기서 사용불가능한가보다.
 	$.getJSON("checkPassworld?pwd="+pwd,function(data){
			alert(data);
			if(data=="SUCCESS"){
				
			}else{
				
			}
		})*/
		
	}); 
	
	

</script>





  
  