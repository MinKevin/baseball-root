package com.baseball_root.global.response;

import com.baseball_root.global.SuccessCode;
import org.springframework.http.HttpStatus;

public class ResponseUtil {
    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(true, HttpStatus.OK.value(), data, null);
    }

    public static <T> ApiResponse<T> ok(SuccessCode successCode) {
        return new ApiResponse<>(true, successCode.getHttpStatus().value(), null, successCode.getDetail());
    }
}
