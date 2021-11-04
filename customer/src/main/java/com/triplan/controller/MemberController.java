package com.triplan.controller;

import com.triplan.domain.MemberVO;
import com.triplan.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PutMapping("/{memberId}")
    public String update(@PathVariable Integer memberId, @RequestBody MemberVO memberVO){
        memberService.update(memberId, memberVO);
        return "회원 정보 수정";
    }

}
