<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<%=request.getContextPath() %>/resources/css/schedule/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/schedule/css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/schedule/css/animate.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/schedule/css/style.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/schedule/font-awesome/css/font-awesome.css" rel="stylesheet">

<style>
    .careerList{
    	cursor:pointer;
    }
    
    .hide{
    	display:none;
    }
    .infor{
    	width : 50px;
    	text-align : center;
    	margin-right : 10px;
    	text-weight : bold;
    }
    #centerDiv{
    	text-align : center;
    }
    
   #sizeDiv{
   	
   	width:100%; 
   	
   	padding-left:20px;

   }
    #leftDiv{
    	text-align : left;
    }
    
    #journalCount{
    	margin-left : 7px;
    }
    
  
   .btns{
   	/* float:right;
   	width:100px; */
   	
   	display : inline;
   	float : right;
   	margin : 5px;
   	
   	
   }
   
   #imgprofile{
		width : 200px;
		height : 250px;
		
	}
	
	/* #leftinfor{
		displya : inline;
	} */
	
	.plus{
		display : inline;
		
		
	}
	
	.plusn:hover , .minusn:hover{
		color : #FF3A36;
	}
	
	/* .careerList:hover{
		color : #FF3A36;
	} */
	
    .switch{
		float : left;
	}
	
	#enabledLabel{
		float : left;
	}
</style>

</head>
<body>
<div class="col-md-12">
<div class="ibox ">
    <div class="ibox-title">
        <h5>상세 정보</h5>
    </div>
<form action="<%=request.getContextPath()%>/member/modifyResident" method="post" id="modifyForm">
	<input type="hidden" name="member_code" value="${resident.member_code }">
    <div id="centerDiv" class="ibox-content no-padding border-left-right">
    <div id="leftinfor">
        <div class="ibox-content no-padding border-left-right">
        <br/>
            <IMG id="imgprofile" class="img-fluid" onerror="this.src='<%=request.getContextPath()%>/resources/images/animal/a16.jpg'" src="<%=request.getContextPath()%>/member/getPicture?picture=${resident.member_picture }&member_code=${resident.member_code }" />
        </div>
            <h4><strong>${resident.member_name }</strong></h4>
            <p><i class="fa"></i>${resident.member_id} </p>
    </div>
       
        <div id="sizeDiv" class="ibox ">
        <div id="leftDiv" class="ibox-content profile-content">
           <h5>
                	정보
            </h5>
            <p>
                	<label class="infor"><i class="fa fa-home"></i></label>${resident.member_address }<br/>
                	<label class="infor"><i class="fa fa-envelope"></i></label>${resident.member_email }<br/>
                	<label class="infor"><i class="fa fa-phone"></i></label>${resident.member_phone }<br/>
                	<%-- <label class="infor"><i class="fa fa-money"></i></label>${superintendent.superintendent_pay }<br/> --%>
	                
                	<label class="infor"><i class="fa fa-pencil"></i></label><input name="member_significant" type="text" value="${resident.member_significant }"><br/>
                	<label class="infor"><i class="fa fa-clock-o"></i></label>${resident.member_recent_login_time }<br/>
            		<div>
	                	<label id="enabledLabel" class="infor"><i class="fa fa-unlock"></i></label>
	                	<div class="switch">
				              <div class="onoffswitch">
				                  <input type="checkbox" name="enabledStr" checked class="onoffswitch-checkbox" id="example1" >
				                  <label class="onoffswitch-label" for="example1">
				                      <span class="onoffswitch-inner"></span>
				                      <span class="onoffswitch-switch"></span>
				                  </label>
				                  <input type="hidden" id="enabledStr" value="${resident.member_enabled }">
				              </div>
				          </div>
				       <div>
	                <br/><br/>
            </p>
            
            
            <%-- 
            
            <h5 class="plus" id="addFacility">
                	담당 시설&nbsp;<i class="fa fa-plus-circle plusn"></i>
            </h5>
            
           	<ul>
           	<c:forEach items="${responsibilityFacility}" var="responsibilityFacility" varStatus="status">
           	<li>${responsibilityFacility.facility_name }<input type="hidden" name="facility_codes[${status.index }].facility_code" class="testlength" value="${responsibilityFacility.facility_code }"><i class="fa fa-minus-circle minusn"></i></li>
           	<li>${responsibilityFacility.facility_name }<input type="hidden" name="facility_codes" value="${responsibilityFacility.facility_code }"><i class="fa fa-minus-circle minusn"></i></li>
           		<li style="display : none">${responsibilityFacility.facility_name }<input type="hidden" name="before_facility_codes" value="${responsibilityFacility.facility_code }"><i class="fa fa-minus-circle minusn"></i></li>
           	</c:forEach>
           	</ul>
            
            
            <h5 class="plus" id="addTask">
                	담당 업무&nbsp;<i class="fa fa-plus-circle plusn"></i>
            </h5>
       		<ul>
           	<c:forEach items="${responsibilityTask}" var="responsibilityTask" varStatus="status">
           	<li>${responsibilityTask.task_contents}<input type="hidden" name="task_codes" value="${responsibilityTask.task_code}"><i class="fa fa-minus-circle minusn"></i></li>
           	<li style="display : none">${responsibilityTask.task_contents}<input type="hidden" name="before_task_codes" value="${responsibilityTask.task_code}"><i class="fa fa-minus-circle minusn"></i></li>
           	</c:forEach>
           	</ul>
              	
            <h5 class="careerList">
                	경력 사항<i id="careerIcon" class="fa fa-sort-desc"></i>
            </h5>
           	<table id="table" class="table hide">
                 <thead>
                 <tr>
                     <th>회사명</th>
                     <th>직무</th>
                     <th>직책</th>
                     <th>입사날짜</th>
                     <th>퇴사날짜</th>
                 </tr>
                 </thead>
                 <tbody>
                 <c:forEach items="${career}" var="career">
                  <tr>
                      <td>${career.career_company_name }</td>
                      <td>${career.career_work_kind }</td>
                      <td>${career.career_position }</td>
                      <td><fmt:formatDate value="${career.career_start_date }" pattern="yyyy-MM-dd" /></td>
                      <td><fmt:formatDate value="${career.career_last_date }" pattern="yyyy-MM-dd" /></td>
                      <td>${career.career_start_date }</td>
                      <td>${career.career_last_date }</td>
                  </tr>
                 </c:forEach>
                 </tbody>
             </table>
	               	
            
            <div class="row m-t-lg">
                <div class="col-md-4">
                    <span class="bar" style="display: none;">5,3,9,6,5,9,7,3,5,2</span><svg class="peity" height="16" width="32"><rect fill="#1ab394" x="0" y="7.111111111111111" width="2.3" height="8.88888888888889"></rect><rect fill="#d7d7d7" x="3.3" y="10.666666666666668" width="2.3" height="5.333333333333333"></rect><rect fill="#1ab394" x="6.6" y="0" width="2.3" height="16"></rect><rect fill="#d7d7d7" x="9.899999999999999" y="5.333333333333334" width="2.3" height="10.666666666666666"></rect><rect fill="#1ab394" x="13.2" y="7.111111111111111" width="2.3" height="8.88888888888889"></rect><rect fill="#d7d7d7" x="16.5" y="0" width="2.3" height="16"></rect><rect fill="#1ab394" x="19.799999999999997" y="3.555555555555557" width="2.3" height="12.444444444444443"></rect><rect fill="#d7d7d7" x="23.099999999999998" y="10.666666666666668" width="2.3" height="5.333333333333333"></rect><rect fill="#1ab394" x="26.4" y="7.111111111111111" width="2.3" height="8.88888888888889"></rect><rect fill="#d7d7d7" x="29.7" y="12.444444444444445" width="2.3" height="3.5555555555555554"></rect></svg>
                  <span id="journalCount" onClick="location.href='일지리스트 검색어에 작성자가 이 멤버아이디인것 검색한채로 띄운다.'"><strong>${journalCount}</strong> 개 의 일지를 작성했습니다.</span>
              </div>
            </div>
            <br/> --%>
            
            <div id="btns" class="ibox-content">
                <button type="button" class="btn btn-default btn-sm btns" onClick='history.go(-1)'>취소</button>
                <input type="button" class="btn btn-primary btn-sm btns" onClick="goSubmit('post','')" value="저장"/>
            </div>
			
    </div>
    </div>
	
