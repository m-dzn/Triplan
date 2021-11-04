package com.triplan.service;

import com.triplan.domain.MemberVO;
import com.triplan.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    @Override
    public void update(Integer memberId, MemberVO memberVO) {
        memberVO.setMemberId(memberId);
        memberMapper.update(memberVO);
    }

}
