package com.triplan.mapper.item;

import com.triplan.domain.item.RoomVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomMapper {
    
    void insert(RoomVO roomVO);

    RoomVO select(Integer roomId);

    void update(RoomVO roomVO);

    void delete(Integer roomId);

    RoomVO getRoomByItemId(Integer itemId);

    void updateByItemId(RoomVO roomVO);
}
