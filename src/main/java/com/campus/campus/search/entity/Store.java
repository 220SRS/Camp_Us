package com.campus.campus.search.entity;

import com.campus.campus.search.dto.StoreListResponseDto;
import com.campus.campus.search.entity.options.BasicOption;
import com.campus.campus.search.entity.options.CampTypeOption;
import com.campus.campus.search.entity.options.DetailOption;
import com.campus.campus.search.entity.options.EnvironmentOption;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
public class Store {

    private CampTypeOption campTypeOption;
    // 일반야영장, 글램핑, 카라반, 자동차야영장

    private String regionOption;
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

    public static Store of(CampTypeOption campTypeOption,
                           String regionOption,
                           BasicOption basicOption,
                           DetailOption detailOption,
                           EnvironmentOption environmentOption) {

        Store store = new Store();

        store.setCampTypeOption(campTypeOption);
        store.setRegionOption(regionOption);
        store.setBasicOption(basicOption);
        store.setDetailOption(detailOption);
        store.setEnvironmentOption(environmentOption);

        return store;
    }

}
