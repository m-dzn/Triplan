package com.triplan.mapper;

import com.triplan.domain.CouponVO;
import com.triplan.dto.CouponDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CouponMapper {

    void insert(CouponVO couponVO);

    CouponVO select(Integer couponId);

    void update(CouponDTO couponDTO);

    void delete(Integer couponId);

}
