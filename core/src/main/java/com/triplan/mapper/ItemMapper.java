package com.triplan.mapper;

import com.triplan.domain.ItemVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemMapper {

    void insert(ItemVO itemVO);

    ItemVO select(Integer itemId);

    void update(ItemVO itemVO);

    void delete(Integer itemId);
}
