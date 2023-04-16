package com.campus.campus.reservation.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationUpdateDto {
    private Integer mbCnt; // 인원 수
    private LocalDateTime startDate; // 시작 날짜
    private LocalDateTime endDate; // 마지막 날짜
    private Long paymentAmt; // 결제 금액
    private String userRequest; // 요청 사항
}
