package com.campus.campus.reservation.controller;

import com.campus.campus.reservation.dto.ReservationUpdateDto;
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


    @PostMapping
    public ResponseEntity saveReservation(@Valid @RequestBody ReservationSaveDto reservationSaveDto) {
        //예약 정보 생성
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
    public ResponseEntity saveAdditionalOptions() {
        //추가옵션 선택 정보 생성
    }

    @PostMapping
    public ResponseEntity findByCampId() {
        //추가옵션 리스트 조회
    }
}
