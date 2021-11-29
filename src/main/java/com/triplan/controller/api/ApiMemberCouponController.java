package com.triplan.controller.api;

import com.triplan.dto.response.customer.MemberCouponDTO;
import com.triplan.security.CurrentMember;
import com.triplan.security.MemberPrincipal;
import com.triplan.service.inf.MemberCouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/membercoupons")
@RequiredArgsConstructor
public class ApiMemberCouponController {

    private final MemberCouponService memberCouponService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String insert(@Valid @RequestBody MemberCouponDTO memberCouponDTO) {
        memberCouponService.insert(memberCouponDTO);
        return "memberCouponCreated";
    }

    @GetMapping("/{memberCouponId}")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public MemberCouponDTO select(
            @PathVariable Integer memberCouponId,
            @CurrentMember MemberPrincipal currentMember
    ) {
        Integer memberId = currentMember.getMemberId();
        return memberCouponService.select(memberCouponId, memberId);
    }

    @PutMapping("/{memberCouponId}")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String update(@PathVariable Integer memberCouponId, @Valid @RequestBody MemberCouponDTO memberCouponDTO) {
        memberCouponService.update(memberCouponId, memberCouponDTO);
        return "memberCouponUpdated";
    }

    @DeleteMapping("/{memberCouponId}")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String delete(
            @PathVariable Integer memberCouponId,
            @CurrentMember MemberPrincipal currentMember
    ) {
        Integer memberId = currentMember.getMemberId();
        memberCouponService.delete(memberCouponId, memberId);
        return "memberCouponDeleted";
    }

    // 회원 쿠폰 등록 A - 이벤트 페이지 쿠폰 버튼 클릭
    @PostMapping("/getcoupon/{couponId}")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public Integer getCoupon(@PathVariable Integer couponId, @CurrentMember MemberPrincipal currentMember) {
        Integer memberId = currentMember.getMemberId();
        Integer result = memberCouponService.getCoupon(memberId, couponId);
        // -2(쿠폰 중복으로 인한 발급 실패), -1(발급 실패), 0(쿠폰 미존재, 유효기간 경과로 인한 발급 실패), 1(정상 발급)
        return result;
    }

    // 회원 쿠폰 등록 B - 회원이 직접 쿠폰 번호 입력
    @PostMapping("/getcouponbynum/{num}")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public Integer getCouponByNum(@PathVariable Integer num, @CurrentMember MemberPrincipal currentMember) {
        Integer memberId = currentMember.getMemberId();
        Integer result = memberCouponService.getCouponByNum(memberId, num);
        // -2(쿠폰 중복으로 인한 발급 실패), -1(발급 실패), 0(쿠폰 미존재, 유효기간 경과로 인한 발급 실패), 1(정상 발급)
        return result;
    }

    // 나의 쿠폰 조회 A - 전체
    @GetMapping("/mycouponlist")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public List<MemberCouponDTO> myCouponList(@CurrentMember MemberPrincipal currentMember) {
        Integer memberId = currentMember.getMemberId();
        return memberCouponService.myCouponList(memberId);
    }

    // 나의 쿠폰 조회 B - 사용 가능
    @GetMapping("/myavailablecouponlist")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public List<MemberCouponDTO> myAvailableCouponList(@CurrentMember MemberPrincipal currentMember) {
        Integer memberId = currentMember.getMemberId();
        return memberCouponService.myAvailableCouponList(memberId);
    }

    // 나의 쿠폰 조회 C - 사용한 쿠폰
    @GetMapping("/myusedcouponlist")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public List<MemberCouponDTO> myUsedCouponList(@CurrentMember MemberPrincipal currentMember) {
        Integer memberId = currentMember.getMemberId();
        return memberCouponService.myUsedCouponList(memberId);
    }

    // 나의 쿠폰 조회 D - 기한 지난 쿠폰
    @GetMapping("/myunavailablecouponlist")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public List<MemberCouponDTO> myUnavailableCouponList(@CurrentMember MemberPrincipal currentMember) {
        Integer memberId = currentMember.getMemberId();
        return memberCouponService.myUnavailableCouponList(memberId);
    }

}
