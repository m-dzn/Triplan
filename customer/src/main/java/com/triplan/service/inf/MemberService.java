package com.triplan.service.inf;

import com.triplan.domain.MemberVO;

public interface MemberService {

    void register(MemberVO memberVO);

    MemberVO getMember(Integer memberId);

    void update(Integer memberId, MemberVO memberVO);

    void updateBasicInfo(Integer memberId, MemberVO memberVO);

    void updateEmail(Integer memberId, MemberVO memberVO);

    void updatePassword(Integer memberId, MemberVO memberVO);

    void delete(Integer memberId);

    Integer emailCheck(String email);

    Integer nicknameCheck(String nickname);
}
