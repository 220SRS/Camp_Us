package com.campus.campus.reservation.service;

import com.campus.campus.mypageReservation.ReservationResponseDto;
import com.campus.campus.reservation.dto.ReservationSaveDto;
import com.campus.campus.reservation.entity.Reservation;
import com.campus.campus.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;

    // TODO : 예진 (saveReservation)
    public ReservationResponseDto postReservation(ReservationSaveDto reservationSaveDto) {
        Reservation reservation = Reservation.of(reservationSaveDto);
        reservationRepository.save(reservation);
        return ReservationResponseDto.of(reservation);
    }

    public Reservation saveReservation(Reservation reservation) {
        Reservation reservation1 = new Reservation();

        reservationRepository.save(reservation1);

        return reservation1;
    }

    public Reservation updateReservation(Long rsvId, ReservationSaveDto reservationSaveDto) {
        Reservation reservation = reservationRepository.findById(rsvId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid reservation ID: " + rsvId));

        reservation.setMemberId(reservationSaveDto.getMemberId());
        reservation.setStoreId(reservationSaveDto.getStoreId());
        reservation.setMbCnt(reservationSaveDto.getMbCnt());
        reservation.setStartDate(reservationSaveDto.getStartDate());
        reservation.setEndDate(reservationSaveDto.getEndDate());
        reservation.setPaymentAmt(reservationSaveDto.getPaymentAmt());
        reservation.setUserRequest(reservationSaveDto.getUserRequest());
        reservation.setRsvStatus(reservationSaveDto.getRsvStatus());
        reservation.setRsvDate(reservationSaveDto.getRsvDate());

        return reservation;
    }

    public Optional<Reservation> findReservationById(Long rsvId) {
        return reservationRepository.findById(rsvId);
    }

    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    public void cancelReservation(Long rsvId) {
        reservationRepository.deleteById(rsvId);
    }
}
