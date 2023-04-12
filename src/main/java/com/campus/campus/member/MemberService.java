package com.campus.campus.member;

import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberResponseDto saveMember(MemberSaveDto memberSaveDto) {

        Member member = Member.of(memberSaveDto);

        memberRepository.save(member);

        return MemberResponseDto.of(member);

    }
}
