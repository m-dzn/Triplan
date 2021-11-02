package com.triplan.controller;

import com.triplan.domain.SellerVO;
import com.triplan.mapper.SellerMapper;
import com.triplan.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/Seller")
@RequiredArgsConstructor
public class SellerController {
    private final SellerService sellerService;

    @PostMapping("/insert")
    public String insert(@RequestBody SellerVO sellerVO){
        sellerService.insertSeller(sellerVO);
        return "정보 입력 완료";
    }

    @GetMapping("/{sellerId}")
    public SellerVO read(@PathVariable int sellerId) {
        SellerVO result = sellerService.readSeller(sellerId);
        return result;
    }

    @PutMapping("/{sellerId}")
    public String update(@PathVariable int sellerId, @RequestBody SellerVO sellerVO) {
        sellerService.update(sellerId,sellerVO);
        return "정보 수정 완료";
    }

    @DeleteMapping("/{sellerId}")
    public String delete(@PathVariable int sellerId){
        sellerService.delete(sellerId);
        return "정보 삭제 완료";
    }














}
