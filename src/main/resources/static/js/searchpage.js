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


const testData = [
    {
        "name": "(주)디노담양힐링파크 지점",
        "id": 1,
        "simpleAddr": "전라남도 담양군",
        "campTypeOption": {
            "general": true,
            "glamping": true,
            "caravan": true,
            "car": false
        },
        "regionOption": {
            "region": "기타"
        },
        "basicOption": {
            "showerRoom": true,
            "mart": true,
            "wifi": true,
            "toilet": true,
            "equipRental": false,
            "pet": false
        },
        "detailOption": {
            "playground": false,
            "childPlayFct": false,
            "walkingLoad": true,
            "fireWood": true,
            "waterPlay": true,
            "trailerAc": false,
            "caravanAc": false,
            "exprn": false,
            "locationType": {
                "grass": false,
                "crushStone": false,
                "tech": true,
                "pebble": false,
                "soil": false
            }
        },
        "environmentOption": {
            "mountain": false,
            "forest": false,
            "river": false,
            "beach": false,
            "valley": false,
            "lake": true,
            "island": false,
            "city": false
        }
    },
    {
        "name": "(주)쉐르빌리안티티",
        "id": 2,
        "simpleAddr": "강원도 홍천군",
        "campTypeOption": {
            "general": false,
            "glamping": true,
            "caravan": false,
            "car": false
        },
        "regionOption": {
            "region": "기타"
        },
        "basicOption": {
            "showerRoom": true,
            "mart": true,
            "wifi": true,
            "toilet": true,
            "equipRental": false,
            "pet": false
        },
        "detailOption": {
            "playground": true,
            "childPlayFct": false,
            "walkingLoad": false,
            "fireWood": true,
            "waterPlay": false,
            "trailerAc": false,
            "caravanAc": false,
            "exprn": false,
            "locationType": {
                "grass": false,
                "crushStone": false,
                "tech": false,
                "pebble": false,
                "soil": false
            }
        },
        "environmentOption": {
            "mountain": true,
            "forest": false,
            "river": true,
            "beach": false,
            "valley": false,
            "lake": false,
            "island": false,
            "city": false
        }
    },
    {
        "name": "(주)아웃오브파크",
        "id": 3,
        "simpleAddr": "강원도 춘천시",
        "campTypeOption": {
            "general": false,
            "glamping": false,
            "caravan": true,
            "car": false
        },
        "regionOption": {
            "region": "기타"
        },
        "basicOption": {
            "showerRoom": false,
            "mart": false,
            "wifi": false,
            "toilet": false,
            "equipRental": false,
            "pet": false
        },
        "detailOption": {
            "playground": false,
            "childPlayFct": false,
            "walkingLoad": false,
            "fireWood": false,
            "waterPlay": true,
            "trailerAc": false,
            "caravanAc": false,
            "exprn": false,
            "locationType": {
                "grass": false,
                "crushStone": false,
                "tech": false,
                "pebble": false,
                "soil": false
            }
        },
        "environmentOption": {
            "mountain": true,
            "forest": false,
            "river": true,
            "beach": false,
            "valley": false,
            "lake": false,
            "island": false,
            "city": false
        }
    },
    {
        "name": "(주)양촌여울체험캠프",
        "id": 4,
        "simpleAddr": "경상남도 창원시",
        "campTypeOption": {
            "general": true,
            "glamping": false,
            "caravan": false,
            "car": true
        },
        "regionOption": {
            "region": "기타"
        },
        "basicOption": {
            "showerRoom": true,
            "mart": true,
            "wifi": false,
            "toilet": true,
            "equipRental": false,
            "pet": false
        },
        "detailOption": {
            "playground": false,
            "childPlayFct": false,
            "walkingLoad": true,
            "fireWood": false,
            "waterPlay": false,
            "trailerAc": true,
            "caravanAc": false,
            "exprn": false,
            "locationType": {
                "grass": false,
                "crushStone": true,
                "tech": true,
                "pebble": false,
                "soil": false
            }
        },
        "environmentOption": {
            "mountain": true,
            "forest": true,
            "river": false,
            "beach": false,
            "valley": false,
            "lake": false,
            "island": false,
            "city": false
        }
    },
    {
        "name": "(주)어반슬로우시티",
        "id": 5,
        "simpleAddr": "강원도 춘천시",
        "campTypeOption": {
            "general": false,
            "glamping": true,
            "caravan": false,
            "car": true
        },
        "regionOption": {
            "region": "기타"
        },
        "basicOption": {
            "showerRoom": false,
            "mart": false,
            "wifi": false,
            "toilet": false,
            "equipRental": false,
            "pet": false
        },
        "detailOption": {
            "playground": false,
            "childPlayFct": false,
            "walkingLoad": false,
            "fireWood": false,
            "waterPlay": false,
            "trailerAc": false,
            "caravanAc": false,
            "exprn": false,
            "locationType": {
                "grass": false,
                "crushStone": false,
                "tech": false,
                "pebble": false,
                "soil": false
            }
        },
        "environmentOption": {
            "mountain": false,
            "forest": false,
            "river": false,
            "beach": false,
            "valley": false,
            "lake": false,
            "island": false,
            "city": false
        }
    }
];


