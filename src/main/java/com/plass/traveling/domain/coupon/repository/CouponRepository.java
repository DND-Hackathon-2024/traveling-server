package com.plass.traveling.domain.coupon.repository;

import com.plass.traveling.domain.coupon.entity.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CouponRepository extends JpaRepository<CouponEntity, Long> {
    public List<CouponEntity> findByCouponLocation(String couponLocation);
}
