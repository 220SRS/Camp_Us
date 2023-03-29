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
  });
});