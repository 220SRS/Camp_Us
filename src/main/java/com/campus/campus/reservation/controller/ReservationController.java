package com.campus.campus.reservation.controller;

import com.campus.campus.dataapi.entity.CampBaseInfo;
import com.campus.campus.dataapi.service.CampDataService;
import com.campus.campus.member.Member;
import com.campus.campus.member.MemberService;
import com.campus.campus.mypageReservation.ReservationResponseDto;
import com.campus.campus.reservation.dto.ReservationSaveDto;
import com.campus.campus.reservation.entity.Reservation;
import com.campus.campus.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private final MemberService memberService;
    private final CampDataService campDataService;

    public ReservationController(ReservationService reservationService, MemberService memberService, CampDataService campDataService) {
        this.reservationService = reservationService;
        this.memberService = memberService;
        this.campDataService = campDataService;
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationSaveDto reservationSaveDto) {
        Reservation newReservation = reservationService.createReservation(reservationSaveDto);
        return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
    }



}
