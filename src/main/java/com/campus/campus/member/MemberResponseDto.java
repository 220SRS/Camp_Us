package com.campus.campus.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberResponseDto {

    private String name;

    private String nickName;

    private String email;

    private String phone;


    public static MemberResponseDto of(Member member) {

        MemberResponseDto memberResponseDto = new MemberResponseDto();

        memberResponseDto.setName(member.getName());
        memberResponseDto.setNickName(member.getNickName());
        memberResponseDto.setEmail(member.getEmail());
        memberResponseDto.setPhone(member.getPhone());

        return memberResponseDto;

    }
}
