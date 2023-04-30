package com.campus.campus.search.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Map;

//getter없으니까 데이터가 제대로 안들어간다.
@Getter
@AllArgsConstructor
public class CampTypeListDto {
    Map<String, Integer> campType;
    Map<String, Integer> amenityType;
    Map<String, Integer> surrFctType;
    Map<String, Integer> surrType;
    Map<String, Integer> doNameType;
}
