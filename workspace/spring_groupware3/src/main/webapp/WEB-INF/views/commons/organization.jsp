<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html><head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta charset="utf-8">
<meta name="robots" content="noindex,nofollow">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<title>메뉴관리</title>


<style type="text/css" id="fontFamilyStyleSheet">
body { font-family: 'Open Sans', sans-serif !important; }
</style>

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/css/font-awesome.min.css">
		
<!-- page specific plugin styles start -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/common/libs/dhtmlwindow/1.1/dhtmlwindow.css" type="text/css">	<!-- DHTML Window Widget v1.1 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/common/libs/dhtmlmodal/1.1/modal.css" type="text/css">			<!-- DHTML Modal window v1.1 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/css/jquery-ui.min.css">		<!-- jQuery UI v1.11.4 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/common/libs/jquery-qtip2/2.2.1/jquery.qtip.min.css">				<!-- jQuery qTip2 v2.2.1 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/css/bootstrap-datepicker3.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/css/ui.jqgrid.min.css">		<!-- jQuery jqGrid -->

<!-- page specific plugin styles end -->

<!-- text fonts -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/css/garam-fonts.min.css">

<!-- ace styles -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/css/garam.min.css" class="ace-main-stylesheet" id="main-ace-style">

<!--[if lte IE 9]>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/css/garam-part2.min.css" class="ace-main-stylesheet" />
<![endif]-->

<!--[if lte IE 9]>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/css/garam-ie.min.css" />
<![endif]-->

<!-- inline styles related to this page start -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/common/css/garam.garam.css">

<!-- inline styles related to this page end -->

<!-- ace settings handler -->
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/garam-extra.min.js"></script><style>@keyframes nodeInserted{from{outline-color:#fff}to{outline-color:#000}}@-moz-keyframes nodeInserted{from{outline-color:#fff}to{outline-color:#000}}@-webkit-keyframes nodeInserted{from{outline-color:#fff}to{outline-color:#000}}@-ms-keyframes nodeInserted{from{outline-color:#fff}to{outline-color:#000}}@-o-keyframes nodeInserted{from{outline-color:#fff}to{outline-color:#000}}.ace-save-state{animation-duration:10ms;-o-animation-duration:10ms;-ms-animation-duration:10ms;-moz-animation-duration:10ms;-webkit-animation-duration:10ms;animation-delay:0s;-o-animation-delay:0s;-ms-animation-delay:0s;-moz-animation-delay:0s;-webkit-animation-delay:0s;animation-name:nodeInserted;-o-animation-name:nodeInserted;-ms-animation-name:nodeInserted;-moz-animation-name:nodeInserted;-webkit-animation-name:nodeInserted}</style>

<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

<!--[if lte IE 8]>
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/html5shiv.js"></script>
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/respond.js"></script>
<![endif]-->




<!-- basic scripts -->

<!--[if !IE]> -->
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/jquery.min.js"></script>
<!-- <![endif]-->

<!--[if IE]>
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/jquery1x.min.js"></script>
<![endif]-->

