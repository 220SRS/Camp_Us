package com.campus.campus.reservation.service;

import com.campus.campus.reservation.entity.Reservation;
import com.campus.campus.reservation.repository.ReservationRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private final MemberService memberService;
    private final CampService campService;
    private final ReservationRepository reservationRepository;

    //생성자 주입

    public Reservation saveReservation(Reservation reservation) {
        return savedReservation;
    }

    public Reservation updateReservation(Reservation reservation) {
        return ;
    }

    public Reservation findByReservation() {

    }

    public Page<Reservation> findByReservations() {

    }

    public Reservation cancelReservation() {

    }
}
