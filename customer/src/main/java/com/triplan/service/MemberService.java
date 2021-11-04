package com.triplan.service;

import com.triplan.domain.MemberVO;

// @Controller, @Component, @Service, @RestController, @Repository 이런 거 interface에는 붙일 필요가 없음
public interface MemberService {
    
    void update(Integer memberId, MemberVO memberVO);

}
