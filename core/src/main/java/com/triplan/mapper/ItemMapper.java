package com.triplan.mapper;

import com.triplan.domain.FlightVO;
import com.triplan.domain.ItemVO;
import com.triplan.domain.RoomVO;
import com.triplan.enumclass.ItemCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemMapper {

    Integer insert(ItemVO itemVO);

    ItemVO select(Integer itemId);

    void update(ItemVO itemVO);

    void delete(Integer itemId);

    List<ItemVO> getItemByItemGroupId(Integer itemGroupId);

    ItemVO getItemByItemId(@Param("room") ItemCategory room, @Param("itemId") Integer itemId);

    //Integer getItemId();
}
