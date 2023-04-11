package com.campus.campus.search.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/search")
@RestController
public class SearchController {

    //나중에 기본 로딩때 가져올 리스트는 어떻게 구현해야 하는지 고민.
    //메서드1

    //기본 약속
    //검색 버튼을 누를 때만 작동한다.
    //주로 검색 기능이니까 get메서드 위주 구성

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

        return new ResponseEntity(HttpStatus.OK);
    }



}
