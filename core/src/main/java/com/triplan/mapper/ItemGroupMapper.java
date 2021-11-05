package com.triplan.mapper;

import com.triplan.domain.ItemGroupVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemGroupMapper {
    void insert(ItemGroupVO itemGroupVO);

    ItemGroupVO read(int num);

    void update(int num);

    void delete(int num);

    ItemGroupVO getList(int num);

    List<ItemGroupVO> getListBySellerId(Integer sellerId);
}