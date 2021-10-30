package com.triplan.service;

import com.triplan.domain.RoomVO;

public interface RoomService {

    void roomInsert(RoomVO roomVO);
    RoomVO roomSelect(int room_id);
    void roomUpdate(RoomVO roomVO);
    void roomDelete(int room_id);

}
