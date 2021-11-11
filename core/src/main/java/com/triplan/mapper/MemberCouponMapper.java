package com.triplan.mapper;

import com.triplan.domain.MemberCouponVO;
import com.triplan.dto.MemberCouponDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberCouponMapper {

    void insert(MemberCouponVO memberCouponVO);

    MemberCouponVO select(Integer memberCouponId);

    void update(MemberCouponDTO memberCouponDTO);

    void delete(Integer memberCouponId);
}
