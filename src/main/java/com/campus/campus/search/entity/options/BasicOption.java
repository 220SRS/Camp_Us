package com.campus.campus.search.entity.options;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class BasicOption {

    boolean showerRoom;
    // 샤워실 (샤워실 개수 swrmCnt-swrmCo)
    boolean mart;
    // 매점 (마트.편의점)
    boolean wifi;
    // 와이파이 (무선인터넷)
    boolean toilet;
    // 화장실 (화장실 개수 toiletCnt-toiletCo)
    boolean equipRental;
    // 장비대여 (캠핑장비대여 eqpRental)
    boolean pet;
    // 반려동물 (애완동물 출입 animalYn-animalCmgCl)

    public static BasicOption of(String amenities, Integer swrmCnt, Integer toiletCnt,
                                 String animalYn, String eqpRental){

        BasicOption basicOption = new BasicOption();

        Arrays.stream(amenities.split(","))
                .forEach(amenity ->{
                    switch (amenity){
                        case "마트.편의점":
                            basicOption.setMart(true);
                            break;
                        case "무선인터넷":
                            basicOption.setWifi(true);
                            break;
                        default:
                            //do nothing
                    }
                });

        if(swrmCnt>0) basicOption.setShowerRoom(true);
        if(toiletCnt>0) basicOption.setToilet(true);
        if(animalYn.equals("Y")) basicOption.setPet(true);
        if(!eqpRental.isEmpty()) basicOption.setEquipRental(true);

        return basicOption;

    }
}
