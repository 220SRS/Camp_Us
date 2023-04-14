package com.campus.campus.mypageReservation;

import com.campus.campus.reservation.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mypage/reservation")
public class MypageReservationController {
    private final MyPageReservationServiceImpl myPageReservationService;

    @Autowired
    public MypageReservationController(MyPageReservationServiceImpl myPageReservationService) {
        this.myPageReservationService = myPageReservationService;
    }

    @GetMapping
    public ResponseEntity<ReservationListResponseDto> findAllReservationByUserId(
            @RequestParam("user_id") Long user_id){
        // 예약 내역 조회
        List<Reservation> reservations = myPageReservationService.findAllReservationByUserId(user_id);
        List<ReservationResponseDto> reservationResponseDtos = new ArrayList<>();

        for (Reservation reservation:reservations){
            ReservationResponseDto reservationResponseDto = new ReservationResponseDto();
            reservationResponseDto.setRsv_id(reservation.getRsv_id());
            reservationResponseDto.setStore_id(reservation.getStore_id());
            reservationResponseDto.setStart_date(reservation.getStart_date());
            reservationResponseDto.setEnd_date(reservation.getEnd_date());
            reservationResponseDto.setPayment_amt(reservation.getPayment_amt());
            reservationResponseDto.setRsv_status(reservation.getRsv_status());
            reservationResponseDtos.add(reservationResponseDto);
        }
        ReservationListResponseDto responseDto = new ReservationListResponseDto();
        responseDto.setReservationResponseDtos(reservationResponseDtos);

        return ResponseEntity.ok(responseDto);
    }


}
