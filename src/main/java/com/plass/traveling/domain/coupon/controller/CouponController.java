package com.plass.traveling.domain.coupon.controller;

import com.plass.traveling.domain.coupon.dto.req.CouponRequest;
import com.plass.traveling.domain.coupon.service.CouponService;
import com.plass.traveling.global.common.BaseResponse;
import com.plass.traveling.global.common.annotation.GetAuthenticatedId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupon")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @PostMapping
    public BaseResponse createCoupon(
            @RequestBody CouponRequest couponRequest,
            @GetAuthenticatedId Long userId
    ) {
        return couponService.createCoupon(couponRequest, userId);
    }

    @GetMapping("/{couponId}")
    public BaseResponse getCoupon(
            @PathVariable Long couponId
    ) {
        return couponService.getCouponInfo(couponId);
    }

    @GetMapping("/location/{location}")
    public BaseResponse getCouponByLocation(
            @PathVariable String location,
            @GetAuthenticatedId Long userId
    ) {
        return couponService.getCouponByLocation(location, userId);
    }

}
