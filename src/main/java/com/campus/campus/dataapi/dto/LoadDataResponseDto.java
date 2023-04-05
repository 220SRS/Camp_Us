package com.campus.campus.dataapi.dto;

import lombok.Getter;

@Getter
public class LoadDataResponseDto {
    private String saveResult;

    public LoadDataResponseDto(boolean isAllSaved) {
        this.saveResult = (isAllSaved) ? "All saved" : "Not all saved";
    }
}
