package com.campus.campus.dataapi.controller;

import com.campus.campus.dataapi.dto.LoadDataResponseDto;
import com.campus.campus.dataapi.service.CampDataService;
import com.campus.campus.global.api.ApiResponse;
import com.campus.campus.global.constant.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LoadDataController {
    private final CampDataService campDataService;

    @GetMapping("/load-data")
    public ApiResponse<?> loadFromApiWithJson(){
        LoadDataResponseDto loadDataResponseDto = campDataService.loadAndSaveFromApiWithJson();
        SuccessCode code = SuccessCode.LOAD_SUCCESS;
        return ApiResponse.success(code.name(), code.getHttpStatus(), code.getMessage(), loadDataResponseDto);
    }

}
