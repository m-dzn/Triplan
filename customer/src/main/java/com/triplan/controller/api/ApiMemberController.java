package com.triplan.controller.api;

import com.triplan.domain.MemberVO;
import com.triplan.service.inf.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class ApiMemberController {
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

    private final MemberService memberService;

    @PostMapping
    public String register(@RequestBody MemberVO memberVO) {
        memberService.register(memberVO);
        return "회원 가입 성공";
    }

    @GetMapping("/{memberId}")
    public MemberVO getMember(@PathVariable Integer memberId) {
        return memberService.getMember(memberId);
    }

    @PutMapping("/{memberId}")
    public String update(@PathVariable Integer memberId, @RequestBody MemberVO memberVO) {
        memberService.update(memberId, memberVO);
        return "회원 정보 수정";
    }

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

    @DeleteMapping("/{memberId}")
    public String delete(@PathVariable Integer memberId) {
        memberService.delete(memberId);
        return "회원 탈퇴 완료";
    }

    /* 중복 검사 */
    @GetMapping("/email-check")
    public Integer emailCheck(@RequestParam("email") String email) {
        Integer result = memberService.emailCheck(email);
        return result;
    }

    @GetMapping("/nickname-check")
    public Integer nicknameCheck(@RequestParam("nickname") String nickname) {
        Integer result = memberService.nicknameCheck(nickname);
        return result;
    }




}
