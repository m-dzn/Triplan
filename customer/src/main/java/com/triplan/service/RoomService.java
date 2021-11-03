package com.triplan.service;

import com.triplan.domain.RoomVO;

public interface RoomService {

    void roomInsert(RoomVO roomVO);
    RoomVO roomSelect(Integer roomId);
    void roomUpdate(RoomVO roomVO);
    void roomDelete(Integer roomId);

}
