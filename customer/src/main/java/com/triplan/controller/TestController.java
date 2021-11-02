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

    @GetMapping({"/mypage"})
    public String mypage() {
        return "mypage";
    }

    @GetMapping({"/login"})
    public String login() {
        return "login";
    }

    @GetMapping({"/join"})
    public String join() {
        return "join";
    }
}
