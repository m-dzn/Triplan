package com.triplan.controller.api;

import com.triplan.dto.CouponDTO;
import com.triplan.service.inf.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coupons")
@RequiredArgsConstructor
public class ApiCouponController {

    private final CouponService couponService;

    @PostMapping
    public String insert(@RequestBody CouponDTO couponDTO) {
        couponService.insert(couponDTO);
        return "쿠폰 insert 성공";
    }

    @GetMapping("/{couponId}")
    public CouponDTO select(@PathVariable Integer couponId) {
        return couponService.select(couponId);
    }

    @PutMapping("/{couponId}")
    public String update(@PathVariable Integer couponId, @RequestBody CouponDTO couponDTO) {
        couponService.update(couponId, couponDTO);
        return "쿠폰 update 성공";
    }

    @DeleteMapping("/{couponId}")
    public String roomDelete(@PathVariable Integer couponId) {
        couponService.delete(couponId);
        return "쿠폰 delete 성공";
    }

}
