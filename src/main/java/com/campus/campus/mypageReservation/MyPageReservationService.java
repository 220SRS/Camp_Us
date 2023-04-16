package com.campus.campus.mypageReservation;

import com.campus.campus.reservation.entity.Reservation;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface MyPageReservationService {
    List<Reservation> findFilterReservationByUserId(long user_id, String status, String period);

    ResponseEntity<?> deleteReservation(long rsvId);

}
