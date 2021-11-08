package com.triplan.service;

import com.triplan.domain.MemberVO;
import com.triplan.mapper.MemberMapper;
import com.triplan.service.inf.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    public void register(MemberVO memberVO) {
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
    public void updateBasicInfo(Integer memberId, MemberVO memberVO) {
        memberVO.setMemberId(memberId);
        memberMapper.updateBasicInfo(memberVO);
    }

    @Override
    public void updateEmail(Integer memberId, MemberVO memberVO) {
        memberVO.setMemberId(memberId);
        memberMapper.updateEmail(memberVO);
    }

    @Override
    public void updatePassword(Integer memberId, MemberVO memberVO) {
        memberVO.setMemberId(memberId);
        memberMapper.updatePassword(memberVO);
    }

    @Override
    public void delete(Integer memberId) {
        memberMapper.delete(memberId);
    }

    @Override
    public Integer emailCheck(String email) {
        Integer result = memberMapper.emailCheck(email);
        return result;
    }

    @Override
    public Integer nicknameCheck(String nickname) {
        Integer result = memberMapper.nicknameCheck(nickname);
        return result;
    }


}
