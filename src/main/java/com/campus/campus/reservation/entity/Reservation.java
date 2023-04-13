package com.campus.campus.reservation.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

//    private Campsite campId; // 캠핑장정보 가져오기

//    private Users users; // user정보 가져오기

    private String startDate; // 예약 시작일

    private String endDate; // 예약 종료일

    private Long paymentAmount; // 결제 금액

    private Long paymentStatus; // 결제 상태

}
