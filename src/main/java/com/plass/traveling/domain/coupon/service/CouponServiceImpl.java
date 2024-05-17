package com.plass.traveling.domain.coupon.service;

import com.plass.traveling.domain.coupon.dto.req.CouponRequest;
import com.plass.traveling.domain.coupon.entity.CouponEntity;
import com.plass.traveling.domain.coupon.repository.CouponRepository;
import com.plass.traveling.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService{

    private final CouponRepository couponRepository;

    private String createCode(){
        Random rnd = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            code.append(rnd.nextInt(10));
        }
        return code.toString();
    }


    @Override
    public BaseResponse createCoupon(CouponRequest couponRequest, Long userId) {

        CouponEntity couponEntity = couponReqToEntity(couponRequest, userId, createCode());

        return new BaseResponse(
                HttpStatus.CREATED,
                "쿠폰 생성 성공",
                couponEntityToResponse(couponRepository.save(couponEntity))
        );
    }
}
