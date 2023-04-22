package com.campus.campus.mypageReservation;

import com.campus.campus.reservation.entity.Reservation;
import com.campus.campus.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyPageReservationServiceImpl implements MyPageReservationService {
    private final ReservationRepository reservationRepository;

    @Override
    public List<Reservation> findFilterReservationByUserId(long user_id, String status, String period) {
        LocalDateTime currentDate = LocalDateTime.now();  // 현재 시간
        LocalDateTime sDate = generateDateWithMonthOffsetByPeriod(period, currentDate);
        List<Reservation.RsvStatus> rsvStatusList = generateRsvStatusListByStatus(status);

        System.out.println("sDate : " + sDate);
        System.out.println(rsvStatusList);

        if (period.equals("전체")) {
            return reservationRepository
                    .findByMember_MemberIdAndRsvStatusIn(user_id, rsvStatusList);
        } else {
            return reservationRepository
                    .findByMemberIdAndRsvStatusInAndRsvDateBetween(user_id, rsvStatusList, sDate, currentDate);
        }
    }

    @Override
    public ResponseEntity<?> deleteReservation(long rsvId) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(rsvId);
        if (optionalReservation.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Reservation reservation = optionalReservation.get();
        reservationRepository.delete(reservation);

        return ResponseEntity.ok().build();

    }

    public List<Reservation.RsvStatus> generateRsvStatusListByStatus(String status) {
        /* 선택한 status에 맞게 예약상태 return하는 함수
        - status : 선택한 상태 (이용중/완료)
            - default : 이용중
        * */
        List<Reservation.RsvStatus> rsvStatusList = new ArrayList<>();

        // 입력 상태 필터링
        if (status == null || status.equals("이용중")) { // default
            rsvStatusList.add(Reservation.RsvStatus.RSV_USING);
        } else if (status.equals("완료")) {
            rsvStatusList.add(Reservation.RsvStatus.RSV_CANCLE);
            rsvStatusList.add(Reservation.RsvStatus.RSV_COMPLETE);
        }
        return rsvStatusList;
    }

    public LocalDateTime generateDateWithMonthOffsetByPeriod(String period, LocalDateTime currentDate) {
        /* 특정 period에 맞게 시간 계산하는 함수(6개월 전/1년 전)
        - currentDate : 현재 시각
        - period : 선택한 검색 기간 (6개월/1년/전체)
             - default : 6개월
         */
        int monthsOffset = 0;

        if (period == null) {
            monthsOffset = 6;
        } else if (period.equals("6개월")) {
            monthsOffset = 6;
        } else if (period.equals("1년")) {
            monthsOffset = 12;
        }

        return currentDate.minusMonths(monthsOffset);
    }

}
