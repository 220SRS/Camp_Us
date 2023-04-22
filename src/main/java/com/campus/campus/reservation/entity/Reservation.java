package com.campus.campus.reservation.entity;

import com.campus.campus.dataapi.entity.CampBaseInfo;
import com.campus.campus.member.Member;
import com.campus.campus.review.Review;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "RESERVATION")
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "rsvId")

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rsvId; // 예약 id
    @ManyToOne
    @JoinColumn(name = "storeId", nullable = false)
    private CampBaseInfo campBaseInfo; // 캠핑장정보 가져오기
    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    //@JsonManagedReference
    private Member member; // member정보 가져오기
    @Column(nullable = false)
    private Integer mbCnt; // 인원 수
    @Column(nullable = false)
    private LocalDateTime startDate; // 예약 시작일
    @Column(nullable = false)
    private LocalDateTime endDate; // 예약 종료일
    @Column(nullable = false)
    private Long paymentAmt; // 결제 금액
    @Column
    private String userRequest; // 요청 사항
    @Enumerated(EnumType.STRING)
    private RsvStatus rsvStatus = RsvStatus.RSV_USING; // 예약 진행 상태(완료/진행/취소)
    @CreatedDate
    @Column
    private LocalDateTime rsvDate;  // 예약 생성 시간 및 날짜

    // Review 매핑
    @OneToMany(mappedBy = "reservation")
    private List<Review> reviewList = new ArrayList<>();


    public enum RsvStatus {
        RSV_COMPLETE(1, "예약 완료"),
        RSV_USING(2, "예약중"),
        RSV_CANCLE(3, "예약취소");
        @Getter
        private int stepNumber;
        @Getter
        private String status;

        RsvStatus(int stepNumber, String status) {
            this.stepNumber = stepNumber;
            this.status = status;
        }
    }
    
}
