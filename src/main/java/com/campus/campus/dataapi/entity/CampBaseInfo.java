package com.campus.campus.dataapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "CampBaseInfo")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CampBaseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contentId;
    @Column
    private String campingName;
    @Column
    private String summaryIntro;
    @Column(length = 10000)
    private String intro;
    @Column
    private String category;
    @Column
    private String doNm;
    @Column
    private String sigunguNm;
    //    @Column
//    private String zipcode;
    @Column
    private String addr;
//    @Column
//    private double latitude;
//    @Column
//    private double longitude;
//    @Column
//    private String directionInfo;
//    @Column
//    private String tel;
//    @Column
//    private String homepageUrl;
//    @Column
//    private String glampInnerFclty;
//    @Column
//    private String caravInnerFclty;
//    @Column
//    private String openPeriod;
//    @Column
//    private String openDate;
//    @Column
//    private String amenities;
//    @Column
//    private String animalYN;
//    @Column
//    private String firstImageUrl;

}
