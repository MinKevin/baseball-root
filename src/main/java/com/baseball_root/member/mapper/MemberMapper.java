package com.baseball_root.member.mapper;

import com.baseball_root.member.domain.Member;
import com.baseball_root.member.dto.MemberDto;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface MemberMapper {
    Member toEntity(MemberDto.Request memberRequestDto, String id);
}
