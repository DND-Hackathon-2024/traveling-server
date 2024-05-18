package com.plass.traveling.domain.trap.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plass.traveling.domain.coupon.entity.CouponEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "trap")
public class Trap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
        장소 이름
    */
    @Column(nullable = false)
    private String placeName;

    /*
        장소 설명
    */
    @Column(nullable = false)
    private String placeDesc;

    /*
        장소 주소
    */
    @Column(nullable = false)
    private String address;

    /*
        장소 이미지
    */
    @Column(nullable = false)
    private String imgUrl;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "coupon_id")
    private CouponEntity couponId;

    @Builder
    public Trap(Long id,
                String placeName,
                String placeDesc,
                String address,
                CouponEntity couponId,
                String imgUrl) {
        this.id = id;
        this.placeName = placeName;
        this.placeDesc = placeDesc;
        this.address = address;
        this.couponId = couponId;
        this.imgUrl = imgUrl;
    }
}

