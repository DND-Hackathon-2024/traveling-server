package com.plass.traveling.global.exception;

import com.plass.traveling.global.common.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public BaseResponse handleCustomException(CustomException e) {
        return new BaseResponse(
            e.errorCode.getHttpStatus(), e.errorCode.getMessage()
        );


    }

}
