package com.triplan.mapper;

import com.triplan.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    void updateGrade(@Param("memberId")Integer memberId, @Param("totalPayment") Long totalPayment);

    MemberVO selectByEmail(String email);

}
