package com.campus.campus.search.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    /* 기본정보 */
    @Column
    private String storeName;
    @Column
    private String simpleInfo; // 한줄설명
    @Column(length = 10000) //더 공간을 길게!
    private String detailInfo; // 여러줄 설명
    @Column
    private String category;

    /* 위치정보 */
    @Column
    private String doNm;
    @Column
    private String sigunguNm;
    //    @Column
    //    private String zipcode;
    @Column
    private String addr;

    /* 검색페이지를 위한 검색조건 항목 */
    // 입지형태
    @Column
    private String grass; // 잔디(단위:면)
    @Column
    private String crushStone; // 파쇄석(단위:면)
    @Column
    private String tech; // 테크(단위:면)
    @Column
    private String pebble; // 자갈(단위:면)
    @Column
    private String soil; // 맨흙(단위:면)
    //---------

    @Column
    private String toiletCnt; // 화장실 개수
    @Column
    private String swrmCnt; // 샤워실 개수
    @Column
    private String surrFacilities; // 주변 정보

    @Column
    private String caravanAc; // 개인 카라반 동반 여부
    @Column
    private String trailerAc; // 개인 트레일러 동반 여부

    @Column
    private String eqpRental; // 캠핑장비 대여
    @Column
    private String exprnYn; // 체험 프로그램 여부

    @Column
    private String amenities; // 주변 정보
    @Column
    private String locationType; // 입지 구분
    @Column
    private String animalYN; // 애완동물 출입
}
