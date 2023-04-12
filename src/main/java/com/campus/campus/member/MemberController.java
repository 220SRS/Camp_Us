package com.campus.campus.member;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<MemberResponseDto> saveMember(@RequestBody MemberSaveDto memberSaveDto) {

        MemberResponseDto memberResponseDto = memberService.saveMember(memberSaveDto);

        return ResponseEntity.ok(memberResponseDto);

    }
}
