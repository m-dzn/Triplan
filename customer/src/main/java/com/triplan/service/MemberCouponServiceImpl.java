package com.triplan.service;

import com.triplan.domain.MemberCouponVO;
import com.triplan.dto.MemberCouponDTO;
import com.triplan.mapper.MemberCouponMapper;
import com.triplan.service.inf.MemberCouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberCouponServiceImpl implements MemberCouponService {

    private final MemberCouponMapper memberCouponMapper;

    @Override
    public void insert(MemberCouponDTO memberCouponDTO) {
        MemberCouponVO memberCouponVO = memberCouponDTO.toVO();
        memberCouponMapper.insert(memberCouponVO);
    }

    @Override
    public MemberCouponDTO select(Integer memberCouponId) {
        MemberCouponVO memberCouponVO = memberCouponMapper.select(memberCouponId);
        return MemberCouponDTO.of(memberCouponVO);
    }

    @Override
    public void update(Integer memberCouponId, MemberCouponDTO memberCouponDTO) {
        memberCouponDTO.setMemberCouponId(memberCouponId);
        memberCouponMapper.update(memberCouponDTO);
    }

    @Override
    public void delete(Integer memberCouponId) {
        memberCouponMapper.delete(memberCouponId);
    }
}
