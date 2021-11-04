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
    public void updateBasicInfo(Integer memberId, MemberVO memberVO) {
        memberVO.setMemberId(memberId);
        memberMapper.update(memberVO);
    }

    public void register(MemberVO memberVO) {
        memberMapper.insert(memberVO);
    }

    @Override
    public MemberVO getMember(int memberId) {
        MemberVO result = memberMapper.select(memberId);
        return result;
    }

    @Override
    public void update(int memberId, MemberVO memberVO) {
        memberVO.setMemberId(memberId);
        memberMapper.update(memberVO);
    }

    @Override
    public void delete(int memberId) {
        memberMapper.delete(memberId);
    }

}
