package com.campus.campus.member.myPageInfo.service;

import com.campus.campus.member.Member;
import com.campus.campus.member.MemberRepository;
import com.campus.campus.member.myPageInfo.dto.responseDto.MypageInfoResponseDto;
import com.campus.campus.member.myPageInfo.dto.responseDto.NameResponseDto;
import com.campus.campus.member.myPageInfo.dto.responseDto.NickNameResponseDto;
import com.campus.campus.member.myPageInfo.dto.responseDto.PhoneResponseDto;
import com.campus.campus.member.myPageInfo.dto.updateDto.NameUpdateDto;
import com.campus.campus.member.myPageInfo.dto.updateDto.NickNameUpdateDto;
import com.campus.campus.member.myPageInfo.dto.updateDto.PhoneUpdateDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyPageInfoService {

    private final MemberRepository memberRepository;

    public MyPageInfoService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public NameResponseDto updateName(Long memberId, NameUpdateDto nameUpdateDto) {
        Member findMember = memberRepository.findById(memberId).orElseThrow(IllegalArgumentException::new);

        findMember.updateName(nameUpdateDto);

        return NameResponseDto.of(findMember);
    }

    @Transactional
    public NickNameResponseDto updateNickName(Long memberId, NickNameUpdateDto nickNameUpdateDto) {
        Member findMember = memberRepository.findById(memberId).orElseThrow(IllegalArgumentException::new);

        findMember.updateNickName(nickNameUpdateDto);

        return NickNameResponseDto.of(findMember);
    }

    @Transactional
    public PhoneResponseDto updatePhone(Long memberId, PhoneUpdateDto phoneUpdateDto) {
        Member findMember = memberRepository.findById(memberId).orElseThrow(IllegalArgumentException::new);

        findMember.updatePhone(phoneUpdateDto);

        return PhoneResponseDto.of(findMember);
    }

    public MypageInfoResponseDto findMember(Long memberId) {

        Member findMember = memberRepository.findById(memberId).orElseThrow(IllegalArgumentException::new);

        return MypageInfoResponseDto.of(findMember);
    }
}
