package com.triplan.mapper;

import com.triplan.domain.CouponVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CouponMapper {

    void insert(CouponVO couponVO);

    CouponVO select(Integer couponId);

    void update(CouponVO couponVO);

    void delete(Integer couponId);

}
