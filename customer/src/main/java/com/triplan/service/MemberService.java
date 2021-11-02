package com.triplan.service;

import com.triplan.domain.MemberVO;

public interface MemberService {

    void register(MemberVO memberVO);

    MemberVO getMember(int memberId);

    void update(int memberId, MemberVO memberVO);

    void delete(int memberId);

}
