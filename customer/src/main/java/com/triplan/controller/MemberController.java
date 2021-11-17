package com.triplan.controller;

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

//    @PostMapping("/profile")
//    public String updateProfileImg(MemberProfileDTO memberProfileDTO, @RequestParam("file") List<MultipartFile> file, Model model) throws IOException {
//        MemberVO response = memberService.updateProfileImg(memberProfileDTO, file);
//        model.addAttribute("member",response);
//        return "profileImgTest";
//    }

}
