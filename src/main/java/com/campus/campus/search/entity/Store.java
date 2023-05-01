package com.campus.campus.search.entity;

import com.campus.campus.search.dto.StoreListResponseDto;
import com.campus.campus.search.entity.options.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
public class Store {

    private String name; // 사실 name으로 처리할려다가 캠핑장이름은 동일할 수도 있으니까..
    private long id; // id값 혹시몰라서 받고
    private String simpleAddr; // 간단한 주소 doNm+sigunguNm

    private CampTypeOption campTypeOption;
    // 일반야영장, 글램핑, 카라반, 자동차야영장

    private RegionOption regionOption;
    // 서울, 인천, 경기, 부산, 울산, 대구, 광주, 대전, 제주, 기타

    private BasicOption basicOption;
    // 샤워실(샤워실개수), 매점(마트.편의점), 와이파이(무선인터넷), 화장실(화장실개수),
    // 장비대여, 반려동물, 주차장

    private DetailOption detailOption;
    // 체험활동, 놀이터, 운동장, 산책로,
    // 물놀이, 장작구매, 트레일러 진입, 카라반 진입
    // 입지형태(잔디, 파쇄석, 테크, 자갈, 맨흙)

    private EnvironmentOption environmentOption;
    // 산, 숲, 강, 해변, 계곡, 호수, 섬, 도심

    public static Store of(String name, long id, String simpleAddr,
                           CampTypeOption campTypeOption,
                           RegionOption regionOption,
                           BasicOption basicOption,
                           DetailOption detailOption,
                           EnvironmentOption environmentOption) {

        Store store = new Store();

        store.setName(name);
        store.setId(id);
        store.setSimpleAddr(simpleAddr);

        store.setCampTypeOption(campTypeOption);
        store.setRegionOption(regionOption);
        store.setBasicOption(basicOption);
        store.setDetailOption(detailOption);
        store.setEnvironmentOption(environmentOption);

        return store;
    }

}
