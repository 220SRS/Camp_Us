package com.campus.campus.search.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class LocationType {

    private boolean grass;
    // 잔디 (단위:면) (siteBottomCl1)

    private boolean crushStone;
    // 파쇄석 (단위:면) (siteBottomCl2)

    private boolean tech;
    // 테크 (단위:면) (siteBottomCl3)

    private boolean pebble;
    // 자갈 (단위:면) (siteBottomCl4)

    private boolean soil;
    // 맨흙 (단위:면) (siteBottomCl5)

    public static LocationType of(Integer grass, Integer crushStone, Integer tech, Integer pebble, Integer soil) {
        LocationType locationType = new LocationType();

        if(grass>0) locationType.setGrass(true);
        if(crushStone>0) locationType.setCrushStone(true);
        if(tech>0) locationType.setTech(true);
        if(pebble>0) locationType.setPebble(true);
        if(soil>0) locationType.setSoil(true);

        return locationType;
    }
}
