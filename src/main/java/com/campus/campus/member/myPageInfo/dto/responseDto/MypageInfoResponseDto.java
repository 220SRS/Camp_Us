package com.campus.campus.member.myPageInfo.dto.responseDto;

import com.campus.campus.member.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MypageInfoResponseDto {

    private String nickname;

    private String reservation_name;

    private String phone_number;

    public static MypageInfoResponseDto of(Member findMember) {

        MypageInfoResponseDto mypageInfoResponseDto = new MypageInfoResponseDto();

        mypageInfoResponseDto.setNickname(findMember.getNickName());
        mypageInfoResponseDto.setPhone_number(findMember.getPhone());
        mypageInfoResponseDto.setReservation_name(findMember.getName());

        return mypageInfoResponseDto;
    }
}
