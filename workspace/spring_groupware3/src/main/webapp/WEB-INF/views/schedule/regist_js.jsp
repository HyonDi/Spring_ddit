<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<script type="text/javascript">
	/* validate check - jquery */
	function validCheck() {
		//tripUsers, purpose, area, startDate/endDate, startLoc/endLoc, trans, 
		//corp, residence, require, content, prepare, userid, crate
		
		var chk = $("#submitForm").validate({
			rules: {
				subject: "required",
				purpose: "required",
				area: "required",
				//startDate: "required",
				//endDate: "required",
				//startLoc: "required",
				endLoc: "required",
				corp: "required",
				
				crateDept: {
					required: true,
					number: true,
					minlength: 10
				},
				email: {
					required: true,
					email: true,
					minlength: 5
				}
			},
			messages: {
				subject2: {
					required: "제목 2 값을 입력해 주십시오",
					minlength: jQuery.format("최소{0}자 이상 입력해 주십시오.")
					//제목 2 값을 입력해 주십시오
					//최소{0}자 이상 입력해 주십시오.
				},
				email: {
					required: "e-mail 주소를 입력해 주십시오.",
					minlength: "e-mail 주소 형식이 맞지 않습니다. 정확히 입력하십시오."
					//e-mail 주소를 입력해 주십시오.
					//e-mail 주소 형식이 맞지 않습니다. 정확히 입력하십시오.
				}
			},			
			focusInvalid: true
		});
		return $("#submitForm").validate().form();
	}

	function docSubmit(){
		if( !validCheck() ) {
			ModalDialog({'t':'<b>필드 입력 오류 ! !</b>', 'c':'필드 중 값이 입력되지 않았거나  잘못 입력된 값이 있습니다.',
			'w':'250', 'h':'150', 'r':false, 'b':{'OK':function(){$(this).dialog('close');}} });
			//필드 입력 오류 !//필드 중 값이 입력되지 않았거나,\r\n잘못 입력된 값이 있습니다.
			return false;
		}

		//alert('기타 검증 ...');
		//return;
		
		var form = document.submitForm;
				
		//if( FieldNullCheck(form.subject, "제목", "TEXT") == false ) return false;
        if (isEmpty("subject")) 
        {
        	alert("제목을 입력해 주세요");
            //제목을 입력해 주세요
            form.subject.focus();
            return ; 
        }

		form.content.value = geteditordata() ;

		if (!confirm("저장 하시겠습니까?")) return false;//저장 하시겠습니까?
		form.cmd.value = "1";
		form.method = "POST";
		form.action ="./control.jsp";
		return;

		//게시시간끝
		
		if (null != document.all.Uploader)
		{
			var uploader = document.all.Uploader;

			/*
			//새로 첨부된 파일이 있으면 업로더를 통해서 Submit
			if (uploader.NewFileCount > 0)
			{
				uploader.Submit(form);

				var location = uploader.Location;
				if (location == "") {
					document.write(uploader.Response);
				} else {
					document.location = location;
				}
				return false;
			}
			*/
			if (uploader.Submit(form)) {
				var loc = uploader.Location;
				if (loc == "") {
					//document.write(uploader.Response);
					//새창 열었을때 response 값이 필요없다. 바로 window 닫아준다.
					try{
            	    parent.opener.location.reload();
            	    }catch(ex){
					window.close();
					}
					window.close();
				} else {
					document.location.href = loc;
				}
			}
			return false;

		}
		return true;
	}

	function goSubmit(cmd,docId,type)
	{
		var frm = document.getElementById("scheWebForm");
		switch(cmd)
		{
			case "list":
				frm.method = "post";
				frm.action = "./list.jsp";
				break;
				
			case "save" :
				// 기본 검증...
				if(type == "J"){		//프로젝트 관리
					if ($("#taskId option").index($("#taskId option:selected")) == 0 || $("[name='scheData.scid']:visible > option:selected").val() == "" ) {
	    				alert( "업무명을 선택하십시오.");
	    				//업무명을 선택하십시오.
	    				$("[name='scheData.scid']").focus();
	    				return;
					}
				}
				if(type == "P" || type == "S"){		//일정관리
					if ($("[name='scheData.scid']:visible > option:selected").length == 0 || $("[name='scheData.scid']:visible > option:selected").val() == "" ) {
	    				alert( "일정 유형을 선택하십시오.");
	    				//일정 유형을 선택하십시오.
	    				$("[name='scheData.scid']").focus();
	    				return;
					}
				}
				
				//커뮤니티는 공유자선택 공개안함 - 저장시 최상위 전체공유로 등록
				if ($('#sharelist option').length == 0 && $("input[name='scheData.gubun']:checked").val() == 'S' && $("input[name='search.workType']").val() != "3"){
					alert("공유자를 선택하세요.");
					return;
				}
				
				$('#sharelist option').each(function(i) { this.selected = true; });
				
				if ( !dateCheck() ) return;	//시작일, 종료일 검증
				if ( !repeatCheck() ) return;	//반복 일정 검증
				

				if( $("[name='scheData.subject']").val() == "" ) {
    				alert("제목을 입력해 주십시오 !"); $('[name=subject]').focus(); return;
				}
				
				$("[name='scheData.contents']").val(geteditordata());
				
				if( $("[name='scheData.contents']").val() == "" ) {
    				alert("내용을 입력해 주세요"); $("[name='scheData.contents']").focus(); return;
				}
				
				var msg = "저장 하시겠습니까? ";
				//저장 하시겠습니까?
				if ( !confirm( msg ) ) return;
				
				$(window).unbind("beforeunload");
				
				//시작일 한번만 표기를 선택한 경우... 반복일정은 무시되어야 함.
				
				window.name = 'modal';
				frm.target='modal';
				if($("[id=gubun_p]:hidden").length>0) $("[id=gubun_p]:hidden").remove();
				if($("[id=gubun_s]:hidden").length>0) $("[id=gubun_s]:hidden").remove();
				if($("[id=gubun_j]:hidden").length>0) $("[id=gubun_j]:hidden").remove();
				if($("[id=gubun_c]:hidden").length>0) $("[id=gubun_c]:hidden").remove();
// 				alert($('form').serialize());
// 				$("[name='scheData.scid']:hidden").remove();
				frm.method = "post";
// 				frm.action = "./save.htm";
				break;
				
			case "post":
				if(!docSubmit()) return;
				break;
			case "close":
				closeDoc();
				return;
				
				if(confirm("편집중인 문서는 저장되지 않습니다 !\n창을 닫으시겠습니까 ?")){
					//현재 문서를 닫으시겠습니까?\\n\\n문서 편집중에 닫는 경우 저장이 되지 않습니다.
					closeDoc();
				}
				return;
				break;
		}
		
		waitMsg();
		
		if ($('.template-upload') && $('.template-upload').length > 0) {
			frm.action = "/upload";
			$('.fileupload-buttonbar').find('.start').click();
		} else {
			frm.action = "./save.htm";
			frm.submit();
		}
	}

	function openDeptSelector(sVal)
	{
		var returnValue = window.showModalDialog("../../common/department_selector.jsp?openmode=1&onlydept=1","","dialogWidth:280px;dialogHeight:450px;center:yes;help:0;status:0;scroll:0");
		if (returnValue != null)
		{
			var arrayVal = returnValue.split(":");
			
			var createDept = document.getElementsByName("createDept")[0];
			var createDeptId = document.getElementsByName("createDeptId")[0];
			
			createDept.value = arrayVal[0];
			createDeptId.value= arrayVal[1];
		}
	}
