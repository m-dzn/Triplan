package com.triplan.mapper;

import com.triplan.domain.ItemVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemMapper {

    void itemInsert(ItemVO itemVO);

    ItemVO itemGet(int itemId);

    void itemUpdate(ItemVO itemVO);

    void itemDelete(int itemId);
}
