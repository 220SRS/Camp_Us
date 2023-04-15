package com.campus.campus.mypageReservation;

import com.campus.campus.reservation.entity.Reservation;


import java.util.List;

public interface MyPageReservationService {
    List<Reservation> findFilterReservationByUserId(long user_id, String status, String period);

    void deleteReservation(long rsv_id);

}
