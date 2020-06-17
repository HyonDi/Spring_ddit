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
	
    .careerList:hover{
		color : #FF3A36;
	}
	
	/* .inlinediv{
		display : inline;
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
    <div id="centerDiv" class="ibox-content no-padding border-left-right">
    <div id="leftinfor">
        <div class="ibox-content no-padding border-left-right">
        <br/>
            <IMG id="imgprofile" onerror="this.src='<%=request.getContextPath()%>/resources/images/animal/a16.jpg'" class="img-fluid" src="<%=request.getContextPath()%>/member/getPicture?picture=${resident.member_picture }&member_code=${resident.member_code }" />
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
	                
                	<label class="infor"><i class="fa fa-pencil"></i></label>${resident.member_significant }<br/>
                	<label class="infor"><i class="fa fa-clock-o"></i></label>${resident.member_recent_login_time }<br/>
            		<div>
	                 <label id="enabledLabel" class="infor"><i class="fa fa-unlock"></i></label> 
	                	<div class="switch inlinediv">
				              <div class="onoffswitch inlinediv">
				                  <input type="checkbox" checked disabled class="onoffswitch-checkbox" id="example1">
				                  <label class="onoffswitch-label" for="example1">
				                      <span class="onoffswitch-inner"></span>
				                      <span class="onoffswitch-switch"></span>
				                  </label>
				                  <input type="hidden" id="enabledStr" value="${resident.member_enabled }">
				              </div>
				          </div>
	                </div>
	                <br/><br/>
            </p>
            
            
            
            
           <%--  <h5>
                	담당 시설
            </h5>
            
             	<ul>
             	<c:forEach items="${responsibilityFacility}" var="responsibilityFacility">
             	<li>${responsibilityFacility.facility_name }</li>
             	</c:forEach>
             	</ul>
            
            <h5>
                	담당 업무
            </h5>
          		<ul>
              	<c:forEach items="${responsibilityTask}" var="responsibilityTask">
              	<li>${responsibilityTask.task_contents}</li>
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
            <br/>
             --%>
            <div id="btns" class="ibox-content">
                <button type="button" class="btn btn-default btn-sm btns" onClick="goRemove()">계정 삭제</button>
                <button type="button" class="btn btn-primary btn-sm btns" onClick="location.href='<%=request.getContextPath()%>/member/modifyResident?member_code=${resident.member_code }'">계정 수정</button>
            </div>
			
    </div>
    </div>
	
</div>
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

<script>
    $(document).ready(function(){
    	
    		
    	 if($('#enabledStr').val()!=1){
    		$("input[type=checkbox]").prop("checked",false);
    	} 
    	
    });
    
    function goRemove(){
		
		if (!confirm("삭제 하시겠습니까?")) return false;
		
		location.href='<%=request.getContextPath()%>/member/deleteResident?member_code=${resident.member_code }';
		
	}
</script>


</body>
</html>