package com.campus.campus.search.dto;

import com.campus.campus.dataapi.entity.CampBaseInfo;
import com.campus.campus.search.entity.SearchStore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchStoreResponseDto {

    public SearchStoreResponseDto(CampBaseInfo searchStore) {
        this.searchStoreId = searchStore.getContentId();
        this.searchStoreName = searchStore.getStoreName();
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
        this.locationType = searchStore.getLocationType();
        this.animalYN = searchStore.getAnimalYN();
    }

    long searchStoreId;

    /* 기본 정보 */
    String searchStoreName;
    String category; //업종-> 일반야영장,카라반,글램핑

    //String mainImg; //메인 이미지
    //int price; //가격

    /* 위치 정보 */
    String doNm; //~도
    String sigunguNm; //~시군구

    //체험활동/주차장 ??어디서?

    /* 검색조건 항목 */
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
    //바다,산,숲,강,호수,계곡,섬,평야,기타



}
