package com.campus.campus.mypageReservation;

import com.campus.campus.reservation.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mypage")
public class MypageReservationController {
    private final MyPageReservationServiceImpl myPageReservationService;

    @Autowired
    public MypageReservationController(MyPageReservationServiceImpl myPageReservationService) {
        this.myPageReservationService = myPageReservationService;
    }

    @GetMapping("/reservation/{user_id}")
    public ResponseEntity<ReservationListResponseDto> findFilterReservationByUserId(
            @PathVariable("user_id") Long user_id,
            @RequestParam(value = "status", defaultValue = "이용중") String status,
            @RequestParam(value = "period", defaultValue = "6개월") String period
    ) {
        // 예약 내역 조회
        List<Reservation> reservations = myPageReservationService.findFilterReservationByUserId(user_id, status, period);
        List<ReservationResponseDto> reservationResponseDtos = new ArrayList<>();

        for (Reservation reservation : reservations) {
            ReservationResponseDto reservationResponseDto = new ReservationResponseDto();
            reservationResponseDto.setRsvId(reservation.getRsvId());
            reservationResponseDto.setStoreId(reservation.getCampBaseInfo().getStoreId());
            reservationResponseDto.setMainImg(reservation.getCampBaseInfo().getMainImg());
            reservationResponseDto.setStartDate(reservation.getStartDate());
            reservationResponseDto.setEndDate(reservation.getEndDate());
            reservationResponseDto.setPaymentAmt(reservation.getPaymentAmt());
            reservationResponseDto.setRsvStatus(reservation.getRsvStatus());
            reservationResponseDtos.add(reservationResponseDto);
        }
        ReservationListResponseDto responseDto = new ReservationListResponseDto();
        responseDto.setReservationResponseDtos(reservationResponseDtos);

        System.out.println(responseDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/reservation")
    public ResponseEntity deleteReservation(@RequestParam("rsvId") Long rsvId) {

        return myPageReservationService.deleteReservation(rsvId);
    }

}
