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

    for (var i = 0; i < reservationData.length; i++) {
        var data = reservationData[i];
        var cardHtml = `<div class="card">
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
                <a href="#0" class="btn_2">리뷰 등록</a>
                <a href="#0" class="btn_3">삭제</a>
              </div>
            </div>
          </div>
      </div>
    </div>`;
        container.innerHTML += cardHtml;
    }
}

showReservationData(reservationData);
