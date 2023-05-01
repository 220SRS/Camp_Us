package com.campus.campus.search.entity.options;

import com.campus.campus.search.entity.LocationType;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class DetailOption {

    /* amenities */
    boolean playground;
    // 운동장
    boolean childPlayFct;
    // 어린이 놀이 시설
    boolean walkingLoad;
    // 산책로
    boolean fireWood;
    // 장작판매

    /* SurrFacilities */
    boolean waterPlay;
    // 물놀이 (수상레저, 강/물놀이, 계곡 물놀이, 수영장, 해수욕)

    boolean trailerAc;
    // 트레일러 동반 여부 (trailerAc)
    boolean caravanAc;
    // 카라반 동반 여부 (caravanAc)
    boolean exprn;
    // 체험활동 (exprnYn)

    LocationType locationType;

    public static DetailOption of(String amenities, String surrFacilities,
                                  String exprn, String caravanAc, String trailerAc,
                                  LocationType locationType){

        DetailOption detailOption=new DetailOption();

        Arrays.stream(amenities.split(","))
                .forEach(str -> {
                    switch (str) {
                        case "운동장":
                            detailOption.setPlayground(true);
                            break;
                        case "어린이놀이시설":
                            detailOption.setChildPlayFct(true);
                            break;
                        case "산책로":
                            detailOption.setWalkingLoad(true);
                            break;
                        case "장작판매":
                            detailOption.setFireWood(true);
                            break;
                        default:
                            // do nothing
                    }
                });

        Arrays.stream(surrFacilities.split(","))
                .filter(str ->
                                str.equals("수상레저") ||
                                str.equals("강/물놀이") ||
                                str.equals("계곡 물놀이") ||
                                str.equals("수영장") ||
                                str.equals("해수욕"))
                .forEach(str -> detailOption.setWaterPlay(true));


        if (exprn != null && exprn.equals("Y")) {
            detailOption.setExprn(true);
        }
        if (caravanAc != null && caravanAc.equals("Y")) {
            detailOption.setCaravanAc(true);
        }
        if (trailerAc != null && trailerAc.equals("Y")) {
            detailOption.setTrailerAc(true);
        }

        detailOption.setLocationType(locationType);

        return detailOption;
    }
}
