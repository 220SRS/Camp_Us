package com.campus.campus.search.controller;

import com.campus.campus.dataapi.entity.CampBaseInfo;
import com.campus.campus.search.dto.*;
import com.campus.campus.search.service.SearchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequestMapping("/search")
@RestController
public class SearchController {


    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    //전면 수정
/*
    //근데 나 검색기능만..있는데..??
    //메서드2
    @PostMapping("/camps")
    public ResponseEntity getCampList(@RequestBody SpecificConditionsDto specificConditionsDto){
        System.out.println("getCampList");

        return new ResponseEntity(HttpStatus.OK);
    }
*/
    @GetMapping("/dataDeduplication")
    public ResponseEntity dataDeduplication(){
        List<CampBaseInfo> campBaseInfos = searchService.findRawData();

        //내가 하고싶었던 작업
        //캠프 리스트의 10번 인덱스 값(String)을 따로 배열로 만들기 -> 해당 배열로 해쉬맵 만들기
//        Map<String, Integer> datas = campBaseInfos.stream().filter(e->)
//                collect(Collectors.toList())
        //반복문 말고 스트림써보기
        System.out.println("dtD");

        Map<String, Integer> categoryDatas=new HashMap<>();
        Map<String, Integer> AmenityDatas = new HashMap<>();
        Map<String, Integer> surrFctDatas = new HashMap<>();
        Map<String, Integer> surrDatas = new HashMap<>();
        Map<String, Integer> doNameDatas = new HashMap<>();
        String[] strs;

        for (int i = 0; i < campBaseInfos.size(); i++) {
            strs = campBaseInfos.get(i).getCategory().split(",");
            Stream.of(strs).forEach(e -> categoryDatas.compute(e, (k, v) -> v == null ? 1 : v + 1));

            strs = campBaseInfos.get(i).getAmenities().split(",");
            Stream.of(strs).forEach(e -> AmenityDatas.compute(e, (k, v) -> v == null ? 1 : v + 1));

            strs = campBaseInfos.get(i).getSurrFacilities().split(",");
            Stream.of(strs).forEach(e -> surrFctDatas.compute(e, (k, v) -> v == null ? 1 : v + 1));

            strs = campBaseInfos.get(i).getSurroundings().split(",");
            Stream.of(strs).forEach(e -> surrDatas.compute(e, (k, v) -> v == null ? 1 : v + 1));

            strs = campBaseInfos.get(i).getDoNm().split(",");
            Stream.of(strs).forEach(e -> doNameDatas.compute(e, (k, v) -> v == null ? 1 : v + 1));

        }

        CampTypeListDto response=new CampTypeListDto(categoryDatas,AmenityDatas, surrFctDatas,surrDatas, doNameDatas);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    //테스트 완료!
    @GetMapping("/camps")
    public ResponseEntity findAll(){
        System.out.println("getCampList");

        StoreListResponseDto response = searchService.findAll();


        //그런데 모든 데이터를 가져오는게 올바른 걸까..?
        //일부 데이터 먼저가저오고 스크롤이 내려갈때마다 더 데이터를 가져오는게 더 좋지 않을까..?
        //그 부분은 더 찾아봐야겠다.
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{campId}")
    public ResponseEntity findById(@PathVariable long campId){
        System.out.println("controller > findById");

        StoreResponseDto response = searchService.findById(campId);

        return ResponseEntity.ok(response);

    }

/*
    @GetMapping("/{store_id}")
    public ResponseEntity getStoreOn*/

}
