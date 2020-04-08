<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%-- include될 애여서 html태그들 다 지웠다. --%>

<script>
	$('input#inputFile').on('change', function(event){
		// alert("file select !");
		
		// checkUpload 속성 값을 0으로 세팅합니다.
		$('input[name="checkUpload"]').val(0);
		
		// alert($('input[name="checkUpload"]').val());
		
		// this = input#inputFile
		var fileFormat = this.value.substr(this.value.lastIndexOf(".") + 1).toUpperCase();
		// 이미지 확장자 jpg확인
		if(fileFormat != "JPG"){
			alert("이미지는 jpg 형식만 가능합니다.");
			return;
		};
		
		// 이미지 파일 용량 체크
			// 파일정보는 files[] 에 경로와 다른것들이 들어있는데,
			// files[0] 에 실제파일이 들어있다.
		// 얘는 file객체가아니고 input태그(input#inputFile) 에 들어있는 file을 얘기함.
		if(this.files[0].size>1024*1024*1){
			alert("사진 용량은 1MB 이하만 가능합니다.");
			return;
		};
		
		
		// 파일선택오른쪽 textfield에 작성됨.
		document.getElementById('inputFileName').value= this.files[0].name;
		
		// 자바스크립트의 if문은 boolean이아니라 있는지/없는지 임.
		// 값이 없을 때(NaN, null , 1/0, false, undefined) false. 있을 때 true
		// 따라서 아래 if문 조건식은 this.files 가 있고, this.files[0] 이 있니? 하고 있는 것.
		if(this.files && this.files[0]) {
			
			
			// new fileReader : java의 흔적. 봄(돔,봄 javacript에있었음.)안에 있대.
			var reader = new FileReader();
			
			reader.onload = function(e) {
				// 이미지 미리보기
					// 백그라운드로 넣은이유? 이미지태그로넣으면 안좋아요. 크기와 비율이 다른 이미지를 늘리고 쪼그라트림.
					// 그리고 다운로드가 가능함.(이미지태그 넣으면. 백그라운드에넣으면 스크롤안에도 못넣으니 보안성^)
					// background-size 에서 cover는 짧은쪽을먼저 맞추고, 나머진 잘라버린다.
					// 'background-position' : 'center'  이미지를 가운데로.
					// 'background-repeat' : 'no-repeat' : 여백부분에 이미지가 반복됨. ( cover 하면 상관없음. )
				$('div#pictureView').css({'background-image' : 'url(' + e.target.result + ')',
											'background-position' : 'center',
											'background-size' : 'cover',
											'background-repeat' : 'no-repeat'
				});
			}
			reader.readAsDataURL(this.files[0]);
		}
		
		
	});
	

	

	

	
	function upload_go(){
		
/* 		for(var data of $('form[role="imageForm"]')){
			alert(data);
		} */
		
		// form 태그 양식을 객체화.
			// form을 formData객체에 넣음. => 왜? : 심지어 폼[0] 이네. => 0의미!! : 0번째 외에 추가적인데이터 말고 0번째만 가져오기위함.
			// [0] 없애면 form이 안들어와요. form에 필요한 정보까지 들어오기때문.[0] 은 form타입 element이지만 [1]부터는 아니기때문임.
			
					
			// form submit 하면 화면이 변해서? form태그안에 file이있으니 submit해야 날아간다. ajax로 하는건 파라미터만 날라감.(파일명만 날아간다.)
			// submit하면 화면이바뀌어(우린 안바뀌어야해!). 그래서 form객체를 만든것이다.
			// ajax로할때는 파라미터로 String만넘길때 가능.
		var form = new FormData($('form[role="imageForm"]')[0]);
		
		if($('input[name="picturesFile"]').val()==""){
			alert("사진을 선택하세요.");
			$('input[name="pictureFile"]').click();
			return;
		};
		
		
		// form객체로 넘길때엔 ajax속성이 바뀐다.
		// processData, contentType 을 flase로.반드시!!
		// 이렇게하면 실제로 submit한것처럼 반응을 함.
		// file명만 넣고, checkipload1로 바꾸고 끝낸다.
		$.ajax({
			url:"<%=request.getContextPath()%>/member/picture",
			data : form,
			type: 'post',
			processData:false,
			contentType:false,
			success:function(data){
				$('input#oldFile').val(data);
				$('form[role="form"] > input[name="picture"]').val(data);
				$('input[name="checkUpload"]').val(1);
				alert("사진을 업로드 했습니다.");
			}
		});
	}
	// 
	
</script>