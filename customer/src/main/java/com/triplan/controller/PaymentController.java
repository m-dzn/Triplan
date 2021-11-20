package com.triplan.controller;

import com.triplan.domain.PaymentVO;
import com.triplan.domain.ReservationVO;
import com.triplan.dto.MemberCouponDTO;
import com.triplan.dto.ReservationDTO;
import com.triplan.service.inf.PaymentService;
import com.triplan.service.inf.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller()
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private final ReservationService reservationService;


//    @GetMapping("pay/payInfo/{paymentId}/{itemId}")
//    public String paymentCheck(@PathVariable("paymentId") Integer paymentId, @PathVariable("itemId") Integer itemId, Model model) {
//        PaymentVO paymentVO = paymentService.read(paymentId); // 결제테이블 정보
//        ReservationDTO reservationDTO = reservationService.select(paymentVO.getResId()); // 예약테이블 정보
//        String name = paymentService.readNameByItem(itemId); // 상품이름
//        model.addAttribute("payment" , paymentVO);
//        model.addAttribute("reservation", reservationDTO);
//        model.addAttribute("itemName", name);
//        return "payAfter";
//    }

}
