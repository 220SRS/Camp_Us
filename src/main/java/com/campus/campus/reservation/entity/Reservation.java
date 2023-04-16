package com.campus.campus.reservation.entity;

import com.campus.campus.reservation.dto.ReservationSaveDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Entity(name = "RESERVATION")
@NoArgsConstructor
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rsvId; // 예약 id
    @Column
    private Long memberId;   // member id
    @Column
    private Long storeId;  // 캠핑장 id
    @Column
    private Integer mbCnt; // 인원 수
    @Column
    private LocalDateTime startDate; // 예약 시작일
    @Column
    private LocalDateTime endDate; // 예약 종료일
    @Column
    private Long paymentAmt; // 결제 금액
    @Column
    private String userRequest; // 요청 사항
    @Enumerated(EnumType.STRING)
    private RsvStatus rsvStatus = RsvStatus.RSV_USING; // 예약 진행 상태(완료/진행/취소)
    @Column(nullable = false)
    private LocalDateTime rsvDate = LocalDateTime.now();  // 예약 생성 시간 및 날짜

    public static Reservation of(ReservationSaveDto reservationSaveDto) {
        Reservation reservation = new Reservation();

        reservation.setMemberId(reservationSaveDto.getMemberId());
        reservation.setStoreId(reservationSaveDto.getStoreId());
        reservation.setMbCnt(reservationSaveDto.getMbCnt());
        reservation.setStartDate(reservationSaveDto.getStartDate());
        reservation.setEndDate(reservationSaveDto.getEndDate());
        reservation.setPaymentAmt(reservationSaveDto.getPaymentAmt());
        reservation.setUserRequest(reservationSaveDto.getUserRequest());
        reservation.setRsvStatus(reservationSaveDto.getRsvStatus());
        reservation.setRsvDate(reservationSaveDto.getRsvDate());

        return reservation;
    }

    public enum RsvStatus {
        RSV_COMPLETE(1, "예약 완료"),
        RSV_USING(2, "예약중"),
        RSV_CANCLE(3, "예약취소");
        @Getter
        private int stepNumber;
        @Getter
        private String status;

        RsvStatus(int stepNumber, String status) {
            this.stepNumber = stepNumber;
            this.status = status;
        }
    }
}
