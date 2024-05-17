package com.plass.traveling.domain.coupon.service;

import com.plass.traveling.domain.coupon.dto.req.CouponRequest;
import com.plass.traveling.domain.coupon.dto.res.CouponResponse;
import com.plass.traveling.domain.coupon.entity.CouponEntity;
import com.plass.traveling.domain.coupon.repository.CouponRepository;
import com.plass.traveling.domain.member.entity.MemberEntity;
import com.plass.traveling.domain.member.repository.MemberRepository;
import com.plass.traveling.global.common.BaseResponse;
import com.plass.traveling.global.exception.CustomException;
import com.plass.traveling.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService{

    private final CouponRepository couponRepository;
    private final MemberRepository memberRepository;

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

    @Override
    public BaseResponse getCouponInfo(Long couponId) {

        return new BaseResponse(
                HttpStatus.OK,
                "쿠폰 조회 성공",
                couponEntityToResponse(couponRepository.findById(couponId).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND)))
        );
    }

    @Override
    public BaseResponse getCouponByLocation(String location, Long userId) {

        MemberEntity member = memberRepository.findById(userId).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND));
        List<CouponEntity> couponEntities = member.getCoupons()
                .stream()
                .filter(coupon -> coupon.getCouponLocation().contains(location))
                .toList();


        return new BaseResponse(
                HttpStatus.OK,
                "지역위치 기반으로 쿠폰조회 성공",
                couponEntities.stream().map(
                        this::couponEntityToResponse
                ).toList()
        );
    }

    @Override
    public BaseResponse addCoupon(Long userId, Long couponId) {
        CouponEntity couponEntity = couponRepository.findById(couponId).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND));
        MemberEntity member = memberRepository.findById(userId).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND));
        member.addCoupon(couponEntity);
        couponEntity.addMember(member);
        memberRepository.save(member);

        return new BaseResponse(
                HttpStatus.OK,
                "쿠폰추가성공"
        );
    }

    @Override
    public BaseResponse getAllCoupon(Long userId) {
        ;
        return new BaseResponse(
                HttpStatus.OK,
                "모든쿠폰불러오기성공",
                memberRepository.findById(userId).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND)).getCoupons().stream().map(this::couponEntityToResponse).toList()

        );
    }


}
