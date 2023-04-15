package com.campus.campus.reservation.service;

import com.campus.campus.member.MemberService;
import com.campus.campus.reservation.entity.Reservation;
import com.campus.campus.reservation.repository.ReservationRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private final MemberService memberService;
//    private final CampService campService; 캠프서비스 가져와야함
    private final ReservationRepository reservationRepository;

    public ReservationService(MemberService memberService,
                              ReservationRepository reservationRepository) {
        this.memberService = memberService;
        this.reservationRepository = reservationRepository;
    }

    public Reservation saveReservation(Reservation reservation) {
        Reservation reservation1 = new Reservation();

        reservationRepository.save(reservation1);

        return reservation1;
    }

//    public Reservation updateReservation(Reservation reservation) {
//
//    }
//
//    public Reservation findByReservation() {
//        Reservation savedReservation = reservationRepository.findById()
//    }
//
//    public Page<Reservation> findByReservations() {
//
//    }
//
//    public Reservation cancelReservation() {
//
//    }
}
