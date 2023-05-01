package com.campus.campus.search.entity.options;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class RegionOption {

    private String region;

    public static RegionOption of(String doName) {
        RegionOption regionOption = new RegionOption();

        //System.out.println("haha: "+doName);
        switch (doName) {
            case "서울":
            case "인천":
            case "경기":
            case "부산":
            case "울산":
            case "대구":
            case "광주":
            case "대전":
            case "제주":
                regionOption.setRegion(doName);
                break;
            default:
                regionOption.setRegion("기타");
        }

        return regionOption;
    }
}
