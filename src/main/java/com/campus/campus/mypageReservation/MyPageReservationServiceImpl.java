package com.campus.campus.mypageReservation;

import com.campus.campus.reservation.entity.Reservation;
import com.campus.campus.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Date;
@Service
@RequiredArgsConstructor
public class MyPageReservationServiceImpl implements MyPageReservationService{
    private final ReservationRepository reservationRepository;

    @Override
    public List<Reservation> findAllReservationByUserId(long user_id) {
        Date currentDate = new Date();  // 현재 시간
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.MONTH, -6);
        Date sDate = calendar.getTime();

        Reservation.RsvStatus rsvStatus = Reservation.RsvStatus.RSV_USING;

        List<Reservation> reservations
                = reservationRepository
                .findByUser_idAndRsv_statusAndRsv_dateBetween(user_id, rsvStatus, sDate, currentDate);

        return reservations;
    }

    @Override
    public List<Reservation> findFilterReservationByUserId(long user_id) {
        return null;
    }

    @Override
    public void deleteReservation(long rsv_id) {

    }
}
