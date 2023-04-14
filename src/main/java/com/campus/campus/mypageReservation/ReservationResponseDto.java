package com.campus.campus.mypageReservation;

import com.campus.campus.reservation.entity.Reservation;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReservationResponseDto {
    // 예약 내역 카드 1개의 정보
    private Long rsvId; // 예약번호
    private Long storeId;  // 캠핑장 id
    private Date startDate;  // 시작 날짜
    private Date endDate; // 마지막 날짜
    private Long paymentAmt; // 결제 금액
    private Reservation.RsvStatus rsvStatus; // 결제 상태

}
