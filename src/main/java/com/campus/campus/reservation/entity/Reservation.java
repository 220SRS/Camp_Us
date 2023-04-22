package com.campus.campus.reservation.entity;

import com.campus.campus.reservation.dto.ReservationSaveDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rsvId; // 예약 id

//    private Campsite campId; // 캠핑장정보 가져오기

    //    private Users users; // user정보 가져오기
    @Column
    private Long userId;   // user id
    @Column
    private Long storeId;  // 캠핑장 id
    @Column
    private Integer mbCnt; //인원 수
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
    @Column(name = "created_at")
    private LocalDateTime rsvDate;  // 예약한 날짜

    public static Reservation of(ReservationSaveDto reservationSaveDto) {
        Reservation reservation = new Reservation();

        reservation.setUserId(reservationSaveDto.getUserId());
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

