package com.triplan.service;

import com.triplan.domain.MemberVO;
import com.triplan.mapper.MemberMapper;
import com.triplan.service.inf.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(MemberVO memberVO) {
        memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));
        memberMapper.insert(memberVO);
    }

    @Override
    public MemberVO getMember(Integer memberId) {
        MemberVO result = memberMapper.select(memberId);
        return result;
    }

    @Override
    public void update(Integer memberId, MemberVO memberVO) {
        memberVO.setMemberId(memberId);
        memberMapper.update(memberVO);
    }

    @Override
    public void delete(Integer memberId) {
        memberMapper.delete(memberId);
    }
}
