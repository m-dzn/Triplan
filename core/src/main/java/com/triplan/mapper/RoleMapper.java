package com.triplan.mapper;

import com.triplan.domain.RoleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {

    List<RoleVO> selectByMemberId(Integer memberId);

}
