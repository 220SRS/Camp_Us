package com.campus.campus.reservation.dto;

import com.campus.campus.reservation.entity.Reservation;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationSaveDto {
    @NotNull(message = "캠핑장 ID를 입력해주세요.")
    private Long storeId;
    @NotNull(message = "회원 ID를 입력해주세요.")
    private Long memberId;
    @NotNull(message = "인원 수를 입력해주세요.")
    @Min(value = 1, message = "인원 수는 1명 이상이어야 합니다.")
    private Integer mbCnt;  // 인원 수
    @NotNull(message = "예약 시작일을 입력해주세요.")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startDate;  // 시작 날짜
    @NotNull(message = "예약 종료일을 입력해주세요.")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endDate; // 마지막 날짜
    @NotNull(message = "결제 금액을 입력해주세요.")
    @Min(value = 0, message = "결제 금액은 0 이상이어야 합니다.")
    private Long paymentAmt; // 결제 금액
    private String userRequest; // 요청 사항
    private Reservation.RsvStatus rsvStatus; // 결제 상태
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime rsvDate;  // 예약한 날짜

}




