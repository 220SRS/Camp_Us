package com.campus.campus.review;

import com.campus.campus.member.Member;
import com.campus.campus.reservation.entity.Reservation;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    private Member member; // member 매핑
    @ManyToOne
    @JoinColumn(name = "rsvId", nullable = false)
    private Reservation reservation; // Reservation 매핑

    @Column(nullable = false)
    private Float stars;
    @Column(nullable = false)
    private String comment;
    @CreatedDate
    @Column
    private LocalDate createdAt = LocalDate.now();

    private byte[] image1;
    private byte[] image2;
    private byte[] image3;

}
