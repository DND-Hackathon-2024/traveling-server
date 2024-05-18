package com.plass.traveling.domain.trap.service;

import com.plass.traveling.domain.coupon.entity.CouponEntity;
import com.plass.traveling.domain.trap.entity.Trap;
import com.plass.traveling.domain.trap.payload.request.CreateTrapRequest;
import com.plass.traveling.global.common.BaseResponse;

public interface TrapService {
    BaseResponse findAll();

    BaseResponse trapCreate(CreateTrapRequest createTrapRequest);

    BaseResponse trapDelete(Long placeId);
    
    BaseResponse getTrap(Long trapId);

    default Trap dtoToEntity(CreateTrapRequest createTrapRequest, CouponEntity couponEntity){
        return Trap.builder()
                .placeName(createTrapRequest.placeName())
                .placeDesc(createTrapRequest.placeDesc())
                .address(createTrapRequest.address())
                .couponId(couponEntity)
                .imgUrl(createTrapRequest.imgUrl())
                .build();
    }
}