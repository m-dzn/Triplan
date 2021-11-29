package com.triplan.service.inf;

import com.triplan.dto.response.customer.MemberCouponDTO;

import java.util.List;

public interface MemberCouponService {

    void insert(MemberCouponDTO memberCouponDTO);

    MemberCouponDTO select(Integer memberCouponId, Integer memberId);

    void update(Integer memberCouponId, MemberCouponDTO memberCouponDTO);

    void delete(Integer memberCouponId, Integer memberId);

    Integer getCoupon(Integer memberId, Integer couponId);

    Integer getCouponByNum(Integer memberId, Integer num);

    List<MemberCouponDTO> myCouponList(Integer memberId);

    List<MemberCouponDTO> myAvailableCouponList(Integer memberId);

    List<MemberCouponDTO> myUsedCouponList(Integer memberId);

    List<MemberCouponDTO> myUnavailableCouponList(Integer memberId);
}
