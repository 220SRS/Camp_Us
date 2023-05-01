package com.campus.campus.search.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Map;


@Getter
@AllArgsConstructor
public class CampTypeListDto {
    /*
    * 온전하게 searchController.dataDeduplication() 메서드를 위한 dto
    * 실제 서비스에서 사용하지 않는다.
    * 내가 그냥 데이터 분류하려고 썼다.
    * */

    Map<String, Integer> campType;
    Map<String, Integer> amenityType;
    Map<String, Integer> surrFctType;
    Map<String, Integer> surrType;
    Map<String, Integer> doNameType;
}
