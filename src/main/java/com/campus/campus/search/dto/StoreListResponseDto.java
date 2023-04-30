package com.campus.campus.search.dto;

import com.campus.campus.search.entity.Store;
import com.campus.campus.search.entity.options.BasicOption;
import com.campus.campus.search.entity.options.CampTypeOption;
import com.campus.campus.search.entity.options.DetailOption;
import com.campus.campus.search.entity.options.EnvironmentOption;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class StoreListResponseDto {

    List<Store> storeList;

}
