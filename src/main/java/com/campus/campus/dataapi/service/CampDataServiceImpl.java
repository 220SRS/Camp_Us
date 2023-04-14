package com.campus.campus.dataapi.service;

import com.campus.campus.dataapi.dto.LoadDataResponseDto;
import com.campus.campus.dataapi.dto.SaveCampRequestDto;
import com.campus.campus.dataapi.entity.CampBaseInfo;
import com.campus.campus.dataapi.exception.DataLoadFailedException;
import com.campus.campus.dataapi.exception.WrongURLException;
import com.campus.campus.dataapi.repository.SaveCampRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
@Service
@RequiredArgsConstructor
public class CampDataServiceImpl implements CampDataService {

    public final SaveCampRepository campRepository;

    public LoadDataResponseDto loadAndSaveFromApiWithJson() {
        try {
            int page = 1;
            int numOfRows = 10;
            String apiUrl = "https://apis.data.go.kr/B551011/GoCamping/basedList?MobileOS=WIN&MobileApp=TadakTadak&_type=json";
            String apikey = "eqzJCAvqSy0VmYJ77GE51mGpqo4PFub0OrAs%2Fhw1S0COTrvYFwPULfG4K%2Bixr0uYch4uw3ciXr4PhRI%2F%2FdDQ%2FQ%3D%3D";

            int totalCnt = 0;
            int savedDataAmount = 0;

            boolean isLastPage = false;

            while (!isLastPage) {
                URL url = new URL(apiUrl + "&serviceKey=" + apikey + "&pageNo=" + page + "&numOfRows=" + numOfRows);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setRequestProperty("content-type", "application/json");

                BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                StringBuffer result = new StringBuffer();
                result.append(bf.readLine());
                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(result.toString());

                checkURLKey(jsonObject);

                JSONObject response = (JSONObject) jsonObject.get("response");
                JSONObject body = (JSONObject) response.get("body");
                JSONObject item = (JSONObject) body.get("items");

                JSONArray jsonArray = (JSONArray) item.get("item");

                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject object = (JSONObject) jsonArray.get(i);

                    Long store_id = Long.parseLong(object.get("contentId").toString());
                    String store_name = (String) object.get("facltNm");
                    String biz_num = (String) object.get("bizrno");
                    String main_img = (String) object.get("firstImageUrl");
                    String simple_info = (String) object.get("lineIntro");
                    String detail_info = (String) object.get("intro");
                    String store_phone = (String) object.get("tel");
                    String site_url = (String) object.get("homepage");
                    String category = (String) object.get("induty");
                    String location = (String) object.get("addr1");
                    String doNm = (String) object.get("doNm");
                    String sigunguNm = (String) object.get("sigunguNm");
                    String zipcode = (String) object.get("zipcode");
                    Long latitude = Long.parseLong(object.get("mapX").toString());
                    Long longitude = Long.parseLong(object.get("mapY").toString());
                    String direction_info = (String) object.get("direction");
                    String basic_facility = (String) object.get("sbrsCl");
                    String surroundings = (String) object.get("lctCl");
                    String surround_info = (String) object.get("posblFcltyCl");
                    String glamping_facility = (String) object.get("glampInnerFclty");
                    String caravan_facility = (String) object.get("caravInnerFclty");
                    String operating_season = (String) object.get("operPdCl");
                    String operating_date = (String) object.get("operDeCl");
                    Integer toilet_cnt = Integer.parseInt(object.get("toiletCo").toString());
                    Integer swrm_cnt = Integer.parseInt(object.get("swrmCo").toString());
                    Integer wtrpl_cnt = Integer.parseInt(object.get("wtrplCo").toString());
                    String animal_yn = (String) object.get("animalCmgCl");
                    String camp_feature = (String) object.get("featureNm");
                    Integer siteBottomCl1 = Integer.parseInt(object.get("siteBottomCl1").toString());
                    Integer siteBottomCl2 = Integer.parseInt(object.get("siteBottomCl2").toString());
                    Integer siteBottomCl3 = Integer.parseInt(object.get("siteBottomCl3").toString());
                    Integer siteBottomCl4 = Integer.parseInt(object.get("siteBottomCl4").toString());
                    Integer siteBottomCl5 = Integer.parseInt(object.get("siteBottomCl5").toString());
                    String exprn_yn = (String) object.get("exprnProgrmAt");
                    String exprn = (String) object.get("exprn");


                    SaveCampRequestDto saveCampRequestDto = new SaveCampRequestDto(store_id, store_name, biz_num, main_img, simple_info, detail_info, store_phone, site_url, category, location, doNm, sigunguNm, zipcode, latitude, longitude, direction_info, basic_facility, surroundings, surround_info, glamping_facility, caravan_facility, operating_season, operating_date, toilet_cnt, swrm_cnt, wtrpl_cnt, animal_yn, camp_feature, siteBottomCl1, siteBottomCl2, siteBottomCl3, siteBottomCl4, siteBottomCl5, exprn_yn, exprn);

                    CampBaseInfo campBaseInfo = CampBaseInfo.builder()
                            .store_id(store_id)
                            .store_name(store_name)
                            .biz_num(biz_num)
                            .main_img(main_img)
                            .simple_info(simple_info)
                            .detail_info(detail_info)
                            .store_phone(store_phone)
                            .site_url(site_url)
                            .category(category)
                            .location(location)
                            .doNm(doNm)
                            .sigunguNm(sigunguNm)
                            .zipcode(zipcode)
                            .latitude(latitude)
                            .longitude(longitude)
                            .direction_info(direction_info)
                            .basic_facility(basic_facility)
                            .surroundings(surroundings)
                            .surround_info(surround_info)
                            .glamping_facility(glamping_facility)
                            .caravan_facility(caravan_facility)
                            .operating_season(operating_season)
                            .operating_date(operating_date)
                            .toilet_cnt(toilet_cnt)
                            .swrm_cnt(swrm_cnt)
                            .wtrpl_cnt(wtrpl_cnt)
                            .animal_yn(animal_yn)
                            .camp_feature(camp_feature)
                            .siteBottomCl1(siteBottomCl1)
                            .siteBottomCl2(siteBottomCl2)
                            .siteBottomCl3(siteBottomCl3)
                            .siteBottomCl4(siteBottomCl4)
                            .siteBottomCl5(siteBottomCl5)
                            .exprn_yn(exprn_yn)
                            .exprn(exprn)
                            .build();

                    campRepository.save(campBaseInfo);
                }
                totalCnt = ((Number) body.get("totalCount")).intValue();
                // 현재 페이지가 마지막 페이지인지 확인합니다.
                if (page * numOfRows >= totalCnt) {
                    isLastPage = true;
                } else {
                    page++; // 다음 페이지로 이동합니다.
                }
            }
            savedDataAmount = ((Number) campRepository.count()).intValue(); // 현재 db에 저장된 데이터 갯수

            log.info("Page: {}", page);
            log.info("totalCnt: {} & savedDataAmount : {}", totalCnt, savedDataAmount);
            return new LoadDataResponseDto(totalCnt == savedDataAmount);

        } catch (Exception e) {
            throw new DataLoadFailedException(e);
        }
    }


    private void checkURLKey(JSONObject jsonObject) {
        if (jsonObject.get("code") != null && (int) jsonObject.get("code") == -4) {
            throw new WrongURLException();
        }
    }


}