<script type="text/javascript">
	var _console = window.console;
	if('ontouchstart' in document.documentElement) document.write("<script src='<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts start -->
<script src="<%=request.getContextPath()%>/resources/common/libs/dhtmlwindow/1.1/dhtmlwindow.js"></script></head><body class="no-skin" style="background-color: inherit;"><div id="dhtmlwindowholder"><span style="display:none">.</span></div>								<!-- DHTML Window Widget v1.1 -->
<script src="<%=request.getContextPath()%>/resources/common/libs/dhtmlmodal/1.1/modal.js"></script><div id="interVeil"></div>									<!-- DHTML Modal window v1.1  -->
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/jquery-ui.min.js"></script>					<!-- jQuery UI v1.11.4 -->
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/jquery.ui.touch-punch.min.js"></script>		<!-- jQuery UI Touch Punch v0.2.3 -->
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/bootbox.min.js"></script>						<!-- bootbox.js v4.3.0 -->
<script src="<%=request.getContextPath()%>/resources/common/libs/jquery-cookie/jquery.cookie.js"></script>				<!-- jQuery Cookie Pligin -->
<!-- <script src="<%=request.getContextPath()%>/resources/common/jquery/plugins/jquery.validate.js"></script>								jQuery Validation v1.8.1 -->
<!-- <script src="<%=request.getContextPath()%>/resources/common/libs/jquery-validation/jquery.validate.defaults.js"></script>				jQuery Validation defaults -->
<script src="<%=request.getContextPath()%>/resources/common/libs/jquery-validation/1.15.0/jquery.validate.js"></script>				<!-- jQuery Validation defaults --> 
<script src="<%=request.getContextPath()%>/resources/common/libs/jquery-validation/jquery.validate.defaults.js"></script>				
<script src="<%=request.getContextPath()%>/resources/common/libs/jquery-qtip2/2.2.1/jquery.qtip.min.js"></script>						<!-- jQuery qTip2 v2.2.1 -->
<script src="<%=request.getContextPath()%>/resources/common/jquery/plugins/BlockUI/jquery.blockUI.js"></script>						<!-- jQuery blockUI v2.63 -->
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/date-time/locales/bootstrap-datepicker.kr.js"></script>
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/jqGrid/jquery.jqGrid.min.js"></script>		<!-- jQuery jqGrid JS v5.0.1 -->
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/jqGrid/i18n/grid.locale-en.js"></script>	<!-- jQuery jqGrid English Translation -->

<!-- page specific plugin scripts end -->

<!-- ace scripts -->
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/garam-elements.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/garam.min.js"></script>

<!-- inline scripts related to this page start -->
<script src="<%=request.getContextPath()%>/resources/common/scripts/common.js"></script>
<script src="<%=request.getContextPath()%>/resources/common/scripts/organization_selector.js"></script>
<script type="text/javascript">
$.fn.datepicker.defaults.language = "ko";
</script>
<script src="<%=request.getContextPath()%>/resources/common/scripts/garam.garam.js"></script>
<script src="<%=request.getContextPath()%>/resources/common/scripts/parent.reload.js"></script>

<!-- inline scripts related to this page end -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/common/jquery/plugins/dynatree/skin-vista/ui.dynatree.css" />
<script src="<%=request.getContextPath()%>/resources/common/jquery/plugins/dynatree/jquery.dynatree.js"></script>
<script src="<%=request.getContextPath()%>/resources/common/jquery/plugins/dynatree/config.dynatree.js"></script>
<script src="<%=request.getContextPath()%>/resources/common/libs/json-js/json2.js" type="text/javascript"></script>
<!-- <style type="text/css">
.fontnull { font-size: 0pt; }
table { width: 100%; table-layout: fixed; border-collapse: collapse; }
.ui-autocomplete-loading { background: white url('<%=request.getContextPath()%>/resources/common/images/ui-anim_basic_16x16.gif') right center no-repeat; }
.ui-autocomplete { max-height: 300px; overflow-y: auto; overflow-x: auto; }
.ui-autocomplete a { white-space: nowrap; }
* html .ui-autocomplete { height: 300px; }
</style> -->
<script type="text/javascript">
	var rootKey = "00000000000000";
	var rootName = "대덕인재개발원";
	var onlydept = 0;
	var onlyuser = 0;
	var multiple = 1;
	/* 
	
		
			rootKey = "00000000000000";
			rootName = "대덕인재개발원";
		
	
	 */
	var isFirst = true;
	var returnFunc = null;
	
	// 사용자 부분 데이터
	var userSector = [			
			{ 
				"title": "대덕인재개발원", 
				"isFolder": true, 
				"isLazy": true, 
				"key": "00000000000000", 
				"addClass": "대덕인재개발원:00000000000000", 
				"address": {"type":"D","dpid":"00000000000000","dpname":"대덕인재개발원","dporder":"0"}
			}
	];
	
	// 사용자 전사 데이터
	var addressBook = [
		
			
			{ 
				"title": "대덕인재개발원", 
				"isFolder": true, 
				"isLazy": true, 
				"key": "00000000000000", 
				"addClass": "대덕인재개발원:00000000000000", 
				"address": {"type":"D","dpid":"00000000000000","dpname":"대덕인재개발원","dporder":"0"}
			}
		
	];

	$(document).ready(function(){
		$('select[name=addressBookList] > option:eq(0)').attr('selected', true);
		
		if (multiple == 0) {
			$('#leftSelector').css("width", "98%");
			$('#centerSelector').css("display", "none");
			$('#rightSelector').css("display", "none");
		}
		
	    $("#treeCtnr").dynatree({
	        children: addressBook, // 초기(루트) 노드를 생성합니다.
	    	onSelect: function(select, node) {	// 클릭되었을 때 호출합니다.
	    		if (!multiple) {
					if (onlyuser == 1 &&node.data.address.type == 'D') return false;
					if (onlydept == 1 &&node.data.address.type == 'P') return false;
    				var objAddress = node.data.address;
					var subtopdpid = "";
	    			if (node.getLevel() > 2) {
	    				while(node.getLevel() > 2) node = node.getParent();
	    				subtopdpid = node.data.address["dpid"];
	    			} else {
	    				subtopdpid = node.data.address["dpid"];
	    			}
	    			Organizations.add("select_address", objAddress, true, subtopdpid);
	    		}
	    	},
	    	onDblClick: function(node, e) {											// 더블 클릭되었을 때 호출합니다.
	    		var targetType = node.getEventTargetType(e); 						// 클릭한 노드영역
	    		if (targetType) {
    				if (onlyuser == 1 &&node.data.address.type == 'D') return false;
    				if (onlydept == 1 &&node.data.address.type == 'P') return false;
    				var objAddress = node.data.address;
					var subtopdpid = "";
	    			if (node.getLevel() > 2) {
	    				while(node.getLevel() > 2) node = node.getParent();
	    				subtopdpid = node.data.address["dpid"];
	    			} else {
	    				subtopdpid = node.data.address["dpid"];
	    			}
	    			Organizations.add("select_address", objAddress, true, subtopdpid);
	    			if (!multiple) OnOK();
	    		} else return false;
	    	},
	    	onLazyRead: function(node) {											// 처음으로 확장 될 때 호출됩니다.
				node.appendAjax({
					url: "<%=request.getContextPath()%>/commons/organization_selector_support_json",
					data: { dpId: node.data.key },
					async: (isFirst)? false: true									// 포커스를 주기 위해서 비동기로 사용
				});
			}
	    }); 

		//$("#treeCtnr").dynatree("getTree").getNodeByKey(rootKey).toggleExpand();	// 루트 노드를 확장합니다.

	 	isFirst = false;

		try {
			Organizations.Data = [];
			var if_list = Organizations.getFrameByName("if_list");
			var if_main = (if_list == null)? window.parent.window: if_list.parent.window;
			if (if_main == window && opener != null) {
				if_main = opener;
			}
			var item = if_main.organizationsArgument.Item;
			var data = if_main.organizationsArgument.Data || [];
			
			returnFunc = if_main.organizationsArgument.Func;

			Organizations.setOnlyuser(onlyuser);
			Organizations.setOnlydept(onlydept);
			Organizations.setMultiple(multiple);
			
			if (item != null) Organizations.setItem(item);
			for(var i = 0; i < data.length; i++)
				Organizations.add("select_address", data[i], (data.length-1 == i)?true:false);

			if_main.organizationsArgument.Item = null;
			if_main.organizationsArgument.Data = null;
			if_main.organizationsArgument.Func = null;
		} catch(e) { try{ console.log(e); } catch(e) {} }

// 		$("input[name=search]").bind("keydown", function(e) {
// 			if (e.keyCode == $.ui.keyCode.ENTER) $(this).autocomplete('search', $(this).val());
// 		})
		
		
	});

	//사용자 추가는 가능하나, 삭제가 안됨. - 수정해야 함.
	function ipadSelectSync() {
			
			if ( isMobile() == false ) return;
			
			var sel = $("#select_address");
			var div = $("#select_address_div");

			oplen = $('#select_address option');
			div.html("");

			for( var i=0; i < oplen.length; i++ ) {
				var ob = oplen.eq(i);
				
				ids = "div_sel_" + i;
				txtId = ids + "_text";
				valId = ids + "_value";

				strText = ob.text();
				strVal = ob.attr("value");
				
				//console.log( i + " - " + strText + " / " + strVal );
				
				var addDiv = $('<div onclick="javascript:apprpersonlist_div_del(\'' + ids + '\');" style="cursor:pointer; width:100%; white-space:pre; " id="' + ids + '"></div>');
				/*
				addDiv.hover( function() {
					this.css( 'background-color', '#dfdfdf' );
				});
				*/
				
				addDiv.append( $('<span id="' + txtId + '"></span>').text( strText ) );
				addDiv.append( $('<span style="display:none;" id="' + valId + '">' + strVal + '</span>') );
				
				div.append( addDiv );
			}
	}
	// ipad 에서 삭제 하는 경우
	function apprpersonlist_div_del( args ) {
		var selIds = args.split("_");
		var selId = selIds[selIds.length-1];

		var sel = $('#select_address');
		sel = $('#select_address option');
		sel.eq(selId).attr("selected", "selected");
		
		Organizations.remove('select_address');
	}

	function OnCancel() {
		if (returnFunc != null) returnFunc(null, window); else closeDoc2();
	}

	function OnOK() {
		if (returnFunc != null) returnFunc(Organizations.Data["select_address"], window); else closeDoc2();
	}

	function dynatreeChange(elem) {
		var select = $(elem);
		var rootNode = $("#treeCtnr").dynatree("getRoot");
		rootNode.removeChildren();
		switch(select.val()) {
			case '1': rootNode.addChild(userSector[0]); break;
			case '2': for(i in addressBook) rootNode.addChild(addressBook[i]); break;
			default : break;
		}
		rootNode.render();
		//$("#treeCtnr").dynatree("getTree").getNodeByKey(rootKey).toggleExpand();	// 루트 노드를 확장합니다.
	}
</script>



	<!-- Page Path Begins -->
	<div class="breadcrumbs" id="breadcrumbs">
		<ul class="breadcrumb">
			<li>
				<i class="green ace-icon fa fa-group bigger-150"></i>
				&nbsp;조직도 <!-- 공유자 선택 -->
			</li>
		</ul>
	</div>
	<!-- Page Path Ends -->

	<!-- Page Content Begins -->
	<div class="page-content no-padding">

		<div class="row modal-row">
			<div class="col-xs-12 col-xh-5-5 no-padding" id="leftSelector">
				<label class="col-xs-3 no-padding-right control-label bolder" for="domain" style="top:4px;">
					주소록
				</label>
				<div class="col-xs-9 no-padding">
					<select name="range" class="form-control" onchange="dynatreeChange(this)">
						<option value="1">부문주소록</option>
						<option value="2" selected="selected">전사주소록</option>
					</select>
				</div>
				<div class="space-1 col-xs-12"></div>
				<div class="input-group col-xs-12">
					<input type="text" id="search" name="search" class="form-control search-query ui-autocomplete-input" autocomplete="off">
					<span class="input-group-btn">
						<button type="button" class="btn btn-white btn-sm" id="searchBtn">
							<span class="ace-icon fa fa-search icon-on-right bigger-110"></span>
						</button>
					</span>
				</div>
				<div class="space-1 col-xs-12"></div>
				<div id="treeCtnr" class="ui-corner-all" style="border:1px solid #ddd;background-color:#fff;overflow:auto;height:250px;">
					<ul class="dynatree-container">
						<!-- 조직 표현되는 곳 -->						
					</ul>
				</div>
			</div>
			<div class="col-xs-12 col-xh-1 no-padding center" id="centerSelector">
				<div class="space-4 hidden-xs visible-xh-block" style="margin-top:100px;"></div>
				<div class="space-4 col-xs-12"></div>
				<button type="button" class="btn btn-sm btn-white" onclick="Organizations.add('select_address', null, true);" title="추가">
					<i class="blue ace-icon fa fa-chevron-right no-margin-right hidden-xs visible-xh-block"></i>
					<i class="blue ace-icon fa fa-chevron-down no-margin-right hidden-xh visible-xs-block"></i>
				</button>
				<div class="space-4 col-xs-12"></div>
				<button type="button" class="btn btn-sm btn-white" onclick="Organizations.remove('select_address');" title="삭제">
					<i class="red ace-icon fa fa-chevron-left no-margin-right hidden-xs visible-xh-block"></i>
					<i class="red ace-icon fa fa-chevron-up no-margin-right hidden-xh visible-xs-block"></i>
				</button>
			</div>
			<div class="col-xs-12 col-xh-5-5 no-padding" id="rightSelector">
				<select id="select_address" name="select_address" multiple="multiple" class="ui-corner-all" style="width:100%;height:308px;" ondblclick="Organizations.remove('select_address')"></select>
				<div id="select_address_div" style="display:none; width:100%; height:320px; background:#fff; border:1px solid #aaa; height:310px;">
				</div>
			</div>
		</div>
		
<!-- 		<div class="space-4"></div> -->
		
		<!-- Page Button Begins -->
<!-- 		<div class="row"> -->
			<div class="col-xs-12 align-center" style="margin-top:5px;">
				<button type="button" class="btn btn-sm btn-white btn-bold" onclick="OnOK();">
					<i class="blue ace-icon fa fa-circle-o"></i><b>확인</b>
				</button>
				<button type="button" class="btn btn-sm btn-white btn-bold" onclick="OnCancel();">
					<i class="red ace-icon fa fa-times"></i><b>취소</b>
				</button>
			</div>
<!-- 		</div> -->
		<!-- Page Button Ends -->
	</div>
	<!-- Page Content Ends -->
	

		<ul class="ui-autocomplete ui-front ui-menu ui-widget ui-widget-content" id="ui-id-1" tabindex="0" style="display: none;">
		</ul>
		<span role="status" aria-live="assertive" aria-relevant="additions" class="ui-helper-hidden-accessible"></span>
	</body>
</html>