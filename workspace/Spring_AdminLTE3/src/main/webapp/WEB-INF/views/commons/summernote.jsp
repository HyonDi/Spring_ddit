<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<!-- 
Head 마크업 써도 무방함. decorator에 head에 내용만 등록된다 (마크업 중복안됨) 
-->
<head>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/bootstrap/plugins/summernote/summernote-bs4.css">
</head>
<!-- Summernote -->
<script src="<%= request.getContextPath() %>/resources/bootstrap/plugins/summernote/summernote-bs4.min.js"></script>

<%-- //커스터마이징시 이 함수안에 제이슨형태로 값을 넘겨준다. 
	// summernote는 css못준대--%>

<script>
	$(function(){ //ready function (문서를 다 읽고 실행해라) : js는 footer에 있을 수 있는데 현재 script는 header에 있기때문에
		$('#content').summernote({
			placeholder : '여기에 내용을 적으세요',
			height : 250,
			
			callbacks:{
				//callback 안하면 default 설정(바이너리로 이미지를 읽어서 editor에 사진이 추가되긴하는데 코드가 엄청나게 길어서 DB에 저장할 수 없음)
				onImageUpload : function(files, editor, welEditable){
					//alert("image selected!");
					for(var i = files.length - 1; i >= 0; i--){
						if(files[i].size > 1024*1024*5){
							alert("이미지는 5MB 미만입니다.");
							return;
						}
						for(var i = files.length - 1; i >= 0; i--){
							sendFile(files[i], this);
							// 서버에 사진을 던질것이다.ajax로.
						}
					}
				},
				onMediaDelete : function(target){
					//alert("image delete");
					deleteFile(target[0].src);
				}
			}
		});
	});
	
	function sendFile(file, el){
		var form_data = new FormData();
		form_data.append("file", file);
		
		$.ajax({
			data : form_data,
			type : "POST",
			url : "<%= request.getContextPath() %>/uploadImg.do",
			cache : false,
			contentType : false,
			processData : false,
			success : function(img_url){
				//$(el) : summernote 뒤에 있는 textarea
				$(el).summernote('editor.insertImage', img_url); //'editor.insertImage' : image 태그를 만들어줌
			},
			error:function(error){
				alert("이미지 첨부에 실패했습니다.");
			}
		});
	}
	
	function deleteFile(src){
		var splitSrc = src.split("=");
		var fileName = splitSrc[splitSrc.length-1];
		
		//alert(fileName);
		var fileData = {
				"fileName":fileName
		}
		//속성명:fileName 을 의미한다.
		
		
		$.ajax({
			url : "<%= request.getContextPath() %>/deleteImg.do",
			type : "post",
			data : JSON.stringify(fileData),
			contentType:"application/json",
			success : function(res){
				console.log(res+"!!!!!!!");
			},
			error : function(error){
				alert("이미지 삭제에 실패했습니다.");
			}
			
		});
	}
	
</script>