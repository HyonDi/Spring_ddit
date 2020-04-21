<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	$('input#inputFile').on('change', function(event){
		$('input[name="checkUpload"]').val(0);
		
		<%-- alert($('input[name="checkUpload"]').val()); --%> 
		
		<%-- 확장자를 대문자로 통일 --%>
		var fileFormat = this.value.substr(this.value.lastIndexOf(".")+1).toUpperCase();
		
		<%-- 이미지 확장자 jpg 확인 (추가로 png 넣음) --%>
		if(fileFormat!="JPG" && fileFormat!="PNG"){
			alert("이미지는 jpg 형식만 가능합니다.");
			return;
		}
		
		<%-- 이미지 파일 용량 체크 --%>
		if(this.files[0].size>1024*1024*1){
			alert("사진 용량은 1MB 이하만 가능합니다.");
			return;
		}
		
		//files[0] : 파일 정보가 여러가지 저장되는데 그 중 경로는 첫번째 인덱스에 존재한다.
		document.getElementById('inputFileName').value = this.files[0].name;
		
		//자바 스크립트의 if문 : 데이터가 있으면 true, 없으면 false
		if(this.files && this.files[0]){
			
			//FileReader() : 브라우저에 존재하는 객체
			var reader = new FileReader();
			
			//이벤트
			reader.onload = function(e){
				//이미지 미리보기
				//e.target.result : event 객체에 있는 target의 result
				//'background-size' : 'cover' <-> 'contain'
				$('div#pictureView').css({
					'background-image' : 'url(' + e.target.result + ')',
					'background-position' : 'center',
					'background-size' : 'cover',
					'background-repeat' : 'no-repeat'
				});
			}
			
			//이거 안 쓰면 파일 이름 이상하게 나옴
			reader.readAsDataURL(this.files[0]);
			
		}
		
	});
	
	
	function upload_go(){
		//form 태그 양식을 객체화
		var form = new FormData($('form[role="imageForm"]')[0]); //[0]번으로 지정 안하면 htmlElement가 아니라 object로 꺼내옴
		//$('form[name="frm"]').submit(); 같은 경우는 submit 메서드가 저절로 0번째를 찾아서 submit하기 때문에 [0] 안씀
		
		if($('input[name="[pictureFile]"]').val() == ""){
			alert("사진을 선택하세요.");
			$('input[name="pictureFile"]').click();
			return;
		};
		
		//processData : false, contentType : false -> form 객체를 보낼때 꼭 해줘야함. form객체에 이미 내장되어있음
		$.ajax({
			url : "<%= request.getContextPath() %>/member/picture.do",
			data : form,
			type : 'post',
			processData : false,
			contentType : false,
			success : function(data){
				$('input#oldFile').val(data);
				$('form[role="form"] > input[name="picture"]').val(data);
				$('input[name="checkUpload"]').val(1);
				alert("사진을 업로드 했습니다.");
			},
			error : function(xhr, exception){
				alert("파일 업로드를 실패했습니다.");
			}
		});
	}
</script>