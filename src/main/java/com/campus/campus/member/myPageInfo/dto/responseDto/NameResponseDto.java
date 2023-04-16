package com.campus.campus.member.myPageInfo.dto.responseDto;

import com.campus.campus.member.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NameResponseDto {

    private String reservation_name;

    public static NameResponseDto of(Member findMember) {
        NameResponseDto nameResponseDto = new NameResponseDto();

        nameResponseDto.setReservation_name(findMember.getName());

        return nameResponseDto;
    }
}
