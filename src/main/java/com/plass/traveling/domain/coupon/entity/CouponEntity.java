package com.plass.traveling.domain.coupon.entity;

import com.plass.traveling.domain.member.entity.MemberEntity;
import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @Builder
    public CouponEntity(String code, String couponName, String couponDescription, String couponLocation, String couponDiscount, String couponCreateUserName) {
        this.code = code;
        this.couponName = couponName;
        this.couponDescription = couponDescription;
        this.couponLocation = couponLocation;
        this.couponDiscount = couponDiscount;
        this.couponCreateUserName = couponCreateUserName;
    }

    public void addMember(MemberEntity member){
        this.member = member;
    }

}
