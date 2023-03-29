$(function(){
    $('.wrap_section_contents > div').hide();
    $('.tab_section a').click(function () {
        $('.wrap_section_contents > div').hide().filter(this.hash).fadeIn();
        $('.tab_section a').removeClass('active');
        $(this).addClass('active');
        return false;
    }).filter(':eq(0)').click();
});