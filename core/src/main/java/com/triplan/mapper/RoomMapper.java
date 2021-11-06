package com.triplan.mapper;

import com.triplan.domain.RoomVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomMapper {
    
    void insert(RoomVO roomVO);

    RoomVO select(Integer roomId);

    void update(RoomVO roomVO);

    void delete(Integer roomId);

}
