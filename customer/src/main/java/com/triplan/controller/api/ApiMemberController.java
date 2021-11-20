package com.triplan.controller.api;

import com.triplan.domain.MemberVO;
import com.triplan.service.inf.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class ApiMemberController {

    private final MemberService memberService;

    /* 회원가입*/
    @PostMapping
    public String register(@Valid @RequestBody MemberVO memberVO) {
        memberService.register(memberVO);
        return "회원 가입 성공";
    }

    @GetMapping("/{memberId}")
    public MemberVO getMember(@PathVariable Integer memberId) {
        return memberService.getMember(memberId);
    }

    /* 회원정보수정 */
    @PatchMapping("/{memberId}/basic-info") /*닉네임,프로필이미지*/
    public String updateBasicInfo(@PathVariable Integer memberId, @RequestBody MemberVO memberVO){
        memberService.updateBasicInfo(memberId, memberVO);
        return "회원 기본정보 수정";
    }

    @PatchMapping("/{memberId}/change-email") /*이메일*/
    public String updateEmail(@PathVariable Integer memberId, @RequestBody MemberVO memberVO){
        memberService.updateEmail(memberId, memberVO);
        return "회원 이메일정보 수정";
    }

    @PatchMapping("/{memberId}/change-password") /*비밀번호*/
    public String updatePassword(@PathVariable Integer memberId, @RequestBody MemberVO memberVO){
        memberService.updatePassword(memberId, memberVO);
        return "회원 비밀번호정보 수정";
    }

    @PatchMapping("/{memberId}/change-etc") /*기타(포인트,등급,계좌)*/
    public String updateEtc(@PathVariable Integer memberId, @RequestBody MemberVO memberVO) {
        memberService.updateEtc(memberId, memberVO);
        return "회원 기타정보 수정";
    }

    /* 회원 탈퇴 */
    @DeleteMapping("/{memberId}")
    public String delete(@PathVariable Integer memberId) {
        memberService.delete(memberId);
        return "회원 탈퇴 완료";
    }

    /* 중복 검사 */
    @GetMapping("/email-duplicated")
    public Boolean emailCheck(@RequestParam("email") String email) {
        Boolean result = memberService.emailCheck(email);
        return result;
    }

    @GetMapping("/nickname-duplicated")
    public Boolean nicknameCheck(@RequestParam("nickname") String nickname) {
        Boolean result = memberService.nicknameCheck(nickname);
        return result;
    }

    @PatchMapping("/updateProfileImg")
    public String updateMemberProfile(@RequestPart("files") List<MultipartFile> files) {
        Integer memberId = 1;
        memberService.updateProfileImg(files, memberId);
        return "정보 입력 성공";
    }

}
