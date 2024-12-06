package com.baseball_root.member.controller;

import com.baseball_root.global.response.ApiResponse;
import com.baseball_root.global.response.ResponseUtil;
import com.baseball_root.member.dto.MemberDto;
import com.baseball_root.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ApiResponse<?> save(@RequestBody MemberDto.Request memberRequestDto) {
        MemberDto.Response memberResponseDto = memberService.save(memberRequestDto);

        return ResponseUtil.ok(memberResponseDto);
    }

    @PatchMapping
    public ApiResponse<?> update(@RequestParam(name = "id") String id, @RequestBody MemberDto.Request memberRequestDto) {
        MemberDto.Response memberResponseDto = memberService.update(id, memberRequestDto);

        return ResponseUtil.ok(memberResponseDto);
    }
}
