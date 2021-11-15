package com.triplan.service;

import com.triplan.domain.CouponVO;
import com.triplan.dto.CouponDTO;
import com.triplan.mapper.CouponMapper;
import com.triplan.service.inf.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {

    private final CouponMapper couponMapper;

    @Override
    public void insert(CouponDTO couponDTO) {
        CouponVO couponVO = couponDTO.toVO();
        couponMapper.insert(couponVO);
    }

    @Override
    public CouponDTO select(Integer couponId) {
        CouponVO couponVO = couponMapper.select(couponId);
        return CouponDTO.of(couponVO);
    }

    @Override
    public void update(Integer couponId, CouponDTO couponDTO) {
        couponDTO.setCouponId(couponId);
        couponMapper.update(couponDTO);
    }

    @Override
    public void delete(Integer couponId) {
        couponMapper.delete(couponId);
    }

}
