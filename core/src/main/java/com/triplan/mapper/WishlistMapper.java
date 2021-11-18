package com.triplan.mapper;

import com.triplan.domain.ItemGroupVO;
import com.triplan.dto.response.WishlistResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WishlistMapper {

    void insert(@Param("memberId") Integer memberId, @Param("itemGroupId") Integer itemGroupId);

    void delete(Integer wishListId);

    List<WishlistResponseDTO> list(Integer memberId);

    Boolean exist(@Param("itemGroupId") Integer itemGroupId, @Param("memberId") Integer memberId);

    ItemGroupVO selectItemGroupByWishlistId(Integer wishlistId);
}
