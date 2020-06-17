<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title></title>
    <link href="<%=request.getContextPath() %>/resources/css/schedule/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/schedule/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/schedule/css/plugins/chosen/bootstrap-chosen.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/schedule/css/plugins/bootstrap-tagsinput/bootstrap-tagsinput.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/schedule/css/plugins/colorpicker/bootstrap-colorpicker.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/schedule/css/plugins/cropper/cropper.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/schedule/css/plugins/switchery/switchery.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/schedule/css/plugins/jasny/jasny-bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/schedule/css/plugins/nouslider/jquery.nouislider.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/schedule/css/plugins/datapicker/datepicker3.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/schedule/css/plugins/ionRangeSlider/ion.rangeSlider.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/schedule/css/plugins/ionRangeSlider/ion.rangeSlider.skinFlat.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/schedule/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/schedule/css/plugins/clockpicker/clockpicker.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/schedule/css/plugins/daterangepicker/daterangepicker-bs3.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/schedule/css/plugins/select2/select2.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/schedule/css/plugins/touchspin/jquery.bootstrap-touchspin.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/schedule/css/plugins/dualListbox/bootstrap-duallistbox.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/schedule/css/animate.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/schedule/css/style.css" rel="stylesheet">

<style>
	.clock{
		height : 30px;
	}
	
	#newSortCode, #sortCode, #endTime{
		margin-right : 10px;	
	}
	
	#topIbox{
		height : 100%;
	}
	
	#buttonDiv{
		text-align : right;
	}
	
	.titleDiv{
		background : #e74c3c;
		color : white;
	}
	
	#title{
		margin-left : 20px;
	}
	
	input{
		background-color : #EB7F71;
		background : #EB7F71;
		color : #EB7F71;
	}
	
	.noneborder{
		border : none;
		padding-left : 0px;
		padding-right : 0px;
	}
	
	.colorbox{
		height : 30px;
		width : 30px;
		padding : 0px;
		margin : 0px;
		margin-right : 10px;
	}
	
	#colorText{
		height : 20px;
	}
</style>


</head>

<body>
	<div class="titleDiv">
		<br/>
		<h1 id="title"> <b>일정 확인</b> </h1>
		<br/>
	</div>



