<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<script type='text/javascript'>
jQuery(function($) {
	var originalPeriod = "";	// 일정 드래그 이동 및 일정 종료일시 조정시 일시를 임시저장하는 변수
	var originalAllday = "";	// 일정 드래그 이동시 종일일정 설정을 임시저장하는 변수
	
	var optionA = '<option value="">전체</option>';
	var optionS = optionA;
	var optionP = optionA;
	
	
		optionS += '<option value="2017120912321465">회사일정</option>';
	
		optionS += '<option value="2017120912322319">회의</option>';
	
		optionS += '<option value="2017120912324617">출장</option>';
	
		optionS += '<option value="2017120912331631">교육</option>';
	
		optionS += '<option value="2017120912332420">기념일</option>';
	
		optionS += '<option value="2017122111044967">행사</option>';
	
		optionP += '<option value="2018012410311587">관리자1</option>';
	
	
	var source = new Array();

	/* 기념일 */
	source[0] = {
		events: function(start, end, timezone, callback) {
			var start = $('#calendar').fullCalendar('getView').start.format("YYYY-MM-DD");
			var end = $('#calendar').fullCalendar('getView').end.format("YYYY-MM-DD");
			$.ajax({
				url: '/schedule/holiday_json?startDate='+start+'&endDate='+end,
			    type: 'POST',
			    dataType: 'json',
			    success: function(data, text, request) {
			    	var events = data;		    	
			        callback(events);
			    },
			    error:function(){
		    		events=[];
		    		callback(events);
		    	}
			});
		}
	};

	/* 개인공유일정 */
	source[1] = {
	    color: "#4f99c6",
		events : function(start, end, timezone, callback) {
			var fc_start = $("#calendar").fullCalendar("getView").start.format("YYYY-MM-DD");
			var fc_end = $("#calendar").fullCalendar("getView").end.format("YYYY-MM-DD");
			var gubun = $("input[name='gubun']:checked").val();
			var scid = $("select[name='scid']").val();
			var url = "./calendar_json.htm?startDate="+fc_start+"&endDate="+fc_end+"&gubun="+gubun+"&scid="+scid
					+"&scheId=00000000000000&workType=1";
			var expYYYYMM = $("#calendar").find("h2").text();	//현재 달력에 나타내는 년-월
			//var bgColor = [];	// 중요도 배경색
			//bgColor[10] = "#838383";
			//bgColor[20] = "#0066EE";
			//bgColor[30] = "#EE6600";
			$.ajax({
			    url: url,
			    type: "POST",
			    dataType: "json",
			    success: function(data, text, request) { 
			    	events = [];
			    	for(var i in data) {
		    			var evt = data[i];
		    			var s = stringToDateFull(evt.start);
		    			var e = stringToDateFull(evt.end);
		    			//text.substr(0,limit)
		    			switch(evt.repeattype) {
			    			case "0" :									// 반복 없음
								events.push({
									id: evt.id,
									title: evt.title.substr(0,23),
									allDay: evt.allDay,
									//allDay: (evt.allDay)?true:(((e.getTime() - s.getTime()) / (1000 * 60 * 60) >= 24)? true: false), /* 24시간 이상인 경우 종일일정으로 표시 */
									start: new Date(s.valueOf()),
									end: new Date(e.valueOf()),
									//backgroundColor: bgColor[evt.important || 0],
									backgroundColor: evt.backgroundColor,
									isAdmin: evt.isAdmin, 
									descript: evt.descript
								});
			    				break;
			    			case "1" :									// 반복 일간
			    				var rday = parseInt(evt.repeatday);		// 반복 일수
				    			while (s <= e) {
									events.push({
										id: evt.id,
										title: evt.title.substr(0,23),
										start: new Date(s.valueOf()),
										descript: evt.descript,
										//backgroundColor: bgColor[evt.important || 0],
										backgroundColor: evt.backgroundColor,
										isAdmin: evt.isAdmin,
										allDay: evt.allDay,
										className: 'repeat'
									});
									s.setDate(s.getDate() + rday);
				    			}
			    				break;
			    			case "2" :									// 반복 주간
			    				var rweek = parseInt(evt.repeatweek);	// 요일
				    			while (s <= e) {
				    				if (s.getDay() <= rweek) {
			    						s.setDate(s.getDate() + (rweek - s.getDay()));
				    					events.push({
											id: evt.id ,
											title: evt.title.substr(0,23),
											start: new Date(s.valueOf()),
											descript: evt.descript,
											//backgroundColor: bgColor[evt.important || 0],
											backgroundColor: evt.backgroundColor,
											isAdmin: evt.isAdmin,
											allDay: evt.allDay,
											className: 'repeat'
										});
				    				}
				    				s.setDate(s.getDate() + (7 - (s.getDay() - rweek)));
								}
			    				break;
			    			case "3" :									// 반복 월간
			    				var rmonth = parseInt(evt.repeatmonth);	// 월간 반복일자
			    				if(rmonth < 10) rmonth = "0"+rmonth;
			    				var sMonth = new Date(evt.start.substring(0, 10));	//반복일정의 시작일
			    				
				    			while (s <= e) {
				    				var fmonth = s.getMonth()+1;
				    				if(fmonth < 10) fmonth = "0"+fmonth;
				    				var cal = new Date(expYYYYMM.substring(0, 4)+"-"+fmonth+"-"+rmonth);	//달력에 표시되는 표시할 날짜
				    				
				    				if (cal >= sMonth) {	//일정 시작일과 같거나 이후인 일정을 표시한다.
			    						s.setDate(rmonth);
				    					events.push({
											id: evt.id ,
											title: evt.title.substr(0,23),
											start: new Date(s.valueOf()),
											descript: evt.descript,
											//backgroundColor: bgColor[evt.important || 0],
											backgroundColor: evt.backgroundColor,
											isAdmin: evt.isAdmin,
											allDay: evt.allDay,
											className: 'repeat'
										});
				    				}
				    				s.setMonth(s.getMonth() + 1);
								}
			    				break;
		    			}
			    	}			    	
					callback(events);
			    },
			    error:function(){
		    		events=[];
		    		callback(events);
		    	}
			
			});
		}
	};


	
	$("input[name='gubun']").change(function() {
		var num = $("input[name='gubun']").index(this);
		
		//선택한 라벨의 클래스 속성을 변경하여 선택효과를 준다.
		$("#gubun-search").find("label").each(function(idx, value) {
			if (idx == num) {
				$(this).addClass("btn-grey");
				$(this).removeClass("btn-light");
			} else {
				$(this).addClass("btn-light");
				$(this).removeClass("btn-grey");
			}
		});
		
		var scid = $("select[name='scid']");
		var val = $(this).val();
		if (val == "S") {
			scid.html(optionS);
			scid.show();
		} else if (val == "P") {
			scid.html(optionP);
			scid.show();
		} else {
			scid.html(optionA);
			scid.hide();
		}
		
		reloadCal();
	});
	
	var calendar = $('#calendar').fullCalendar({
			//General Display
			header: {
				left: 'prev,next today',
				center: 'prev title next',
				right: 'month,agendaWeek,agendaDay'
			},
			theme: false,
			
 			//googleCalendarApiKey: 'AIzaSyDcnW6WejpTOCffshGDDb4neIrXVUA1EAE',	//fullcalendar id
			googleCalendarApiKey: 'AIzaSyDxSPwclVkn9zON7qbC4DJwQnZA_wahYto',	//jkkim id
			
			//Agenda Options (all-day 사용 여부 및 문자표시 설정)
			allDaySlot: true,
			allDayText: '종일일정', 
			
			//Text/Time Customization
			timeFormat: 'HH:mm',
			titleFormat: {
				month: 'YYYY-MM',
				week: "YYYY-MM-DD",
			    day: 'YYYY-MM-DD dddd'
			},
			buttonText: {
			    today: '오늘의일정', 
			    month: '월간일정', 
			    week: '주간일정', 
			    day: '일간일정' 
			},
			monthNames: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'],
			monthNamesShort: [],
			dayNames: ['일요일', 
						'월요일', 
						'화요일', 
						'수요일', 
						'목요일', 
						'금요일', 
						'토요일'],
			dayNamesShort: ['일요일', 
						'월요일', 
						'화요일', 
						'수요일', 
						'목요일', 
						'금요일', 
						'토요일'],
			
			//Selection
			selectable: true,
			selectHelper: true,
			select: function(start, end, jsEvent, view) {
				//커뮤니티 비회원 진행X
				var isPass = Boolean(true);
				if("1" == "3") isPass = fnClubUsed("${sche_no}");
				if(!isPass) return false;
				
			    /**
			     * 예로 캘린더에서 2016-05-11에 클릭을 하면 2016-05-11 09:00 ~ 2016-05-12 09:00 데이터로 전달되어 오고 있음
			     * 2016-05-11 00:00 ~ 2016-05-11 23:59 으로 변경하여 사용하려고 하였으나, 09:00 설정부분을 찾지 못함
			     * end 데이터에 1일을 뺄셈하여 처리함 - 2016-05-11 LSH
			     */
			    var end = $.fullCalendar.moment(end).add(-1, 'd');
			    
				var startdate = start.format("YYYY-MM-DD");
				var enddate = end.format("YYYY-MM-DD");
				var url = "/schedule/regist?startDate="+startdate+"&endDate="+enddate+"&sche_no=${sche_no}&workType=1";
				OpenWindow(url, "일정등록", "800", "400"); 
				calendar.fullCalendar('unselect');
			},
			
			//Event Dragging & Resizing
			editable: true,				// 일정 편집 여부
			eventDragStart: function(event, jsEvent, ui, view) {					// 일정이동이 시작될때 일정기간을 임시저장
				if(event.allDay){
					originalPeriod = event.start.format("YYYY-MM-DD")+" ~ "+event.end.format("YYYY-MM-DD");
				}else{
					originalPeriod = event.start.format("YYYY-MM-DD HH:mm:ss")+" ~ "+event.end.format("YYYY-MM-DD HH:mm:ss");
				}
				if(event.allDay != null){
					originalAllday = event.allDay;
				}
			},
			eventDrop: function(event, dayDelta, revertFunc, jsEvent, ui, view) {
				if (event.className.join(",").indexOf("repeat") > -1) {				// 반복일정인 경우
					revertFunc();
					alert("반복일정은 이동할 수 없습니다.");
				} else if (event.className.join(",").indexOf("holiday") > -1) {		// 국경일정인 경우
					revertFunc();
					alert("국경일은 이동할 수 없습니다.");
				} else if (!event.isAdmin) {		// 편집권한이 없는경우
					revertFunc();
					alert("접근할 권한이 없습니다 !");
				} else {															// 일정이동
					var newPeriod = event.start.format("YYYY-MM-DD HH:mm:ss")+" ~ "+event.end.format("YYYY-MM-DD HH:mm:ss");
					if(event.allDay){//종일일정은 시간을 찾지 않는다.
						newPeriod = event.start.format("YYYY-MM-DD")+" ~ "+event.end.format("YYYY-MM-DD");
					}
					
					var msg = "";
					if (originalPeriod != newPeriod) {
						msg += "\"" + event.title + "\" 의 일정의 기간을 \n";
						msg += "\"" + originalPeriod  + "\" 에서 \n";
						msg += "\"" + newPeriod  + "\" 로 \n";
						msg += "이동";
					}

					if (msg != "") msg += "하시겠습니까?";

					var url = '/schedule/sche_update.htm?id=' + event.id 
						    + '&startdate=' + event.start.format("YYYY-MM-DD")
						    + '&starth='  + event.start.format("hh")
						    + '&startm='  + event.start.format("mm")
						    + '&starts='  + event.start.format("A")
						    + '&enddate=' + event.end.format("YYYY-MM-DD");
						if(!event.allDay){
						    url+= '&endh='  + event.end.format("hh")
						    + '&endm='  + event.end.format("mm")
						    + '&ends='  + event.end.format("A");
						}
						    url+= '&allday=' + ((event.allDay) ? '1' : '0');

					if (confirm(msg) && msg != "") {
						$.ajax({
							url: url,
						    type: 'POST',
						    dataType: 'json',
						    success: function(data, text, request) {
						    	var result = $.trim(data);
						    }
						});
					} else revertFunc();
				}
				originalAllday = "";
				originalPeriod = "";
			},
			eventResizeStart: function(event, jsEvent, ui, view) {					// 일정조정이 시작될때 종료일시를 임시저장
				originalPeriod = event.end.format("YYYY-MM-DD HH:mm:ss");
			},
			eventResize: function(event, dayDelta, revertFunc, jsEvent, ui, view) {
				if (event.className.join(",").indexOf("repeat") > -1) {				// 반복일정인 경우
					revertFunc();
					alert("반복 일정은 조정 할 수 없습니다.");
				} else if (event.className.join(",").indexOf("holiday") > -1) {		// 국경일정인 경우
					revertFunc();
					alert("국경일은 조정 할 수 없습니다.");
				} else if (!event.end) {											// 종료일시가 없는 경우
					revertFunc();
					alert("종료일이 시작일보다 작을 수 없습니다.");
				} else if (!event.isAdmin) {		// 편집권한이 없는경우
					revertFunc();
					alert("접근할 권한이 없습니다 !");
				} else {															// 일정조정
					var msg = "\"" + event.title + "\" 의 종료일시를 \n"
							+ "\"" + originalPeriod  + "\" 에서 \"" + event.end.format("YYYY-MM-DD HH:mm:ss")  + "\" 로 \n"
							+ "조정하시겠습니까?";
					var url = '/schedule/sche_update.htm?id=' + event.id 
						    + '&enddate=' + event.end.format("YYYY-MM-DD")
						    + '&endh='  + event.end.format("hh")
						    + '&endm='  + event.end.format("mm")
						    + '&ends='  + event.end.format("A")
						    + '&allday=' + ((event.allDay) ? '1' : '0');
					
					if (confirm(msg)) { 
						$.ajax({
							url: url,
						    type: 'POST',
						    dataType: 'json',
						    success: function(data, text, request) {
						    	var result = $.trim(data);
						    }
						});
					} else revertFunc();
				}
				originalPeriod = "";
			},
			
			//Clicking & Hovering
			eventClick: function(calEvent, jsEvent, view) {
				if( calEvent.url != "") {return}
				
				if (calEvent.id == '0' || !calEvent.id) return;
								
				//커뮤니티 비회원 진행X
				var isPass = Boolean(true);
				if("1" == "3") isPass = fnClubUsed("00000000000000");
				if(!isPass) return false;
				
		        var url = "/schedule/read.htm?docId="+calEvent.id+"&scheId=00000000000000&workType=1";
		        OpenWindow(url, "Schedule", "800", "350");
		    },
		    
		    //Event Rendering
			eventRender: function(event, element, view)   {
				
				if ( event.url != "" ) {
					$(element).attr("target" , "_blank");
					$(element).attr("title" , "Google Schedule");
				}
				
				if (event.id == '0') return;
		   		element.qtip({
		   			content: event.descript,
		   			position: {
		   				at: 'top center',
		   				my: 'bottom center',
		   				viewport: $(window),
		   				effect: false
		   			},
		   			style: {
		   				classes: 'ui-tooltip-bootstrap ui-tooltip-shadow ui-tooltip-rounded',
						width:300
		   			}
		   		});
		    },
		    
		    //Event Data
			eventSources: [ source[0], source[1] ]
		});
		
		// 신규버튼 삽입
// 		var strButton = '<button type="button" class="fc-month-button fc-button fc-state-default fc-corner-left fc-corner-right" onclick="todayInsert()">'
// 					  + '신규'
// 					  + '</button>';
		
		var strButton = '<button type="button" class="btn btn-sm btn-white btn-bold" style="font-size: 12px;" onclick="todayInsert();">'
					  +	'<i class="red ace-icon fa fa-pencil-square-o bigger-120"></i>일정등록'
					  + '</button>';
					
		var insButton = $(strButton);
// 		$("#calendar").find(".fc-left").prepend(insButton);
		
		
		
			
			
				strButton += '<button type="button" id="catMng" class="btn btn-sm btn-white btn-bold" style="font-size: 12px;" onclick="fnCategoryPop();">'
				  +	'<i class="blue ace-icon fa fa-gear bigger-120"></i>일정종류'
				  + '</button>';
				  
// 				strButton += '<button type="button" class="fc-month-button fc-button fc-state-default fc-corner-left fc-corner-right" onclick="fnCategoryPop()">'
// 					  + '일정종류'
// 					  + '</button>';
				insButton = $(strButton);
				$("#calendar").find(".fc-left").append(insButton);
			
		
		
		$('#scid').hide();
		
		//달력을 한 화면으로  
	    $(window).bind('resize', function() {
	        $("#calendar").fullCalendar("option", "height", getCalendarHeight());
	    }).trigger('resize');
		
	});
	
	//달력을 한 화면에 나타냄 
	function getCalendarHeight() {
	    var newHeight = $(window).height() - 75; 
	    return newHeight;
	}

	// 김정국 추가
	function stringToDate(strDate) {
		//yyyy-mm-dd 형태
		var a = strDate.split("-");
		var date1 = new Date(a[0], a[1]-1, a[2], 00, 00, 00, 00);
		return date1;
	}
		
	// 김정국 추가
	function stringToDateFull(strDate) {
		//yyyy-mm-dd hh:mm 형태
		var i = strDate.split(" ");
		var a = i[0].split("-");
		var b = i[1].split(":"); 
		var date1 = new Date(a[0], a[1]-1, a[2], b[0], b[1], 00, 00 );
		return date1;
	}

	function todayInsert() {
		//커뮤니티 비회원 진행X
		var isPass = Boolean(true);
		if("1" == "3") isPass = fnClubUsed("00000000000000");
		if(!isPass) return false;
		
		var today = moment().format("YYYY-MM-DD");
		var startdate = today;
		var enddate = today;
		var url = "/schedule/form.htm?startDate="+startdate+"&endDate="+enddate+"&scheId=00000000000000&workType=1";
		OpenWindow(url, "일정등록", "800", "400");
	}
	
	function goCal(args) {
		switch(args) {
 			case 1 : parent.onTopMenu('MENU0409',''); break; // 통합일정표
 			case 2 : parent.onTopMenu('MENU0410','MENU041001'); break; // 회사일정
			case 3 : parent.onTopMenu('MENU04','MENU0411'); break; // 개인공유일정
		}
	}
	
	function reloadCal() {
		var newSource = new Array();
		newSource[0] = source[0];
		newSource[1] = source[1];
		$('#calendar').fullCalendar('removeEventSource', source[0]);
		$('#calendar').fullCalendar('removeEventSource', source[1]);
		$('#calendar').fullCalendar('refetchEvents');
		$('#calendar').fullCalendar('addEventSource', newSource[0]);
		$('#calendar').fullCalendar('addEventSource', newSource[1]);
		$('#calendar').fullCalendar('refetchEvents');
		source[0] = newSource[0];
		source[1] = newSource[1];
	}
	
	//커뮤니티 일정분류 관리 새창
	function schSomeKind() {
		//커뮤니티 비회원 진행X
		var isPass = Boolean(true);
		if("1" == "3") isPass = fnClubUsed("00000000000000");
		if(!isPass) return false;
		
		var url = "/schedule/category_form.htm?gubun=S&scheId=00000000000000&workType=1&position=T";
		OpenWindow(url, '일정종류', "750", "400"); 
	}
	
	//일정종류 관리 새창
	function fnCategoryPop(){
		var url = "/schedule/category_form.htm?gubun=P&scheId=00000000000000&workType=1&position=T";
		OpenWindow(url, "", "750", "400");
	}
	
	
</script>
    