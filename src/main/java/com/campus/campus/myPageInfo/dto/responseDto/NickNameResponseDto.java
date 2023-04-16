package com.campus.campus.myPageInfo.dto.responseDto;

import com.campus.campus.member.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NickNameResponseDto {

    private String nickName;

    public static NickNameResponseDto of(Member findMember) {
        NickNameResponseDto nickNameResponseDto = new NickNameResponseDto();

        nickNameResponseDto.setNickName(findMember.getNickName());

        return nickNameResponseDto;
    }
}
