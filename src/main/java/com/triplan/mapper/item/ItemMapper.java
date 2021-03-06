package com.triplan.mapper.item;

import com.triplan.domain.item.ItemVO;
import com.triplan.dto.response.customer.RoomCardResponseDTO;
import com.triplan.enumclass.item.ItemCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface ItemMapper {

    Integer insert(ItemVO itemVO);

    ItemVO select(Integer itemId);

    void update(ItemVO itemVO);

    void delete(Integer itemId);

    List<ItemVO> getItemByItemGroupId(Integer itemGroupId);

    ItemVO getItemByItemId(@Param("room") ItemCategory room, @Param("itemId") Integer itemId);

    List<ItemVO> getItemList(Integer itemId);

    List<ItemVO> getItemBySellerId(Integer sellerId);

    Integer count(Integer sellerId);

    void updateByItemGroupId(Integer itemGroupId);

    List<ItemVO> getItemRoomBySellerId(
            @Param("sellerId") Integer sellerId,
            @Param("room") ItemCategory room,
            @Param("startRow") Integer startRow,
            @Param("pageSize") Integer pageSize
    );

    List<ItemVO> getItemFlightBySellerId(@Param("sellerId") Integer sellerId, @Param("flight") ItemCategory flight, @Param("startRow") Integer startRow, @Param("pageSize") Integer pageSize);

    int countRoom(@Param("sellerId") Integer sellerId, @Param("room") ItemCategory room);

    int countFlight(@Param("sellerId") Integer sellerId, @Param("flight") ItemCategory flight);

    List<ItemVO> getItemVOList(ItemCategory room);

    List<RoomCardResponseDTO> getItemsByItemGroupId(
            @Param("itemGroupId") Integer itemGroupId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

}