</div>
</form>
</div>
</div>




<script src="<%=request.getContextPath() %>/resources/js/schedule/js/jquery-3.1.1.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/popper.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/bootstrap.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/inspinia.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/pace/pace.min.js"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.3/handlebars.min.js" ></script>
<script id="select-template" type="text/x-handlebars-template">
	
	
		{{#each .}}
			<option value="{{facility_code}}">{{facility_name}}</option>
		{{/each}}
	

</script>

<script id="select2-template" type="text/x-handlebars-template">
	
		{{#each .}}
			<option value="{{task_code}}">{{task_contents}}</option>
		{{/each}}

</script>

<script>


$(function(){
	// onload 됐을 때 enabled 가 0이 넘어오면 checked 를 없앰.
	 if($('#enabledStr').val()!=1){
 		$("input[type=checkbox]").prop("checked",false);
 	} 
})


$(document).on('click','.minusn', function(){
	$(this).parent('li').remove();
})


 function goSubmit(cmd,docId){ 
		var frm = document.getElementById("modifyForm");
		switch(cmd) {
			case "post":				 
				//if (!docSubmit()) return;
				docSubmit();
				//frm.submit();
				break;
			case "close":
				if(confirm("편집중인 문서는 저장되지 않습니다 !\n창을 닫으시겠습니까 ?")){
					window.close();
				}
				return;
				break;
			default:
				return;
				break;
		}
	}
function docSubmit(){
		var form = document.getElementById("modifyForm");
		// setEditorForm(); // 에디터의 데이터를 폼에 삽입
	   
		if (!confirm("저장 하시겠습니까?")) return false;

		//$(window).unbind("beforeunload");
		
		
		//waitMsg();	/* Processing message */
		
		form.submit();
	}
    
  /*   $(".careerList").click(function(){
        var career = $(this).next("table");

        if( career.is(":visible") ){
        	// 표가 보이는 상태일 때
        	career.slideUp();
        	
        	$('#careerIcon').removeClass('fa-sort-asc');
        	$('#careerIcon').addClass('fa-sort-desc');
        }else{
        	// 표가 안보이는 상태일 때
        	career.slideDown();
        	$('#careerIcon').removeClass('fa-sort-desc');
        	$('#careerIcon').addClass('fa-sort-asc');
        	
        }
    }); */
    

</script>


</body>
</html>