// 예약 정보 카드를 보여주는 함수
function showTestData(testData) {
    var container = document.getElementById("sarch_cards-container");

    // 입력된 데이터 갯수에 따라 카드를 생성하는 코드
    for (var i = 0; i < testData.length; i++) {
        var data = testData[i];
        var cardHtml = `
<div class="card" id="search_card-${i}">
  <div class="search_list">
    <div class="row">
      <div class="col-md-4 col-sm-4">
        <div class="photo">
          <img src="../../resources/static/images/camp_list1.jpg" alt=""/>
        </div>
      </div>
      <div class="col-md-5 col-sm-5">
        <div>
            <h3 class="camp_name">${data.name}</h3>
        </div>
        <div>
            <span>${data.simpleAddr}</span>
        </div>
      </div>
      <div class="col-md-3 col-sm-3">
        <div><span>8.9</span></div>
        <div>230,000원</div>
      </div>
    </div>
  </div>
</div>`
        container.insertAdjacentHTML('beforeend', cardHtml);
    }

    // for (var i = 0; i < testData.length; i++) {
    //     // 리뷰 버튼에 이벤트 리스너 추가(modal 생성)
    //     var reviewBtn = document.getElementById(`reviewbtn-${i}`);
    //     reviewBtn.addEventListener('click', openModal);
    //     // 삭제 버튼에 이벤트 리스너 추가 (예약내역 삭제)
    //     var exitReviewBtn = document.getElementById(`exitreview-${i}`);
    //     exitReviewBtn.addEventListener('click', (function (index) {
    //         return function () {
    //             removeCard(index);
    //         };
    //     })(i));
    // }
}
// $.ajax({
//     url: "http://localhost:8080/search/camps",
//     method: "GET",
//     dataType: "json",
//     success: function(data) {
//         console.log(data);
//
//     },
//     error: function(xhr, status, error) {
//         console.log("오류 발생: " + error);
//     }
// });

showTestData(testData);

/* 스크롤 */
let currentPage=1;
let isLoading=false;

$(window).on("scroll",function (){

    //위로 스크롤된 길이
    let scrollTop=$(window).scrollTop();

    //웹 브라우저의 창의 높이
    let windowHeight=$(window).height();

    //문서 전체의 높이
    let documentHeight=$(document).height();

    //바닥까지 스크롤 되었는 지 여부를 알아낸다.
    let isBottom=scrollTop+windowHeight + 10>=documentHeight;

    if(isBottom){
        //만약 현재 마지막 페이지라면
        // if(currentPage == ${totalPageCount} || isLoading){
        //     return;
        // }

        isLoading=true;

        currentPage++;

        console.log("inscroll:"+currentPage);
        GetList(currentPage);
    }
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
        //
        // data.area = "서울";
        // data.campType = "카라반";
        // data.basicOption = "샤워실";
        // data.detailOption = "트레일러";
        //
        // /*// 체크된 체크박스들의 값을 가져와서 JSON 형태로 만듦
        // $("input[type=checkbox]:checked").each(function() {
        //     data.areas.push($(this).next(".at1").text());
        // });*/
        //
        // // data 객체를 JSON 문자열로 변환하고 인코딩하여 쿼리스트링으로 추가
        // var queryString = $.param(data);
        // var encodedQueryString = encodeURI(queryString);

        // 서버로 데이터 전송
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/search/camps",
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