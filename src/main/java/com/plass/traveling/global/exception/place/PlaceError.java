package com.plass.traveling.global.exception.place;

import com.plass.traveling.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum PlaceError implements ErrorProperty {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 유저를 찾을 수 없습니다."),
    PLACE_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "해당 장소를 찾을 수 없습니다.");
    private final HttpStatus status;
    private final String message;
}
