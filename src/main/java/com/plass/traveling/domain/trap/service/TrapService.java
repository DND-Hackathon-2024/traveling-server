package com.plass.traveling.domain.trap.service;

import com.plass.traveling.domain.trap.entity.Trap;
import com.plass.traveling.domain.trap.payload.request.CreateTrapRequest;
import com.plass.traveling.global.common.BaseResponse;

public interface TrapService {
    BaseResponse findAll();

    BaseResponse trapCreate(CreateTrapRequest createTrapRequest);

    BaseResponse trapDelete(Long placeId);

    default Trap dtoToEntity(CreateTrapRequest createTrapRequest){
        return Trap.builder()
                .placeName(createTrapRequest.placeName())
                .placeDesc(createTrapRequest.placeDesc())
                .address(createTrapRequest.address())
                .couponId(createTrapRequest.couponId())
                .imgUrl(createTrapRequest.imgUrl())
                .build();
    }
}