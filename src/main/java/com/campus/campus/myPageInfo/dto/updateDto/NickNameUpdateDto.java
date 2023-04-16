package com.campus.campus.myPageInfo.dto.updateDto;

import lombok.Getter;

import javax.validation.constraints.Size;

@Getter
public class NickNameUpdateDto {

    @Size(max = 20, message = "닉네임은 한 글자 이상이거나 20글자 이하여야 합니다")
    private String nickName;

}
