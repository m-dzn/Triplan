package com.triplan.mapper;

import com.triplan.domain.ItemGroupVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemGroupMapper {

    void insert(ItemGroupVO itemGroupVO);

    ItemGroupVO select(Integer itemGroupId);

    void update(ItemGroupVO itemGroupVO);

    void delete(Integer itemGroupId);

}
