/**
 * 
 */

//팝업창들 띄우기
//새로운 Window창을 Open할 경우 사용되는 함수 (arg : 주소, 창타이틀, 넓이, 길이)
function OpenWindow(UrlStr, WinTitle, WinWidth, WinHeight){
	winleft = (screen.width - WinWidth) / 2;
	wintop = (screen.height - WinHeight) / 2;
	var win = window.open(UrlStr, WinTitle, "scrollbars=yes, width=" + WinWidth + ", " + "height=" + WinHeight + ", top=" + wintop + ", left="
							+ winleft + ", resizable=yes, status=yes");
	win.focus();
}

//팝업창 닫기
function CloseWindow(){
	window.opener.location.reload(true);
	window.close();
}

//===============================================================================

//form submit (사진 업로드 확인 alert 메서드때문에 공통사항은 아니라 regist.jsp에서 작성해도 무방
function SubmitMemberRegist(formRole){
	var uploadCheck = $('input[name="checkUpload"]').val();
	if(!(uploadCheck>0)){
		alert("사진 업로드는 필수입니다.");
		//$('input[name="pictureFile"]').click();
		return;
	}
	var form = $('form[role="' + formRole + '"]');
	form.submit();
}