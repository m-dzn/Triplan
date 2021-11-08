package com.triplan.service.inf;

import com.triplan.domain.MemberVO;

public interface MemberService {

    void register(MemberVO memberVO);

    MemberVO getMember(Integer memberId);

    void update(Integer memberId, MemberVO memberVO);

    void delete(Integer memberId);

}
