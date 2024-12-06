package com.baseball_root.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    INVALID_MEMBER_ID_EXCEPTION(HttpStatus.BAD_REQUEST, "존재하지 않는 멤버 id입니다.");

    private final HttpStatus httpStatus;
    private final String detail;

    ErrorCode(HttpStatus httpStatus, String detail) {
        this.httpStatus = httpStatus;
        this.detail = detail;
    }
}
