package com.triplan.mapper;

import com.triplan.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    void insert(MemberVO memberVO);

    MemberVO select(Integer memberId);

    void update(MemberVO memberVO);

    void delete(Integer memberId);

}