<form method=POST>
	<div class="ibox-content">
		<div class="form-group" id="data_5">
			<h3>날짜</h3>
			<div class="input-daterange input-group" id="asd">
			        <input id="startDate" readonly type="text" class="form-control-sm form-control" name="schedule_start_date" value="${oneSchedule.schedule_start_date} ">
			        <span class="input-group-addon"> &emsp;~&emsp; </span>
			        <input id="endDate" readonly type="text" class="form-control-sm form-control" name="schedule_end_date" value="${oneSchedule.schedule_end_date}"><!-- value="05/22/2014" -->
		    </div>
		</div>
		
		<br/>
	
		<div class="clockPick">
		    <h3>시간</h3>
		    <div class="form-group input-daterange input-group">
			    
			          <input id="startTime" class="form-control clock " readonly name="schedule_start_time" type="text" placeholder="시작 시간">
			          <span class="input-group input-group-addon clock "> &emsp;~&emsp; </span>
			          <input id="endTime" class="form-control clock " readonly name="schedule_end_time" type="text" placeholder="종료 시간">
			        
			          <input type='checkbox' disabled id='isAllDay' value="isAllDay" class="i-checks icheckbox_square-grey makeCheck" <c:if test="${oneSchedule.schedule_isallday==1}">checked="checked"</c:if> />
	            	  <label id="isAllDayLabel" for='isAllDay' onclick="ichk(this);">종일</label>
	            	  <input id="isAllDayCheck" name="schedule_isallday" type="text" hidden="true"/>
			</div>
		</div>
		
		<br/>
		
		<div class="contents input-group">
			<div class="form-control noneborder">
				<h3>내용</h3>
				<input name="schedule_name" readonly class="form-control" type="text" value="${oneSchedule.schedule_name}"/>
			</div>
			<div>&emsp;&emsp;</div>
			<div class="form-control noneborder">
				<h3>상세 설명</h3>
				<input name="schedule_contents" readonly class="form-control" type="text" value="${oneSchedule.schedule_contents}"/>
			</div>
		</div>
		
		<br/>
		
		<div class="sortCode">
			<h3>일정 분류</h3>
			<div class="form-group input-daterange input-group">
			
				<input class="form-control" id="newSortCode" type="text" name="new_schedule_sort_code" placeholder="새로운 일정분류명을 입력해주세요." hidden="true"/>

				<!-- 색상 rgb 들어온 곳 -->	            
	            <input class="form-control" id="colorText" hidden="true" name="schedule_sort_color"/>
	            <!-- 색상선택하는 div -->
	            <div id="colorPick" hidden="true">
		            <div data-color="rgb(255, 255, 255)" id="demo_apidemo" class="back-change colorpicker-element colorbox" style="background-color: rgb(100, 100, 100);">
	            	<!-- <input id="colorText" type="text" class="form-control demo1 colorpicker-element" value="#5367ce"> -->
	                      <div class="ibox-tools">
	                          <a class="collapse-link">
	                              <i class="fa fa-chevron-up"></i>
	                          </a>
	                          <a class="dropdown-toggle" data-toggle="dropdown" href="#">
	                              <i class="fa fa-wrench"></i>
	                          </a>
	                          <ul class="dropdown-menu dropdown-user">
	                              <li><a href="#" class="dropdown-item">Config option 1</a>
	                              </li>
	                              <li><a href="#" class="dropdown-item">Config option 2</a>
	                              </li>
	                          </ul>
	                          <a class="close-link">
	                              <i class="fa fa-times"></i>
	                          </a>
	                      </div>
	                  </div>
                  </div>
	            <!--  -->
	            
	            <select disabled name="schedule_sort_code" class="form-control" id="sortCode">
	            
	            	<c:forEach items="${scheduleSortcodeList }" var="sortCodeList">
	            		<c:if test="${sortCodeList.schedule_sort_code eq oneSchedule.schedule_sort_code}">
	            			<option value="${sortCodeList.schedule_sort_code }" selected>${sortCodeList.schedule_sort_name}</option>
	            		</c:if>
	            		<c:if test="${sortCodeList.schedule_sort_code ne oneSchedule.schedule_sort_code}">
	            			<option value="${sortCodeList.schedule_sort_code }">${sortCodeList.schedule_sort_name}</option>
	            		</c:if>
	            		<%-- <option value="${sortCodeList.schedule_sort_code }">${sortCodeList.schedule_sort_name}</option> --%>
	            	</c:forEach>
            		<!-- 
            		이렇게 받고싶어서 modelandview썼음.
            		
            		 -->
	            </select>
	
	            <%-- <input type='checkbox' id='makeSortCode' name="isNewCode" class="i-checks icheckbox_square-grey makeCheck" /> --%>
	           <%--  <label id="makeSortCodeLabel" for='makeSortCode' onclick="ichk(this);">새 일정분류 만들기</label> --%>
             </div>
		</div>
		<br/>
		
		<!-- 이페이지는 스케쥴 등록하는 페이지니까 -->
		<input type="text" name="schedule_istodolist" hidden="true" value="0"/>

		<div id="buttonDiv" class="ibox-content">
		<br/>
			<button type="button" class="btn btn-outline btn-success" onclick="location.href='<%=request.getContextPath()%>/mypage/schedule_management/updateSchedule?schedule_code=${oneSchedule.schedule_code}'">수&emsp;정</button>
			<button type="button" class="btn btn-outline btn-default" onclick="closeDoc();">닫&emsp;기</button>													
			<%-- <button type="button" class="btn btn-outline btn-default" onClick="remove_go();">삭&emsp;제</button> --%>
		</div>
	</div>
