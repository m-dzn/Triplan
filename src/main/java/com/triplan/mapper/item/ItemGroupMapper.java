package com.triplan.mapper.item;

import com.triplan.domain.item.ItemGroupVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemGroupMapper {

    void insert(ItemGroupVO itemGroupVO);

    ItemGroupVO select(Integer itemGroupId);

    void update(ItemGroupVO itemGroupVO);

    void delete(Integer itemGroupId);

    ItemGroupVO getItemGroupByItemGroupId(Integer itemGroupId);

    List<ItemGroupVO> selectAll(List<ItemGroupVO> resultItemGroupId);

    List<ItemGroupVO> getItemGroupBySellerId(@Param("sellerId") Integer sellerId, @Param("startRow") Integer startRow, @Param("pageSize") Integer pageSize);

    int count(Integer sellerId);

    List<ItemGroupVO> selectAllSort(@Param("itemGroupId") List<ItemGroupVO> sortItemGroupId, @Param("sortType")String sortType);
}
