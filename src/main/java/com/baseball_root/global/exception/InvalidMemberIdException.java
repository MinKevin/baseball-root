package com.baseball_root.global.exception;

public class InvalidMemberIdException extends CustomException {
    public InvalidMemberIdException() {
        super(ErrorCode.INVALID_MEMBER_ID_EXCEPTION);
    }
}