</form>










<!-- script -->
 <!-- Mainly scripts -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/jquery-3.1.1.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/popper.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/bootstrap.js"></script>

<!-- Custom and plugin javascript -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/inspinia.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/pace/pace.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Chosen -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/chosen/chosen.jquery.js"></script>

<!-- JSKnob -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/jsKnob/jquery.knob.js"></script>

<!-- Input Mask-->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/jasny/jasny-bootstrap.min.js"></script>

<!-- Data picker -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/datapicker/bootstrap-datepicker.js"></script>

<!-- NouSlider -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/nouslider/jquery.nouislider.min.js"></script>

<!-- Switchery -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/switchery/switchery.js"></script>

 <!-- IonRangeSlider -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/ionRangeSlider/ion.rangeSlider.min.js"></script>

<!-- iCheck -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/iCheck/icheck.min.js"></script>
<!-- MENU -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/metisMenu/jquery.metisMenu.js"></script>

<!-- Color picker -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>

<!-- Clock picker -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/clockpicker/clockpicker.js"></script>

<!-- Image cropper -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/cropper/cropper.min.js"></script>

<!-- Date range use moment.js same as full calendar plugin -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/fullcalendar/moment.min.js"></script>

<!-- Date range picker -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/daterangepicker/daterangepicker.js"></script>

<!-- Select2 -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/select2/select2.full.min.js"></script>

<!-- TouchSpin -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/touchspin/jquery.bootstrap-touchspin.min.js"></script>

<!-- Tags Input -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/bootstrap-tagsinput/bootstrap-tagsinput.js"></script>

<!-- Dual Listbox -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/dualListbox/jquery.bootstrap-duallistbox.js"></script>
<script>

