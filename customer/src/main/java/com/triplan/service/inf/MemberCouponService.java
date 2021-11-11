package com.triplan.service.inf;

import com.triplan.dto.MemberCouponDTO;

public interface MemberCouponService {

    void insert(MemberCouponDTO memberCouponDTO);

    MemberCouponDTO select(Integer memberCouponId);

    void update(Integer memberCouponId, MemberCouponDTO memberCouponDTO);

    void delete(Integer memberCouponId);
}
