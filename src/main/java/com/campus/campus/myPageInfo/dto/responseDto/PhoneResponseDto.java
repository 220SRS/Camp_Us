package com.campus.campus.myPageInfo.dto.responseDto;

import com.campus.campus.member.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PhoneResponseDto {

    private String phone;

    public static PhoneResponseDto of(Member findMember) {
        PhoneResponseDto phoneResponseDto = new PhoneResponseDto();

        phoneResponseDto.setPhone(findMember.getPhone());

        return phoneResponseDto;
    }
}
