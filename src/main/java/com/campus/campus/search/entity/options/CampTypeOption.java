package com.campus.campus.search.entity.options;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CampTypeOption {
    boolean general;
    // 일반야영장
    boolean glamping;
    // 글램핑
    boolean caravan;
    // 카라반
    boolean car;
    // 자동차야영장

    public static CampTypeOption of(String campTypes) {
        CampTypeOption campTypeOption=new CampTypeOption();
        String[] campTypeList=campTypes.split(",");

        for (String campType : campTypeList) {
            switch (campType){
                case "일반야영장":
                    campTypeOption.setGeneral(true);
                    break;
                case "글램핑":
                    campTypeOption.setGlamping(true);
                    break;
                case "카라반":
                    campTypeOption.setCaravan(true);
                    break;
                case "자동차야영장":
                    campTypeOption.setCar(true);
                    break;
                default:
                    //어떻게 처리해주는게 좋을까?
                    //1. 데이터가 들어있지 않으면 다 true로 만들거나
                    //2. 에러 발생시켜서 그 캠핑장은 패스하는 방법?
                    //일단 1번 방법(내가 2번 방법을 아직 잘 몰라)
                    campTypeOption.setGeneral(true);
                    campTypeOption.setGlamping(true);
                    campTypeOption.setCaravan(true);
                    campTypeOption.setCar(true);

            }
        }

        return campTypeOption;
    }

}
