package com.campus.campus.myPageInfo.dto.updateDto;

import lombok.Getter;

import javax.validation.constraints.*;

@Getter
public class NameUpdateDto {


    @Pattern(regexp = "^[가-힣]+(\\s?[가-힣]+)*$", message = "한글로만 작성해야 합니다(외국명도 마찬가지로 한글발음으로 작성해야 합니다)")
    @Size(max = 30, message = "이름은 한 글자 이상이거나 30글자 이하여야 합니다")
    private String reservation_name;

}
