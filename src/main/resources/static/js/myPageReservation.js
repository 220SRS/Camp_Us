// 예약 정보 배열
// 필요한 info
// 예약 내역 관련 - 예약id(reservationNo) & 예약일자(date) & 예약금액(price)
// 캠핑장 정보 관련 - 예약된 캠핑장 id & 캠핑장 대표 이미지(img) & 캠핑장명(campingName)
const reservationData = [
    {
        img: "../../resources/static/images/together.jpg",
        reservationDate: "2022.02.03",
        campingName: "Hotel Mariott Paris",
        reservationNo: "23442",
        reservationPrice: "150000",
    },
    {
        img: "../../resources/static/images/together.jpg",
        reservationDate: "2022.03.15",
        campingName: "Hotel Sofitel Seoul",
        reservationNo: "23532",
        reservationPrice: "120000",
    },
    {
        img: "../../resources/static/images/together.jpg",
        reservationDate: "2022.03.15",
        campingName: "Hotel Sofitel Seoul",
        reservationNo: "23532",
        reservationPrice: "120000",
    },
    {
        img: "../../resources/static/images/together.jpg",
        reservationDate: "2022.03.15",
        campingName: "Hotel Sofitel Seoul",
        reservationNo: "23532",
        reservationPrice: "120000",
    },
    {
        img: "../../resources/static/images/together.jpg",
        reservationDate: "2022.03.15",
        campingName: "Hotel Sofitel Seoul",
        reservationNo: "23532",
        reservationPrice: "120000",
    }
];

// 예약 정보 카드를 보여주는 함수
function showReservationData(reservationData) {
    var container = document.getElementById("cards-container");

    // 입력된 데이터 갯수에 따라 카드를 생성하는 코드
    for (var i = 0; i < reservationData.length; i++) {
        var data = reservationData[i];
        var cardHtml = `<div class="card" id="reviewcard">
  <div class="strip_booking">
    <div class="row">
      <div class="col-md-2 col-sm-2">
        <div class="photo">
          <img src="${data.img}" alt=""/>
        </div>
      </div>
      <div class="col-md-6 col-sm-5">
        <h3 class="hotel_booking">${data.campingName}<span>${data.reservationDate}</span></h3>
      </div>
      <div class="col-md-2 col-sm-3">
        <ul class="info_booking">
          <li><strong>예약번호</strong> ${data.reservationNo}</li>
          <li><strong>금액</strong> ${data.reservationPrice}</li>
        </ul>
      </div>
      <div class="col-md-2 col-sm-2">
        <div class="booking_buttons">
        
          <!-- TODO : Demuu - reviewbtn 버튼 눌렀을 때, modal이 뜨게하고 싶어요!!-->
          <button type="button" class="btn_2" id="reviewbtn">리뷰 등록
          </button>
          <button type="button" class="btn_3" id="exitreview">삭제
          </button>    
        </div>
      </div>
    </div>
  </div>
</div>`
        container.innerHTML += cardHtml;
    }
}

showReservationData(reservationData);



// TODO : Demuu - 제가 추가하고 싶은 코드는 밑의 html코드에요 (myPageReservation.html에도 코드 있어요,,!)
// 버튼을 누르면 modal을 생성하고 modal.js에 있는 기능을 적용하는 것까지 하고 싶어요

/* <div id="modalBox" class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <div><h4 class="modal-title" id="myModalLabel">00 캠핑장 </h4></div>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close" id="closeModalBtn"><span
                            aria-hidden="true">&times;</span></button>
                    <!--<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>-->
                </div>
                <div class="modal-body">
                    <div><span>💡💡💡💡💡💡</span></div>
                    <div class="reviewImg">
                        <img src="../../resources/static/images/night.jpg" alt="..." class="img-thumbnail rounded">
                    </div>
                    <p class="h5">리뷰 작성</p>
                    <div class="form-group">
                        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary">확인</button>
                    <!--<button type="button" class="btn btn-default" id="closeModalBtn">취소</button>-->
                </div>
            </div>
        </div>
    </div>
*/