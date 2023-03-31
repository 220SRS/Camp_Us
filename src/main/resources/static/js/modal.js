// 모달 버튼에 이벤트를 건다.
$('#reviewbtn').on('click', function () {
    $('#modalBox').modal('show');
});

// 모달 안의 취소 버튼에 이벤트를 건다.
$('#closeModalBtn').on('click', function () {
    $('#modalBox').modal('hide');
});