</script>

<script type="text/javascript">

// Date.prototype.nekAddHours = function(hours) { this.setHours(this.getHours() + hours); }
// Date.prototype.nekAddMinutes = function(minutes) { this.setMinutes(this.getMinutes() + minutes); }
// Date.prototype.nekGetAMPM = function() { d = "AM"; h = this.getHours(); if (h >= 12) { d = "PM"; } return d; }
// Date.prototype.nekGetHalfHours = function() { hh = this.getHours(); h = hh; if (h >= 12) { h = hh -12; } return h; }
// Date.prototype.nekToDateString = function() { d = this.getFullYear() + '-' + (this.getMonth()+1).nekLpad() + '-' + this.getDate().nekLpad(); return d; };
// Date.prototype.nekToTimeString = function() { t = this.getHours().nekLpad() + ':' + this.getMinutes().nekLpad() + ':' + this.getSeconds().nekLpad(); return t; };
// Date.prototype.nekToString = function() { s = this.nekToDateString() + ' ' + this.nekToTimeString(); return s; };
// Number.prototype.nekLpad = function(l) { l = l || 2; n = this + ''; while(n.length < l) n = '0' +n; return n; };

$(document).ready(function () {
	validator = $("#scheWebForm").validate({
		rules:{
			"scheData.subject":{
				required:true
			},
			"scheData.contents":{
				required:true
			}
		},
		messages:{
			"scheData.subject":{
				required: '제목을 입력하십시오'
			},
			"scheData.contents":{
				required: '내용을 입력해 주세요'
			}
		},
		focusInvalid:true
	});
	
	$( "[name='scheData.gubun']" ).click( function() {
		var gubun = $("[name='scheData.gubun']:checked").val();
		if ( gubun == "S" && $("input[name='search.workType']").val() != "3") {
			$( "#dispshareuser" ).show();
			$( "#dispattenduser" ).show();
		} else {
			$( "#dispshareuser" ).hide();
			$( "#dispattenduser" ).hide();
		}
	});
	
	$( "[name='scheData.startdateonly']" ).click( function() {
		var chk = $("[name='scheData.startdateonly']:checked").val();
		
		if ( chk == "1" ) {
			$( "#disprepeat" ).hide();
			
			$( "#rday" ).hide();
			$( "#rweek" ).hide();
			$( "#rmonth" ).hide();
		} else {
			$( "#disprepeat" ).show();

			switch(parseInt($("input[name='scheData.repeattype']:checked").val())){
				case 1: $( "#rday" ).show(); break;
				case 2: $( "#rweek" ).show(); break;
				case 3: $( "#rmonth" ).show(); break;
			}
		}
	});
	
	var chk = $("[name='scheData.startdateonly']:checked").val();
	
	if ( chk == "1" ) {
		$( "#disprepeat" ).hide();
		
		$( "#rday" ).hide();
		$( "#rweek" ).hide();
		$( "#rmonth" ).hide();
	} else {
		$( "#disprepeat" ).show();

		switch(parseInt($("input[name='scheData.repeattype']:checked").val())){
			case 1: $( "#rday" ).show(); break;
			case 2: $( "#rweek" ).show(); break;
			case 3: $( "#rmonth" ).show(); break;
		}
	}
	
	if ( $("[name='scheData.gubun']:checked").val() == 'S' && $("input[name='search.workType']").val() != "3"){
		$("#dispshareuser").show();
		$("#dispattenduser").show();
	}

	$("input[name='scheData.repeattype']").filter('input[value=""]').attr("checked","checked");
	$("input[name='scheData.repeattype']").filter('input[value=""]').click();

	$("input[name='scheData.repeatweek']").filter('input[value=""]').attr("checked","checked");
	
	var shares = document.getElementById("sharelist");
	for (var i = 0; i < shares.length; i++) {
		var objAddress = ParseAddress(shares[i].value);
		if (objAddress != null) {
			objRecipients.push(objAddress);
		}
	}
	
	var attends = document.getElementById("attendlist");
	for (var i = 0; i < attends.length; i++) {
		var objAddress = ParseAddress(attends[i].value);
		if (objAddress != null) {
			objAttends.push(objAddress);
		}
	}
	
	//MaxChar 및 ModalDialog 활용할 것. - jquery폴더에 download 되어있음
	$('input[id=startdate], input[id=enddate]').datepicker({
	}).on('changeDate', function(e) {
		var minDate = new Date(e.date.valueOf());
		if ($(this).attr('id') == 'startdate') {
			$('input[id=enddate]').datepicker('setStartDate', minDate);
		} else if ($(this).attr('id') == 'enddate') {
			$('input[id=startdate]').datepicker('setEndDate', minDate);
		}
	});

	$( "#opendialog" ).click(function() {
		openDialog("Title Message")
	});

	$( "#openmodal" ).click(function() {
		openModal( "Title Message" );
	});	

	$( "#openmodalconfirm" ).click(function() {
		openConfirm( "Title Message" );
	});

	$('#tabs').tabs(  {
	        selected: 0,     // which tab to start on when page loads
	        select: function(e, ui) {
	            var t = $(e.target);
	
	            return true;
	
	        }
	});

	
	function split( val ) {
		return val.split( /,\s*/ );
	}
	function extractLast( term ) {
		return split( term ).pop();
	}

	Organizations.Item = [
 			"type",
			"userid",
			"username",
			"dpid",
			"dpname",
			"includeSub",
			"upname",
   			"udname"
		];
	Organizations.formatAddress("sharelist");
	Organizations.formatAddress("attendlist");
	
	$('#sharelist').bind('dblclick', function() {
		var title = '조직도';
		var caption = '공유자 선택';
		Organizations.open('sharelist', title, caption, 0, 0, 1);
	});
	
	$('#attendlist').bind('dblclick', function() {
		var title = '조직도';
		var caption = '참석자 선택';
		Organizations.open('attendlist', title, caption, 1, 0, 1);
	});
	
	//커뮤니티 조직도
	if($("input[name='search.workType']").val() == "3"){
		Organizations.setOpenFunc(function(str, titleStr, captionStr, onlyuserNum, onlydeptNum, multipleNum) {
			var that = this;
			var elem = document.getElementById(str);
			var url = "/club/member_selector.htm?";
			var par = new Array();
				par.push("title=" + encodeURI(titleStr));
				par.push("caption=" + encodeURI(captionStr));
				par.push("onlyuser=" + onlyuserNum);
				par.push("onlydept=" + onlydeptNum);
				par.push("multiple=" + multipleNum);
				par.push("clubId=" + $("input[name='search.scheId']").val());
				
			var if_list = this.getFrameByName("if_list");
			var if_main = (this.isParent && this.isFrame && if_list)? if_list.parent.window: top;
			
			if_main.organizationsArgument = {};
			if_main.organizationsArgument.Item = that.Item;
			if_main.organizationsArgument.Data = that.Data[str] || [];
			if_main.organizationsArgument.Func = function(ret) {
				if (ret != null) {
					that.Data[str] = new Array();
					for(var i = 0; i < ret.length; i++) {
						var data = that.convert(ret[i]);
						that.Data[str].push(data);
						that.userFunc(str, data);
					}
					that.refreshSelect(elem, that.Data[str]);
				}
				try {
					hideIframeModal();
				} catch (e) {
					if_main.modalwindow.hide();
				}
			};
			
			var winWidth = (this.multiple)?550:280 + "px";
			
			try {
				showIframeModal(url+par.join("&"), 'Member Selector', '490', '410');
			} catch (e) {
				if_main.modalwindow = if_main.dhtmlmodal.open(
						url, "iframe", url+par.join("&"), title,
						"width="+winWidth+",height=410px,center=1,resize=1,scrolling=0", "recal"
				);
			}
		});
	}

	getTask('', '');
	
	ShowUserInfoSet();
	
	pageScroll();
	
	if ($(document.getElementById("scheData.docId")).val() == "") {
		// 신규시 등록시 현재시간으로 일시의 기본값 설정
// 		var nowDate = new Date(); // 현재시간
// 		var minHour = 7; // 오전 7시 부터 설정
// 		var minUnit = 30; // 분단위
// 		var minInterval = 60; // 시작시간과 종료시간의 분간격
		
// 		nowDate.nekAddMinutes(minUnit - nowDate.getMinutes() % minUnit);
// 		if (nowDate.getHours() < minHour) nowDate.setHours(minHour);
		
// 		$("#startdate").val(nowDate.nekToDateString());
// 		$("#starth").val(nowDate.nekGetHalfHours().nekLpad());
// 		$("#startm").val(nowDate.getMinutes().nekLpad());
// 		$("#starts").val(nowDate.nekGetAMPM());
		
// 		nowDate.nekAddMinutes(minInterval);
// 		if (nowDate.getHours() < minHour) nowDate.setHours(minHour);
		
// 		$("#enddate").val(nowDate.nekToDateString());
// 		$("#endh").val(nowDate.nekGetHalfHours().nekLpad());
// 		$("#endm").val(nowDate.getMinutes().nekLpad());
// 		$("#ends").val(nowDate.nekGetAMPM());
	}
	
	alldaynotime($(document.getElementById("scheData.allday1")).attr("checked") == "checked");
	sMinTime('starth', $("#starts").val());
	sMinTime('endh', $("#ends").val());

	selectAcid($("input[name='scheData.gubun']:checked").val());
	
	setTimeout( "popupAutoResize2();", "500");		//팝업창 resize
});

