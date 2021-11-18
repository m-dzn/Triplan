package com.triplan.mapper;

import com.triplan.domain.WishlistVO;
import com.triplan.dto.response.WishlistResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WishlistMapper {

    void insert(@Param("memberId") Integer memberId, @Param("itemGroupId") Integer itemGroupId);

    WishlistVO select(Integer wishlistId);

    void delete(Integer wishListId);

    List<WishlistResponseDTO> list(
            @Param("memberId") Integer memberId,
            @Param("pageSize") Integer pageSize,
            @Param("currentPage") Integer currentPage
    );

    Boolean exist(@Param("itemGroupId") Integer itemGroupId, @Param("memberId") Integer memberId);

    Integer countByMemberId(Integer memberId);
}
