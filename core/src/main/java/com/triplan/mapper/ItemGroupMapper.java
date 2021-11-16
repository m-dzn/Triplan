package com.triplan.mapper;

import com.triplan.domain.ItemGroupVO;
import com.triplan.domain.ItemVO;
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

    List<ItemGroupVO> getItemGroupBySellerId(@Param("sellerId") Integer sellerId, @Param("pageSize") Integer pageSize, @Param("currentPage") Integer currentPage);

    int count(Integer sellerId);
}
