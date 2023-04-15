package com.campus.campus.reservation.service;
import com.campus.campus.mypageReservation.ReservationResponseDto;
import com.campus.campus.reservation.dto.ReservationSaveDto;
import com.campus.campus.reservation.entity.Reservation;
import com.campus.campus.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

}
