package com.triplan.service;

import com.triplan.domain.CouponVO;
import com.triplan.mapper.CouponMapper;
import com.triplan.service.inf.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {

    private final CouponMapper couponMapper;

    @Override
    public void insert(CouponVO couponVO) {
        couponMapper.insert(couponVO);
    }

    @Override
    public CouponVO select(Integer couponId) {
        return couponMapper.select(couponId);
    }

    @Override
    public void update(CouponVO couponVO) {
        couponMapper.update(couponVO);
    }

    @Override
    public void delete(Integer couponId) {
        couponMapper.delete(couponId);
    }

}
