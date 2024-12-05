package com.baseball_root.member.controller;

import com.baseball_root.member.dto.MemberDto;
import com.baseball_root.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody MemberDto.Request memberRequestDto) {
        System.out.println(memberRequestDto.getFavoriteTeam());
        MemberDto.Response memberResponseDto = memberService.save(memberRequestDto);

        return ResponseEntity.ok(memberResponseDto);
    }
}