</script>

<script>
function openDialog( args ) {
	/*
	var editor = document.getElementById("Wec");
	var up = document.getElementById("Uploader");
	//var dn = document.getElementById("Downloader");
	editor.style.display = "none";
	up.style.display = "none";
	*/
	
	$( "#dialog" ).dialog({
		dialogClass: 'alert',
		title: args,
		resizable: false,
		show: "blind",
		hide: "blind",
		open: function() {
			//$('Wec').style.display = "none"
		},
		beforeClose: function() {
		    //$('Wec').style.display = "";
		}
	});
}

function openModal( args ) {
	$( "#dialog:ui-dialog" ).dialog( "destroy" );
	
	$( "#dialog-message" ).dialog({
		dialogClass: 'alert',
		title: args,
		closeOnEscape: true,
		resizable: false,
		modal: true,
		buttons: {
			확인: function() {
				alert( 'true' );
				$( this ).dialog( "close" );
			}
		}
	});
}

function openConfirm( args ) {
	$( "#dialog:ui-dialog" ).dialog( "destroy" );

	$( "#dialog-confirm" ).dialog({
		title: args,
		resizable: false,
		height:250,
		modal: true,
		buttons: {
			취소: function() {
				alert( 'false' );
				$( this ).dialog( "close" );
			},
			"확인": function() {
				alert( 'true' );
				$( this ).dialog( "close" );
			}
		}
	});
}

