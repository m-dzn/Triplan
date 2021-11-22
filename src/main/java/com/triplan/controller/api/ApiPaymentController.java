package com.triplan.controller.api;

import com.triplan.domain.item.PaymentVO;
import com.triplan.security.CurrentMember;
import com.triplan.security.MemberPrincipal;
import com.triplan.service.inf.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class ApiPaymentController {

    private final PaymentService paymentService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public Integer create(@RequestBody PaymentVO paymentVO, @CurrentMember MemberPrincipal currentMember){
        Integer memberId = currentMember.getMemberId();
        paymentService.create(paymentVO, memberId);
        return paymentVO.getPaymentId();
    }

    @GetMapping("/{paymentId}")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public PaymentVO read(@PathVariable Integer paymentId, @CurrentMember MemberPrincipal currentMember){
        Integer memberId = currentMember.getMemberId();
        return paymentService.read(paymentId, memberId);
    }

    @PutMapping("/{paymentId}")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String update(
            @PathVariable Integer paymentId,
            @RequestBody PaymentVO paymentVO,
            @CurrentMember MemberPrincipal currentMember
    ){
        Integer memberId = currentMember.getMemberId();
        paymentService.update(paymentId, paymentVO, memberId);
        return "결제정보수정";
    }

    @DeleteMapping("/{paymentId}")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String delete(@PathVariable Integer paymentId, @CurrentMember MemberPrincipal currentMember){
        Integer memberId = currentMember.getMemberId();
        paymentService.delete(paymentId, memberId);
        return "결제정보삭제";
    }

}
