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
        campingName: "Hotel",
        reservationNo: "23532",
        reservationPrice: "120000",
    },
    {
        img: "../../resources/static/images/together.jpg",
        reservationDate: "2022.03.15",
        campingName: "Sofitel Seoul",
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
        var cardHtml = `<div class="card" id="reviewcard-${i}">
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
          <button type="button" class="btn_2" id ="reviewbtn-${i}">리뷰 등록
          </button>
          <button type="button" class="btn_3" id="exitreview-${i}">삭제
          </button>    
        </div>
      </div>
    </div>
  </div>
</div>`
        container.insertAdjacentHTML('beforeend', cardHtml);
    }

    for (var i = 0; i < reservationData.length; i++) {
        // 리뷰 버튼에 이벤트 리스너 추가(modal 생성)
        var reviewBtn = document.getElementById(`reviewbtn-${i}`);
        reviewBtn.addEventListener('click', openModal);
        // 삭제 버튼에 이벤트 리스너 추가 (예약내역 삭제)
        var exitReviewBtn = document.getElementById(`exitreview-${i}`);
        exitReviewBtn.addEventListener('click', (function (index) {
            return function () {
                removeCard(index);
            };
        })(i));
    }
}

// modal 생성하는 함수
function openModal() {
    var modalHtml = `
<div class="modalBox">
  <div class="card clearfix">
    <h2 class="madal-title">XX 캠핑장</h2>
    <div class="swiper mySwiper">
        <div class="swiper-wrapper">
            <div class="swiper-slide">
                <img src="https://i0.wp.com/adventure.co.kr/wp-content/uploads/2020/09/no-image.jpg" class="image-box" style="max-width: 100%;"/>
            </div>
            <div class="swiper-slide">
                <img src="https://i0.wp.com/adventure.co.kr/wp-content/uploads/2020/09/no-image.jpg" class="image-box" style="max-width: 100%;"/>
            </div>
            <div class="swiper-slide">
                <img src="https://i0.wp.com/adventure.co.kr/wp-content/uploads/2020/09/no-image.jpg" class="image-box" style="max-width: 100%;"/>
            </div>
        </div>
        <div class="swiper-button-next"></div>
        <div class="swiper-button-prev"></div>
      </div>
    <div class="card-body">
      <h5 class="card-title">리뷰 작성</h5>
      <div class="form-textarea">
        <textarea name="" id="" rows="3"></textarea>
      </div>
    </div>
    <div class="closeModal">
      <button type="button" class="btn btn-primary closeModalBtn" style="float: right;">확인</button>
    </div>
  </div>
</div>
    `;

    var container = document.getElementById("cards-container");
    container.insertAdjacentHTML('beforeend', modalHtml);

    // 모달 열기
    var modalBox = document.getElementById("modalBox");
    $(modalBox).modal('show');

    // 모달 닫기 버튼에 이벤트 리스너 추가
    var closeModalBtn = document.getElementById("closeModalBtn");
    closeModalBtn.addEventListener('click', closeModal);

    // 이미지 등록 및 스와이퍼 기능 추가
    const fileDOM = document.querySelector('#file');
    const swiperWrapper = document.querySelector('.swiper-wrapper');
    let swiper;

    fileDOM.addEventListener("change", () => {

        const files = fileDOM.files;
        // 기존 이미지 삭제
        const imageBox = document.querySelector(".image-box");
        imageBox.remove();
        // 등록한 이미지에 접근
        for (const file of files) {
            const reader = new FileReader();
            reader.onload = ({target}) => {
                const slide = document.createElement("div");
                slide.classList.add("swiper-slide");
                const img = document.createElement("img");
                img.src = target.result;
                img.classList.add("image-box");
                slide.appendChild(img);
                swiperWrapper.appendChild(slide);
            };
            reader.readAsDataURL(file);
        }

        if (!swiper) {
            swiper = new Swiper(".swiper-container", {
                cssMode: true,
                slidesPerView: 1,
                spaceBetween: 10,
                navigation: {
                    nextEl: ".swiper-button-next",
                    prevEl: ".swiper-button-prev",
                },
                pagination: {
                    el: ".swiper-pagination",
                    clickable: true
                },
                mousewheel: true,
                keyboard: true,
            });
        } else {
            // 업로드된 이미지로 스와이퍼 슬라이드를 갱신하고 슬라이드 위치를 처음으로 초기화
            swiper.update();
            swiper.slideTo(0, 0);
        }


    });

}

// modal 지우는 함수
function closeModal() {
    var modalBox = document.getElementById("modalBox");
    $(modalBox).modal('hide');
    modalBox.remove();
}

// 예약내역 삭제하는 함수
function removeCard(index) {
    var cardToRemove = document.getElementById(`reviewcard-${index}`);
    cardToRemove.remove();
}


showReservationData(reservationData);
