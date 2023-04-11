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


/* 검색 버튼 누르면 서버에 요청 보내기 */
$(document).ready(function() {
    $("#btn_srch").click(function() {
        var data = {};
        //data.areas = [];
    /*    data.area = encodeURI("서울");
        data.campType = encodeURI("카라반");
        data.basicOption = encodeURI("샤워실");
        data.detailOption = encodeURI("트레일러");*/

        data.area = "서울";
        data.campType = "카라반";
        data.basicOption = "샤워실";
        data.detailOption = "트레일러";

        /*// 체크된 체크박스들의 값을 가져와서 JSON 형태로 만듦
        $("input[type=checkbox]:checked").each(function() {
            data.areas.push($(this).next(".at1").text());
        });*/

        // data 객체를 JSON 문자열로 변환하고 인코딩하여 쿼리스트링으로 추가
        var queryString = $.param(data);
        var encodedQueryString = encodeURI(queryString);

        // 서버로 데이터 전송
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/search/camps?"+encodedQueryString,
            contentType: "application/json",
            success: function(result) {
                console.log(result);
            },
            error: function(error) {
                console.log(error);
            }
        });
    });
});