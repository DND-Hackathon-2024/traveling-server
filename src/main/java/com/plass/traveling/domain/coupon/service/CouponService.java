package com.plass.traveling.domain.coupon.service;

import com.plass.traveling.domain.coupon.dto.req.CouponRequest;
import com.plass.traveling.domain.coupon.dto.res.CouponResponse;
import com.plass.traveling.domain.coupon.entity.CouponEntity;
import com.plass.traveling.global.common.BaseResponse;

public interface CouponService {
    BaseResponse createCoupon(CouponRequest couponRequest, Long userId);


    default CouponEntity couponReqToEntity(CouponRequest couponRequest, Long userId, String code) {
        return CouponEntity.builder()
                .couponName(couponRequest.couponName())
                .couponDiscount(couponRequest.couponDiscount())
                .build();
    }

    default CouponResponse couponEntityToResponse(CouponEntity couponEntity) {
        return CouponResponse.builder()
                .couponId(couponEntity.getId())
                .code(couponEntity.getCode())
                .couponName(couponEntity.getCouponName())
                .couponDiscount(couponEntity.getCouponDiscount())
                .couponCreateUserName(couponEntity.getCouponCreateUserName())
                .build();
    }
}
