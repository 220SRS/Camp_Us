package com.campus.campus.member;

import com.campus.campus.member.audit.Auditable;
import com.campus.campus.member.myPageInfo.dto.updateDto.NameUpdateDto;
import com.campus.campus.member.myPageInfo.dto.updateDto.NickNameUpdateDto;
import com.campus.campus.member.myPageInfo.dto.updateDto.PhoneUpdateDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.*;
import java.security.Principal;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Member extends Auditable implements Principal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(length = 15, nullable = false)
    private String password;

    @Column(length = 15, nullable = false)
    private String confirmPassword;

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


    // login
    public Member(String email, String password){
        this.email = email;
        this.password = password;
    }

}
