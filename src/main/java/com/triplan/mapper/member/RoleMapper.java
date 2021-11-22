package com.triplan.mapper.member;

import com.triplan.domain.member.RoleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper {

    void insertMemberRole(@Param("memberId") Integer memberId, @Param("roleId") Integer roleId);

    List<RoleVO> selectByMemberId(Integer memberId);

}
