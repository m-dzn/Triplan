package com.triplan.mapper;

import com.triplan.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    void insert(MemberVO memberVO);

    MemberVO select(Integer memberId);

    void updateEtc(MemberVO memberVO);

    void updateBasicInfo(MemberVO memberVO);

    void updateEmail(MemberVO memberVO);

    void updatePassword(MemberVO memberVO);

    void delete(Integer memberId);

    Boolean emailCheck(String email);

    Boolean nicknameCheck(String nickname);
}
