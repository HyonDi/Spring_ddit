<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<style>
.fileDrop{
	width:100%;
	height:200px;
	border:1px dotted blue;	
}
small{
	margin-left:3px;
	font-weight:bold;
	color:gray;
}
</style>

</head>
<body>
	<h3>Ajax File Upload</h3>
	<div class="fileDrop"></div>
	
	<div class="uploadedList" ></div>
	
	<button type="button" id='submitBtn'>등록</button>
</body>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script>
	$(this).on("dragenter dragover drop",function(event){
		//alert("drag & drop");
		event.preventDefault();
		
	});

	$(".fileDrop").on("dragenter dragover", function(event){
		//alert("file drop");
		event.preventDefault();
	});
	
	$(".fileDrop").on("drop",function(event){
		//alert("drop");
		event.preventDefault();
		
		var files = event.originalEvent.dataTransfer.files;
		
		for(var i = 0; i < files.length; i++) {
			//alert(files[i].name);
			addFile(files[i]);
		}
	});
	
	function addFile(file){
		var formData=new FormData();
		/* form태그없이 파라미터로 보낼때 formData사용. */
		formData.append("file", file);
		
		$.ajax({
			url:"uploadAjax",
			type:"post",
			data:formData,
			contentType:false,
			processData:false,
			success:function(data){// 이미지인경우 서버가 data로 보내주는 것은 /2020/05/07/s_uuid$$fileName.jpg : true : 썸네일로.
								   // 이미지가 아닌경우 : /2020/05/07/uuid$$fileName.txt : false : text로.
				var str="";
				if(checkImageType(data)){
					/* 썸네일 */
					str="<div><a class='thumnail' href='displayFile?fileName="+getImageLink(data)+"'>"
					   +"<img src='displayFile?fileName="+data+"'/>"
					   +"</a><small data-src='"+data+"'><button>X</button></small></div>";
				}else{
					/* 텍스트  */
					str="<div><a class='thumnail' href='displayFile?fileName="+data+"'>"
						 +getOriginalName(data)+"</a>"
						 +"<small data-src='"+data+"'>"
						 +"<button>X</button></small></div>";
				}
				
				$(".uploadedList").append(str);
				// json데이터가 아니어서 핸들바?를 사용하지못함.
			},
			error:function(error){}
		});
	}
	
	function checkImageType(fileName){
		fileName=fileName.substring(fileName.lastIndexOf(',')+1).toLowerCase();
		var pattern=/jpg|gif|png|jpeg/i;/* i 가 전체 라는 의미래. fileName이 확장자로 넘어올 것인데 그 전체가 패턴중 하나인지 검사. */
		return fileName.match(pattern);
	}
	
	function getOriginalName(fileName){// 이미지가 아닐경우 파일경로?이름?를 가져오는 것.
		if(checkImageType(fileName)){
			return;
		}
		
		var idx=fileName.indexOf("$$")+1; // $$:구분자로우리가정한것. file이름나오도록
		return fileName.substr(idx);
		
	}
	
	
	function getImageLink(fileName){// 이미지일 경우 파일이름?경로?를 가져오는 것.
		if(!checkImageType(fileName)){// 이미지가 아니면 return.
			return;
		}
		var front=fileName.substr(0,12);// 이미지면 front에 담기는 것 : /2020/05/07/
		var end=fileName.substr(14); // end에 담기는 것 : fileName.jpg  짤려서 사라진부분은 's_' 로, 이미지의경우 썸네일로 저장하느라 추가됐던 s_를 없애고 파일이름을 지정했다.
		return front+end;
	}
	
	
	
</script>

</html>