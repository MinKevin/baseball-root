package com.baseball_root.global;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SuccessCode {
    DELETE_MEMBER_SUCCESS(HttpStatus.ACCEPTED, "회원 탈퇴가 완료되었습니다.");

    private final HttpStatus httpStatus;
    private final String detail;

    SuccessCode(HttpStatus httpStatus, String detail) {
        this.httpStatus = httpStatus;
        this.detail = detail;
    }
}
