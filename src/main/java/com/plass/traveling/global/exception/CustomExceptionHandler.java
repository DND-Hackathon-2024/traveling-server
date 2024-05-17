package com.plass.traveling.global.exception;

import com.plass.traveling.global.common.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public BaseResponse handleCustomException(CustomException e) {
        return new BaseResponse(
            e.getErrorCode().getHttpStatus(), e.getErrorCode().getMessage()
        );
    }

}
