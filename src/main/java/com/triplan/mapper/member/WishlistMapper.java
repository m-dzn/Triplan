package com.triplan.mapper.member;

import com.triplan.domain.member.WishlistVO;
import com.triplan.dto.response.customer.WishlistResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WishlistMapper {

    void insert(@Param("memberId") Integer memberId, @Param("itemGroupId") Integer itemGroupId);

    WishlistVO select(Integer wishlistId);

    WishlistVO selectByItemGroupIdAndMemberId(@Param("itemGroupId") Integer itemGroupId, @Param("memberId") Integer memberId);

    void delete(Integer wishListId);

    void deleteByItemGroupId(Integer itemGroupId);

    List<WishlistResponseDTO> list(
            @Param("memberId") Integer memberId,
            @Param("startRow") Integer startRow,
            @Param("pageSize") Integer pageSize
    );

    Boolean exist(@Param("itemGroupId") Integer itemGroupId, @Param("memberId") Integer memberId);

    Integer countByMemberId(Integer memberId);
}
