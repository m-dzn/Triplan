package com.triplan.controller;

import com.triplan.domain.MemberVO;
import com.triplan.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

/*   // 회원정보 수정 화면 구현 : GET방식
    @GetMapping("/memberModify")
    public String memberModifyGET(HttpServletRequest req, Model model, MemberVO memverVO) throws Exception {

        HttpSession session = req.getSession();

        MemberVO member = (MemberVO) session.getAttribute("member");
        MemberVO modifyMember = memberService.getMember(member.getMemberId());

        model.addAttribute("modifyNickname", modifyMember.getNickname());

        return "memberModify";
    }
*/

    @PutMapping("/{memberId}/basic")
    public String updateBasicInfo(@PathVariable Integer memberId, @RequestBody MemberVO memberVO){
        memberService.updateBasicInfo(memberId, memberVO);
        return "회원 기본정보 수정";
    }

    @PutMapping("/{memberId}/email")
    public String updateEmail(@PathVariable Integer memberId, @RequestBody MemberVO memberVO){
        memberService.updateEmail(memberId, memberVO);
        return "회원 이메일정보 수정";
    }

    @PutMapping("/{memberId}/pass")
    public String updatePassword(@PathVariable Integer memberId, @RequestBody MemberVO memberVO){
        memberService.updatePassword(memberId, memberVO);
        return "회원 비밀번호정보 수정";
    }
}
