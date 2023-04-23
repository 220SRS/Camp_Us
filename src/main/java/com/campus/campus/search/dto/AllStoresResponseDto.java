package com.campus.campus.search.dto;

import com.campus.campus.dataapi.entity.CampBaseInfo;
import com.campus.campus.search.entity.SearchStore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AllStoresResponseDto {

    List<CampBaseInfo> campBaseInfos;

    public AllStoresResponseDto(List<CampBaseInfo> campBaseInfos) {
        this.campBaseInfos = campBaseInfos;
    }
}
