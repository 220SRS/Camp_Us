//var updateBtnList = document.querySelectorAll('.updateBefore button');
//updateBtnList.forEach(function (updateBtn) {
//  updateBtn.addEventListener('click', function (event) {
//    // 클릭 이벤트 처리 로직
//    var detailPage = event.target.parentNode.nextElementSibling;
//    if (detailPage.style.display === 'none') {
//      detailPage.style.display = 'block';
//    } else {
//      detailPage.style.display = 'none';
//    }
//  });
//});

// 김인환 코드
//var updateBtnList = document.querySelectorAll('.updateBtn');
//updateBtnList.forEach(function (updateBtn) {
//  updateBtn.addEventListener('click', function (event) {
//    // 클릭 이벤트 처리 로직
//    var detailPage = event.target.parentNode.nextElementSibling;
//    if (detailPage.style.display === 'none') {
//      detailPage.style.display = 'block';
//      event.target.style.display = 'none'; // 수정 버튼 숨기기
//    } else {
//      detailPage.style.display = 'none';
//      event.target.style.display = 'block'; // 수정 버튼 보이기
//    }
//  });
//});
//
//var cancelBtnList = document.querySelectorAll('.cancelBtn');
//cancelBtnList.forEach(function (cancelBtn) {
//  cancelBtn.addEventListener('click', function (event) {
//    // 클릭 이벤트 처리 로직
//    var updateBefore = event.target.parentNode.previousElementSibling;
//    updateBefore.style.display = 'block';
//    event.target.parentNode.style.display = 'none';
//    var updateBtn = updateBefore.querySelector('.updateBtn');
//    updateBtn.style.display = 'block'; // 수정 버튼 보이기
//  });
//});
//
//$.ajax({
//  url: "http://localhost:8080/myPage/1",
//  type: "GET",
//  dataType: "json",
//  success: function(data) {
//    // 서버에서 받은 JSON 데이터를 이용하여 페이지 내용 업데이트
//    updatePage(data);
//  },
//  error: function(jqXHR, textStatus, errorThrown) {
//    console.log("Error: " + textStatus + " " + errorThrown);
//  }
//});
//
//function updatePage(data) {
//  // 닉네임 업데이트
//  $("#nickname").text(data.nickname);
//  // 예약자 이름 업데이트
//  $("#reservation_name").text(data.reservation_name);
//  // 휴대폰 번호 업데이트
//  $("#phone_number").text(data.phone_number);
//}
//
//const express = require('express');
//const app = express();
//const cors = require('cors');
//
//app.use(cors());
//
//$(document).ready(function () {
//    $(document).on("click", ".update-nickname", function () {
//        sendUpdateRequest("nickname", $("#nickname").text(), $("input[name='tel']").eq(0).val(), "http://localhost:8080/myPage/nickName/1");
//    });
//
//    $(document).on("click", ".update-reservation-name", function () {
//        sendUpdateRequest("reservation_name", $("#reservation_name").text(), $("input[name='tel']").eq(1).val(), "http://localhost:8080/myPage/name/1");
//    });
//
//    $(document).on("click", ".update-phone-number", function () {
//        sendUpdateRequest("phone_number", $("#phone_number").text(), $("input[name='tel']").eq(2).val(), "http://localhost:8080/myPage/phone/1");
//    });

$(document).ready(function () {
    // 이벤트 리스너 등록 코드를 여기에 추가
    var updateBtnList = document.querySelectorAll('.updateBtn');
    updateBtnList.forEach(function (updateBtn) {
        updateBtn.addEventListener('click', function (event) {
            // 클릭 이벤트 처리 로직
            var detailPage = event.target.parentNode.nextElementSibling;
            if (detailPage.style.display === 'none') {
                detailPage.style.display = 'block';
                event.target.style.display = 'none'; // 수정 버튼 숨기기
            } else {
                detailPage.style.display = 'none';
                event.target.style.display = 'block'; // 수정 버튼 보이기
            }
        });
    });

    var cancelBtnList = document.querySelectorAll('.cancelBtn');
    cancelBtnList.forEach(function (cancelBtn) {
        cancelBtn.addEventListener('click', function (event) {
            // 클릭 이벤트 처리 로직
            var updateBefore = event.target.parentNode.previousElementSibling;
            updateBefore.style.display = 'block';
            event.target.parentNode.style.display = 'none';
            var updateBtn = updateBefore.querySelector('.updateBtn');
            updateBtn.style.display = 'block'; // 수정 버튼 보이기

            var inputField = event.target.parentNode.querySelector('.text');
            inputField.value = "";
        });
    });

    // 기존 코드
    $.ajax({
        url: "http://localhost:8080/myPage/1",
        type: "GET",
        dataType: "json",
        success: function (data) {
            // 서버에서 받은 JSON 데이터를 이용하여 페이지 내용 업데이트
            updatePage(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Error: " + textStatus + " " + errorThrown);
        }
    });

    function updatePage(data) {
        // 닉네임 업데이트
        $("#nickname").text(data.nickname);
        // 예약자 이름 업데이트
        $("#reservation_name").text(data.reservation_name);
        // 휴대폰 번호 업데이트
        $("#phone_number").text(data.phone_number);
    }

    $(document).on("click", ".update-nickname", function () {
        sendUpdateRequest("nickname", $("#nickname").text(), $("input[name='tel']").eq(0).val(), "http://localhost:8080/myPage/nickName/1");
    });

    $(document).on("click", ".update-reservation-name", function () {
        sendUpdateRequest("reservation_name", $("#reservation_name").text(), $("input[name='tel']").eq(1).val(), "http://localhost:8080/myPage/name/1");
    });

    $(document).on("click", ".update-phone-number", function () {
        sendUpdateRequest("phone_number", $("#phone_number").text(), $("input[name='tel']").eq(2).val(), "http://localhost:8080/myPage/phone/1");
    });

    function sendUpdateRequest(field, oldValue, newValue, url) {
        if (oldValue === newValue) {
            alert("변경된 내용이 없습니다.");
            return;
        }

    let data = {};

    switch (field) {
        case 'nickname':
            data = { "nickname": newValue };
            break;
        case 'reservation_name':
            data = { "reservation_name": newValue };
            break;
        case 'phone_number':
            data = { "phone_number": newValue };
            break;
    }

        $.ajax({
            url: url,
            type: "PATCH",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (response) {
                alert("정보가 성공적으로 수정되었습니다.");
                $("#" + field).text(newValue);
            },
            error: function (xhr, status, error) {
                console.error(error);
                alert("정보 수정에 실패했습니다.");
            }
        });
    }
});