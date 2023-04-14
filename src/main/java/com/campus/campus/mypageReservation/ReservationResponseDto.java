package com.campus.campus.mypageReservation;

import com.campus.campus.reservation.entity.Reservation;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReservationResponseDto {
    // 예약 내역 카드 1개의 정보
    private Long rsv_id; // 예약번호
    private Long store_id;  // 캠핑장 id
    private Date start_date;  // 시작 날짜
    private Date end_date; // 마지막 날짜
    private Long payment_amt; // 결제 금액
    private Reservation.RsvStatus rsv_status; // 결제 상태

}
