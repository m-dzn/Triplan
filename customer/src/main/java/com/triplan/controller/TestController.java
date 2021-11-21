//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.triplan.controller;

import com.triplan.domain.ItemGroupVO;
import com.triplan.domain.PaymentVO;
import com.triplan.dto.MemberCouponDTO;
import com.triplan.dto.ReservationDTO;
import com.triplan.dto.customer.response.ItemRoomResponseDTO;
import com.triplan.enumclass.ItemCategory;
import com.triplan.service.inf.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestController {


    private final MemberCouponService memberCouponService;
    private final ItemGroupService itemGroupService;
    private final ItemService itemService;
    private final PaymentService paymentService;
    private final ReservationService reservationService;

    @GetMapping({"/warning"})
    public String warning() {
        return "warning";
    }

    @GetMapping({"/main"})
    public String main() {
        return "main";
    }

    @GetMapping({"/mypagemember"})
    public String mypage() {
        return "mypage_modify";
    }

    @GetMapping({"/mypagecoupon"})
    public String mypagecoupon() { return "mypage_coupon"; }

    @GetMapping({"/mypagecoupondisabled"})
    public String mypagecoupondisabled() { return "mypage_coupon_disabled"; }

    @GetMapping({"/mypagecouponexpired"})
    public String mypagecouponexpired() { return "mypage_coupon_expired"; }

    @GetMapping({"/login"})
    public String login() {
        return "login";
    }

    @GetMapping({"/join"})
    public String join() {
        return "join";
    }

    @GetMapping({"/pay"}) // 예약/결제창
    public String pay(Model model,
                      @RequestParam Integer itemGroupId,
                      @RequestParam Integer itemId,
                      @RequestParam String startDate,
                      @RequestParam String endDate
                      ) {
    // URL로 받아올거 : memberId, sellerId, itemId, itemGroupId, startDate, endDate
    // 프론트로 넘겨줄거 :  쿠폰목록, 아이템그룹정보, 아이템정보, 상품 시작/종료기간, memberId, sellerId
        Integer memberId = 1;
        Integer sellerId = itemGroupService.getItemGroup(itemGroupId).getSellerId();

        // 내 쿠폰 목록 - 쿠폰id, 쿠폰명, 할인금액
        List<MemberCouponDTO> couponList = memberCouponService.myAvailableCouponList(memberId);
        model.addAttribute("couponList", couponList);
        // 아이템 그륩 정보 - 상품그룹명
        ItemGroupVO itemGroupVO = itemGroupService.getItemGroup(itemGroupId);
        model.addAttribute("itemGroup", itemGroupVO);
        // 아이템 정보 - 상품명
        ItemRoomResponseDTO itemRoomResponseDTO = itemService.getDetailRoomByItemId(ItemCategory.ROOM, itemId);
        model.addAttribute("item", itemRoomResponseDTO);
        // 상품 시작, 종료 기간
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        // memberId
        model.addAttribute("memberId", memberId);
        // sellerId
        model.addAttribute("sellerId", sellerId);
        return "pay";
    }

    @GetMapping("pay/payInfo/{paymentId}/{itemId}")
    public String paymentCheck(@PathVariable("paymentId") Integer paymentId, @PathVariable("itemId") Integer itemId, Model model) {
        PaymentVO paymentVO = paymentService.read(paymentId); // 결제테이블 정보
        ReservationDTO reservationDTO = reservationService.select(paymentVO.getResId()); // 예약테이블 정보
        String name = paymentService.readNameByItem(itemId); // 상품이름
        model.addAttribute("payment" , paymentVO);
        model.addAttribute("reservation", reservationDTO);
        model.addAttribute("itemName", name);
        return "payAfter";
    }

    @GetMapping({"/prodet"})
    public String prodet() {
        return "product_detail";
    }

    @GetMapping({"/memwithdraw"})
    public String memwithdraw() {
        return "mem_withdraw";
    }

    @GetMapping({"/notice"})
    public String notice() {
        return "notice";
    }

    @GetMapping({"/notcon"})
    public String notice_content() {
        return "notice_content";
    }

    @GetMapping({"/notwri"})
    public String notice_write() {
        return "notice_write";
    }

    @GetMapping({"/notupd"})
    public String notice_update() {
        return "notice_update";
    }

    @GetMapping({"/product"})
    public String product() {
        return "product";
    }

    @GetMapping({"/wishlist"})
    public String wishlist() {
        return "wishlist";
    }

    @GetMapping({"/qna"})
    public String qna() {
        return "qna";
    }

    @GetMapping({"/qnacon"})
    public String qnacon() {
        return "qna_content";
    }

    @GetMapping({"/qnawri"})
    public String qnawri() {
        return "qna_write";
    }

    @GetMapping({"/qnaupd"})
    public String qnaupd() {
        return "qna_update";
    }

    @GetMapping({"/qnaans"})
    public String qnaans() {
        return "qna_answer";
    }

    @GetMapping({"/proqnacon"})
    public String proqnacon() {
        return "product_detail_qna_content";
    }

    @GetMapping({"/proqnawri"})
    public String proqnawri() {
        return "product_detail_qna_write";
    }

    @GetMapping({"/proqnaupd"})
    public String proqnaupd() {
        return "product_detail_qna_update";
    }

    @GetMapping({"/payAfter"})
    public String payAfter() {
        return "payAfter";
    }

    @GetMapping({"/myReservation"})
    public String myReservation() {
        return "mypage_reservation";
    }

}
