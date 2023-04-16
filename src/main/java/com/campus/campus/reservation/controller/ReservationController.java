package com.campus.campus.reservation.controller;

import com.campus.campus.mypageReservation.ReservationResponseDto;
import com.campus.campus.reservation.dto.ReservationSaveDto;
import com.campus.campus.reservation.entity.Reservation;
import com.campus.campus.reservation.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/reservations")
@Validated
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // TODO: 예진 - save reservation
    @PostMapping("/reservation")
    public ResponseEntity<ReservationResponseDto> postReservation(@RequestBody ReservationSaveDto reservationSaveDto) {
        ReservationResponseDto reservationResponseDto = reservationService.postReservation(reservationSaveDto);
        return ResponseEntity.ok(reservationResponseDto);
    }

}
