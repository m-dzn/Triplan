package com.triplan.mapper;

import com.triplan.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    void insert(MemberVO memberVO);

    MemberVO select(Integer memberId);

    void update(MemberVO memberVO);

    void updateBasicInfo(MemberVO memberVO);

    void updateEmail(MemberVO memberVO);

    void updatePassword(MemberVO memberVO);

    void delete(Integer memberId);

    Integer emailCheck(String email);

    Integer nicknameCheck(String nickname);
}
