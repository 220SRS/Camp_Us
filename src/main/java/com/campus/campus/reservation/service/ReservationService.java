package com.campus.campus.reservation.service;

import com.campus.campus.dataapi.entity.CampBaseInfo;
import com.campus.campus.dataapi.repository.SaveCampRepository;
import com.campus.campus.member.Member;
import com.campus.campus.member.MemberRepository;
import com.campus.campus.mypageReservation.ReservationResponseDto;
import com.campus.campus.reservation.dto.ReservationPatchDto;
import com.campus.campus.reservation.dto.ReservationSaveDto;
import com.campus.campus.reservation.dto.ReservationUpdateDto;
import com.campus.campus.reservation.entity.Reservation;
import com.campus.campus.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;
    private MemberRepository memberRepository;
    private SaveCampRepository saveCampRepository;

    public ReservationService(ReservationRepository reservationRepository, MemberRepository memberRepository, SaveCampRepository saveCampRepository) {
        this.reservationRepository = reservationRepository;
        this.memberRepository = memberRepository;
        this.saveCampRepository = saveCampRepository;
    }

    //예약 생성
    @Transactional
    public ReservationResponseDto saveReservation(ReservationSaveDto reservationSaveDto) {
        Reservation reservation = new Reservation();

        Member member = memberRepository.findById(reservationSaveDto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID: " + reservationSaveDto.getMemberId()));
        reservation.setMember(member);

        CampBaseInfo campBaseInfo = saveCampRepository.findById(reservationSaveDto.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid store ID: " + reservationSaveDto.getStoreId()));
        reservation.setCampBaseInfo(campBaseInfo);

        reservation.setMbCnt(reservationSaveDto.getMbCnt());
        reservation.setStartDate(reservationSaveDto.getStartDate());
        reservation.setEndDate(reservationSaveDto.getEndDate());
        reservation.setPaymentAmt(reservationSaveDto.getPaymentAmt());
        reservation.setUserRequest(reservationSaveDto.getUserRequest());
        reservation.setRsvStatus(reservationSaveDto.getRsvStatus());

        Reservation savedReservation = reservationRepository.save(reservation);
        return ReservationResponseDto.of(savedReservation);
    }

    //예약 전체 변경
    @Transactional
    public ReservationResponseDto updateReservation(Long rsvId, ReservationUpdateDto reservationUpdateDto) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(rsvId);

        if (reservationOptional.isPresent()) {
            Reservation reservation = reservationOptional.get();
            reservation.setMbCnt(reservationUpdateDto.getMbCnt());
            reservation.setStartDate(reservationUpdateDto.getStartDate());
            reservation.setEndDate(reservationUpdateDto.getEndDate());
            reservation.setPaymentAmt(reservationUpdateDto.getPaymentAmt());
            reservation.setUserRequest(reservationUpdateDto.getUserRequest());

            Reservation updatedReservation = reservationRepository.save(reservation);
            return ReservationResponseDto.of(updatedReservation);
        } else {
            throw new IllegalArgumentException("Invalid reservation ID: " + rsvId);
        }
    }

    //예약 전체 조회
    @Transactional(readOnly = true)
    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    //예약 Id별 조회
    public Optional<ReservationResponseDto> findReservationById(Long rsvId) {
        return reservationRepository.findById(rsvId)
                .map(ReservationResponseDto::of);
    }

    //예약 삭제
    @Transactional
    public void deleteReservation(Long rsvId) {
        reservationRepository.deleteById(rsvId);
    }
}
