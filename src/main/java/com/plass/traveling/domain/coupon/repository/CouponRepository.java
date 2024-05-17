package com.plass.traveling.domain.coupon.repository;

import com.plass.traveling.domain.coupon.entity.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<CouponEntity, Long> {
}
