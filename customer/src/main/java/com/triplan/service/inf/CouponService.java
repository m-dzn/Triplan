package com.triplan.service.inf;

import com.triplan.domain.CouponVO;

public interface CouponService {
    
    void insert(CouponVO couponVO);

    CouponVO select(Integer couponId);

    void update(CouponVO couponVO);

    void delete(Integer couponId);
}
