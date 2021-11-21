package com.triplan.controller;

import com.triplan.domain.MemberVO;
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

    @GetMapping("/{memberId}")
    public MemberVO getMember(@PathVariable Integer memberId) {
        MemberVO memberVO = memberService.getMember(memberId);
        return memberVO;
    }

    @PutMapping("/{memberId}")
    public String updateMypage(@PathVariable Integer memberId, @RequestBody MemberVO memberVO){
        memberService.updateMypage(memberId, memberVO);
        return "회원정보 수정";
    }

    @PatchMapping("/updateProfileImg")
    public String updateMemberProfile(@RequestPart("files") List<MultipartFile> files) {
        Integer memberId = 1;
        return memberService.updateProfileImg(files, memberId);
    }
}
