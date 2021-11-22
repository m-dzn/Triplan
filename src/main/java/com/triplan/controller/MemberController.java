package com.triplan.controller;

import com.triplan.domain.member.MemberVO;
import com.triplan.security.CurrentMember;
import com.triplan.security.MemberPrincipal;
import com.triplan.service.inf.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public MemberVO getMember(@CurrentMember MemberPrincipal currentMember) {
        Integer memberId = currentMember.getMemberId();
        MemberVO memberVO = memberService.getMember(memberId);
        return memberVO;
    }

    @PutMapping
    public String updateMypage(@RequestBody MemberVO memberVO, @CurrentMember MemberPrincipal currentMember){
        Integer memberId = currentMember.getMemberId();
        memberService.updateMypage(memberId, memberVO);
        return "회원정보 수정";
    }

    @PatchMapping("/updateProfileImg")
    public String updateMemberProfile(
            @RequestPart("files") List<MultipartFile> files,
            @CurrentMember MemberPrincipal currentMember
    ) {
        Integer memberId = currentMember.getMemberId();
        return memberService.updateProfileImg(files, memberId);
    }

}
