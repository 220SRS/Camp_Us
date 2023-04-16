package com.campus.campus.member;

import com.campus.campus.myPageInfo.dto.updateDto.NameUpdateDto;
import com.campus.campus.myPageInfo.dto.updateDto.NickNameUpdateDto;
import com.campus.campus.myPageInfo.dto.updateDto.PhoneUpdateDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String name;

    private String nickName;

    private String email;

    private String phone;

    public static Member of(MemberSaveDto memberSaveDto) {

        Member member = new Member();

        member.setName(memberSaveDto.getName());
        member.setNickName(memberSaveDto.getNickName());
        member.setEmail(memberSaveDto.getEmail());
        member.setPhone(memberSaveDto.getPhone());

        return member;
    }

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
