package com.campus.campus.search.entity.options;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class EnvironmentOption {

    // 산, 숲, 강, 해변, 계곡, 호수, 섬, 도심
    private boolean mountain;
    private boolean forest;
    private boolean river;
    private boolean beach;
    private boolean valley;
    private boolean lake;
    private boolean island;
    private boolean city;

    public static EnvironmentOption of(String surroundings) {
        EnvironmentOption environmentOption=new EnvironmentOption();

        Arrays.stream(surroundings.split(","))
                .forEach(str->{
                    switch (str) {
                        case "산":
                            environmentOption.setMountain(true);
                            break;
                        case "숲":
                            environmentOption.setForest(true);
                            break;
                        case "강":
                            environmentOption.setRiver(true);
                            break;
                        case "해변":
                            environmentOption.setBeach(true);
                            break;
                        case "계곡":
                            environmentOption.setValley(true);
                            break;
                        case "호수":
                            environmentOption.setLake(true);
                            break;
                        case "섬":
                            environmentOption.setIsland(true);
                            break;
                        case "도심":
                            environmentOption.setCity(true);
                            break;
                        default:
                            //do nothing
                    }
                });

        return environmentOption;
    }
}
