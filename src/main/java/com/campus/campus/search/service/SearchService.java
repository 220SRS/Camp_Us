package com.campus.campus.search.service;

import com.campus.campus.dataapi.entity.CampBaseInfo;
import com.campus.campus.dataapi.repository.SaveCampRepository;
import com.campus.campus.search.dto.StoreListResponseDto;
import com.campus.campus.search.entity.LocationType;
import com.campus.campus.search.entity.Store;
import com.campus.campus.search.entity.options.BasicOption;
import com.campus.campus.search.entity.options.CampTypeOption;
import com.campus.campus.search.entity.options.DetailOption;
import com.campus.campus.search.entity.options.EnvironmentOption;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SearchService {


    private final SaveCampRepository saveCampRepository;

    public SearchService(SaveCampRepository saveCampRepository) {
        this.saveCampRepository = saveCampRepository;
    }
/*
    private final StoreRepository storeRepository;

    public SearchService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }*/

    public CampBaseInfo findById(long storeId){

        System.out.println("service > findById()");

        Optional<CampBaseInfo> campBaseInfo = saveCampRepository.findById(storeId);
        System.out.println(campBaseInfo.get().getStoreName());
        return campBaseInfo.get();
    }

    public List<CampBaseInfo> findRawData(){

        List<CampBaseInfo> campBaseInfos=saveCampRepository.findAll();

        return campBaseInfos;
    }

    public StoreListResponseDto findAll(){

        System.out.println("service > findAll()");

        List<CampBaseInfo> campBaseInfos=findRawData();
        List<Store> storeList=new ArrayList<>();

        for (CampBaseInfo campInfo : campBaseInfos) {

            //캠핑종류
            CampTypeOption campTypeOption = CampTypeOption.of(campInfo.getCategory());
            //지역옵션
            String doName = campInfo.getDoNm().substring(0, 2);
            //기본옵션
            BasicOption basicOption = BasicOption.of(campInfo.getAmenities(), campInfo.getSwrmCnt(), campInfo.getToiletCnt(),
                    campInfo.getAnimalYn(), campInfo.getEqpRental());
            //상세옵션(+입지형태)
            LocationType locationType = LocationType.of(campInfo.getGrass(), campInfo.getCrushStone(), campInfo.getTech(),
                    campInfo.getPebble(), campInfo.getSoil());
            DetailOption detailOption = DetailOption.of(campInfo.getAmenities(), campInfo.getSurrFacilities(),
                    campInfo.getExprn(), campInfo.getCaravanAc(), campInfo.getTrailerAc(), locationType);
            //환경옵션
            EnvironmentOption environmentOption = EnvironmentOption.of(campInfo.getSurroundings());

            Store store = Store.of(campTypeOption, doName, basicOption, detailOption, environmentOption);
            storeList.add(store);
        }

        StoreListResponseDto responseDto = new StoreListResponseDto(storeList);

        return responseDto;
    }

   /* public List<SearchStore> stubFindAll(){
        System.out.println("service > stub findAll()");

        // data.sql -> 인텔리제이
        // 더미 데이터 넣을때~!
        List<SearchStore> searchStores = new ArrayList<>();
        searchStores.add(new SearchStore(
                1L, "캠핑장1","카라반","경기도","화성시",
                "0","20","0","0","0","4","6","운동장,강/물놀이,농어촌체험시설",
                "Y","Y","Y","Y", "전기,무선인터넷,장작판매,온수,트렘폴린,물놀이장,놀이터,산책로,운동시설,마트.편의점",
                "강", "Y"
        ));

        searchStores.add(new SearchStore(
                2L, "캠핑장2","글램핑"," ","서울특별시",
                "0","20","0","0","0","4","6","운동장,강/물놀이,농어촌체험시설",
                "Y","Y","N","Y", "전기,무선인터넷,장작판매,온수,트렘폴린,물놀이장,놀이터,산책로,운동시설,마트.편의점",
                "호수", "Y"
        ));

        searchStores.add(new SearchStore(
                3L, "캠핑장3","일반야영장"," ","부산광역시",
                "0","0","10","10","0","4","6","운동장,강/물놀이,농어촌체험시설",
                "Y","Y","N","N", "전기,무선인터넷,장작판매,온수,트렘폴린,물놀이장,놀이터,산책로,운동시설,마트.편의점",
                "강, 호수", "N"
        ));

        return searchStores;

    }*/
}
