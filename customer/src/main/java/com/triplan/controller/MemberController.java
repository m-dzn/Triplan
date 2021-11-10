package com.triplan.controller;

import com.triplan.domain.MemberVO;
import com.triplan.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController<memberVO> {

    private final MemberService memberService;

    @PostMapping
    public String register(@RequestBody MemberVO memberVO) {
        memberService.register(memberVO);
        return "board/list";
    }

    @GetMapping("/{memberId}")
    public MemberVO getMember(@PathVariable int memberId){
        System.out.println(" C : getM 실행--------");

        return memberService.getMember(memberId);
    }

    @PutMapping("/{memberId}")
    public String update(@PathVariable int memberId, @RequestBody MemberVO memberVO){
        memberService.update(memberId, memberVO);
        return "수정 완료";
    }

    @DeleteMapping("/{memberId}")
    public String delete(@PathVariable int memberId){
        memberService.delete(memberId);
        return "멤버 삭제 완료";
    }

}
