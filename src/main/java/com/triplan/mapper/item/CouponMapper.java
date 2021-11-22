package com.triplan.mapper.item;

import com.triplan.domain.item.CouponVO;
import com.triplan.dto.response.customer.CouponDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CouponMapper {

    void insert(CouponVO couponVO);

    CouponVO select(Integer couponId);

    void update(CouponDTO couponDTO);

    void delete(Integer couponId);

    CouponVO selectByNum(Integer num);

}
