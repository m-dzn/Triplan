package com.triplan.service;

import com.triplan.domain.RoomVO;

public interface RoomService {

    void roomInsert(RoomVO roomVO);
    RoomVO roomSelect(int roomId);
    void roomUpdate(RoomVO roomVO);
    void roomDelete(int roomId);

}
