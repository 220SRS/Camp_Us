package com.campus.campus.reservation.controller;

import com.campus.campus.reservation.dto.ReservationSaveDto;
import com.campus.campus.reservation.dto.ReservationUpdateDto;
import com.campus.campus.reservation.entity.Reservation;
import com.campus.campus.reservation.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RestController
@RequestMapping("/api/reservations")
@Validated
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity saveReservation( @RequestBody ReservationSaveDto reservationSaveDto) {
        String dateStr = "2023-04-20";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        LocalDateTime date = LocalDateTime.parse(dateStr, formatter);

        // Reservation 객체 생성
        Reservation reservation  = new Reservation();
        reservation.setUserId(1L);
        reservation.setStoreId(1L);
        reservation.setMbCnt(6);
        reservation.setStartDate(date);
        reservation.setEndDate(date);
        reservation.setPaymentAmt(150000L);
        reservation.setUserRequest("예약이 편하네요");
        reservation.setRsvStatus(Reservation.RsvStatus.RSV_USING);
        reservation.getRsvDate();

        // 예약 정보 생성
        Reservation savedReservation = reservationService.saveReservation(reservation);

        // savedReservation의 정보를 응답으로 반환
        return ResponseEntity.ok(savedReservation);
    }

//    @PostMapping("")
//    public ResponseEntity updateReservation(ReservationUpdateDto reservationUpdateDto) {
//
//    }

//    @PostMapping("/{reservationId}")
//    public ResponseEntity findByReservationId(@PathVariable("reservationId") @Positive long reservationId) {
//        //예약 정보 조회
//    }
//
//    @PostMapping
//    public ResponseEntity saveReservationUserInfo() {
//        //예약자 정보 생성
//    }
//
//    @PostMapping
//    public ResponseEntity findByUserId() {
//        //예약자 정보 조회
//    }
//
//    @PostMapping
//    public ResponseEntity saveOptions() {
//        //추가옵션 선택 정보 생성
//    }
//
//    @PostMapping
//    public ResponseEntity findByOptions() {
//        //추가옵션 리스트 조회
//    }
}
