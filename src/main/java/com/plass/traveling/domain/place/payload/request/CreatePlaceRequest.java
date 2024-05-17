package com.plass.traveling.domain.place.payload.request;

public record CreatePlaceRequest(
        Long id,
        String placeName,
        String placeDesc,
        String address,
        Long couponId,
        String imgUrl) {
}
