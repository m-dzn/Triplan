package com.triplan.controller;

import com.triplan.domain.MemberVO;
import com.triplan.dto.MemberProfileDTO;
import com.triplan.service.inf.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /* (파일첨부)프로필 이미지 수정 */
    @GetMapping("/profile-update")
    public String profileUpdate() {
        return "profileTest";
    }

    @PostMapping("/profile")
    public String updateProfileImg(MemberProfileDTO memberProfileDTO, @RequestParam("file") List<MultipartFile> file, Model model) throws IOException {
        MemberVO response = memberService.updateProfileImg(memberProfileDTO, file);
        model.addAttribute("member",response);
        return "profileImgTest";
    }

}
