package com.triplan.service;

import com.triplan.domain.item.CouponVO;
import com.triplan.domain.member.MemberCouponVO;
import com.triplan.dto.response.customer.MemberCouponDTO;
import com.triplan.exception.AccessNotAllowedException;
import com.triplan.mapper.item.CouponMapper;
import com.triplan.mapper.member.MemberCouponMapper;
import com.triplan.service.inf.MemberCouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberCouponServiceImpl implements MemberCouponService {

    private final MemberCouponMapper memberCouponMapper;
    private final CouponMapper couponMapper;

    @Override
    public void insert(MemberCouponDTO memberCouponDTO) {
        MemberCouponVO memberCouponVO = memberCouponDTO.toVO();
        memberCouponMapper.insert(memberCouponVO);
    }

    @Override
    public MemberCouponDTO select(Integer memberCouponId, Integer memberId) {
        MemberCouponVO memberCouponVO = memberCouponMapper.select(memberCouponId);
        if (isMemberSame(memberCouponVO.getMemberId(), memberId)) {
            return MemberCouponDTO.of(memberCouponVO);
        }

        return null;
    }

    @Override
    public void update(Integer memberCouponId, MemberCouponDTO memberCouponDTO) {
        memberCouponDTO.setMemberCouponId(memberCouponId);
        memberCouponMapper.update(memberCouponDTO);
    }

    @Override
    public void delete(Integer memberCouponId, Integer memberId) {
        MemberCouponVO memberCouponVO = memberCouponMapper.select(memberCouponId);

        if (isMemberSame(memberCouponVO.getMemberId(), memberId)) {
            memberCouponMapper.delete(memberCouponId);
        }
    }

    @Override
    public Integer getCoupon(Integer memberId, Integer couponId) {
        Integer result = -1;
        CouponVO couponVO = couponMapper.select(couponId);
        if(couponVO == null){
            // 쿠폰 조회 불가 - 해당 쿠폰 없음
            result = 0;
        }else {
            // 쿠폰 조회 완료, 쿠폰 체크 후 발급
            result = memberCouponInsertAfterCheck(memberId, couponVO, couponId);
        }
        return result;
    }

    @Override
    public Integer getCouponByNum(Integer memberId, Integer num) {
        Integer result = -1;
        CouponVO couponVO = couponMapper.selectByNum(num);
        if(couponVO == null) {
            // num에 해당하는 쿠폰 정보 없음
            result = 0;
        }else {
            // 쿠폰 조회 완료, 쿠폰 체크 후 발급
            Integer couponId = couponVO.getCouponId();
            result = memberCouponInsertAfterCheck(memberId, couponVO, couponId);
        }
        return result;
    }

    @Override
    public List<MemberCouponDTO> myCouponList(Integer memberId) {
        return memberCouponMapper.myCouponList(memberId);
    }

    @Override
    public List<MemberCouponDTO> myAvailableCouponList(Integer memberId) {
        return memberCouponMapper.myAvailableCouponList(memberId);
    }

    @Override
    public List<MemberCouponDTO> myUsedCouponList(Integer memberId) {
        return memberCouponMapper.myUsedCouponList(memberId);
    }

    @Override
    public List<MemberCouponDTO> myUnavailableCouponList(Integer memberId) {
        return memberCouponMapper.myUnavailableCouponList(memberId);
    }

    private Integer memberCouponInsertAfterCheck(Integer memberId, CouponVO couponVO, Integer couponId) {
        Integer result;
        LocalDateTime expiredAt = couponVO.getExpiredAt();
        // 쿠폰 유효기간 체크
        if(expiredAt.isAfter(LocalDateTime.now())) {
            // 쿠폰 중복 검사
            if(memberCouponMapper.ownCoupon(couponId, memberId) == 0){
                MemberCouponVO memberCouponVO = new MemberCouponVO();
                memberCouponVO.setCouponId(couponId);
                memberCouponVO.setMemberId(memberId);
                memberCouponMapper.insert(memberCouponVO);
                result = 1;
            }else {
                // 쿠폰 중복 - 이미 가지고 있는 쿠폰
                result = -2;
            }
        }else {
            // 유효기간 경과
            result = 0;
        }
        return result;
    }

    private boolean isMemberSame(Integer dbMemberId, Integer memberId) {
        try {
            if (memberId.equals(dbMemberId)) {
                return true;
            } else {
                throw new AccessNotAllowedException();
            }
        } catch (AccessNotAllowedException e) {
            e.printStackTrace();
        }
        return false;
    }

}
