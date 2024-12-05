package com.baseball_root.member.dto;

import lombok.*;


public class MemberDto {
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private String nickname;
        private String favoriteTeam;
        private String profileImage;
    }

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private String id;
        private String nickname;
        private String favoriteTeam;
        private String profileImage;
    }
}