function viewStart() {
	document.getElementById("lblStart").style.display = "block";
}
        
//종료일 텍스트박스 클릭시 종료일 아이프레임을 보이게 합니다. 
function viewEnd() {
	//document.getElementById("lblEnd").style.display = "block";
}
        
//시작일,종료일 텍스트 박스 이외 다른 행동시 아이프레임을 안보이게 숨깁니다. 
function OffLayer() {
	selectobj = event.srcElement.id;
	if (selectobj != "datepicker" ) {
		document.getElementById("lblStart").style.display = "none"
		//document.getElementById("lblEnd").style.display = "none"
	}
}

function CloseWin(){
	window.parent.$("#hidFld").val('1');
	window.parent.$("#modalDiv").dialog('close');
	return false;
}


//////////////////////////조직도 //////////////////////////////////
var ORGUNIT_TYPE_USER = 0;
var ORGUNIT_TYPE_DEPARTMENT = 1;
var objRecipients = new Array();
var objAttends = new Array();
function OnClickAddressBook() {
	var ret = window.showModalDialog("/common/recipient_selector.htm?caption=NEK+%EC%A3%BC%EC%86%8C%EB%A1%9D&title=%3Cspring%3Amessage+code%3D%27sch.coose.sharer%27+text%3D%27%EA%B3%B5%EC%9C%A0%EC%9E%90%EB%A5%BC+%EC%84%A0%ED%83%9D%ED%95%98%EC%84%B8%EC%9A%94.%27%2F%3E", objRecipients,"dialogHeight: 400px; dialogWidth: 550px; edge: Raised; center: Yes; help: No; resizable: No; status: No; Scroll: no");
	
	if (ret != null) {
		objRecipients = new Array();
		for (var i = 0; i < ret.length; i++) {
			objRecipients.push(ret[i]);
		}
		RefreshRecipientsList();
	}
}

