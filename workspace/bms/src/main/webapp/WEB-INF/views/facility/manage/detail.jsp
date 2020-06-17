<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="<%=request.getContextPath() %>/resources/css/schedule/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath() %>/resources/css/schedule/css/plugins/iCheck/custom.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath() %>/resources/css/schedule/css/animate.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath() %>/resources/css/schedule/css/style.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath() %>/resources/css/schedule/font-awesome/css/font-awesome.css"
	rel="stylesheet">

<style>
.careerList {
	cursor: pointer;
}

.hide {
	display: none;
}

.infor {
	width: 50px;
	text-align: center;
	margin-right: 10px;
}

#centerDiv {
	text-align: center;
}

#sizeDiv {
	width: 100%;
	padding-left: 20px;
}

#leftDiv {
	text-align: left;
}

#journalCount {
	margin-left: 7px;
}

.btns {
	/* float:right;
   	width:100px; */
	display: inline;
	float: right;
	margin: 5px;
}

#imgprofile {
	width: 200px;
	height: 250px;
}

#hideitem {
	display: none;
}

.btn btn-xs btn-info hide{
	display:none;
}

.btn btn-xs btn-info{
	display:inline;
	width: 10%;
}

#addbtn{
	margin-left:10px;
}
#check{
	display:inline;
}