/*  $(".icheckbox_square-grey").on('change','.iCheck-helper',function(e){
	  
  	alert("aaaaa");
	   if(this.checked){
	       // 체크돼있으면 select 를 숨기고 input을 나타나게.
	       //$('select[]').prop("hidden",hidden);
	       alert("checked");
	  } else{
		  // 체크 안돼있으면 select을 나타내고 input을 숨긴다.
		  //$('select[]').prop("hidden",false);
		  alert("unchecked");
	  }  
  }); */
  

  
  
  function goSubmit(cmd,docId){ 
		var frm = document.getElementById("registForm");
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
  
 
  
  
  function ichk(as){
	  
	  ick = as.getAttribute("id");
	  
	  if(ick == null){
		  ick = as.parentNode.firstChild.getAttribute("id");
	  }
	  
	  thisId = ick.indexOf("make");
	  
	  /* if(thisId == 0){
		  alert("메이크");
	  }else if(thisId < 0){
		  alert("이즈올");
	  } */ 
	  
	if(thisId==0){
		if($('#makeSortCode').prop("checked")){
		   // select 가 뜨게. 새로 안만든다.
			  $('select[id="sortCode"]').attr("hidden",false);
		      $('input[id="newSortCode"]').attr("hidden",true);
		      $('#colorPick').attr("hidden",true);
		  } else{
			// input이 뜨게. 새로 만든다.
			  $('select[id="sortCode"]').attr("hidden",true);
		      $('input[id="newSortCode"]').attr("hidden",false);
		      $('#colorPick').attr("hidden",false);
		  }   
	}	  
	  
	 if(thisId < 0){
		/* $('#starTime').attr('disabled','disabled');
		$('#endTime').attr('disabled','disabled'); */
		 if($('#isAllDay').prop("checked")){
			// 종일 아닐 때
			  $('#startTime').attr('readonly',false);
			  $('#startTime').attr('value','');
			  $('#endTime').attr('readonly',false);
			  $('#endTime').attr('value','');
			  $('#isAllDayCheck').attr('value',0);
			  //alert($('#isAllDayCheck').val());
			
		  } else{
			// 종일일때
			  $('#startTime').attr('readonly',true);
			  $('#startTime').attr('value','-');
			  $('#endTime').attr('readonly',true);
			  $('#endTime').attr('value','-');
			  $('#isAllDayCheck').attr('value',1);
			  
			  //alert($('#isAllDayCheck').val());
		  }
	}	   
	  
  } 
  
  // rgb 를 16진수로 바꾸는 함수
  function rgb2hex(rgb) {
     if (  rgb.search("rgb") == -1 ) {
          return rgb;
     } else {
          rgb = rgb.match(/^rgba?\((\d+),\s*(\d+),\s*(\d+)(?:,\s*(\d+))?\)$/);
          function hex(x) {
               return ("0" + parseInt(x).toString(16)).slice(-2);
          }
          return "#" + hex(rgb[1]) + hex(rgb[2]) + hex(rgb[3]); 
     }
	}

  

  
  $(document).ready(function(){
	
	
	  
	  if($('#isAllDay').prop("checked")){
		// 종일일때
		  $('#startTime').attr('readonly',true);
		  $('#startTime').attr('value','-');
		  $('#endTime').attr('readonly',true);
		  $('#endTime').attr('value','-');
		  $('#isAllDayCheck').attr('value',1);
		  //alert($('#isAllDayCheck').val());
	  } else{
		// 종일 아닐 때
		  $('#startTime').attr('readonly',false);
		  $('#startTime').attr('value','');
		  $('#endTime').attr('readonly',false);
		  $('#endTime').attr('value','');
		  $('#isAllDayCheck').attr('value',0);
		  //alert($('#isAllDayCheck').val());
	  }
	  
	  // 시계
/* 	  $('.clockpicker2').clockpicker({
	    'default': 'now',
	    vibrate: true,
	    placement: "bottom",
	    align: "left",
	    autoclose: true,
	    twelvehour: false
	  });

	  
      $('.tagsinput').tagsinput({
          tagClass: 'label label-primary'
      });

      var $image = $(".image-crop > img")
      var $cropped = $($image).cropper({
          aspectRatio: 1.618,
          preview: ".img-preview",
          done: function(data) {
              // Output the result data for cropping image.
          }
      }); */

      var $inputImage = $("#inputImage");
      if (window.FileReader) {
          $inputImage.change(function() {
              var fileReader = new FileReader(),
                      files = this.files,
                      file;

              if (!files.length) {
                  return;
              }

              file = files[0];

              if (/^image\/\w+$/.test(file.type)) {
                  fileReader.readAsDataURL(file);
                  fileReader.onload = function () {
                      $inputImage.val("");
                      $image.cropper("reset", true).cropper("replace", this.result);
                  };
              } else {
                  showMessage("Please choose an image file.");
              }
          });
      } else {
          $inputImage.addClass("hide");
      }

      $("#download").click(function (link) {
          link.target.href = $cropped.cropper('getCroppedCanvas', { width: 620, height: 520 }).toDataURL("image/png").replace("image/png", "application/octet-stream");
          link.target.download = 'cropped.png';
      });


      $("#zoomIn").click(function() {
          $image.cropper("zoom", 0.1);
      });

      $("#zoomOut").click(function() {
          $image.cropper("zoom", -0.1);
      });

      $("#rotateLeft").click(function() {
          $image.cropper("rotate", 45);
      });

      $("#rotateRight").click(function() {
          $image.cropper("rotate", -45);
      });

      $("#setDrag").click(function() {
          $image.cropper("setDragMode", "crop");
      });

      var mem = $('#data_1 .input-group.date').datepicker({
          todayBtn: "linked",
          keyboardNavigation: false,
          forceParse: false,
          calendarWeeks: true,
          autoclose: true
      });

      var yearsAgo = new Date();
      yearsAgo.setFullYear(yearsAgo.getFullYear() - 20);

      $('#selector').datepicker('setDate', yearsAgo );


     /*  $('#data_2 .input-group.date').datepicker({
          startView: 1,
          todayBtn: "linked",
          keyboardNavigation: false,
          forceParse: false,
          autoclose: true,
          format: "yyyy-mm-dd"
      }); */

      $('#data_3 .input-group.date').datepicker({
          startView: 2,
          todayBtn: "linked",
          keyboardNavigation: false,
          forceParse: false,
          autoclose: true
      });

      $('#data_4 .input-group.date').datepicker({
          minViewMode: 1,
          keyboardNavigation: false,
          forceParse: false,
          forceParse: false,
          autoclose: true,
          todayHighlight: true
      });

   /*    $('#data_5 .input-daterange').datepicker({
    	  format: 'yyyy-mm-dd',
          keyboardNavigation: false,
          forceParse: false,
          autoclose: true
      }); */

      /* var elem = document.querySelector('.js-switch');
      var switchery = new Switchery(elem, { color: '#1AB394' });

      var elem_2 = document.querySelector('.js-switch_2');
      var switchery_2 = new Switchery(elem_2, { color: '#ED5565' });

      var elem_3 = document.querySelector('.js-switch_3');
      var switchery_3 = new Switchery(elem_3, { color: '#1AB394' });

      var elem_4 = document.querySelector('.js-switch_4');
      var switchery_4 = new Switchery(elem_4, { color: '#f8ac59' });
          switchery_4.disable(); */

      $('.i-checks').iCheck({
          checkboxClass: 'icheckbox_square-grey',
          radioClass: 'iradio_square-grey'
      });

      $('.demo1').colorpicker();
		
      var backcolor = '';
      var divStyle = $('.back-change')[0].style;
      $('#demo_apidemo').colorpicker({
          color: divStyle.backgroundColor
      }).on('changeColor', function(ev) {
                  divStyle.backgroundColor = ev.color.toHex();
                  backcolor = divStyle.backgroundColor;
                  backcolor = rgb2hex(backcolor);
                  $('#colorText').val(backcolor);
              });

      $('.clockpicker').clockpicker();

      $('input[name="daterange"]').daterangepicker();

      $('#reportrange span').html(moment().subtract(29, 'days').format('MMMM D, YYYY') + ' - ' + moment().format('MMMM D, YYYY'));

      $('#reportrange').daterangepicker({
          format: 'MM/DD/YYYY',
          startDate: moment().subtract(29, 'days'),
          endDate: moment(),
          minDate: '01/01/2012',
          maxDate: '12/31/2100',//'12/31/2015'
          dateLimit: { days: 60 },
          showDropdowns: true,
          showWeekNumbers: true,
          timePicker: false,
          timePickerIncrement: 1,
          timePicker12Hour: true,
          ranges: {
              'Today': [moment(), moment()],
              'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
              'Last 7 Days': [moment().subtract(6, 'days'), moment()],
              'Last 30 Days': [moment().subtract(29, 'days'), moment()],
              'This Month': [moment().startOf('month'), moment().endOf('month')],
              'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
          },
          opens: 'right',
          drops: 'down',
          buttonClasses: ['btn', 'btn-sm'],
          applyClass: 'btn-primary',
          cancelClass: 'btn-default',
          separator: ' to ',
          locale: {
              applyLabel: 'Submit',
              cancelLabel: 'Cancel',
              fromLabel: 'From',
              toLabel: 'To',
              customRangeLabel: 'Custom',
              daysOfWeek: ['Su', 'Mo', 'Tu', 'We', 'Th', 'Fr','Sa'],
              monthNames: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
              firstDay: 1
          }
      }, function(start, end, label) {
          console.log(start.toISOString(), end.toISOString(), label);
          $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
          
      });

      $(".select2_demo_1").select2();
      $(".select2_demo_2").select2();
      $(".select2_demo_3").select2({
          placeholder: "Select a state",
          allowClear: true
      });


      $(".touchspin1").TouchSpin({
          buttondown_class: 'btn btn-white',
          buttonup_class: 'btn btn-white'
      });

      $(".touchspin2").TouchSpin({
          min: 0,
          max: 100,
          step: 0.1,
          decimals: 2,
          boostat: 5,
          maxboostedstep: 10,
          postfix: '%',
          buttondown_class: 'btn btn-white',
          buttonup_class: 'btn btn-white'
      });

      $(".touchspin3").TouchSpin({
          verticalbuttons: true,
          buttondown_class: 'btn btn-white',
          buttonup_class: 'btn btn-white'
      });

      $('.dual_select').bootstrapDualListbox({
          selectorMinimalHeight: 160
      });


  });

  $('.chosen-select').chosen({width: "100%"});

  $("#ionrange_1").ionRangeSlider({
      min: 0,
      max: 5000,
      type: 'double',
      prefix: "$",
      maxPostfix: "+",
      prettify: false,
      hasGrid: true
  });

  $("#ionrange_2").ionRangeSlider({
      min: 0,
      max: 10,
      type: 'single',
      step: 0.1,
      postfix: " carats",
      prettify: false,
      hasGrid: true
  });

  $("#ionrange_3").ionRangeSlider({
      min: -50,
      max: 50,
      from: 0,
      postfix: "°",
      prettify: false,
      hasGrid: true
  });

  $("#ionrange_4").ionRangeSlider({
      values: [
          "January", "February", "March",
          "April", "May", "June",
          "July", "August", "September",
          "October", "November", "December"
      ],
      type: 'single',
      hasGrid: true
  });

  $("#ionrange_5").ionRangeSlider({
      min: 10000,
      max: 100000,
      step: 100,
      postfix: " km",
      from: 55000,
      hideMinMax: true,
      hideFromTo: false
  });

  $(".dial").knob();

  var basic_slider = document.getElementById('basic_slider');

  noUiSlider.create(basic_slider, {
      start: 40,
      behaviour: 'tap',
      connect: 'upper',
      range: {
          'min':  20,
          'max':  80
      }
  });

  var range_slider = document.getElementById('range_slider');

  noUiSlider.create(range_slider, {
      start: [ 40, 60 ],
      behaviour: 'drag',
      connect: true,
      range: {
          'min':  20,
          'max':  80
      }
  });

  var drag_fixed = document.getElementById('drag-fixed');

  noUiSlider.create(drag_fixed, {
      start: [ 40, 60 ],
      behaviour: 'drag-fixed',
      connect: true,
      range: {
          'min':  20,
          'max':  80
      }
  });
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

function closeDoc2(win) {
	var t_win = (win !== undefined)? win: window;
	var isWindow = (top == t_win);
	var isFrame = (t_win.frameElement != null);
	var isOpener = (t_win.opener != null);
	var isParent = (t_win.parent != null);
	//console.log(isWindow + "/" + isFrame + "/" + isOpener + "/" + isParent);
	
	if (isOpener && isWindow) {
		t_win.close();
	} else if (isParent && isFrame) {
		var elem = t_win.frameElement.parentElement.parentElement;
		var className = elem.getAttribute("class") || elem.className;
		//if (className.toLowerCase().indexOf("dhtmlwindow") > -1) {
			try { 
				parent.hideIframeModal();
				return;
				parent.modalwindow.hide(); 
			} catch(e) {
				try { console.log(e); } catch(e) {}
			}
			elem.outerHTML = "";
		//}
	}
}
function remove_go(){
	if (!confirm("일정을 삭제하시겠습니까?")) { 
		revertFunc(); 
	}
	
	location.href="<%=request.getContextPath()%>/mypage/schedule_management/removeSchedule?schedule_code=${oneSchedule.schedule_code}";	
}
							

</script>
</body>
</html>