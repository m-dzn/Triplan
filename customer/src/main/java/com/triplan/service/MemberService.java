package com.triplan.service;

import com.triplan.domain.MemberVO;

// @Controller, @Component, @Service, @RestController, @Repository 이런 거 interface에는 붙일 필요가 없음
public interface MemberService {
    
    void updateBasicInfo(Integer memberId, MemberVO memberVO);

    void updateEmail(Integer memberId, MemberVO memberVO);

    void updatePassword(Integer memberId, MemberVO memberVO);

    void register(MemberVO memberVO);

    MemberVO getMember(Integer memberId);

    void update(Integer memberId, MemberVO memberVO);

    void delete(Integer memberId);


}
