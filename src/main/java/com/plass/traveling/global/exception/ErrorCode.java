package com.plass.traveling.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    MEMBER_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "멤버가 이미 존재합니다");

    private final HttpStatus httpStatus;
    private final String message;

}
