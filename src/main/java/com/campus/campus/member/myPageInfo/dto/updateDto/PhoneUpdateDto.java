package com.campus.campus.member.myPageInfo.dto.updateDto;

import lombok.Getter;

import javax.validation.constraints.Pattern;

@Getter
public class PhoneUpdateDto {

    @Pattern(regexp = "^01[0-9]-[0-9]{3,4}-[0-9]{4}$", message = "핸드폰번호를 다시 확인해주싶시요")
    private String phone;

}
