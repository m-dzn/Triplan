package com.triplan.controller.api;

import com.triplan.dto.MemberCouponDTO;
import com.triplan.service.inf.MemberCouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/membercoupons")
@RequiredArgsConstructor
public class ApiMemberCouponController {

    private final MemberCouponService memberCouponService;

    @PostMapping
    public String insert(@RequestBody MemberCouponDTO memberCouponDTO) {
        memberCouponService.insert(memberCouponDTO);
        return "멤버 쿠폰 insert 성공";
    }

    @GetMapping("/{memberCouponId}")
    public MemberCouponDTO select(@PathVariable Integer memberCouponId) {
        return memberCouponService.select(memberCouponId);
    }

    @PutMapping("/{memberCouponId}")
    public String update(@PathVariable Integer memberCouponId, @RequestBody MemberCouponDTO memberCouponDTO) {
        memberCouponService.update(memberCouponId, memberCouponDTO);
        return "멤버 쿠폰 update 성공";
    }

    @DeleteMapping("/{memberCouponId}")
    public String delete(@PathVariable Integer memberCouponId) {
        memberCouponService.delete(memberCouponId);
        return "멤버 쿠폰 delete 성공";
    }


}
