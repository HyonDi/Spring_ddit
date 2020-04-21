<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<head>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/summernote/summernote-bs4.css">
</head>


<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/summernote/summernote-bs4.min.js">

</script>

<% //커스터마이징시 이 함수안에 제이슨형태로 값을 넘겨준다. 
	// summernote는 css못준대%>
<script>
	$(function(){
		$('#content').summernote({
			placeholder:'여기에내용을 적으세요.',
			height:250,
			
			callbacks:{
				onImageUpload : function(files, editor, welEditable) {
					alert("image selected!");
					for(var i = files.length - 1; i>= 0; i--){
						if(files[i].size > 1024*1024*5){
							alert("이미지는 5MB 미만입니다.");
							return;
						}
						for(var i = files.length -1; i>=0; i --) {
							sendFile(files[i], this);// 서버에 사진을 던질것이다.ajax로.
						}
					}
				},
				onMediaDelete : function(target) {
					alert("image delete");
					deleteFile(target[0].src);
					
				}
			}
		});
		
	});
	
	function sendFile(file, el) {
		
		var from_data = new FormData();
		form_data.append("file", file);
		
		$.ajax({
			data : form_data,
			type : "POST",
			url : '<%=request.getContextPath()%>/uploadImg.do',
			cache : false,
			contentType : false,
			processData : false,
			success : function(img_url) {
				$(el).summernote('editor.insertImage', img_url);
			}
		});
	}

	function deleteFile(src){
		
		var splitSrc =src.split("fileName=");
		var fileName = splitSrc[splitSrc.length-1];
		
		// alert(fileName);
		var fileData = {
				fileName:fileName
				//속성명:fileName 을 의미한다.
		}
		
		$.ajax({
			url:"<%=request.getContextPath()%>/deleteImg.do",
			data:JSON.stringify(fileData),
			type="post",
			success:function(res){
				console.log(res);
			}
		});
	}
	
</script>

