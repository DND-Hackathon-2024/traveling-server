package com.plass.traveling.domain.coupon.dto.req;

public record CouponRequest(
        String couponName,
        String description,
        String location,
        String couponDiscount
) {
}
