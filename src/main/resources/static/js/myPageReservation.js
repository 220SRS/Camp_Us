// 예약 정보 배열
const reservationData = [
    {
        img: "../../resources/static/images/together.jpg",
        date: "2022.02.03",
        hotel: "Hotel Mariott Paris",
        reservationNo: "23442",
        amount: "150000",
    },
    {
        img: "../../resources/static/images/together.jpg",
        date: "2022.03.15",
        hotel: "Hotel Sofitel Seoul",
        reservationNo: "23532",
        amount: "120000",
    },
    {
        img: "../../resources/static/images/together.jpg",
        date: "2022.03.15",
        hotel: "Hotel Sofitel Seoul",
        reservationNo: "23532",
        amount: "120000",
    },
    {
        img: "../../resources/static/images/together.jpg",
        date: "2022.03.15",
        hotel: "Hotel Sofitel Seoul",
        reservationNo: "23532",
        amount: "120000",
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
              <h3 class="hotel_booking">${data.hotel}<span>${data.date}</span></h3>
            </div>
            <div class="col-md-2 col-sm-3">
              <ul class="info_booking">
                <li><strong>예약번호</strong> ${data.reservationNo}</li>
                <li><strong>금액</strong> ${data.amount}</li>
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
