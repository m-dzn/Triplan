package com.triplan.mapper;

import com.triplan.domain.ItemGroupVO;
import com.triplan.domain.ItemVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemGroupMapper {

    void insert(ItemGroupVO itemGroupVO);

    ItemGroupVO select(Integer itemGroupId);

    void update(ItemGroupVO itemGroupVO);

    void delete(Integer itemGroupId);

    ItemGroupVO getItemGroupByItemGroupId(Integer itemGroupId);
}
