package com.campus.campus.mypageReservation;

import com.campus.campus.reservation.entity.Reservation;
import com.campus.campus.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MyPageReservationService {
    List<Reservation> findAllReservationByUserId(long user_id);
    List<Reservation> findFilterReservationByUserId(long user_id);
    void deleteReservation(long rsv_id);

}