#modifybtn, #deletebtn{
	float:right;
	margin : 0px 10px
}
td{
	display:block;
	height:50px;
}
.check{
	display:none;
}
.form{
	float:right;
	margin : 0px 10px;
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
						<br /> <IMG id="imgprofile" style="width: 400px; height: 300px;"
							class="img-fluid" alt="image"
							src="<%=request.getContextPath()%>/facility_stock/facility_management/getPicture?picture=${facility.facility_picture}&facility_code=${facility.facility_code}" />
					</div>
					<h4>
						<strong>해당시설 이미지</strong>
					</h4>
				</div>

				<div id="sizeDiv" class="ibox ">
					<div id="leftDiv" class="ibox-content profile-content">
						<h5>정보</h5>
						<p>
							<label class="infor"><i class="fa fa-home"></i></label>${facility.facility_name}<br />
						</p>
						<%-- <input type="hidden" value="${facility.facility_code}">
          	<input type="hidden" value="${checkList.facility_code}">
          	 --%>

						<h5 id="check" class="careerList">
							시설 점검 사항<i id="careerIcon" class="fa fa-sort-desc"></i>
						</h5>
						<button id="addbtn" type="button" class="btn btn-xs btn-info hide" onclick="RegistCheck();">추가</button>
						<table id="table" class="table hide">
							<thead>
								<tr>
									<th style="color: red">점검내용</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${empty checkList}">
									<tr>
										<td colspan="1"><strong>해당 내용이 없습니다.</strong></td>
									</tr>
								</c:if>
									<tr id="checkListtr">
									<c:forEach items="${checkList}" var="checkList">
										<input type="hidden" id="facility_codeRes" value="${checkList.facility_code}" />
										<input type="hidden" id="check_pointRes" value="${checkList.check_point_facility_code}" />
										<td>${checkList.check_point_facility_contents}
										<button id="modifyFormbtn" type="button" class="btn btn-xs btn-info form">수정</button>
										<button onclick="location.href='<%=request.getContextPath()%>/facility_stock/facility_management/modifyCheckList?check_point_facility_code=${checkList.check_point_facility_code}'" id="modifybtn" type="button" class="btn btn-xs btn-info check">확인</button>
										<button onclick="location.href='<%=request.getContextPath()%>/facility_stock/facility_management/deleteCheckList?check_point_facility_code=${checkList.check_point_facility_code}'" id="deletebtn" type="button" class="btn btn-xs btn-info">삭제</button>
										</td>
									</c:forEach>
									</tr>
							</tbody>
						</table>


						<br />
						
						<div id="btns" class="ibox-content">
							<button type="button" class="btn btn-primary btn-sm btns"
								onClick="closeDoc()">뒤로 가기</button>
							<button type="button" class="btn btn-default btn-sm btns"
								onClick="goRemove()">시설 삭제</button>
							<button type="button" class="btn btn-primary btn-sm btns"
								onClick="location.href='<%=request.getContextPath()%>/facility_stock/facility_management/modifyForm?facility_code=${facility.facility_code}'">시설
								수정</button>
						</div>

					</div>
				</div>

			</div>
		</div>
	</div>




	<script
		src="<%=request.getContextPath() %>/resources/js/schedule/js/jquery-3.1.1.min.js"></script>
	<script
		src="<%=request.getContextPath() %>/resources/js/schedule/js/popper.min.js"></script>
	<script
		src="<%=request.getContextPath() %>/resources/js/schedule/js/bootstrap.js"></script>
	<script
		src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script
		src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<!-- Custom and plugin javascript -->
	<script
		src="<%=request.getContextPath() %>/resources/js/schedule/js/inspinia.js"></script>
	<script
		src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/pace/pace.min.js"></script>

	<script>

    $(document).ready(function(){
        $(".careerList").click(function(){
            var career = $(this).next().next("table");
 
            if( career.is(":visible") ){
            	// 표가 보이는 상태일 때
            	career.fadeOut();
            	
            	$('#careerIcon').removeClass('fa-sort-asc');
            	$('#careerIcon').addClass('fa-sort-desc');
           		$('#addbtn').addClass('btn btn-xs btn-info hide');
            }else{
            	// 표가 안보이는 상태일 때
            	career.fadeIn();
            	$('#careerIcon').removeClass('fa-sort-desc');
            	$('#careerIcon').addClass('fa-sort-asc');
            	$('#addbtn').removeClass('hide');
            	
              }
        });
    });

	function goRemove(){
		
		if (!confirm("삭제 하시겠습니까?")) return false;
		
		location.href='<%=request.getContextPath()%>/facility_stock/facility_management/delete?facility_code=${facility.facility_code }';
		
	}
	
function closeDoc() {
	//$(window).unbind("beforeunload");
		
		if ( window.opener ) {
			window.close();
		} else {
			try {
		 		var ifrm = $(window.frameElement).parent();
		 		var mdiv = ifrm.parent();
		 		mdiv.remove();
			} catch(e) {
				//alert( ifrm );
			}
		}
	}
// var checkIndex=${checkList.size()};
checkIndex=0;
function RegistCheck(){
	
	var input;
	var button;
	var registcheckbtn;
	var name = ["check_point_facility_contents"];
	for(var i = 0;i<name.length;i++){
		input=$('<input>').attr({
			"type":"text",
			"name":"checkList["+checkIndex+"]"
		}).css({
			"width":"60%",
			"textAlign":"center",
			"margin-top":"10px",
			"display":"inline"
		});
		button=$('<button>X</button>').attr({
			"type":"button",
			"class":"btn btn-xs btn-info del",
			"display":"inline",
		}).css({
			"margin-left":"30px"
		})
		$('#checkListtr').append(input).append(button);
	}
	checkIndex++;
	
	registcheckbtn=$('<button>등록</button>').attr({
		"type":"button",
		"class":"btn btn-xs btn-info qwer",
		"onclick":"registCheckList()",
		"display":"block"
	}).css({
		"margin-top":"20px"
	});
	
	if($('.qwer').length==1){
		return false;
	}
	$('tbody').append(registcheckbtn);
}

$(document).on('click','.del',function(){
	$(this).prev('input').remove();
	$(this).remove();//btn
});

$(document).on('click','.del',function(){
	$(this).prev('input').remove();
	$(this).remove();//btn
});

<%-- $(document).on('click', '.qwer',function(){
	var idx = checkIndex;
	var chknums = $("input[name='checkList["+checkIndex+"]'");
	alert("도큐 : " + chknums.attr('value'));
	
	
	location.href='<%=request.getContextPath()%>/facility_stock/facility_management/registCheckList?facility_code=${facility.facility_code}'
}); --%>

function registCheckList(){
	var idx = checkIndex;
	
// 	var facility_code = $("input[id='#facility_codeRes']:eq(0)").val();
	var check_point_facility_code = $("input[id='#check_pointRes']").val();
	
	for(var i = 0; i < idx; i++){
		check_point_facility_contents = $("input[name='checkList["+i+"]'").val();
		
		$.ajax({
			url : '<%=request.getContextPath()%>/facility_stock/facility_management/registCheckList?facility_code=${facility.facility_code}',
			data : {
				'check_point_facility_contents' : check_point_facility_contents,
				'check_point_facility_code' : check_point_facility_code
			},
			type : 'get',
			dataType : 'text',
			success : function(){
				alert("점검사항이 등록되었습니다");
				window.location.reload();
				career.fadeIn();
            	$('#careerIcon').removeClass('fa-sort-desc');
            	$('#careerIcon').addClass('fa-sort-asc');
            	$('#addbtn').removeClass('hide');
				
			},
			error : function(){
				
			}
		});
		
	}
	
}

</script>


</body>
</html>