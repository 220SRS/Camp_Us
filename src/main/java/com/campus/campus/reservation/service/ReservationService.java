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

    public ReservationService(MemberService memberService,
                              CampService campService,
                              ReservationRepository reservationRepository) {
        this.memberService = memberService;
        this.campService = campService;
        this.reservationRepository = reservationRepository;
    }

    public Reservation saveReservation(Reservation reservation) {
        Reservation reservation1 = new Reservation();
        reservation1.setStartDate("2023-04-13");
        reservation1.setEndDate("2023-04-14");
        reservation1.setPaymentAmount(100000L);
        reservation1.setPaymentStatus(1L);
        reservationRepository.save(reservation1);

        return reservation1;
    }

    public Reservation updateReservation(Reservation reservation) {
        return ;
    }

    public Reservation findByReservation() {
        Reservation savedReservation = reservationRepository.findById()
    }

    public Page<Reservation> findByReservations() {

    }

    public Reservation cancelReservation() {

    }
}
