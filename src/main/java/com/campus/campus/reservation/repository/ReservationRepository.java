package com.campus.campus.reservation.repository;

import com.campus.campus.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByMember_MemberIdAndRsvStatusIn(long user_id, List<Reservation.RsvStatus> rsvStatusList);

    @Query("SELECT r FROM Reservation r WHERE r.member.memberId = :memberId AND r.rsvStatus IN :rsvStatusList AND r.rsvDate BETWEEN :startDate AND :endDate")
    List<Reservation> findByMemberIdAndRsvStatusInAndRsvDateBetween(@Param("memberId") long memberId, @Param("rsvStatusList") List<Reservation.RsvStatus> rsvStatusList, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

}
