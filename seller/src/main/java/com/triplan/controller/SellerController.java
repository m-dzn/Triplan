package com.triplan.controller;

import com.triplan.dto.SellerDTO;
import com.triplan.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sellers")
@RequiredArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    @PostMapping
    public String register(@RequestBody SellerDTO sellerDTO) {
        sellerService.register(sellerDTO);
        return "판매자 추가 성공";
    }

    @GetMapping("/{sellerId}")
    public SellerDTO getSeller(@PathVariable Long sellerId) {
        return sellerService.getSeller(sellerId);
    }

    @PutMapping("/{sellerId}")
    public String update(@PathVariable Long sellerId, @RequestBody SellerDTO sellerDTO) {
        sellerService.update(sellerId, sellerDTO);
        return "판매자 수정 성공";
    }

    @DeleteMapping("/{sellerId}")
    public String delete(@PathVariable Long sellerId) {
        sellerService.delete(sellerId);
        return "판매자 삭제 성공";
    }

}