//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.triplan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    public TestController() {
    }

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

    @GetMapping({"/pay"})
    public String pay() {
        return "pay";
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
}
