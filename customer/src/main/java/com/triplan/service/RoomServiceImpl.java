package com.triplan.service;

import com.triplan.domain.RoomVO;
import com.triplan.mapper.RoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{

    private final RoomMapper roomMapper;

    @Override
    public void roomInsert(RoomVO roomVO) {
        roomMapper.roomInsert(roomVO);
    }

    @Override
    public RoomVO roomSelect(Integer roomId) {
        return roomMapper.roomSelect(roomId);
    }

    @Override
    public void roomUpdate(RoomVO roomVO) {
        roomMapper.roomUpdate(roomVO);
    }

    @Override
    public void roomDelete(Integer roomId) {
        roomMapper.roomDelete(roomId);
    }
}
