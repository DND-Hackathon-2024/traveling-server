package com.plass.traveling.domain.place.service;

import com.plass.traveling.domain.place.entity.Place;
import com.plass.traveling.domain.place.payload.request.CreatePlaceRequest;
import com.plass.traveling.domain.place.payload.request.PlaceDto;
import com.plass.traveling.global.common.BaseResponse;

public interface PlaceService {
    BaseResponse findAll();

    default PlaceDto entityToDto(Place entity){
        return PlaceDto.builder()
                .id(entity.getId())
                .placeName((entity.getPlaceName()))
                .placeDesc(entity.getPlaceDesc())
                .address(entity.getAddress())
                .couponId(entity.getCouponId())
                .imgUrl(entity.getImgUrl())
                .build();
    }

    default Place dtoToEntity(CreatePlaceRequest createPlaceRequest,
                              String placeName,
                              String placeDecs,
                              String address,
                              String couponId,
                              Long imgUrl){
        return Place.builder()
                .placeName(createPlaceRequest.placeName())
                .placeDesc(createPlaceRequest.placeDesc())
                .address(createPlaceRequest.address())
                .couponId(createPlaceRequest.couponId())
                .imgUrl(createPlaceRequest.imgUrl())
                .build();
    }
}