package com.campus.campus.dataapi.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SaveCampRequestDto {
    private Long store_id;        // 업체 식별자 (contentId)
    private String store_name;        // 이름(=캠핑장 이름) (facltNm)
    private String biz_num;        // 사업자 번호 (bizrno)
    private String main_img;        // 대표이미지 (firstImageUrl)
    private String simple_info;        // 한줄 설명 (lineIntro)
    private String detail_info;        // 여러줄 설명 (intro)
    private String store_phone;        // 번호 (tel)
    private String site_url;        // 사이트 주소 (homepage)
    private String category;        // 업종 구분 (induty)
    private String location;        // 주소 (addr1)
    private String doNm;        // 도 (doNm)
    private String sigunguNm;        // 시군구 (sigunguNm)
    private String zipcode;        // 우편번호 (zipcode)
    private Long latitude;        // 경도 (mapX)
    private Long longitude;        // 위도 (mapY)
    private String direction_info;        // 오시는 길 (direction)
    private String basic_facility;        // 기본 시설 (sbrsCl)
    private String surroundings;        // 입지 구분 (lctCl)
    private String surround_info;        // 주변 정보 (posblFcltyCl)
    private String glamping_facility;        // 글램핑 - 내부시설 (glampInnerFclty)
    private String caravan_facility;        // 카라반 - 내부시설 (caravInnerFclty)
    private String operating_season;        // 운영기간 (operPdCl)
    private String operating_date;        // 운영일 (operDeCl)
    private Integer toilet_cnt;        // 화장실 개수 (toiletCo)
    private Integer swrm_cnt;        // 샤워실 개수 (swrmCo)
    private Integer wtrpl_cnt;        // 개수대 개수 (wtrplCo)
    private String animal_yn;        // 애완동물출입 (animalCmgCl)
    private String camp_feature;        // 특징 (featureNm)
    private Integer siteBottomCl1;        // 잔디 (단위:면) (siteBottomCl1)
    private Integer siteBottomCl2;        // 파쇄석 (단위:면) (siteBottomCl2)
    private Integer siteBottomCl3;        // 테크 (단위:면) (siteBottomCl3)
    private Integer siteBottomCl4;        // 자갈 (단위:면) (siteBottomCl4)
    private Integer siteBottomCl5;        // 맨흙 (단위:면) (siteBottomCl5)
    private String exprn_yn;        // 체험프로그램 여부(Y:사용, N:미사용) (exprnProgrmAt)
    private String exprn;        // 그 외 체험활동 (exprn)
}
