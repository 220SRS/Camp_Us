$(function(){
    $('.tabcontent > div').hide();
    $('.tabnav a').click(function () {
        $('.tabcontent > div').hide().filter(this.hash).fadeIn();
        $('.tabnav a').removeClass('active');
        $(this).addClass('active');
        return false;
    }).filter(':eq(0)').click();
});


$(function(){
    $('.areatabcontent > div').hide();
    $('.areatabnav a').click(function () {
        $('.areatabcontent > div').hide().filter(this.hash).fadeIn();
        $('.areatabnav a').removeClass('active');
        $(this).addClass('active');
        return false;
    }).filter(':eq(0)').click();
});