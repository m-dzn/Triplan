package com.triplan.controller.api;

import com.triplan.domain.member.MemberVO;
import com.triplan.security.CurrentMember;
import com.triplan.security.MemberPrincipal;
import com.triplan.service.inf.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class ApiMemberController {

    private final MemberService memberService;
    private final AuthenticationManager authenticationManager;

    /* 회원가입*/
    @PostMapping
    public String register(@Valid @RequestBody MemberVO memberVO) {
        memberService.register(memberVO);
        return "회원 가입 성공";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MemberVO memberVO) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            memberVO.getEmail(),
                            memberVO.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(auth);

            MemberPrincipal memberPrincipal = (MemberPrincipal) auth.getPrincipal();
            return ResponseEntity.ok(memberPrincipal.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().body("로그인 실패");
    }

    @GetMapping
    public MemberVO getMember(@CurrentMember MemberPrincipal currentMember) {
        Integer memberId = currentMember != null ? currentMember.getMemberId() : null;
        return memberService.getMember(memberId);
    }

    /* 회원정보수정 */
    @PatchMapping("/basic-info") /*닉네임,프로필이미지*/
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String updateBasicInfo(@RequestBody MemberVO memberVO, @CurrentMember MemberPrincipal currentMember){
        Integer memberId = currentMember.getMemberId();
        memberService.updateBasicInfo(memberId, memberVO);
        return "회원 기본정보 수정";
    }

    @PatchMapping("/change-email") /*이메일*/
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String updateEmail(@RequestBody MemberVO memberVO, @CurrentMember MemberPrincipal currentMember){
        Integer memberId = currentMember.getMemberId();
        memberService.updateEmail(memberId, memberVO);
        return "회원 이메일정보 수정";
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String updateMypage(@RequestBody MemberVO memberVO, @CurrentMember MemberPrincipal currentMember){
        Integer memberId = currentMember.getMemberId();
        memberService.updateMypage(memberId, memberVO);
        return "회원정보 수정";
    }

    @PatchMapping("/change-password") /*비밀번호*/
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String updatePassword(@RequestBody MemberVO memberVO, @CurrentMember MemberPrincipal currentMember){
        Integer memberId = currentMember.getMemberId();
        memberService.updatePassword(memberId, memberVO);
        return "회원 비밀번호정보 수정";
    }

    @PatchMapping("/change-etc") /*기타(포인트,등급,계좌)*/
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String updateEtc(@RequestBody MemberVO memberVO, @CurrentMember MemberPrincipal currentMember) {
        Integer memberId = currentMember.getMemberId();
        memberService.updateEtc(memberId, memberVO);
        return "회원 기타정보 수정";
    }

    /* 회원 탈퇴 */
    @DeleteMapping
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String delete(@CurrentMember MemberPrincipal currentMember) {
        Integer memberId = currentMember.getMemberId();
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
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String updateMemberProfile(@RequestPart("files") List<MultipartFile> files, @CurrentMember MemberPrincipal currentMember) {
        Integer memberId = currentMember.getMemberId();
        memberService.updateProfileImg(files, memberId);
        return "정보 입력 성공";
    }

}