function OnClickRemoveRecipients() {
	var objList = document.getElementById("sharelist");
	var bRefresh = false;
	for (var i = objList.options.length - 1; i >= 0; i--) {
		if (objList.options[i].selected) {
			RemoveRecipient(objList.options[i].value);
			bRefresh = true;
		}
	}
	
	if (bRefresh) {
		RefreshRecipientsList();
	}

}

function RemoveRecipient(strAddress) {
	var objNewRecipients = new Array();
	var nIndex = -1;
	var objAddress = ParseAddress(strAddress);
	if (objAddress != null) {
		for (var i = 0; i < objRecipients.length; i++) {
			if (objAddress.type != objRecipients[i].type ||
				objAddress.id != objRecipients[i].id) {
				objNewRecipients.push(objRecipients[i]);
			}
		}
		objRecipients = objNewRecipients;
	}
}

function ParseAddress(strData) {
	if (strData == "") {
	return null;
	}
	
	if (strData.charAt(0) == 'P') {
		//user, P:이름:UID:직급
		var segments = strData.split(':');
		if (segments.length < 5) {
			return null;
		}
		var objAddress = new Object();
		objAddress.type		= ORGUNIT_TYPE_USER;
		objAddress.name		= segments[1];
		objAddress.id		= segments[2];
		objAddress.position	= segments[3];
		objAddress.department = segments[4];
		return objAddress;
	} else if (strData.charAt(0) == 'D') {
		//department, D:부서이름:부서ID:(+|-)
		var segments = strData.split(':');
		if (segments.length < 4) {
			return null;
		}
		
		var objAddress = new Object();
		objAddress.type = ORGUNIT_TYPE_DEPARTMENT;
		objAddress.name = segments[4];
		objAddress.id	= segments[2];
		objAddress.includeSub = (segments[5] == "+");
		return objAddress;
	}
	
	return null;
}

function RefreshRecipientsList() {
	//var objList = scheduleWebForm.select_recipients;
	var objList = document.getElementById("sharelist");
	while (objList.options.length > 0) {
		objList.options.remove(0);
	}
	
	for (var i = 0; i < objRecipients.length; i++) {
		var objRecipient = objRecipients[i];			
		var objOption = document.createElement("OPTION");
		objOption.text = AddressToDisplayString(objRecipient);
		objOption.value = AddressToString(objRecipient);
		objList.options.add(objOption);
	}
}

