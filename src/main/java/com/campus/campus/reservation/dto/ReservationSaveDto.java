package com.campus.campus.reservation.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Getter
@Setter
public class ReservationSaveDto {
    @NotNull
    private Long campId;

    @NotNull
    private String startDate;

    @NotNull
    private String endDate;

    @NotNull
    private Long paymentAmount;

    @NotNull
    private Long paymentStatus;

    // 예약자 정보
    @NotNull
    private String name;

    @NotNull
    private String phoneNumber;

    // 추가옵션 정보
    private List<Long> optionIds;
}
