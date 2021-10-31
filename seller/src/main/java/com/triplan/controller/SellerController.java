package com.triplan.controller;

import com.triplan.dto.SellerDTO;
import com.triplan.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sellers")
@RequiredArgsConstructor
public class SellerController { // http://localhost:8181/members

    private final SellerService sellerService;

    // POST, GET, PUT (PATCH), DELETE
    @PostMapping // POST http://localhost:8181/members -> CREATE
    public String register(@RequestBody SellerDTO sellerDTO) { // HTTP Body 정보를 매핑
        sellerService.register(sellerDTO);
        return "멤버 추가 성공";
    }

    @GetMapping("/{sellerId}") // POST http://localhost:8181/members/1 -> READ
    public SellerDTO getSeller(@PathVariable Long sellerId) {
        return sellerService.getSeller(sellerId);
    }

    @PutMapping("/{sellerId}") // PUT http://localhost:8181/members/1 -> UPDATE
    public String update(@PathVariable Long sellerId, @RequestBody SellerDTO sellerDTO) {
        sellerService.update(sellerId, sellerDTO);
        return "멤버 수정 성공";
    }

    @DeleteMapping("/{sellerId}") // DELETE http://localhost:8181/members/1 -> DELETE
    public String delete(@PathVariable Long sellerId) {
        sellerService.delete(sellerId);
        return "멤버 삭제 성공";
    }

}