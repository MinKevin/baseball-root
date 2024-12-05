package com.baseball_root.member.domain;

import com.baseball_root.member.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    private String id;
    private String nickname;
    private String favoriteTeam;
    private String profileImage;

    public MemberDto.Response toResponseDto() {
        return MemberDto.Response.builder()
                .id(id)
                .nickname(nickname)
                .favoriteTeam(favoriteTeam)
                .profileImage(profileImage)
                .build();
    }
}