function AddressToString(objAddress) {
	var sTemp = "" ; 
	if (objAddress.type == ORGUNIT_TYPE_USER) {		
		sTemp = "P:" + objAddress.name + ":" + objAddress.id + ":" + objAddress.position
		+ ":" + objAddress.department + ":" + "false";
	} else if (objAddress.type == ORGUNIT_TYPE_DEPARTMENT) {
		sTemp = "D:" + objAddress.name + ":" + objAddress.id + ":" + ":" + ":" 			
		+ (objAddress.includeSub ? "true" : "false");
	}	
	return sTemp;
}

function AddressToDisplayString(objAddress) {
	var strDisplay = "";
	
	if (objAddress.type == ORGUNIT_TYPE_USER) {
		strDisplay += objAddress.name;
		strDisplay += "/";
		strDisplay += objAddress.position;
		strDisplay += "/";
		strDisplay += objAddress.department;
	} else if (objAddress.type == ORGUNIT_TYPE_DEPARTMENT) {
		strDisplay += objAddress.name;
		if (objAddress.includeSub) {
			strDisplay += "[+]";
		} else {
			strDisplay += "[-]";
		}
	}
	return strDisplay;
}

function typeCheck() {
// 	var rtype = document.getElementsByName("repeattype");
	var rday = document.getElementById("rday");
	var rweek = document.getElementById("rweek");
	var rmonth = document.getElementById("rmonth");
	
	if ( $("input[name='scheData.repeattype']:checked").val() == '0' ) {
		rday.style.display = "none";
		rweek.style.display = "none";
		rmonth.style.display = "none";
	} else if ( $("input[name='scheData.repeattype']:checked").val() == '1' ) {
		rday.style.display = "";
		rweek.style.display = "none";
		rmonth.style.display = "none";
	} else if ( $("input[name='scheData.repeattype']:checked").val() == '2' ) {
		rday.style.display = "none";
		rweek.style.display = "";
		rmonth.style.display = "none";
	} else if ( $("input[name='scheData.repeattype']:checked").val() == '3' ) {
		rday.style.display = "none";
		rweek.style.display = "none";
		rmonth.style.display = "";
	}
}

function addZero(n) {
	return n < 10 ? "0" + n : n;
}

function repeatCheck() {
	var rtype = $("input[name=repeattype]:checked").val();
	
	if ( rtype == "0" ) {
		
	} else if ( rtype == 1 ) {
		var tmp = $("input[name=repeatday]").val();
		if ( tmp == "" || tmp < 1 || tmp > 31) {
			alert( "일단위 반복 일자를 확인하십시오. (1일 ~ 31일)");
			//일단위 반복 일자를 확인하십시오. (1일 ~ 31일)
			$("input[name=repeatday]").focus();
			return false;
		}
	} else if ( rtype == 2 ) {
		var tmp = $("input[name=repeatweek]:checked").val();
		
		if ( !tmp ) {
			alert( '주간 반복 요일을 선택하십시오');
			//주간 반복 요일을 선택하십시오
			$("input[name=repeatweek]").focus();
			return false;
		}
	} else if ( rtype == 3 ) {
		var tmp = $("input[name=repeatmonth]").val();
		if ( tmp == "" || tmp < 1 || tmp > 31) {
			alert( "월단위 반복 일자를 확인하십시오. (1일 ~ 31일)");
			//월단위 반복 일자를 확인하십시오. (1일 ~ 31일)
			$("input[name=repeatmonth]").focus();
			return false;
		}
	}
	return true;
}

function stringToDate(strDate, h, m) {
	var a = strDate.split("-");
	return new Date(a[0], a[1]-1, a[2], h, m, 0, 0);
}

function dateCheck() {
	//시작일, 종료일 검사
	var sdate = $("#startdate").val();
	var sh = $("[name='scheData.starth'] option:selected").val();
	var sm = $("[name='scheData.startm'] option:selected").val();
	var st = $("[name='scheData.starts'] option:selected").val();
	if (st == "PM" && sh != "12" ){
		sh = Number(sh) + Number(12);
	}else if(st == "AM" && sh == "12"){
		sh = "00";
	}

	var edate = $("#enddate").val();
	var eh = $("[name='scheData.endh'] option:selected").val();
	var em = $("[name='scheData.endm'] option:selected").val();
	var et = $("[name='scheData.ends'] option:selected").val();
	if (et == "PM" && eh != "12"){
		eh = Number(eh) + Number(12);
	}else if(et == "AM" && eh == "12"){
		eh = "00";
	}

	if (sdate == "") return false;
	if (edate == "") return false;
	
	var st_date = stringToDate(sdate, sh, sm);
	var ed_date = stringToDate(edate, eh, em);

	if (st_date.getTime() >= ed_date.getTime()) { 
		alert('종료일이 시작일보다 작을 수 없습니다.');
		// $("#enddate").focus();
		return false; 
	}
	return true;
}

