package com.plass.traveling.domain.trap.payload.request;

public record CreateTrapRequest(
        Long id,
        String placeName,
        String placeDesc,
        String address,
        Long couponId,
        String imgUrl) {
}
