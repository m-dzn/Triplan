package com.triplan.mapper;

import com.triplan.domain.ItemVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {

    void itemInsert(ItemVO itemVO);

    ItemVO itemGet(int itemId);

    void itemUpdate(ItemVO itemVO);

    void itemDelete(int itemId);

    List<ItemVO> getListByItemGroupId(Integer itemGroupId);

}