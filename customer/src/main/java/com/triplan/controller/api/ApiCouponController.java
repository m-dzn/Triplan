package com.triplan.controller.api;

import com.triplan.domain.CouponVO;
import com.triplan.service.inf.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coupons")
@RequiredArgsConstructor
public class ApiCouponController {

    private final CouponService couponService;

    @PostMapping
    public String insert(@RequestBody CouponVO couponVO) {
        couponService.insert(couponVO);
        return "쿠폰 insert 성공";
    }

    @GetMapping("/{couponId}")
    public CouponVO select(@PathVariable Integer couponId) {
        return couponService.select(couponId);
    }

    @PutMapping("/{couponId}")
    public String update(@PathVariable Integer couponId, @RequestBody CouponVO couponVO) {
        couponVO.setCouponId(couponId);
        couponService.update(couponVO);
        return "쿠폰 update 성공";
    }

    @DeleteMapping("/{couponId}")
    public String roomDelete(@PathVariable Integer couponId) {
        couponService.delete(couponId);
        return "쿠폰 delete 성공";
    }

}
