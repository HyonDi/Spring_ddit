// 팝업창들 띄우기
// 새로운 Window창을 Open할 경우 사용되는 함수 (arg : 주소, 창타이틀, 넓이, 길이)
function OpenWindow(UrlStr, WinTitle, WinWidth, WinHeight){
	winleft = (screen.width - WinWidth) / 2; 	// 전체크기 - 윈도우크기 / 2  해서 가운데로 위치하게함. 아래도 마찬가지.
	wintop = (screen.height - WinHeight) / 2;
	var win = window.open(UrlStr , WinTitle , "scrollbars=yes,width="+WinWidth +"," 
							+ "height="+WinHeight +", top=" + wintop +", left="
							+ winleft +", resizable=yes, status=yes" );
	win.focus();
	// focus 를 새로 열리는 window창에 줍니다.
}

// 팝업창 닫기
function CloseWindow(){
	window.opener.location.reload(true);// opner : 윈도우 창을 여는 원래창. 새로열린창은 window라고 부름.
	window.close();
}
	
// form submit
function SubmitMemberRegist(formRole){
	var uploadCheck = $('input[name="checkUpload"]').val();
	if(!(uploadCheck>0)){ // 업로드버튼 눌렀는지 확인.
		alert("사진 업로드는 필수입니다.");
		// $('input[name="pictureFile"]').click();
		return;
	}
	var form = $('form[role="'+formRole+'"]');
	form.submit();
}