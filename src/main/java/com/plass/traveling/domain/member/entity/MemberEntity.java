package com.plass.traveling.domain.member.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plass.traveling.domain.coupon.entity.CouponEntity;
import com.plass.traveling.domain.member.enums.MemberRoles;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String phone; // 아이디

    private String password; // 비밀번호

    @Enumerated(EnumType.STRING)
    private MemberRoles role;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<CouponEntity> coupons;

    @Builder
    public MemberEntity (
            String phone,
            String password,
            MemberRoles role
    ) {
        this.phone = phone;
        this.password = password;
        this.role = role;
    }

    public void addCoupon(CouponEntity couponEntity){
        coupons.add(couponEntity);
    }

}
