package com.campus.campus.search.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchStore {

    long id;
    String campingName;
    String mainImg;
    int price;
    //String location; // 위치 디비 수정 필요
    String doNm; //~도
    String sigunguNm; //~시군구
    String induty; //업종-> 일반야영장,카라반,글램핑

    //체험활동/주차장 ??어디서?

    //체크 옵션별로 정리하기
    String amenities; // 부대시설-> 전기,무선인터넷,장작판매,온수,트렘폴린,물놀이장,놀이터,산책로,운동시설,마트.편의점
    //기본옵션)와이파이 (=무선인터넷)
    //기본옵션)매점(=마트,편의점)
    //상세옵션)놀이터
    //상세옵션)수영장(=물놀이장)
    //String sbrsEtc; // 부대시설 기타-> " "
    String surr_facilities; // 주변이용가능시설-> 운동장,강/물놀이,농어촌체험시설
    //String posblFcltyEtc; // 주변이용가능시설 기타-> " "

    String caravanAc; // 개인 카라반 동반 여부->상세옵션)카라반진입
    String trailerAc; // 개인 트레일러 동반 여부->상세옵션)트레일러
    String swrmCnt; // 샤워실 개수->기본옵션)샤워실 (1이상부터 체크 근데 String 타입이네..)
    String toiletCnt;  // 화장실 개수->기본옵션)화장실 (1이상부터 체크)
    String animalYN; // 애완동물출입->기본옵션)반려동물
    String eqpRental; // 캠핑장비대여->기본옵션)장비대여

    //입지형태 > ENUM 처리로 간단하게 처리가 가능한지 고민하기
    String grass; //잔디 ->상세옵션)입지형태
    String crushStone; //파쇄석 ->상세옵션)입지형태
    String tech; //테크 ->상세옵션)입지형태
    String pebble; //자갈 ->상세옵션)입지형태
    String soil; //맨흙 ->상세옵션)입지형태

    //환경 탭 구현하기 > ENUM 처리로 간단하게 처리가 가능한지 고민하기
    //바다,산,숲,강,호수,계곡,섬,평야,기타


}
