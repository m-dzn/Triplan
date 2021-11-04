package com.triplan.mapper;

import com.triplan.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    void update(MemberVO memberVO);
}
