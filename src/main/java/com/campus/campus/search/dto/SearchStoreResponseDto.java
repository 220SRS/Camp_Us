package com.campus.campus.search.dto;

import com.campus.campus.dataapi.entity.CampBaseInfo;
import com.campus.campus.search.entity.SearchStore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchStoreResponseDto {

    public SearchStoreResponseDto(CampBaseInfo searchStore) {
        this.storeId = searchStore.getStoreId();
        this.storeName = searchStore.getStoreName();
        this.category = searchStore.getCategory();
        this.doNm = searchStore.getDoNm();
        this.sigunguNm = searchStore.getSigunguNm();
        this.grass = searchStore.getGrass();
        this.crushStone = searchStore.getCrushStone();
        this.tech = searchStore.getTech();
        this.pebble = searchStore.getPebble();
        this.soil = searchStore.getSoil();
        this.toiletCnt = searchStore.getToiletCnt();
        this.swrmCnt = searchStore.getSwrmCnt();
        this.surrFacilities = searchStore.getSurrFacilities();
        this.caravanAc = searchStore.getCaravanAc();
        this.trailerAc = searchStore.getTrailerAc();
        this.eqpRental = searchStore.getEqpRental();
        this.exprnYn = searchStore.getExprnYn();
        this.amenities = searchStore.getAmenities();
        this.surroundings = searchStore.getSurroundings();
        this.animalYn = searchStore.getAnimalYn();
    }

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

   /* long searchStoreId;

    *//* 기본 정보 *//*
    String searchStoreName;
    String category; //업종-> 일반야영장,카라반,글램핑

    //String mainImg; //메인 이미지
    //int price; //가격

    *//* 위치 정보 *//*
    String doNm; //~도
    String sigunguNm; //~시군구

    //체험활동/주차장 ??어디서?

    *//* 검색조건 항목 *//*
    //입지형태 > ENUM 처리로 간단하게 처리가 가능한지 고민하기
    String grass; //잔디 ->상세옵션)입지형태
    String crushStone; //파쇄석 ->상세옵션)입지형태
    String tech; //테크 ->상세옵션)입지형태
    String pebble; //자갈 ->상세옵션)입지형태
    String soil; //맨흙 ->상세옵션)입지형태


    String toiletCnt; // 화장실 개수
    String swrmCnt; // 샤워실 개수->기본옵션)샤워실 (1이상부터 체크 근데 String 타입이네..)
    String surrFacilities;// 주변이용가능시설-> 운동장,강/물놀이,농어촌체험시설


    String caravanAc; // 개인 카라반 동반 여부->상세옵션)카라반진입
    String trailerAc; // 개인 트레일러 동반 여부->상세옵션)트레일러


    String eqpRental; // 캠핑장비대여->기본옵션)장비대여
    String exprnYn; // 체험 프로그램 여부


    //체크 옵션별로 정리하기
    String amenities; // 주변정보-> 전기,무선인터넷,장작판매,온수,트렘폴린,물놀이장,놀이터,산책로,운동시설,마트.편의점
    //기본옵션)와이파이 (=무선인터넷)
    //기본옵션)매점(=마트,편의점)
    //상세옵션)놀이터
    //상세옵션)수영장(=물놀이장)
    //String sbrsEtc; // 부대시설 기타-> " "
    String locationType; // 입지 구분
    String animalYN; // 애완동물 출입



    //환경 탭 구현하기 > ENUM 처리로 간단하게 처리가 가능한지 고민하기
    //바다,산,숲,강,호수,계곡,섬,평야,기타*/



}
