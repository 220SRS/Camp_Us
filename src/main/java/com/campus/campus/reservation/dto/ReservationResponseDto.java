package com.campus.campus.reservation.dto;

import com.campus.campus.reservation.entity.Reservation;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationResponseDto {
    private Long rsvId; // 예약 id
    private Long memberId; // member id
    private Long storeId; // 캠핑장 id
    private Integer mbCnt; // 인원 수
    private LocalDateTime startDate; // 시작 날짜
    private LocalDateTime endDate; // 마지막 날짜
    private Long paymentAmt; // 결제 금액
    private String userRequest; // 요청 사항
    private Reservation.RsvStatus rsvStatus; // 결제 상태
    private LocalDateTime rsvDate; // 예약한 날짜

    public static ReservationResponseDto of(Reservation reservation) {
        ReservationResponseDto dto = new ReservationResponseDto();
        dto.setRsvId(reservation.getRsvId());
        dto.setMemberId(reservation.getMember().getMemberId());
        dto.setStoreId(reservation.getCampBaseInfo().getStoreId());
        dto.setMbCnt(reservation.getMbCnt());
        dto.setStartDate(reservation.getStartDate());
        dto.setEndDate(reservation.getEndDate());
        dto.setPaymentAmt(reservation.getPaymentAmt());
        dto.setUserRequest(reservation.getUserRequest());
        dto.setRsvStatus(reservation.getRsvStatus());
        dto.setRsvDate(reservation.getRsvDate());
        return dto;
    }
}
