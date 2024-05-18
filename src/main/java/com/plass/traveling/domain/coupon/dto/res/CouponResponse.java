package com.plass.traveling.domain.coupon.dto.res;

import com.plass.traveling.domain.trap.entity.Trap;
import lombok.Builder;

import java.util.List;

@Builder
public record CouponResponse(
        Long id,
        String code,
        String couponName,
        String description,
        String location,
        String couponDiscount,
        String couponCreateUserName,
        List<Trap> trap
) {
}
