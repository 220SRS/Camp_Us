package com.campus.campus.search.controller;

import com.campus.campus.dataapi.entity.CampBaseInfo;
import com.campus.campus.search.dto.AllStoresResponseDto;
import com.campus.campus.search.dto.SearchStoreResponseDto;
import com.campus.campus.search.entity.SearchStore;
import com.campus.campus.search.service.SearchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    //테스트 완료!
    @GetMapping("/camps")
    public ResponseEntity findAll(){
        System.out.println("getCampList2");
        List<CampBaseInfo> campBaseInfos = searchService.findAll();
        /*List<SearchStoreResponseDto> searchStoreResponse =new ArrayList<>();
        for (SearchStore searchStore : searchStores) {
            searchStoreResponse.add(new SearchStoreResponseDto(searchStore));
        }*/
        AllStoresResponseDto response = new AllStoresResponseDto(campBaseInfos);

        return new ResponseEntity(response,HttpStatus.OK);
    }

    @GetMapping("/{campId}")
    public ResponseEntity findById(@PathVariable long campId){
        System.out.println("controller > findById");
        CampBaseInfo campBaseInfo = searchService.findById(campId);
        SearchStoreResponseDto response = new SearchStoreResponseDto(campBaseInfo);

        return new ResponseEntity(response, HttpStatus.OK);

    }

/*
    @GetMapping("/{store_id}")
    public ResponseEntity getStoreOn*/

}
