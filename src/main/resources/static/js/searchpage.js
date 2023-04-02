$(function(){
    $('.search_tabcontent > div').hide();
    $('.search_tabnav a').click(function () {
        $('.search_tabcontent > div').hide().filter(this.hash).fadeIn();
        $('.search_tabnav a').removeClass('active');
        $(this).addClass('active');
        return false;
    }).filter(':eq(0)').click();
});


/* 인원 버튼 */
$(document).ready(function() {
    $('.up').click(function() {
        var value = parseInt($('#person_count').text());
        $('#person_count').text(value + 1);
    });

    $('.dn').click(function() {
        var value = parseInt($('#person_count').text());
        if (value > 2) {
            $('#person_count').text(value - 1);
        }
    });
});
