package com.campus.campus.reservation.service;

import com.campus.campus.dataapi.entity.CampBaseInfo;
import com.campus.campus.dataapi.repository.SaveCampRepository;
import com.campus.campus.member.Member;
import com.campus.campus.member.MemberRepository;
import com.campus.campus.reservation.dto.ReservationSaveDto;
import com.campus.campus.reservation.entity.Reservation;
import com.campus.campus.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {
    @Autowired
    private final ReservationRepository reservationRepository;
    @Autowired
    private final SaveCampRepository saveCampRepository;
    @Autowired
    private final MemberRepository memberRepository;


    // TODO : 예진 (saveReservation)
    public Reservation createReservation(ReservationSaveDto reservationSaveDto) {
        CampBaseInfo campBaseInfo = saveCampRepository.findById(reservationSaveDto.getStoreId()).orElseThrow(() -> new RuntimeException("캠핑장 정보를 찾을 수 없습니다."));
        Member member = memberRepository.findById(reservationSaveDto.getMemberId()).orElseThrow(() -> new RuntimeException("회원 정보를 찾을 수 없습니다."));

        Reservation reservation = new Reservation();
        reservation.setCampBaseInfo(campBaseInfo);
        reservation.setMember(member);
        reservation.setMbCnt(reservationSaveDto.getMbCnt());
        reservation.setStartDate(reservationSaveDto.getStartDate());
        reservation.setEndDate(reservationSaveDto.getEndDate());
        reservation.setPaymentAmt(reservationSaveDto.getPaymentAmt());
        reservation.setUserRequest(reservationSaveDto.getUserRequest());
        reservation.setRsvStatus(Reservation.RsvStatus.RSV_USING);

        return reservationRepository.save(reservation);

    }

}
