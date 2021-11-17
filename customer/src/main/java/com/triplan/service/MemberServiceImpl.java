package com.triplan.service;

import com.triplan.domain.AttachmentVO;
import com.triplan.domain.MemberVO;
import com.triplan.dto.MemberProfileDTO;
import com.triplan.enumclass.AboutTableType;
import com.triplan.mapper.AttachmentMapper;
import com.triplan.mapper.MemberMapper;
import com.triplan.service.inf.MemberService;
import com.triplan.util.AttachmentUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;
    private final AttachmentMapper attachmentMapper;

    public void register(MemberVO memberVO) {
        memberMapper.insert(memberVO);
    }

    @Override
    public MemberVO getMember(Integer memberId) {
        MemberVO result = memberMapper.select(memberId);
        return result;
    }

    @Override
    public void updateEtc(Integer memberId, MemberVO memberVO) {
        memberVO.setMemberId(memberId);
        memberMapper.updateEtc(memberVO);
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
    public Boolean emailCheck(String email) {
        Boolean result = memberMapper.emailCheck(email);
        return result;
    }

    @Override
    public Boolean nicknameCheck(String nickname) {
        Boolean result = memberMapper.nicknameCheck(nickname);
        return result;
    }

    @Override
    @Transactional
    public MemberVO updateProfileImg(MemberProfileDTO memberProfileDTO, List<MultipartFile> files) throws IOException {
        if(files.size() > 0){
            AttachmentVO attachmentVO = AttachmentUtil.getAttachment(files.get(0), AboutTableType.MEMBER, memberProfileDTO.getMemberId());

            attachmentMapper.insert(attachmentVO);

            memberProfileDTO.setProfileImg(attachmentVO.getUrl());
            memberMapper.updateBasicInfo(memberProfileDTO.toVO());
        }

        return memberMapper.select(memberProfileDTO.getMemberId());
    }


}
