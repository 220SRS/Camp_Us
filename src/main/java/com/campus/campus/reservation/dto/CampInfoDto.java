package com.campus.campus.reservation.dto;

import lombok.Getter;

import javax.validation.constraints.Positive;

@Getter
public class CampInfoDto {
    @Positive
    private long campId;
}
