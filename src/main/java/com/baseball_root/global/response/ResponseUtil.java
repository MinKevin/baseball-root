package com.baseball_root.global.response;

public class ResponseUtil {
    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(true, 200, data, null, null);
    }
}
