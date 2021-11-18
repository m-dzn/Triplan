package com.triplan.controller.api;

import com.triplan.domain.PaymentVO;
import com.triplan.service.inf.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class ApiPaymentController {

    private final PaymentService paymentService;

    @PostMapping("/{memberId}")
    public Integer create(@RequestBody PaymentVO paymentVO, @PathVariable Integer memberId){
        paymentService.create(paymentVO, memberId);
        return paymentVO.getPaymentId();
    }

    @GetMapping("/{paymentId}")
    public PaymentVO read(@PathVariable Integer paymentId){
        return paymentService.read(paymentId);
    }

    @PutMapping("/{paymentId}")
    public String update(@PathVariable Integer paymentId, @RequestBody PaymentVO paymentVO){
        paymentService.update(paymentId, paymentVO);
        return "결제정보수정";
    }

    @DeleteMapping("/{paymentId}")
    public String delete(@PathVariable Integer paymentId){
        paymentService.delete(paymentId);
        return "결제정보삭제";
    }

}
