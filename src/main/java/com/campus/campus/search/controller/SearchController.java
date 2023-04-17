package com.campus.campus.search.controller;

import com.campus.campus.search.entity.SearchStore;
import com.campus.campus.search.service.SearchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity getCampList(){
        System.out.println("getCampList2");
        List<SearchStore> searchStores = searchService.findAll();


        return new ResponseEntity(HttpStatus.OK);
    }

/*
    @GetMapping("/{store_id}")
    public ResponseEntity getStoreOn*/

}
