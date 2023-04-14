package com.campus.campus.dataapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "stores")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CampBaseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long store_id;        // 업체 식별자 (contentId)
    @Column
    private String store_name;        // 이름(=캠핑장 이름) (facltNm)
    @Column
    private String biz_num;        // 사업자 번호 (bizrno)
    @Column
    private String main_img;        // 대표이미지 (firstImageUrl)
    @Column
    private String simple_info;        // 한줄 설명 (lineIntro)

    @Column(length = 10000)
    private String detail_info;        // 여러줄 설명 (intro)
    @Column
    private String store_phone;        // 번호 (tel)
    @Column
    private String site_url;        // 사이트 주소 (homepage)
    @Column
    private String category;        // 업종 구분 (induty)
    @Column
    private String location;        // 주소 (addr1)
    @Column
    private String doNm;        // 도 (doNm)
    @Column
    private String sigunguNm;        // 시군구 (sigunguNm)
    @Column
    private String zipcode;        // 우편번호 (zipcode)
    @Column
    private Long latitude;        // 경도 (mapX)
    @Column
    private Long longitude;        // 위도 (mapY)
    @Column
    private String direction_info;        // 오시는 길 (direction)
    @Column
    private String basic_facility;        // 기본 시설 (sbrsCl)
    @Column
    private String surroundings;        // 입지 구분 (lctCl)
    @Column
    private String surround_info;        // 주변 정보 (posblFcltyCl)
    @Column
    private String glamping_facility;        // 글램핑 - 내부시설 (glampInnerFclty)
    @Column
    private String caravan_facility;        // 카라반 - 내부시설 (caravInnerFclty)
    @Column
    private String operating_season;        // 운영기간 (operPdCl)
    @Column
    private String operating_date;        // 운영일 (operDeCl)
    @Column
    private Integer toilet_cnt;        // 화장실 개수 (toiletCo)
    @Column
    private Integer swrm_cnt;        // 샤워실 개수 (swrmCo)
    @Column
    private Integer wtrpl_cnt;        // 개수대 개수 (wtrplCo)
    @Column
    private String animal_yn;        // 애완동물출입 (animalCmgCl)
    @Column
    private String camp_feature;        // 특징 (featureNm)
    @Column
    private Integer siteBottomCl1;        // 잔디 (단위:면) (siteBottomCl1)
    @Column
    private Integer siteBottomCl2;        // 파쇄석 (단위:면) (siteBottomCl2)
    @Column
    private Integer siteBottomCl3;        // 테크 (단위:면) (siteBottomCl3)
    @Column
    private Integer siteBottomCl4;        // 자갈 (단위:면) (siteBottomCl4)
    @Column
    private Integer siteBottomCl5;        // 맨흙 (단위:면) (siteBottomCl5)
    @Column
    private String exprn_yn;        // 체험프로그램 여부(Y:사용, N:미사용) (exprnProgrmAt)
    @Column
    private String exprn;        // 그 외 체험활동 (exprn)


}
