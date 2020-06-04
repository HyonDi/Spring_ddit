jQuery(function ($) {

    $(".sidebar-dropdown > a").click(function(e) {
    	
  $(".sidebar-submenu").slideUp(200);
  if (
    $(this)
      .parent()
      .hasClass("active")
  ) {
    $(".sidebar-dropdown").removeClass("active");
    $(this)
      .parent()
      .removeClass("active");
  } else {
    $(".sidebar-dropdown").removeClass("active");
    $(this)
      .next(".sidebar-submenu")
      .slideDown(200);
    e.preventDefault();	
    $(this)
      .parent()
      .addClass("active");
  }
  
  $(".sidebar-submenu > li > a").on("click", function(event){
	  /*$(this).parents("li").hasClass("active");*/
	  $('iframe').attr('src', $(this).attr('href'));
	  //$('iframe').this()
	  /*$(this).attr('target','iframename');*/
	  reURL(mcode);
  });
  
});

/*$("#close-sidebar").click(function() {
  $(".page-wrapper").removeClass("toggled");
});
$("#show-sidebar").click(function() {
  $(".page-wrapper").addClass("toggled");
});*/


   
   
});

/*$(document).ready(function(){
    // menu 클래스 바로 하위에 있는 a 태그를 클릭했을때
    $(".sidebar-dropdown>a").click(function(){
        var submenu = $(this).next("ul");

        // submenu 가 화면상에 보일때는 위로 보드랍게 접고 아니면 아래로 보드랍게 펼치기
        if( submenu.is(":visible") ){
            submenu.slideUp();
        }else{
            submenu.slideDown();
        }
    });
});*/