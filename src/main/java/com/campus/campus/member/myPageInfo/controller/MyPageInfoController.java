package com.campus.campus.member.myPageInfo.controller;

import com.campus.campus.member.myPageInfo.dto.responseDto.MypageInfoResponseDto;
import com.campus.campus.member.myPageInfo.dto.responseDto.NameResponseDto;
import com.campus.campus.member.myPageInfo.dto.responseDto.NickNameResponseDto;
import com.campus.campus.member.myPageInfo.dto.responseDto.PhoneResponseDto;
import com.campus.campus.member.myPageInfo.dto.updateDto.NameUpdateDto;
import com.campus.campus.member.myPageInfo.dto.updateDto.NickNameUpdateDto;
import com.campus.campus.member.myPageInfo.dto.updateDto.PhoneUpdateDto;
import com.campus.campus.member.myPageInfo.service.MyPageInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/myPage")
@Validated
public class MyPageInfoController {

    private final MyPageInfoService myPageInfoService;

    public MyPageInfoController(MyPageInfoService myPageInfoService) {
        this.myPageInfoService = myPageInfoService;
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MypageInfoResponseDto> findMember(@PathVariable("memberId") Long memberId) {
        MypageInfoResponseDto mypageInfoResponseDto = myPageInfoService.findMember(memberId);

        return ResponseEntity.ok(mypageInfoResponseDto);
    }


    @PatchMapping("/name/{memberId}")
    public ResponseEntity<NameResponseDto> updateMemberName(@Valid @PathVariable("memberId") Long memberId, @RequestBody NameUpdateDto nameUpdateDto) {
        NameResponseDto nameResponseDto = myPageInfoService.updateName(memberId, nameUpdateDto);

        return ResponseEntity.ok(nameResponseDto);
    }

    @PatchMapping("/nickName/{memberId}")
    public ResponseEntity<NickNameResponseDto> updateMemberNickName(@Valid @PathVariable("memberId") Long memberId, @RequestBody NickNameUpdateDto nickNameUpdateDto) {
        NickNameResponseDto nickNameResponseDto = myPageInfoService.updateNickName(memberId, nickNameUpdateDto);

        return ResponseEntity.ok(nickNameResponseDto);
    }

    @PatchMapping("/phone/{memberId}")
    public ResponseEntity<PhoneResponseDto> updateMemberPhone(@Valid @PathVariable("memberId") Long memberId, @RequestBody PhoneUpdateDto phoneUpdateDto) {
        PhoneResponseDto phoneResponseDto = myPageInfoService.updatePhone(memberId, phoneUpdateDto);

        return ResponseEntity.ok(phoneResponseDto);
    }
}
