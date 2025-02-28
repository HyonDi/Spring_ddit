<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>



<!-- inline scripts related to this page end -->

<script type="text/javascript">
function validCheck(){
	
   	var isValid = validator.form();
   	if(!isValid) validator.focusInvalid();
	return isValid;
}


var fileFormData = new FormData();
var registForm = $('form#registForm');

function docSubmit(){
	var form = document.getElementById("registForm");
	// setEditorForm(); // 에디터의 데이터를 폼에 삽입
    if (!validCheck()) return false;
	if (!confirm("저장 하시겠습니까?")) return false;

	$(window).unbind("beforeunload");
	
	
	waitMsg();	/* Processing message */
	
	if ($('.template-upload') && $('.template-upload').length > 0) {
		//$('#fileuploadstartconfirm').val(1);
		$('.fileupload-buttonbar').find('.start').click();
//		$('button[type=submit]').click();
		//return false;
	} else {	
		
		//업로드된 파일 개수.
		var index=0;

		//업로드 되는 파일 개수 확인
		var fileNum=0;
		
		for(var i of fileFormData.values()){
			++fileNum;
		}
							
		
		for(var value of fileFormData.values()){
			
			//file을 업로드하기 위한  formData()를 생성.
			var dataForm=new FormData();
			dataForm.append('file',value);		
			
			var loginUser_id="/${loginUser.id}";
			$.ajax({
				url:"<%=request.getContextPath()%>/upload",
				type:"post",
				data:dataForm,
				processData:false,
				contentType:false,
				success:function(data){
					var fileName,fileType,uuid;
					var splitName;
					if(checkImageType(data)){
						splitName=data.substring(14+loginUser_id.length).split('$$');						
						fileType="1";
					}else{
						splitName=data.substring(12+loginUser_id.length).split('$$');						
						fileType="0";
					}
					uuid=splitName[0];
					fileName=splitName[1];
					
					var uploadPath=data.substring(0,12+loginUser_id.length).replace(/\//g,"\\");
					var input1=$('<input>').attr('type','hidden')
					  					   .attr('name','attachList['+index+'].uuid')
					   					   .val(uuid);
					
					var input2=$('<input>').attr('type','hidden')
					   					   .attr('name','attachList['+index+'].fileName')
					   					   .val(fileName);
					var input3=$('<input>').attr('type','hidden')
										   .attr('name','attachList['+index+'].fileType')
										   .val(fileType);
					var input4=$('<input>').attr('type','hidden')
										   .attr('name','attachList['+index+'].uploadPath')
										   .val(uploadPath);
					
					registForm.prepend(input1).prepend(input2).prepend(input3).prepend(input4);
					index++;					
				}
				
			}); 
		}	
		 
		var submitTime=setInterval(function(e){
			if(fileNum==index){
				// ajax에 의한 파일업로드가 완료되면 submit을 진행한다.
				controlSubmit(registForm);
				
				// 해당 setInterval을 종료.
				clearInterval(submitTime);
			}
		},500);  
	}
	
}




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

//시작-종료일 비활성화
function blarDate(id){
	 if (id == "sDate"){
	 	$('#eDate').datepicker( "option", "minDate", $("#sDate").val() );
	 }else if (id == "eDate"){
	  	$('#sDate').datepicker( "option", "maxDate", $("#eDate").val() );
	 }
}


</script>
<script type="text/javascript">
var validator = null;
$(document).ready(function(){
	validator = $("#registForm").validate({
		rules:{
			"witer":{ required:true },// 필수냐,아니냐. false주면 검사안함.
			"title":{ required:true },
			"cotent":{ required:true },
			"category":{ required:true },	
			"pdsList":{ required:true }
			
	
		},
		messages:{ // 유효성검사
			"writer":{ required:"작성자를 입력해 주십시오 !" },
			"title":{ required:"제목을 입력해 주십시오 !" },
			"content":{ required:"내용을 입력해 주십시오 !" },
			"category":{ required:"분류를 선택해 주십시오 !" },
			"pdsList":{ required:"공유대상을 선택해 주십시오 !" }	
		},
		focusInvalid:true
	});
	
	//영구보존 관련 추가
	var cdate = "";
	 $('#never').click(function() {	
		 
	 	var ischecked = $('#never').is(":checked");
	     if(ischecked){
	         // 이전 값 보존 후, 영구설정.
	         cdate = $("#eDate").val();
	         $("#eDate").val( "" ).prop("disabled",true);
	         $("#sDate").attr("readonly", "true" );
	         $("#eDate").prop("disabled", true );
	     }else{
	         // 이전 값 보존.
	      $("#eDate").val( "" ).prop("disabled",false);
	  	   $("#eDate").val( cdate );
	  	   $("#sDate").attr("readonly", "false");
	         $("#eDate").removeAttr("readonly");
	     }
	  });
	
	 
	if("false"){
	   	Organizations.formatAddress("sharelist");	   
	   
	}
	$('#sharelist_view').on('click', function() {		
		var title = '조직도';
		var caption = '공유자 선택';
   		Organizations.open('sharelist', title, caption, 0, 0, 1);
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
				par.push("clubId=" + $("input[name='search.moduleId']").val());
				
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
	
	pageScroll();	// page Scroll을 위해 사용.
	
	setTimeout( "popupAutoResize2();", "500");		//팝업창 resize
	
});




//분류 변경
function fnChangeCategory(){
	var form = $("#registForm");
	var category = $("select[name=category]").val();
	//alert(category);
		
	form.attr("action",category+"/regist");
	if(category=="free"){	
		$('div#upload').css("display","none");	
		form.attr("enctype","application/x-www-form-urlencoded");
		$('div.bbsId').css("display","none");
		$('div.preserveId').css("display","none");
		$('div.openDate').css("display","none");
		$('div.shareList').css("display","none");
		$('div.title').css("display","block");
		$('div.content').css("display","block");
		$('div.uploadFile').css("display","none");
		
	}else if(category=="notice"){
		
		$('div#upload').css("display","block");
		form.attr("enctype","multipart/form-data");
		$('div.bbsId').css("display","block");
		$('div.preserveId').css("display","none");
		$('div.openDate').css("display","block");		
		$('div.shareList').css("display","none");
		$('div.title').css("display","block");
		$('div.content').css("display","block");
		$('div.uploadFile').css("display","block");
		
		$('select[name="point"]').attr("disabled",false); // false 주면 파라미터안넘김
		$('select[name="point"]').empty();		
		var option2=$('<option>').prop("selected",true).attr("value","0").text("일반");		
		var option1=$('<option>').attr("value","1").text("중요");
		$('select[name="point"]').append(option1).append(option2);
		
	}else{	// value가 pds
		$('div#upload').css("display","block");
		form.attr("enctype","multipart/form-data");
		$('div.bbsId').css("display","block");
		$('div.preserveId').css("display","block");
		$('div.openDate').css("display","block");		
		$('div.shareList').css("display","block");
		$('div.title').css("display","block");
		$('div.content').css("display","block");
		$('div.uploadFile').css("display","block");
		
		$('select[name="point"]').attr("disabled",false);
		$('select[name="point"]').empty();		
		var option2=$('<option>').prop("selected",true).attr("value","0").text("일반");		
		var option1=$('<option>').attr("value","1").text("중요");
		$('select[name="point"]').append(option1).append(option2);
		
	}
}

</script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.1.2/handlebars.min.js"></script>
<script id="templateAttach" type="text/x-handlebars-template">
<li style="width:10%;font-size:0.8em;position:relative;">
	<a href="{{fileName}}" class="btn btn-default btn-xs pull-right delbtn"
	   style="position:absolute;right:0;top:0;padding:0;" >
		<i class="fa fa-fw fa-remove"></i>
	</a>
	
	<span class="mailbox-attachment-icon has-img">
      <img src="{{imgsrc}}" alt=""></span> 
	 <span class="over" >{{fileName}}</span>
	    
</li>
</script>

<script>
var template=Handlebars.compile($('#templateAttach').html());

/* 해당문서형태의 아이콘 */
function getUploadFileInfo(fileName,imgsrc){
	
	var fileNameFormat = fileName.substring(fileName.lastIndexOf('.')+1);	
	
	// 이미지가 아닌경우만. 이미지의경우 썸네일표시할것임.
	if(!checkImageType(fileNameFormat)){
		var icon="";
		
		// 확장자 검사한다. 아이콘명으로 이미지소스를잡을거야.
		switch(fileNameFormat){
		case "doc":case "docx": icon="doc"; break;
		case "ppt":case "pptx": icon="ppt"; break;
		case "xlsx": case "xls": case "csv": icon="xls"; break;
		case "hwp": icon = "hwp"; break;
		case "zip": icon = "zip"; break;
		case "pdf": icon = "pdf"; break;
		default:icon = "file";		
		}		
		
		imgsrc="<%=request.getContextPath()%>/resources/common/images/"+icon+".png";
	}
	// json으로 return.
	return {fileName:fileName,imgsrc:imgsrc};	
}

function checkImageType(fileName){
	var pattern=/jpg|gif|png|jpeg/i;	
	return fileName.toLowerCase().match(pattern);
}

/* 기본이벤트를 막는다. */
$(document).on("dragenter dragover drop",function(event){
	event.preventDefault();
});


$('.fileDrop').on('drop',function(event){
	event.preventDefault();
	
	var files=event.originalEvent.dataTransfer.files;	
	var attachedNum=$('.uploadedList li').length;
	
	if((files.length+attachedNum)>3){
		alert("파일 업로드는 3개까지만 허용됩니다.");
		return;
	}
	var fileName,imgsrc;
	
	if (files) {
	    [].forEach.call(files, readAndPreview);
	 }
	
	function readAndPreview(file) {
	   
		// 드롭핑을하면 파일리더가 읽는다.
		var reader = new FileReader();
		reader.addEventListener("load", function () {	
			
			// 임시로만든 파일저장용 form데이터.
			fileFormData.append(file.name,file);
			
			// 이미지인지 아닌지. (이미지면썸네일, 이미지가아니면 서버에있는 아이콘 경로를 준다.)
			var fileInfo=getUploadFileInfo(file.name,this.result);
			var html=template(fileInfo);
			$('.uploadedList').append(html);
		}, false);
		
		reader.readAsDataURL(file);
	}
	
});



$('.uploadedList').on('click','.delbtn',function(e){
	e.preventDefault();
	
	var that=$(this).parent('li').remove();
	fileFormData.delete($(this).attr("href"));
});
</script>




<%-- <!-- summernote 0.8.12 -->

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.js"></script>
<script>
var $$=jQuery.noConflict();// 제이쿼리버전다른것쓸 때 부스트랩에서?? 충돌막기위함.


$$(function(){
	$$('#content').summernote({
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
	            		alert("!!!");
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
 --%>
 
 <%@ include file="./summernote_js.jsp"%>











