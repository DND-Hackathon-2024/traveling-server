package com.plass.traveling.domain.place.service;

import com.plass.traveling.domain.place.entity.Place;
import com.plass.traveling.domain.place.payload.request.CreatePlaceRequest;
import com.plass.traveling.global.common.BaseResponse;

public interface PlaceService {
    BaseResponse findAll();

    BaseResponse placeCreate(CreatePlaceRequest placeCreateRequest);

    BaseResponse placeDelete(Long placeId);

    default Place dtoToEntity(CreatePlaceRequest createPlaceRequest){
        return Place.builder()
                .placeName(createPlaceRequest.placeName())
                .placeDesc(createPlaceRequest.placeDesc())
                .address(createPlaceRequest.address())
                .couponId(createPlaceRequest.couponId())
                .imgUrl(createPlaceRequest.imgUrl())
                .build();
    }
}