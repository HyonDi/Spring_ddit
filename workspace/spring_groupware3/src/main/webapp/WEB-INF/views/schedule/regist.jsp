<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<div id="dhtmlwindowholder"><span style="display:none">.</span></div>
<div id="interVeil"></div>
<div class="breadcrumbs" id="breadcrumbs">
	<ul class="breadcrumb">
		<li>
			<i class="ace-icon fa fa-calendar home-icon bigger-150"></i>일정관리
		</li>
		<li class="active">
			등록 
		</li>
	</ul>
	<span class="breadcrumb-Info">
		<img src="<%=request.getContextPath() %>/resources/common/images/pp.gif" border="0" align="absmiddle">	
		<a href="#" rel="${loginUser.id }" class="maninfo" data-hasqtip="0">
		${loginUser.id } / 정보시스템 </a>
	</span>
</div>
<div class="page-content" style="padding-bottoms:8px;">	
<!-- 상단 우측버튼 -->
	<div class="row">
		<div class="wizard-actions">
			<button type="button" class="btn btn-sm btn-white btn-bold" onclick="goSubmit('save','', 'P');">
				<i class="red ace-icon fa fa-check bigger-120"></i><b>저장</b>
			</button>
			<button type="button" class="btn btn-sm btn-white btn-bold" onclick="goSubmit('close','');">
				<i class="grey ace-icon fa fa-times bigger-120"></i><b>닫기</b>
			</button>
		</div>
	</div>
	<!-- 상단 우측버튼 -->
			
	<form id="scheWebForm" class="form-horizontal" action="/upload" method="post" enctype="multipart/form-data" onsubmit="return false" novalidate="novalidate">
	
		
		<input id="sche_no" name="sche_no" type="hidden" value="${shceduleReq.sche_no }">
		<input id="search.workType" name="search.workType" type="hidden" value="${scheduleReq.workType }">

		<div class="hr_line"></div>
		<div class="form-group"><!-- label의 for명은 input 개체명과 연관을 가지도록 기술 -->
			<label for="dms.cateType" class="col-xs-4  col-sm-2 control-label no-padding-right bolder g_label">
				일정구분&nbsp;<!-- 일정구분 -->
			</label>
			<div class="col-xs-8  col-sm-4 g_value">
				<span class="block input-icon" style="margin-top: 6px;">
					<input id="p_gubun" name="sche_gubun" onclick="selectAcid('P')" class="ace" type="radio" value="P" checked="checked">
					<span class="lbl">
						<label for="p_gubun">개인일정&nbsp;<!-- 개인일정 --></label>
					</span>
					<input id="s_gubun" name="sche.gubun" onclick="selectAcid('S')" class="ace" type="radio" value="S">
					<span class="lbl">
						<label for="s_gubun">공유일정&nbsp;<!-- 공유일정 --></label>
					</span>
				</span>
			</div>
			<label for="dms.chkOut" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label">
				유형&nbsp;<!-- 유형 -->
			</label>
			<div class="col-xs-8 col-sm-4 g_value"> 
				<div id="gubun_p">
					<div class="input-group">
						<select id="gubun_pv" name="scheData.scid" class="form-control">
							<option value="2018012410311587">관리자1</option>
						</select>
						<span class="input-group-btn">
							<button type="button" class="btn btn-sm btn-white" onclick="addbookp_Category();">
								<i class="grey ace-icon fa fa-plus"></i><b>추가</b>
							</button>
						</span>
					</div>
				</div>
				<div id="gubun_s" style="display:none;">
					<select id="gubun_sv" name="scheData.scid">
						<option value="2017120912321465">회사일정</option>
						<option value="2017120912322319">회의</option>
						<option value="2017120912324617">출장</option>
						<option value="2017120912331631">교육</option>
						<option value="2017120912332420">기념일</option>
						<option value="2017122111044967">행사</option>
					</select>
				</div>
				<div id="gubun_j" style="display:none;">
					<input id="scheData.scid" name="scheData.scid" type="hidden" value="">					
				</div>
				<div id="gubun_c" style="display:none;">
					<div class="input-group">
						<select id="gubun_cv" name="scheData.scid" class="form-control">
							<option value="2017120912321465">회사일정</option><option value="2017120912322319">회의</option><option value="2017120912324617">출장</option><option value="2017120912331631">교육</option><option value="2017120912332420">기념일</option><option value="2017122111044967">행사</option>
						</select>
						<span class="input-group-btn">
							<button type="button" class="btn btn-sm btn-white" onclick="addbookp_Category_S();">
								<i class="grey ace-icon fa fa-plus"></i><b>추가</b>
							</button>
						</span>
					</div>
				</div>
			</div>
			<div class="form-group" id="dispshareuser" style="display:none;">
				<label for="catFullName" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label">
				공유자&nbsp;<!-- 공유자 -->
				</label>
				<div class="col-xs-8 col-sm-10 g_value">
					<select id="sharelist" name="scheShares" style="height:60px;width:70%;display:none;" class="fld_550" multiple="multiple">
					</select>
					<div id="sharelist_view" class="ui-corner-all w100p" style="color: rgb(0, 0, 0); font-size: inherit; font-family: inherit; display: inline-block; border: 1px solid rgb(213, 213, 213); padding: 4px 0px 4px 4px; cursor: pointer; word-break: break-all; overflow-wrap: break-word;">&nbsp;</div>
					<input type="hidden" name="_scheShares" value="1">
				</div>
			</div>
	
			<div class="form-group" id="dispattenduser" style="display:none;">
				<label for="catFullName" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label">
				참석자&nbsp;
				</label>
				<div class="col-xs-8 col-sm-10 g_value">
					<select id="attendlist" name="scheAttends" style="height:60px;width:70%;display:none;" class="fld_550" multiple="multiple">
					
					</select><div id="attendlist_view" class="ui-corner-all w100p" style="color: rgb(0, 0, 0); font-size: inherit; font-family: inherit; display: inline-block; border: 1px solid rgb(213, 213, 213); padding: 4px 0px 4px 4px; cursor: pointer; word-break: break-all; overflow-wrap: break-word;">&nbsp;</div><input type="hidden" name="_scheAttends" value="1">
				</div>
			</div>
	
			<div class="form-group">
				<label for="catFullName" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label required" aria-required="true">
					제목&nbsp;<!-- 제목 -->
				</label>
				<div class="col-xs-8 col-sm-10 g_value">
					<input id="subject" name="scheData.subject" class="form-control" type="text" value="" maxlength="80">
				</div>
			</div>
		
			<div class="form-group">
				<label for="catFullName" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label">
					중요도&nbsp;<!-- 중요도 -->
				</label>
				<div class="col-xs-8 col-sm-10 g_value">
					<span class="block input-icon" style="margin-top: 6px;">
						
						<input id="imp10" name="scheData.important" class="ace" type="radio" value="10" checked="checked"><span class="lbl"><label for="imp10">낮음</label>&nbsp;</span>
						<input id="imp20" name="scheData.important" class="ace" type="radio" value="20"><span class="lbl"><label for="imp20">보통</label>&nbsp;</span>
						<input id="imp30" name="scheData.important" class="ace" type="radio" value="30"><span class="lbl"><label for="imp30">높음</label>&nbsp;</span>
					</span>
				</div>
			</div>
	
			<div class="form-group">
				<label for="" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label">
					일시&nbsp;<!-- 일시 -->
				</label>
				<div class="col-xs-8 col-sm-10 g_value">
					시작일&nbsp;<!-- 시작일 --> : 
				<input id="startdate" name="scheData.startdate" onkeypress="if( !CheckKeyCode() ) return false;" class="date dateInput" readonly="readonly" type="text" value="${scheduleReq.startDate }" maxlength="30">
	
				<span id="timespans">
					<select id="starts" name="scheData.starts" onchange="sMinTime('starth', this.value)"><option value="AM" selected="selected">AM</option><option value="PM">PM</option></select>
					<select id="starth" name="scheData.starth"><option value="12">12</option><option value="01">01</option><option value="02">02</option><option value="03">03</option><option value="04">04</option><option value="05">05</option><option value="06">06</option><option value="07">07</option><option value="08">08</option><option value="09">09</option><option value="10" selected="selected">10</option><option value="11">11</option></select>
					<select id="startm" name="scheData.startm"><option value="00">00</option><option value="05">05</option><option value="10">10</option><option value="15">15</option><option value="20">20</option><option value="25">25</option><option value="30" selected="selected">30</option><option value="35">35</option><option value="40">40</option><option value="45">45</option><option value="50">50</option><option value="55">55</option></select>
				</span>
				 ~ 
				종료일&nbsp;<!-- 종료일 -->:
				<input id="enddate" name="scheData.enddate" onkeypress="if( !CheckKeyCode() ) return false;" class="date dateInput" readonly="readonly" type="text" value="${scheduleReq.endDate }" maxlength="30">
				 
				<span id="timespane">
					<select id="ends" name="scheData.ends" onchange="sMinTime('endh', this.value)"><option value="AM" selected="selected">AM</option><option value="PM">PM</option></select>
					<select id="endh" name="scheData.endh"><option value="12">12</option><option value="01">01</option><option value="02">02</option><option value="03">03</option><option value="04">04</option><option value="05">05</option><option value="06">06</option><option value="07">07</option><option value="08">08</option><option value="09">09</option><option value="10">10</option><option value="11" selected="selected">11</option></select>
					<select id="endm" name="scheData.endm"><option value="00">00</option><option value="05">05</option><option value="10">10</option><option value="15">15</option><option value="20">20</option><option value="25">25</option><option value="30" selected="selected">30</option><option value="35">35</option><option value="40">40</option><option value="45">45</option><option value="50">50</option><option value="55">55</option></select>
				</span>
				</div>
			</div>		
			<div class="form-group">
				<label for="" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label">
					옵션<!-- 옵션 -->
				</label>
				<div class="col-xs-8 col-sm-10 g_value">
					<input id="scheData.startdateonly1" name="scheData.startdateonly" type="checkbox" value="1"><input type="hidden" name="_scheData.startdateonly" value="on">
					<label for="scheData.startdateonly1" style="cursor:pointer;">시작일에 한번만 표기&nbsp;<!-- 시작일에 한번만 표기 --></label>
					
					<input id="scheData.allday1" name="scheData.allday" onclick="alldaynotime(this.checked)" type="checkbox" value="1"><input type="hidden" name="_scheData.allday" value="on">
					<label for="scheData.allday1" style="cursor:pointer;">종일일정&nbsp;<!-- 종일일정--></label>
					
					<span id="isSendMailSpan" style="display: none;">
						<input type="checkbox" id="isSendMail" name="isSendMail" value="T">
						<label for="isSendMail" style="cursor: pointer;">메일발송</label>
					</span>
				</div>
			</div>
			
			<div class="form-group" id="disprepeat">
				<label for="" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label">
					반복&nbsp;<!-- 반복유형 -->
				</label>
				<div class="col-xs-8 col-sm-10 g_value">
				<span class="block input-icon" style="margin-top: 6px;">
					<input id="repeattypeno" name="scheData.repeattype" onclick="typeCheck();" class="ace" type="radio" value="0" checked="checked"> 
					<span class="lbl"><label for="repeattypeno" style="cursor:pointer;">없음&nbsp;<!-- 없음 --></label></span>
		 			<input id="repeattypeday" name="scheData.repeattype" onclick="typeCheck();" class="ace" type="radio" value="1"> 
		 			<span class="lbl"><label for="repeattypeday" style="cursor:pointer;">매일&nbsp;<!-- 매일 --></label></span>
		 			<input id="repeattypeweek" name="scheData.repeattype" onclick="typeCheck();" class="ace" type="radio" value="2"> 
		 			<span class="lbl"><label for="repeattypeweek" style="cursor:pointer;">매주&nbsp;<!-- 매주 --></label></span>
		 			<input id="repeattypemonth" name="scheData.repeattype" onclick="typeCheck();" class="ace" type="radio" value="3"> 
		 			<span class="lbl"><label for="repeattypemonth" style="cursor:pointer;">매월&nbsp;<!-- 매월 --></label></span>
		 			</span>
				</div>
			</div>
			
			<div class="form-group" id="rplace">
				<label for="" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label">
					장소
				</label>
				<div class="col-xs-8 col-sm-10 g_value">
					<input id="scheData.schePlace" name="scheData.schePlace" type="text" value="">
				</div>
			</div>
		
			<div class="form-group" id="rday" style="display:none;">
				<label for="" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label required" aria-required="true">
					매일&nbsp;<!-- 매일 -->
				</label>
				<div class="col-xs-8 col-sm-10 g_value">
					<input id="repeatday" name="scheData.repeatday" onkeypress="if( !CheckKeyCode() ) return false;" class="w50 ime-off" type="text" value="" maxlength="2">
					일마다&nbsp;<!-- 일마다 -->
					반복&nbsp;<!-- 반복 -->
				</div>
			</div>
			
			<div class="form-group" id="rweek" style="display:none;">
				<label for="" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label required" aria-required="true">
					매주&nbsp;<!-- 매주 -->
				</label>
				<div class="col-xs-8 col-sm-10 g_value">
					<span>
						<input id="scheData.repeatweek1" name="scheData.repeatweek" type="radio" value="0">
						<label for="scheData.repeatweek1" style="cursor:pointer;">일요일&nbsp;<!-- 일요일 --></label>
						<input id="scheData.repeatweek2" name="scheData.repeatweek" type="radio" value="1">
						<label for="scheData.repeatweek2" style="cursor:pointer;">월요일&nbsp;<!-- 월요일 --></label>
						<input id="scheData.repeatweek3" name="scheData.repeatweek" type="radio" value="2">
						<label for="scheData.repeatweek3" style="cursor:pointer;">화요일&nbsp;<!-- 화요일 --></label>
						<input id="scheData.repeatweek4" name="scheData.repeatweek" type="radio" value="3">
						<label for="scheData.repeatweek4" style="cursor:pointer;">수요일&nbsp;<!-- 수요일 --></label>
						<input id="scheData.repeatweek5" name="scheData.repeatweek" type="radio" value="4">
						<label for="scheData.repeatweek5" style="cursor:pointer;">목요일&nbsp;<!-- 목요일 --></label>
						<input id="scheData.repeatweek6" name="scheData.repeatweek" type="radio" value="5">
						<label for="scheData.repeatweek6" style="cursor:pointer;">금요일&nbsp;<!-- 금요일 --></label>
						<input id="scheData.repeatweek7" name="scheData.repeatweek" type="radio" value="6">
						<label for="scheData.repeatweek7" style="cursor:pointer;">토요일&nbsp;<!-- 토요일 --></label>
					</span>
				</div>
			</div>
	
			<div class="form-group" id="rmonth" style="display:none;">
				<label for="" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label required" aria-required="true">
					매월&nbsp;<!-- 매월 -->
				</label>
				<div class="col-xs-8 col-sm-10 g_value">
					<input id="repeatmonth" name="scheData.repeatmonth" onkeypress="if( !CheckKeyCode() ) return false;" class="w50 ime-off" type="text" value="" maxlength="2"> 
					일마다&nbsp;<!-- 일마다 -->
					반복&nbsp;<!-- 반복 -->
				</div>
			</div>
			<div class="form-group" >
				<textarea rows="10" cols="" id="sche_content" name="sche_content" onkeydown="CheckTextCount(this, 1000);" class="form-control required" aria-required="true" style="display: none;"></textarea>
			</div>
		</div>
	</form>		
</div>


<%@ include file="./regist_js.jsp" %>
