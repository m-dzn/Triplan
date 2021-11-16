package com.triplan.controller.api;

import com.triplan.domain.PaymentVO;
import com.triplan.service.inf.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/paymentInfo")
    public String paymentCheck(@RequestParam("paymentId") String paymentId) {
        paymentService.read(Integer.parseInt(paymentId));
        return "payment";
    }
}
