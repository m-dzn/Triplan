package com.triplan.controller;

import com.triplan.domain.PaymentVO;
import com.triplan.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments") // localhost:8081/payments/1 GET
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public String create(@RequestBody PaymentVO paymentVO){
        paymentService.create(paymentVO);
        return "결제정보입력";
    }

    @GetMapping("/{paymentId}")
    public PaymentVO read(@PathVariable int paymentId){
        return paymentService.read(paymentId);
    }

    @PutMapping("/{paymentId}")
    public String update(@PathVariable int paymentId, @RequestBody PaymentVO paymentVO){
        paymentService.update(paymentId, paymentVO);
        return "결제정보수정";
    }

    @DeleteMapping("/{paymentId}")
    public String delete(@PathVariable int paymentId){
        paymentService.delete(paymentId);
        return "결제정보삭제";
    }

}
