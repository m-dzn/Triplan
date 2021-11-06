package com.triplan.controller;

import com.triplan.domain.SellerVO;
import com.triplan.service.SellerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sellers")
@RequiredArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    @PostMapping
    public String register(@RequestBody SellerVO sellerVO) {
        sellerService.register(sellerVO);
        return "판매자 추가 성공";
    }

    @GetMapping("/{sellerId}")
    public SellerVO getSeller(@PathVariable Integer sellerId) {
        return sellerService.getSeller(sellerId);
    }

    @PutMapping("/{sellerId}")
    public String update(@PathVariable Integer sellerId, @RequestBody SellerVO sellerVO) {
        sellerService.update(sellerId, sellerVO);
        return "판매자 수정 성공";
    }

    @DeleteMapping("/{sellerId}")
    public String delete(@PathVariable Integer sellerId) {
        sellerService.delete(sellerId);
        return "판매자 삭제 성공";
    }

}