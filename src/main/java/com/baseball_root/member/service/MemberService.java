package com.baseball_root.member.service;

import com.baseball_root.global.exception.InvalidMemberIdException;
import com.baseball_root.member.domain.Member;
import com.baseball_root.member.dto.MemberDto;
import com.baseball_root.member.mapper.MemberMapper;
import com.baseball_root.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public MemberDto.Response save(MemberDto.Request memberRequestDto) {
        String uuid = makeUuid();

        Member member = memberMapper.toEntity(memberRequestDto, uuid);

        member = memberRepository.save(member);

        return member.toResponseDto();
    }

    public MemberDto.Response update(String id, MemberDto.Request memberRequestDto) {
        Member member = memberRepository.findById(id)
                .orElseThrow(InvalidMemberIdException::new);

        member.update(memberRequestDto);

        memberRepository.save(member);

        return member.toResponseDto();
    }

    private String makeUuid() {
        String uuid = UUID.randomUUID().toString().substring(0, 8);
        while (memberRepository.findById(uuid).isPresent()) {
            uuid = UUID.randomUUID().toString().substring(0, 8);
        }
        return uuid;
    }

}
