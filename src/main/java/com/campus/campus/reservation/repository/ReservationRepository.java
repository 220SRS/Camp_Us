package com.campus.campus.reservation.repository;

import com.campus.campus.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
public interface ReservationRepository extends JpaRepository<Reservation, Long> {


    List<Reservation> findByUserIdAndRsvStatusAndRsvDateBetween(Long userId, Reservation.RsvStatus rsvStatus, Date startDate, Date endDate);

}
