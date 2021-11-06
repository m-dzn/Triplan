package com.triplan.controller.api;

import com.triplan.domain.MemberVO;
import com.triplan.service.inf.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class ApiMemberController {

    private final MemberService memberService;

    @PostMapping
    public String register(@RequestBody MemberVO memberVO) {
        memberService.register(memberVO);
        return "회원 가입 성공";
    }

    @GetMapping("/{memberId}")
    public MemberVO  getMember(@PathVariable Integer memberId) {
        return memberService.getMember(memberId);
    }

    @PutMapping("/{memberId}")
    public String update(@PathVariable Integer memberId, @RequestBody MemberVO memberVO) {
        memberService.update(memberId, memberVO);
        return "회원 정보 수정 완료";
    }

    @DeleteMapping("/{memberId}")
    public String delete(@PathVariable Integer memberId) {
        memberService.delete(memberId);
        return "회원 탈퇴 완료";
    }

}
