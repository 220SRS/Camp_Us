package com.campus.campus.reservation.repository;

import com.campus.campus.reservation.entity.Reservation;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByUserIdAndRsvStatusIn(long user_id, List<Reservation.RsvStatus> rsvStatusList);
    @Query("SELECT r FROM Reservation r WHERE r.userId = :userId AND r.rsvStatus IN :rsvStatusList AND r.rsvDate BETWEEN :startDate AND :endDate")
    List<Reservation> findByUserIdAndRsvStatusInAndRsvDateBetween(@Param("userId") long user_id, @Param("rsvStatusList") List<Reservation.RsvStatus> rsvStatusList, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

}