//분류 공개
function selectAcid(val){
	
	//메일발송 공개/비공개
	if(val=="P"){
		$("#isSendMailSpan").css("display", "none");
	}else{
		$("#isSendMailSpan").css("display", "");
	}
	
	 acid1 = document.getElementById("gubun_s");
	 acid2 = document.getElementById("gubun_p");
	 acid3 = document.getElementById("gubun_j");
	 acid4 = document.getElementById("gubun_c");
	if(val == 'S'){
		acid1.style.display = "";
		acid2.style.display = "none";
		acid3.style.display = "none";
		acid4.style.display = "none";
		
		if (document.getElementById("gubun_pv") != null) {
			document.getElementById("gubun_pv").value = "";
			if (typeof document.getElementById("gubun_pv")[0] != "undefined"
					&& document.getElementById("gubun_pv")[0] != null) {
				document.getElementById("gubun_pv")[0].selected = true;
			}
		}
	}else if(val == 'P'){
		acid1.style.display = "none";
		acid2.style.display = "";
		acid3.style.display = "none";
		acid4.style.display = "none";
		
		if (document.getElementById("gubun_sv") != null) {
			document.getElementById("gubun_sv").value = "";
			if (typeof document.getElementById("gubun_sv")[0] != "undefined"
					&& document.getElementById("gubun_sv")[0] != null) {
				document.getElementById("gubun_sv")[0].selected = true;
			}
		}
	}else if(val == 'J'){
		acid1.style.display = "none";
		acid2.style.display = "none";
		acid3.style.display = "";
		acid4.style.display = "none";
		
		if (document.getElementById("gubun_jv") != null) {
			document.getElementById("gubun_jv").value = "";
			if (typeof document.getElementById("gubun_jv")[0] != "undefined"
					&& document.getElementById("gubun_jv")[0] != null) {
				document.getElementById("gubun_jv")[0].selected = true;
			}
		}
	}else if(val == 'C'){
		acid1.style.display = "none";
		acid2.style.display = "none";
		acid3.style.display = "none";
		acid4.style.display = "";
		
		if (document.getElementById("gubun_cv") != null) {
			document.getElementById("gubun_cv").value = "";
			if (typeof document.getElementById("gubun_cv")[0] != "undefined"
					&& document.getElementById("gubun_cv")[0] != null) {
				document.getElementById("gubun_cv")[0].selected = true;
			}
		}
	}
	
}


function getTask(val, taskId) {
	var taskSelect = $('select[id=taskId]');
	var none = "<option value=''>없음</option>";
	if (val == "") { taskSelect.html(none); return; }
	var postPara = {projId: val};
	$.post('/project/task_json.htm?taskOnly=1', postPara, function(data) {
		var option = none;
		if (data != null) {
			for(var i = 0; i < data.rows.length; i++) {
				var row = data.rows[i];
				option += '<option value="'+row.id+'"';
 				if (row.id == taskId) {
					option += ' selected="selected"';
 				}
				option += '>'+row.cell[2]+'</option>';
			}
		}
		if (option == "") option = none;
		taskSelect.html($(option));
	}, 'json');
}

function addbookp_Category() {
	var winwidth = "300";
	var winheight = "180";
	var winleft = (screen.width - winwidth) / 2;
	var wintop = (screen.height - winheight) / 2;
	var url = "/schedule/category_popup.htm?cmd=insert&gubun=P&scheId=00000000000000&workType=1";
	
	showIframeModal(url, "유형추가", 300, 180)
	return;
	
	window.modalwindow = window.dhtmlmodal.open(
		"_CHILDWINDOW_SCHE0922", "iframe", url, "유형추가", 
		"width=300px,height=180px,resize=0,scrolling=1,center=1", "recal"
	);
// 	returnvalue = self.showModalDialog( url , '' ,
// 				 "status:no;scroll=no;dialogLeft:" + winleft + ";dialogTop:" + wintop + ";help:no;dialogWidth:" + winwidth + "px;dialogHeight:" + winheight + "px");
}

function setbookp_Category(returnvalue) {
	if (returnvalue == undefined) returnvalue = window.returnValue;
	if (returnvalue == null ){
		return false;
	} else {
		tmpstr = returnvalue.split(",");
		var newOpt = new Option(tmpstr[1], tmpstr[0], true, true);
		var fld = document.getElementById("gubun_pv");
		fld.options[fld.options.length] = newOpt;
		// $(fld).uniform();
	}
}

