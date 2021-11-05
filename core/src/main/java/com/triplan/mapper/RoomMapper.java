package com.triplan.mapper;

import com.triplan.domain.RoomVO;

public interface RoomMapper {
    void roomInsert(RoomVO roomVO);
    RoomVO roomSelect(Integer roomId);
    void roomUpdate(RoomVO roomVO);
    void roomDelete(Integer roomId);
}
