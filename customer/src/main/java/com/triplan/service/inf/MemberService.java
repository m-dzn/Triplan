package com.triplan.service.inf;

import com.triplan.domain.MemberVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MemberService {

    void register(MemberVO memberVO);

    MemberVO getMember(Integer memberId);

    void updateEtc(Integer memberId, MemberVO memberVO);

    void updateMypage(Integer memberId, MemberVO memberVO);

    void updateBasicInfo(Integer memberId, MemberVO memberVO);

    void updateEmail(Integer memberId, MemberVO memberVO);

    void updatePassword(Integer memberId, MemberVO memberVO);

    void delete(Integer memberId);

    Boolean emailCheck(String email);

    Boolean nicknameCheck(String nickname);

    String updateProfileImg(List<MultipartFile> file, Integer memberId);
}
