package com.plass.traveling.domain.coupon.service;

import com.plass.traveling.domain.coupon.dto.req.CouponRequest;
import com.plass.traveling.domain.coupon.dto.res.CouponResponse;
import com.plass.traveling.domain.coupon.entity.CouponEntity;
import com.plass.traveling.global.common.BaseResponse;

public interface CouponService {
    BaseResponse createCoupon(CouponRequest couponRequest, Long userId);

    BaseResponse getCouponInfo(Long couponId);

    BaseResponse getCouponByLocation(String location, Long userId);

    BaseResponse addCoupon(Long userId, Long couponId);

    BaseResponse getAllCoupon(Long userId);


    default CouponEntity couponReqToEntity(CouponRequest couponRequest, Long userId, String code) {
        return CouponEntity.builder()
                .code(code)
                .couponName(couponRequest.couponName())
                .couponDescription(couponRequest.description())
                .couponLocation(couponRequest.location())
                .couponDiscount(couponRequest.couponDiscount())
                .couponCreateUserName(userId.toString())
                .build();
    }

    default CouponResponse couponEntityToResponse(CouponEntity couponEntity) {
        return CouponResponse.builder()
                .couponId(couponEntity.getId())
                .code(couponEntity.getCode())
                .couponName(couponEntity.getCouponName())
                .description(couponEntity.getCouponDescription())
                .location(couponEntity.getCouponLocation())
                .couponDiscount(couponEntity.getCouponDiscount())
                .couponCreateUserName(couponEntity.getCouponCreateUserName())
                .build();
    }
}
