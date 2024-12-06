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

    public void update(MemberDto.Request memberRequestDto) {
        this.nickname = memberRequestDto.getNickname();
        this.favoriteTeam = memberRequestDto.getFavoriteTeam();
        this.profileImage = memberRequestDto.getProfileImage();
    }

    public MemberDto.Response toResponseDto() {
        return MemberDto.Response.builder()
                .id(id)
                .nickname(nickname)
                .favoriteTeam(favoriteTeam)
                .profileImage(profileImage)
                .build();
    }
}
