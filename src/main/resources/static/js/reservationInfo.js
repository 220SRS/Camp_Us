// 예약 정보 배열
// 필요한 info
// 예약 내역 관련 - 예약id(reservationNo) & 예약일자(date) & 예약금액(price)
// 캠핑장 정보 관련 - 예약된 캠핑장 id & 캠핑장 대표 이미지(img) & 캠핑장명(campingName)
$(document).ready(function () {
    // ReservationResponseDto 객체에서 값을 받아옵니다.
    var status = $('#used_type option:selected').val();
    var period = $('#sort_date option:selected').val();
    var userId = 1;
    function fetchReservationData() {
        $.ajax({
            url: 'http://localhost:8080/mypage/reservation/' + userId + '?status=' + status + '&period=' + period,
            type: "GET",
            success: function (result) {
                //console.log(result); // 데이터가 정상적으로 도착했는지 확인
                var reservationData = result.reservationResponseDtos;
                showReservationData(reservationData);
            },
            error: function (xhr, status, error) {
                console.log(error);
                alert("Error occurred while fetching the reservations.");
            }
        });
    }
    $('#used_type, #sort_date').on('change', function() {
        console.log('Event handler for change event is working!');
        status = $('#used_type option:selected').val();
        period = $('#sort_date option:selected').val();
        console.log("status", status);
        console.log("period", period);

        fetchReservationData(); // change 이벤트 발생시 fetchReservationData 함수를 호출합니다.
    });

    fetchReservationData();
});

function showReservationData(reservationData) {
    var container = document.getElementById("cards-container");
    container.innerHTML = '';
    // 입력된 데이터 갯수에 따라 카드를 생성하는 코드
    for (var i = 0; i < reservationData.length; i++) {
        var data = reservationData[i];
        var cardHtml = `<div class="card" id="reviewcard-${i}">
  <div class="strip_booking">
    <div class="row">
      <div class="col-md-2 col-sm-2">
        <div class="photo">
          
     
        </div>
      </div>
      <div class="col-md-6 col-sm-5">
        <h3 class="hotel_booking">${data.storeId}<span>${data.startDate} - ${data.endDate}</span></h3>
      </div>
      <div class="col-md-2 col-sm-3">
        <ul class="info_booking">
          <li><strong>예약번호</strong> ${data.rsvId}</li>
          <li><strong>금액</strong> ${data.paymentAmt}</li>
        </ul>
      </div>
      <div class="col-md-2 col-sm-2">
        <div class="booking_buttons">
          <button type="button" class="btn_2" id ="reviewbtn-${i}">리뷰 등록
          </button>
          <button type="button" class="btn_3" id="exitreview-${i}">삭제
          </button>    
        </div>
      </div>
    </div>
  </div>
</div>`;
        container.insertAdjacentHTML('beforeend', cardHtml);

        var exitReviewBtn = document.getElementById(`exitreview-${i}`);
        exitReviewBtn.addEventListener('click', (function (index, rsvId) {
            return function () {
                deleteReservation(index, rsvId);
            };
        })(i, data.rsvId));

        var reviewBtn = document.getElementById(`reviewbtn-${i}`);
        reviewBtn.addEventListener('click', (function (index, campingName) {
            return function () {
                openModal(index, campingName);
            };
        })(i, data.storeId));
    }
}

// modal 생성하는 함수
function openModal(index, campingName) {
    var modalHtml = `
    <div class="modal fade" id="modal-${index}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">${campingName} 리뷰 작성</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close" id="closeModal">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <div class="form-group">
              <label for="reviewImages">리뷰 이미지 (최대 3개)</label>
              <input type="file" class="form-control-file" id="reviewImages" multiple accept="image/*"">
              
            </div>
             <div id="selectedImages-${index}"></div>
            
            
              
            <div class="form-group">
              <label for="reviewContent">리뷰 내용</label>
              <textarea class="form-control" id="reviewContent" rows="5"></textarea>
            </div>
          </div>
          
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal" id="close-modal-btn">닫기</button>
            <button type="button" class="btn btn-primary" onclick="submitReview(${index})">리뷰 등록</button>
          </div>
        </div>
      </div>
    </div>
    `;

    var container = document.getElementById(`reviewcard-${index}`);
    container.insertAdjacentHTML('beforeend', modalHtml);

    //"닫기" 버튼에 click 이벤트 리스너 등록
    var closeModalBtn = document.getElementById(`close-modal-btn`);
    closeModalBtn.addEventListener('click', function() {
        closeModal();
    });

    // x버튼에 click 이벤트 리스너 등록
    var removeModalBtn = document.getElementById(`closeModal`);
    removeModalBtn.addEventListener('click', function() {
        closeModal();
    });

    // 이미지 선택창에서 선택한 이미지를 미리보기에 추가하는 이벤트 리스너 등록
    var reviewImagesInput = document.getElementById('reviewImages');
    reviewImagesInput.addEventListener('change', function() {
        readURL(this, index);
    });

    // 모달 열기
    $(`#modal-${index}`).modal('show');

}

// 예약내역 삭제하는 함수
function deleteReservation(index, rsvId) {
    $.ajax({
        url: 'http://localhost:8080/mypage/reservation?rsvId=' + rsvId,
        type: 'DELETE',
        success: function (result) {
            console.log('Reservation deleted:', result);
            removeCard(index);
            // 페이지 리다이렉트
            //window.location.href = url;
        },
        error: function (xhr, status, error) {
            console.log(error);
            alert("Error occurred while deleting the reservation.");
        }
    });
}
// 카드 삭제하는 함수
function removeCard(index) {
    var cardToRemove = document.getElementById(`reviewcard-${index}`);
    cardToRemove.remove();
}
// Modal에서 리뷰이미지 등록 시, 리뷰이미지 보여주고 & 3개이상 등록시 alert적용
function readURL(input, index) {
    var previewContainer = document.getElementById(`selectedImages-${index}`);
    previewContainer.innerHTML = '';

    if (input.files && input.files[0]) {
        if (input.files.length > 3) {
            alert('이미지는 최대 3개까지 등록할 수 있습니다.');
            input.value = '';
            return;
        }

        for (var i = 0; i < input.files.length; i++) {
            var reader = new FileReader();

            reader.onload = function(e) {
                var imgHtml = `<img src="${e.target.result}" class="img-fluid mb-2">`;
                previewContainer.insertAdjacentHTML('beforeend', imgHtml);
            }

            reader.readAsDataURL(input.files[i]);
        }
    }
}

// Modal 닫는 함수
function closeModal() {
    // 모달을 닫습니다.
    $('.modal').modal('hide');

    // 모달 DOM을 삭제합니다.
    $('.modal-backdrop').remove();
    $('body').removeClass('modal-open');
    $('.modal').remove();
}


showReservationData(reservationData);




