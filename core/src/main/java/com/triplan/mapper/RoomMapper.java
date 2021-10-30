package com.triplan.mapper;

import com.triplan.domain.RoomVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomMapper {
    
    void roomInsert(RoomVO roomVO);
    RoomVO roomSelect(int room_id);
    void roomUpdate(RoomVO roomVO);
    void roomDelete(int room_id);

}
