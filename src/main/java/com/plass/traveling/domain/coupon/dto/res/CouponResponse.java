package com.plass.traveling.domain.coupon.dto.res;

import lombok.Builder;

@Builder
public record CouponResponse(
        Long couponId,
        String code,
        String couponName,
        String description,
        String location,
        String couponDiscount,
        String couponCreateUserName
) {
}
