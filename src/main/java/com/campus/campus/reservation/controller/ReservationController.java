package com.campus.campus.reservation.controller;

import com.campus.campus.mypageReservation.ReservationResponseDto;
import com.campus.campus.reservation.dto.ReservationSaveDto;
import com.campus.campus.reservation.dto.ReservationUpdateDto;
import com.campus.campus.reservation.entity.Reservation;
import com.campus.campus.reservation.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("reservations")
@Validated
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // TODO: 예진 - save reservation
//    @PostMapping("/reservation")
//    public ResponseEntity<ReservationResponseDto> postReservation(@RequestBody ReservationSaveDto reservationSaveDto) {
//        ReservationResponseDto reservationResponseDto = reservationService.postReservation(reservationSaveDto);
//        return ResponseEntity.ok(reservationResponseDto);
//    }

    //신규 예약 생성
    @PostMapping
    public ResponseEntity<ReservationResponseDto> saveReservation(@RequestBody ReservationSaveDto reservationSaveDto) {
        ReservationResponseDto reservationResponseDto = reservationService.saveReservation(reservationSaveDto);
        return new ResponseEntity<>(reservationResponseDto, HttpStatus.CREATED);
    }

    //예약 정보 수정
    @PutMapping("/{rsvId}")
    public ResponseEntity<ReservationResponseDto> updateReservation(@PathVariable Long rsvId, @RequestBody ReservationUpdateDto reservationUpdateDto) {
        ReservationResponseDto reservationResponseDto = reservationService.updateReservation(rsvId, reservationUpdateDto);
        return new ResponseEntity<>(reservationResponseDto, HttpStatus.OK);
    }

    //예약 전체 조회
    @GetMapping
    public ResponseEntity<List<ReservationResponseDto>> findAllReservations() {
        List<Reservation> reservations = reservationService.findAllReservations();
        List<ReservationResponseDto> reservationResponseDtos = reservations.stream()
                .map(ReservationResponseDto::of)
                .collect(Collectors.toList());
        return ResponseEntity.ok(reservationResponseDtos);
    }

    //예약 ID로 부분 예약 조회
    @GetMapping("/{rsvId}")
    public ResponseEntity<ReservationResponseDto> findReservationById(@PathVariable Long rsvId) {
        Optional<ReservationResponseDto> reservationResponseDto = reservationService.findReservationById(rsvId);
        return ResponseEntity.of(reservationResponseDto);
    }

    //예약 삭제
    @DeleteMapping("/{rsvId}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long rsvId) {
        reservationService.deleteReservation(rsvId);
        return ResponseEntity.noContent().build();
    }
}
