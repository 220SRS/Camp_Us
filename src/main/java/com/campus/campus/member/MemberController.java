package com.campus.campus.member;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class MemberController {
    private final MemberService memberService;
    private final MemberServiceImpl memberServiceImpl;

    public MemberController(MemberService memberService, MemberServiceImpl memberServiceImpl) {
        this.memberService = memberService;
        this.memberServiceImpl = memberServiceImpl;
    }

    @PostMapping
    public ResponseEntity<MemberResponseDto> saveMember(@RequestBody MemberSaveDto memberSaveDto) {

        MemberResponseDto memberResponseDto = memberService.saveMember(memberSaveDto);

        return ResponseEntity.ok(memberResponseDto);

    }

    // login
    @GetMapping("/register")
    public String registerMemberForm() {
        return "member-register";
    }

    @PostMapping("/register")
    public String registerMember(@Valid MemberDto.Post requestBody){
        Member member = new Member(requestBody.getEmail(), requestBody.getPassword());

        memberServiceImpl.createMember(member);
        System.out.println("Member Registration Successfully");
        return "login";
    }

    @GetMapping("/my-page")
    public String myPage() {
        return "my-page";
    }

}
