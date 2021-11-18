package com.triplan.controller;

import com.triplan.domain.MemberVO;
import com.triplan.security.MemberPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;

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

}
