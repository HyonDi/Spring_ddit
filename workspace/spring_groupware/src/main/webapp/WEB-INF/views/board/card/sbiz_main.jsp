<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script>

function msCardTgl() {
    var
        msCard  =   $('.ms_card'),
        status  =   wCatch();
    msCard.on('mouseenter focusin', function(){

        var
            that    =   $(this),
            front   =   that.find('.ms_card_front'),
            back    =   that.find('.ms_card_back');           
        if (status === 'p') {

            that.addClass('over');
                
            setTimeout(function(){ 
                    front.css('z-index','1');
                    back.css('z-index','2');
            }, 240);
        }

    });

    msCard.on('mouseleave focusout', function(){

        var
            that    =   $(this),
            front   =   that.find('.ms_card_front'),
            back    =   that.find('.ms_card_back');

        if (status === 'p') {
            that.removeClass('over');

            setTimeout(function(){

                    front.css('z-index','2');
                    back.css('z-index','1');

            }, 240);
        }

    });
}
</script>