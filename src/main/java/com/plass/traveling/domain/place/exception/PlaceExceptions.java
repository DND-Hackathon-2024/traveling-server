package com.plass.traveling.domain.place.exception;

import com.plass.traveling.domain.place.exception.error.PlaceError;
import com.plass.traveling.global.exception.BusinessException;

import static com.plass.traveling.domain.place.exception.error.PlaceError.PLACE_NO_ACCESS_ERROR;

public class PlaceExceptions extends BusinessException {
    private static final PlaceExceptions USER_NOT_FOUND = new PlaceExceptions(PlaceError.USER_NOT_FOUND);

    private static final PlaceExceptions PLACE_NOT_FOUND_EXCEPTION = new PlaceExceptions(PlaceError.PLACE_NOT_FOUND_EXCEPTION);

    private static final PlaceExceptions PLACE_EXCEPTIONS = new PlaceExceptions(PLACE_NO_ACCESS_ERROR);

    public PlaceExceptions(PlaceError error) {
        super(error);
    }

    public static PlaceExceptions userNotFound() {
        return USER_NOT_FOUND;
    }

    public static PlaceExceptions notFoundPlace() {
        return PLACE_NOT_FOUND_EXCEPTION;
    }

    public static PlaceExceptions placeNoAccessError() {
        return PLACE_EXCEPTIONS;
    }
}
