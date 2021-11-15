package com.triplan.service.inf;

import com.triplan.domain.MemberVO;
import com.triplan.dto.MemberProfileDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MemberService {

    void register(MemberVO memberVO);

    MemberVO getMember(Integer memberId);

    void updateEtc(Integer memberId, MemberVO memberVO);

    void updateBasicInfo(Integer memberId, MemberVO memberVO);

    void updateEmail(Integer memberId, MemberVO memberVO);

    void updatePassword(Integer memberId, MemberVO memberVO);

    void delete(Integer memberId);

    Boolean emailCheck(String email);

    Boolean nicknameCheck(String nickname);

    MemberVO updateProfileImg(MemberProfileDTO memberProfileDTO, List<MultipartFile> file) throws IOException;
}
