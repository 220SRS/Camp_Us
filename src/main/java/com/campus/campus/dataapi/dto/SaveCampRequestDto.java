package com.campus.campus.dataapi.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
public class SaveCampRequestDto {
    private Long storeId;        // 업체 식별자 (contentId)
    private String storeName;        // 이름(=캠핑장 이름) (facltNm)
    private String bizNum;        // 사업자 번호 (bizrno)
    private String mainImg;        // 대표이미지 (firstImageUrl)
    private String simpleInfo;        // 한줄 설명 (lineIntro)
    private String detailInfo;        // 여러줄 설명 (intro)
    private String storePhone;        // 번호 (tel)
    private String siteUrl;        // 사이트 주소 (homepage)
    private String category;        // 업종 구분 (induty)
    private String location;        // 주소 (addr1)
    private String doNm;        // 도 (doNm)
    private String sigunguNm;        // 시군구 (sigunguNm)
    private String zipcode;        // 우편번호 (zipcode)
    private Double latitude;        // 경도 (mapX)
    private Double longitude;        // 위도 (mapY)
    private String directionInfo;        // 오시는 길 (direction)
    private String amenities;        // 기본 시설 (sbrsCl)
    private String surroundings;        // 입지 구분 (lctCl)
    private String surrFacilities;        // 주변 정보 (posblFcltyCl)
    private String glampingFacility;        // 글램핑 - 내부시설 (glampInnerFclty)
    private String caravanFacility;        // 카라반 - 내부시설 (caravInnerFclty)
    private String operatingSeason;        // 운영기간 (operPdCl)
    private String operatingDate;        // 운영일 (operDeCl)
    private Integer toiletCnt;        // 화장실 개수 (toiletCo)
    private Integer swrmCnt;        // 샤워실 개수 (swrmCo)
    private Integer wtrplCnt;        // 개수대 개수 (wtrplCo)
    private String animalYn;        // 애완동물출입 (animalCmgCl)
    private String campFeature;        // 특징 (featureNm)
    private Integer grass;        // 잔디 (단위:면) (siteBottomCl1)
    private Integer crushStone;        // 파쇄석 (단위:면) (siteBottomCl2)
    private Integer tech;        // 테크 (단위:면) (siteBottomCl3)
    private Integer pebble;        // 자갈 (단위:면) (siteBottomCl4)
    private Integer soil;        // 맨흙 (단위:면) (siteBottomCl5)
    private String caravanAc;  // 개인 카라반 동반 여부
    private String trailerAc;  // 개인 트레일러 동반 여부
    private String eqpRental;  // 캠핑장비 대여
    private String exprnYn;        // 체험프로그램 여부(Y:사용, N:미사용) (exprnProgrmAt)
    private String exprn;        // 그 외 체험활동 (exprn)
}