//커뮤니티용 일정종류 추가
function addbookp_Category_S() {
	var winwidth = "300";
	var winheight = "180";
	var winleft = (screen.width - winwidth) / 2;
	var wintop = (screen.height - winheight) / 2;
	var url = "/schedule/category_popup.htm?cmd=insert&gubun=S&scheId=00000000000000&workType=1";
	
	showIframeModal(url, "유형추가", 300, 180)
	return;
	
	window.modalwindow = window.dhtmlmodal.open(
		"_CHILDWINDOW_SCHE0922", "iframe", url, "유형추가", 
		"width=300px,height=180px,resize=0,scrolling=1,center=1", "recal"
	);
// 	returnvalue = self.showModalDialog( url , '' ,
// 				 "status:no;scroll=no;dialogLeft:" + winleft + ";dialogTop:" + wintop + ";help:no;dialogWidth:" + winwidth + "px;dialogHeight:" + winheight + "px");
}

//커뮤니티용 일정종료 추가 적용
function setbookp_Category_S(returnvalue) {
	if (returnvalue == undefined) returnvalue = window.returnValue;
	if (returnvalue == null ){
		return false;
	} else {
		tmpstr = returnvalue.split(",");
		var newOpt = new Option(tmpstr[1], tmpstr[0], true, true);
		var fld = document.getElementById("gubun_cv");
		fld.options[fld.options.length] = newOpt;
		// $(fld).uniform();
	}
}

function alldaynotime(checked) {
	var elemIds = ["#starth", "#startm", "#starts", "#endh", "#endm", "#ends"];
	for(var i =0; i <elemIds.length; i++){
		var v = elemIds[i];
		if (checked) {
			$(v).attr("disabled", true);
		} else {
			$(v).removeAttr("disabled");
		}
	} 
}

var hOptions = {};
function sMinTime(id, tt) {
	var h = $("#"+id);
	var hOption = h.find("option");
	if (hOptions[id] === undefined) hOptions[id] = new Array();
	
	if (tt == "AM") {
		for(var i = 0; i < hOption.length; i++) {
			hOptions[id].push($(hOption.get(i)).clone().wrapAll("<div/>").parent().html());
			//if (i < 7) $(hOption.get(i)).remove();
		}
	} else if (hOptions[id].length > 0) {
		h.html(hOptions[id].join(""));
		hOptions[id] = new Array();
	}
}

function SetEditorData(objEditor, contentId) {
	var contents = document.getElementById('scheData.contents').value;
	if (contents == "") return;
	
	var editorName = getEditorName();
	if ( editorName == "twe" ) {
		objEditor.HtmlValue = contents;
	} else if ( editorName == "xfree" ) {
		xfe.setHtmlValue(contents);
	} else if ( editorName == "daum" ) {
		objEditor.modify({ content: contents });
	} else if ( editorName == "crosseditor" ) {
		CrossEditor.SetBodyValue(contents);
	}
}
</script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.js"></script>
<script>
var $$=jQuery.noConflict();

$$(function(){
	$$('#sche_content').summernote({
		placeholder: '내용을 작성하세요.',
        tabsize: 1,
		height: 200,
		fontNames : [ '맑은고딕', 'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', ],
		fontNamesIgnoreCheck : [ '맑은고딕' ],
		focus: true,
		
		callbacks: {
			onImageUpload : function(files, editor, welEditable) {
	            for (var i = files.length - 1; i >= 0; i--) {
	            	if(files[i].size > 1024*1024*5){
	            		alert("이미지는 5MB 미만입니다.");
	            	}
	            }
	            for (var i = files.length - 1; i >= 0; i--) {
	            	sendFile(files[i], this);
	            }
	        },
	        onMediaDelete : function(target) {
               // deleteFile(target[0].src);                
	        	deleteFile(target[0].src);
            }
		}
		
	});

})

function sendFile(file, el) {
	var form_data = new FormData();
  	form_data.append("file", file);
  	form_data.append("id","${loginUser.id}");
  	$.ajax({
    	data: form_data,
    	type: "POST",
    	url: '<%=request.getContextPath()%>/uploadImg',
    	cache: false,
    	contentType: false,
    	enctype: 'multipart/form-data',
    	processData: false,
    	success: function(img_url) {
      		$$(el).summernote('editor.insertImage', img_url);
    	}
  	});
}

function deleteFile(src) {
	
	var splitSrc= src.split("/");
	var fileName = splitSrc[splitSrc.length-1];
    $.ajax({
        data: {fileName : fileName, id : '${loginUser.id}'},
        type: "POST",
        url: "<%=request.getContextPath()%>/deleteImg", 
        cache: false,
        success: function(resp) {
            console.log(resp);
        }
    });
}
</script>
