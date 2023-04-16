package com.campus.campus.dataapi.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
public class SaveCampRequestDto {
    private Long contentId;
    private String campingName;
    private String summaryIntro;
    private String intro;
    private String category;
    private String doNm;
    private String sigunguNm;
    //    private String zipcode;
    private String addr;

    // 입지형태
    private String grass; // 잔디(단위:면)
    private String crushStone; // 파쇄석(단위:면)
    private String tech; // 테크(단위:면)
    private String pebble; // 자갈(단위:면)
    private String soil; // 맨흙(단위:면)
    //---------

    private String toiletCnt; // 화장실 개수
    private String swrmCnt; // 샤워실 개수
    private String surrFacilities; // 주변 정보

    private String caravanAc; // 개인 카라반 동반 여부
    private String trailerAc; // 개인 트레일러 동반 여부

    private String eqpRental; // 캠핑장비 대여
    private String exprnYn; // 체험 프로그램 여부
    private String amenities; // 주변 정보

    private String locationType; // 입지 구분
    private String animalYN; // 애완동물 출입

//    private double latitude;
//    private double longitude;
//    private String directionInfo;
//    private String tel;
//    private String homepageUrl;
//    private String glampInnerFclty;
//    private String caravInnerFclty;
//    private String openPeriod;
//    private String openDate;
//    private String amenities;
//    private String animalYN;
//    private String firstImageUrl;
}
