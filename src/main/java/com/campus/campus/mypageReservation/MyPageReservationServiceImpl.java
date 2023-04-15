package com.campus.campus.mypageReservation;

import com.campus.campus.reservation.entity.Reservation;
import com.campus.campus.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class MyPageReservationServiceImpl implements MyPageReservationService {
    private final ReservationRepository reservationRepository;

    @Override
    public List<Reservation> findFilterReservationByUserId(long user_id, String status, String period) {
        Date currentDate = new Date();  // 현재 시간
        Date sDate = generateDateWithMonthOffsetByPeriod(period, currentDate);
        List<Reservation.RsvStatus> rsvStatusList = generateRsvStatusListByStatus(status);

        if (period.equals("전체")) {
            return reservationRepository
                    .findByUserIdAndRsvStatusIn(user_id, rsvStatusList);
        } else {
            return reservationRepository
                    .findByUserIdAndRsvStatusInAndRsvDateBetween(user_id, rsvStatusList, sDate, currentDate);
        }
    }

    @Override
    public void deleteReservation(long rsv_id) {

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

    public Date generateDateWithMonthOffsetByPeriod(String period, Date currentDate) {
        /* 특정 period에 맞게 시간 계산하는 함수(6개월 전/1년 전)
        - currentDate : 현재 시각
        - period : 선택한 검색 기간 (6개월/1년/전체)
             - default : 6개월
         */
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        int monthsOffset = 0;

        if (period == null) {
            monthsOffset = -6; // 기본값은 6개월
        } else if (period.equals("6개월")) {
            monthsOffset = -6;
        } else if (period.equals("1년")) {
            monthsOffset = -12;
        }

        calendar.add(Calendar.MONTH, monthsOffset);
        return calendar.getTime();
    }

}
