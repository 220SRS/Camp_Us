package com.campus.campus.reservation.controller;

import com.campus.campus.reservation.dto.ReservationSaveDto;
import com.campus.campus.reservation.dto.ReservationUpdateDto;
import com.campus.campus.reservation.entity.Reservation;
import com.campus.campus.reservation.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/api/reservations")
@Validated
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity saveReservation(@Valid @RequestBody ReservationSaveDto reservationSaveDto) {
        // Reservation 객체 생성
        Reservation reservation = new Reservation();
//        reservation.setCampId(campService.getCampsiteById(reservationSaveDto.getCampsiteId()));
//        reservation.setUsers(memberService.getUserById(reservationSaveDto.getUserId()));
        reservation.setStartDate(reservationSaveDto.getStartDate());
        reservation.setEndDate(reservationSaveDto.getEndDate());
        reservation.setPaymentAmount(reservationSaveDto.getPaymentAmount());
        reservation.setPaymentStatus(reservationSaveDto.getPaymentStatus());

        // 예약 정보 생성
        Reservation savedReservation = reservationService.saveReservation(reservation);

        // savedReservation의 정보를 응답으로 반환
        return ResponseEntity.ok(savedReservation);
    }

//    @PostMapping("")
//    public ResponseEntity updateReservation(ReservationUpdateDto reservationUpdateDto) {
//
//    }

    @PostMapping("/{reservationId}")
    public ResponseEntity findByReservationId(@PathVariable("reservationId") @Positive long reservationId) {
        //예약 정보 조회
    }

    @PostMapping
    public ResponseEntity saveReservationUserInfo() {
        //예약자 정보 생성
    }

    @PostMapping
    public ResponseEntity findByUserId() {
        //예약자 정보 조회
    }

    @PostMapping
    public ResponseEntity saveOptions() {
        //추가옵션 선택 정보 생성
    }

    @PostMapping
    public ResponseEntity findByOptions() {
        //추가옵션 리스트 조회
    }
}
