package com.campus.campus.member;

import com.campus.campus.member.myPageInfo.dto.updateDto.NameUpdateDto;
import com.campus.campus.member.myPageInfo.dto.updateDto.NickNameUpdateDto;
import com.campus.campus.member.myPageInfo.dto.updateDto.PhoneUpdateDto;
import com.campus.campus.reservation.entity.Reservation;
import com.campus.campus.review.Review;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 30, nullable = false)
    private String nickName;
    @Column(nullable = false, updatable = false, unique = true)
    private String email;
    @Column(length = 13, nullable = false, unique = true)
    private String phone;

    // Reservation 매핑
    @OneToMany(mappedBy = "member")
    private List<Reservation> reservationList = new ArrayList<>();

    // Review 매핑
    @OneToMany(mappedBy = "member")
    private List<Review> reviewList = new ArrayList<>();

//    public static Member of(MemberSaveDto memberSaveDto) {
//
//        Member member = new Member();
//
//        member.setName(memberSaveDto.getName());
//        member.setNickName(memberSaveDto.getNickName());
//        member.setEmail(memberSaveDto.getEmail());
//        member.setPhone(memberSaveDto.getPhone());
//
//        return member;
//    }

    public void updateName(NameUpdateDto nameUpdateDto) {
        this.name = nameUpdateDto.getReservation_name();
    }

    public void updateNickName(NickNameUpdateDto nickNameUpdateDto) {
        this.nickName = nickNameUpdateDto.getNickName();
    }

    public void updatePhone(PhoneUpdateDto phoneUpdateDto) {
        this.phone = phoneUpdateDto.getPhone();
    }

//    private enum usersStatus;

}
