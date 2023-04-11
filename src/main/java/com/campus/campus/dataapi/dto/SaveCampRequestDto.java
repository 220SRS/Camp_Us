package com.campus.campus.dataapi.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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
