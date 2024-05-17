package com.plass.traveling.domain.coupon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class CouponEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String couponName;

    private String couponDescription;

    private String couponLocation;

    private String couponDiscount;

    private String couponCreateUserName;

    @Builder
    public CouponEntity(String code, String couponName, String couponDescription, String couponLocation, String couponDiscount, String couponCreateUserName) {
        this.code = code;
        this.couponName = couponName;
        this.couponDescription = couponDescription;
        this.couponLocation = couponLocation;
        this.couponDiscount = couponDiscount;
        this.couponCreateUserName = couponCreateUserName;
    }

}
