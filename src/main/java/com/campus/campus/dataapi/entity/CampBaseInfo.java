package com.campus.campus.dataapi.entity;

import com.campus.campus.reservation.entity.Reservation;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "stores")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "storeId")
public class CampBaseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;        // 업체 식별자 (contentId)
    @Column
    private String storeName;        // 이름(=캠핑장 이름) (facltNm)
    @Column
    private String bizNum;        // 사업자 번호 (bizrno)
    @Column
    private String mainImg;        // 대표이미지 (firstImageUrl)
    @Column(columnDefinition = "TEXT")
    private String simpleInfo;        // 한줄 설명 (lineIntro)

    @Column(columnDefinition = "TEXT")
    private String detailInfo;        // 여러줄 설명 (intro)
    @Column
    private String storePhone;        // 번호 (tel)
    @Column
    private String siteUrl;        // 사이트 주소 (homepage)
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
    private Double latitude;        // 경도 (mapX)
    @Column
    private Double longitude;        // 위도 (mapY)
    @Column(columnDefinition = "TEXT")
    private String directionInfo;        // 오시는 길 (direction)
    @Column
    private String amenities;        // 기본 시설 (sbrsCl)
    @Column
    private String surroundings;        // 입지 구분 (lctCl)
    @Column
    private String surrFacilities;        // 주변 정보 (posblFcltyCl)
    @Column
    private String glampingFacility;        // 글램핑 - 내부시설 (glampInnerFclty)
    @Column
    private String caravanFacility;        // 카라반 - 내부시설 (caravInnerFclty)
    @Column
    private String operatingSeason;        // 운영기간 (operPdCl)
    @Column
    private String operatingDate;        // 운영일 (operDeCl)
    @Column
    private Integer toiletCnt;        // 화장실 개수 (toiletCo)
    @Column
    private Integer swrmCnt;        // 샤워실 개수 (swrmCo)
    @Column
    private Integer wtrplCnt;        // 개수대 개수 (wtrplCo)
    @Column
    private String animalYn;        // 애완동물출입 (animalCmgCl)
    @Column(columnDefinition = "TEXT")
    private String campFeature;        // 특징 (featureNm)
    @Column
    private Integer grass;        // 잔디 (단위:면) (siteBottomCl1)
    @Column
    private Integer crushStone;        // 파쇄석 (단위:면) (siteBottomCl2)
    @Column
    private Integer tech;        // 테크 (단위:면) (siteBottomCl3)
    @Column
    private Integer pebble;        // 자갈 (단위:면) (siteBottomCl4)
    @Column
    private Integer soil;        // 맨흙 (단위:면) (siteBottomCl5)
    @Column
    private String caravanAc;  // 개인 카라반 동반 여부
    @Column
    private String trailerAc;  // 개인 트레일러 동반 여부
    @Column
    private String eqpRental;  // 캠핑장비 대여
    @Column
    private String exprnYn;        // 체험프로그램 여부(Y:사용, N:미사용) (exprnProgrmAt)
    @Column
    private String exprn;        // 그 외 체험활동 (exprn)


    // Reservation 매핑
    @OneToMany(mappedBy = "campBaseInfo")
    private List<Reservation> reservationList = new ArrayList<>();



}
