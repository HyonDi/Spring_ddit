<%@page import="org.apache.velocity.runtime.directive.Foreach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>

<%--     <meta charset="utf-8"> 


    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>INSPINIA | Calendar</title>
--%>


<link href="<%=request.getContextPath() %>/resources/css/schedule/css/bootstrap.min.css" rel="stylesheet">

<link href="<%=request.getContextPath() %>/resources/css/schedule/css/plugins/iCheck/custom.css" rel="stylesheet">

<link href="<%=request.getContextPath() %>/resources/css/schedule/css/plugins/fullcalendar/fullcalendar.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/schedule/css/plugins/fullcalendar/fullcalendar.print.css" rel='stylesheet' media='print'>

<link href="<%=request.getContextPath() %>/resources/css/schedule/css/animate.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/schedule/css/style.css" rel="stylesheet">

<style>

	
	.ibox-title{
		padding-right : 10px;
		padding-top :0px;
		padding-bottom :5px;
		
	}
	


	
	#xspan{
		float : right;
	}
	
	 #xspan:hover{
     	text-decoration:none;
     	color:#EBA094;
     	border:1px solid gray;
     }

</style>

</head>

<body>


<div class="wrapper wrapper-content">
    <div class="row animated fadeInDown">
        <div class="col-lg-9">
            <div class="ibox ">
                <div class="ibox-title">
                    <h5> </h5>
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
                <div class="ibox-content">
                    <div id="calendar"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<%-- </div>--%>
<%-- </div> --%>



<!-- Mainly scripts -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/jquery-3.1.1.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/fullcalendar/moment.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/popper.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/bootstrap.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/inspinia.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/pace/pace.min.js"></script>

<!-- jQuery UI  -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/jquery-ui/jquery-ui.min.js"></script>

<!-- iCheck -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/iCheck/icheck.min.js"></script>

<!-- Full Calendar -->
<script src="<%=request.getContextPath() %>/resources/js/schedule/js/plugins/fullcalendar/fullcalendar.min.js"></script>

<script>
function OpenWindow(UrlStr, WinTitle, WinWidth, WinHeight) {
	winleft = (screen.width - WinWidth) / 2;
	wintop = (screen.height - WinHeight) / 2;
	var win = window.open(UrlStr , WinTitle , "scrollbars=yes,width="+ WinWidth +", height="+ WinHeight +", top="+ wintop +", left=" + winleft + ", resizable=yes, status=yes"  );
    win.focus() ; 
}

function OpenWindowNoScr(UrlStr, WinTitle, WinWidth, WinHeight) {
	winleft = (screen.width - WinWidth) / 2;
	wintop = (screen.height - WinHeight) / 2;
	var win = window.open(UrlStr , WinTitle , "width="+ WinWidth +", height="+ WinHeight +", top="+ wintop +", left=" + winleft + ", resizable=yes, status=yes"  );
    win.focus() ; 
}



var allScheduleList= ${jsonList};

    $(document).ready(function() {
   	
    	
    	
    	
    	
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-grey',
                radioClass: 'iradio_square-grey'
            });

        /* initialize the external events
         -----------------------------------------------------------------*/


        $('#external-events div.external-event').each(function() {

            // store data so the calendar knows to render an event upon drop
            $(this).data('event', {
                title: $.trim($(this).text()), // use the element's text as the event title
                stick: true // maintain when user navigates (see docs on the renderEvent method)
            });

            // make the event draggable using jQuery UI
            $(this).draggable({
                zIndex: 1111999,
                revert: true,      // will cause the event to go back to its
                revertDuration: 0  //  original position after the drag
            });

        });


        /* initialize the calendar
         -----------------------------------------------------------------*/
   
        $('#calendar').fullCalendar({
        	// 달력 높이
        	height: 600,
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,agendaWeek,agendaDay'
            },
            editable: false,
            durationEditable: false,
            droppable: false, // this allows things to be dropped onto the calendar
            eventClick :
    			function(event){
				var event_schedule_code = event.schedule_code;
    			OpenWindow('<%=request.getContextPath()%>/mypage/schedule_management/detailSchedule_owner_resident?schedule_code='+event_schedule_code+'  ','','850','620');
   			 },
            events : ${jsonList}
        
    });

    });	
</script>
</body>

</html>
