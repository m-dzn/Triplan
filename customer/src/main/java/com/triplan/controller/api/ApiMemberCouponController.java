package com.triplan.controller.api;

import com.triplan.dto.MemberCouponDTO;
import com.triplan.service.inf.MemberCouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/membercoupons")
@RequiredArgsConstructor
public class ApiMemberCouponController {

    private final MemberCouponService memberCouponService;

    @PostMapping
    public String insert(@Valid @RequestBody MemberCouponDTO memberCouponDTO) {
        memberCouponService.insert(memberCouponDTO);
        return "memberCouponCreated";
    }

    @GetMapping("/{memberCouponId}")
    public MemberCouponDTO select(@PathVariable Integer memberCouponId) {
        return memberCouponService.select(memberCouponId);
    }

    @PutMapping("/{memberCouponId}")
    public String update(@PathVariable Integer memberCouponId, @Valid @RequestBody MemberCouponDTO memberCouponDTO) {
        memberCouponService.update(memberCouponId, memberCouponDTO);
        return "memberCouponUpdated";
    }

    @DeleteMapping("/{memberCouponId}")
    public String delete(@PathVariable Integer memberCouponId) {
        memberCouponService.delete(memberCouponId);
        return "memberCouponDeleted";
    }

    // 회원 쿠폰 등록 A - 이벤트 페이지 쿠폰 버튼 클릭
    @PostMapping("/getcoupon/{memberId}/{couponId}")
    public Integer getCoupon(@PathVariable Integer memberId, @PathVariable Integer couponId) {
        Integer result = memberCouponService.getCoupon(memberId, couponId);
        // -2(쿠폰 중복으로 인한 발급 실패), -1(발급 실패), 0(쿠폰 미존재, 유효기간 경과로 인한 발급 실패), 1(정상 발급)
        return result;
    }

    // 회원 쿠폰 등록 B - 회원이 직접 쿠폰 번호 입력
    @PostMapping("/getcouponbynum/{memberId}/{num}")
    public Integer getCouponByNum(@PathVariable Integer memberId, @PathVariable Integer num) {
        Integer result = memberCouponService.getCouponByNum(memberId, num);
        // -2(쿠폰 중복으로 인한 발급 실패), -1(발급 실패), 0(쿠폰 미존재, 유효기간 경과로 인한 발급 실패), 1(정상 발급)
        return result;
    }


    // 나의 쿠폰 조회 A - 전체
    @GetMapping("/mycouponlist/{memberId}")
    public List<MemberCouponDTO> myCouponList(@PathVariable Integer memberId) {
        return memberCouponService.myCouponList(memberId);
    }

    // 나의 쿠폰 조회 B - 사용 가능
    @GetMapping("/myavailablecouponlist/{memberId}")
    public List<MemberCouponDTO> myAvailableCouponList(@PathVariable Integer memberId) {
        return memberCouponService.myAvailableCouponList(memberId);
    }

    // 나의 쿠폰 조회 C - 사용한 쿠폰
    @GetMapping("/myusedcouponlist/{memberId}")
    public List<MemberCouponDTO> myUsedCouponList(@PathVariable Integer memberId) {
        return memberCouponService.myUsedCouponList(memberId);
    }

    // 나의 쿠폰 조회 D - 기한 지난 쿠폰
    @GetMapping("/myunavailablecouponlist/{memberId}")
    public List<MemberCouponDTO> myUnavailableCouponList(@PathVariable Integer memberId) {
        return memberCouponService.myUnavailableCouponList(memberId);
    }
}
